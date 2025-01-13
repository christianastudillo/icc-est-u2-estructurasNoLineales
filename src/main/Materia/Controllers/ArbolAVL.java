package main.Materia.Controllers;

import main.Materia.Models.Node;

public class ArbolAVL {
    private Node root;

    public void insert(int value) {
        System.out.println("Nodo a insertar: " + value);
        root = insert(root, value);
    }

    private Node insert(Node nodo, int value) {
        if (nodo == null) {
            Node newNode = new Node(value);
            newNode.setHeight(1); 
            return newNode;
        }

        if (value < nodo.getValue()) {
            nodo.setLeft(insert(nodo.getLeft(), value));
        } else if (value > nodo.getValue()) {
            nodo.setRight(insert(nodo.getRight(), value));
        } else {
            return nodo; 
        }

        nodo.setHeight(1 + Math.max(height(nodo.getLeft()), height(nodo.getRight())));

        int balance = getBalance(nodo);

        if (balance > 1 && value < nodo.getLeft().getValue()) {
            return rotateRight(nodo);
        }
        if (balance < -1 && value > nodo.getRight().getValue()) {
            return rotateLeft(nodo);
        }
        if (balance > 1 && value > nodo.getLeft().getValue()) {
            nodo.setLeft(rotateLeft(nodo.getLeft()));
            return rotateRight(nodo);
        }
        if (balance < -1 && value < nodo.getRight().getValue()) {
            nodo.setRight(rotateRight(nodo.getRight()));
            return rotateLeft(nodo);
        }

        return nodo;
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    private Node rotateRight(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        System.out.println("Nueva raiz despues de rotacion Der: " + x.getValue());

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(1 + Math.max(height(x.getLeft()), height(x.getRight())));
        y.setHeight(1 + Math.max(height(y.getLeft()), height(y.getRight())));
        System.out.println("Nueva raiz despues de rotacion Izq: " + y.getValue());

        return y;
    }

    public void printTree() {
        printTree(root, " ", true);
    }

    private void printTree(Node node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "---" : "|__") + node.getValue());
            if (node.getLeft() != null || node.getRight() != null) {
                if (node.getLeft() != null) {
                    printTree(node.getLeft(), prefix + (isLeft ? "|   " : "    "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "|   ---null" : "    ---null"));
                }
                if (node.getRight() != null) {
                    printTree(node.getRight(), prefix + (isLeft ? "|   " : "    "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "|   ---null" : "    ---null"));
                }
            }
        }
    }

    public Node getRoot() {
        return root;
    }
}

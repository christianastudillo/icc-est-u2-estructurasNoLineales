package main.Materia.Controllers;

import main.Materia.Models.Node;

public class ArbolBinario {
    private Node root;  

    public void insert(int value) {
        root = insert(root, value);
    }
    public void setRoot(Node root) {
        this.root = root;
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.getValue()) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
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

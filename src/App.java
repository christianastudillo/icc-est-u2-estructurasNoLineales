import java.util.List;
import java.util.Stack;

import main.Ejercicio_01_insert.InsertBSTTEST;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_ListLeves.ListLeves;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Controllers.ArbolAVL;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolRecorridos;
import main.Materia.Models.Node;
public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        //runArbolBinario();
        //runEjercicio3();
        //runArbolAVL();
        System.out.println("---------- EJERCICIO 1 ----------");
        runEjercicio1();
        System.out.println("\n---------- EJERCICIO 2 ----------");
        runEjercicio2();
        System.out.println("\n---------- EJERCICIO 3 ----------");
        runEjercicio3();
        System.out.println("\n---------- EJERCICIO 4 ----------");
        runEjercicio4();

    }
    // public static void runArbolBinario() {
    //     ArbolBinario arbolBinario = new ArbolBinario();
    //     int[] valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

    //     for (int valor : valores) {
    //         arbolBinario.insert(valor);
    //     }
    //     arbolBinario.printTree();
    //     System.out.println(); 

    //     Node root = arbolBinario.getRoot();

    //     ArbolRecorridos arbolRecorridos = new ArbolRecorridos();
    //     System.out.println("\n Recorrido PreOrder Iterativo");
    //     arbolRecorridos.preOrderIterativo(root);
    //     System.out.println("\n Recorrido PreOrder Recursivo");
    //     arbolRecorridos.preOrderRecursivo(root);
    //     System.out.println("\n Recorrido PostOrder");
    //     arbolRecorridos.postOrderRecursivo(root);
    //     System.out.println("\n Recorrido InOrder");
    //     arbolRecorridos.inOrderRecursivo(root);
    // }
    
    public static void runEjercicio1() {
        ArbolBinario arbolBinario = new ArbolBinario();
        InsertBSTTEST insertHelper = new InsertBSTTEST();  
    
        int[] valores = {5, 3, 7, 2, 4, 6, 8};  
        System.out.println("Lista de entrada: " + java.util.Arrays.toString(valores)); 
        Node root = null; 
    
        for (int value : valores) {
            root = insertHelper.insert(root, value);
        }
    
        arbolBinario.setRoot(root);
    
        System.out.println("Árbol Binario después de las inserciones:");
        arbolBinario.printTree(); 
    }
    
    public static void runEjercicio2() {
        ArbolBinario arbolBinario = new ArbolBinario();
        InsertBSTTEST insertHelper = new InsertBSTTEST();
        InvertBinaryTree invertHelper = new InvertBinaryTree();
        
        int[] valores = {4, 2, 7, 1, 3, 6, 9};
        System.out.println("Lista de entrada: " + java.util.Arrays.toString(valores)); 
        Node root = null;
    
        for (int value : valores) {
            root = insertHelper.insert(root, value);
        }
    
        arbolBinario.setRoot(root);
        System.out.println("Árbol Binario Normal:");
        arbolBinario.printTree();
    
        Node invertedRoot = invertHelper.invertTree(root);
        arbolBinario.setRoot(invertedRoot);  
        
        System.out.println("Árbol Binario Invertido:");
        arbolBinario.printTree();
    }
    public static void runEjercicio3(){

        ArbolBinario arbolBinario = new ArbolBinario();
        int[] valores = {4, 2, 7, 1, 3, 6, 9};
        for (int i: valores){
            arbolBinario.insert(i);
        }
        arbolBinario.printTree();
        Node root = arbolBinario.getRoot();
        ListLeves listLeves = new ListLeves();
        List<List<Node>> levels = listLeves.listLeves(root);

        // Imprimir los nodos por niveles
        for (List<Node> level : levels) {
            for (Node node : level) {       
                System.out.print(node.getValue() + " ");
            }
            System.out.println();
        }
    }
    public static void runEjercicio4() {
        ArbolBinario arbolBinario = new ArbolBinario();
        Depth depthHelper = new Depth();

        int[] valores = {3, 9, 20, 15, 7}; 
        System.out.println("Lista de entrada: " + java.util.Arrays.toString(valores)); 
        for (int value : valores) {
            arbolBinario.insert(value);
        }

        System.out.println("Árbol Binario:");
        arbolBinario.printTree();

        int maxDepth = depthHelper.maxDepth(arbolBinario.getRoot());
        System.out.println("La profundidad máxima del árbol binario es: " + maxDepth);
    }

    // private static void runArbolAVL() {
    //     int[] values = {10, 20, 15, 24, 9, 8, 21, 23, 50, 25};

    //     ArbolAVL arbol = new ArbolAVL();

    //     for (int value : values) {
    //         arbol.insert(value);
    //         System.out.println("Árbol AVL después de insertar " + value + ":");
    //         arbol.printTree();
    //         System.out.println(); 
    //     }

    //     System.out.println("FIN");
    // }
    // private static void runArbolAVL() {
    //     int[] values = {10, 20, 15, 24, 9, 8, 21};
    //     ArbolAVL arbol = new ArbolAVL();
    
    //     for (int value : values) {
    //         System.out.println("* Nodo a insertar: " + value);
    //         arbol.insert(value);
    
    //         Node root = arbol.getRoot();
    //         Stack<Node> stack = new Stack<>();
    //         stack.push(root);
    
    //         boolean rotationHappened = false;
    
    //         while (!stack.isEmpty()) {
    //             Node current = stack.pop();
    //             int leftHeight = (current.getLeft() != null) ? current.getLeft().getHeight() : 0;
    //             int rightHeight = (current.getRight() != null) ? current.getRight().getHeight() : 0;
    //             int balance = leftHeight - rightHeight;
    
    //             String rotationType = "";
    //             if (balance > 1) {
    //                 rotationType = (current.getLeft() != null && value > current.getLeft().getValue()) ? "Izquierda-Derecha" : "Derecha";
    //                 rotationHappened = true;
    //             } else if (balance < -1) {
    //                 rotationType = (current.getRight() != null && value < current.getRight().getValue()) ? "Derecha-Izquierda" : "Izquierda";
    //                 rotationHappened = true;
    //             }
    
    //             System.out.println("- Nodo actual: " + current.getValue());
    //             System.out.println("  Altura del nodo: " + current.getHeight());
    //             System.out.println("  Equilibrio del nodo: " + balance);
    
    //             if (!rotationType.isEmpty()) {
    //                 System.out.println("  Rotación " + rotationType + " en nodo " + current.getValue() + ", Balance: " + balance);
    //                 System.out.println("  Nueva raíz después de rotación: " + root.getValue());
    //             }
    
    //             if (current.getRight() != null) stack.push(current.getRight());
    //             if (current.getLeft() != null) stack.push(current.getLeft());
    //         }
    
    //         System.out.println("Árbol AVL después de insertar " + value + ":");
    //         arbol.printTree();
    //         System.out.println();
    //     }
    
    //     System.out.println("FIN");
    // }
    
    
}

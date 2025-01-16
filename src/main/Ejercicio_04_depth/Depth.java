package main.Ejercicio_04_depth;

import main.Materia.Models.Node;

public class Depth {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.getLeft());  //profundidad del subárbol izquierdo
        int rightDepth = maxDepth(root.getRight());  //profundidad del subárbol derecho
        return Math.max(leftDepth, rightDepth) + 1;  
    }
}

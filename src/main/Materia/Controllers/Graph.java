package main.Materia.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import main.Materia.Models.NodeG;

public class Graph {
   private List<NodeG> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public NodeG addNodeg(int value) {
        NodeG newNode = new NodeG(value);
        nodes.add(newNode);
        return newNode;
    }

    public void addEdge(NodeG src, NodeG dest) {
        src.addNeighbors(dest);
        dest.addNeighbors(src);
    }

    public void printGraph() {
        for (NodeG node : nodes) {
            System.out.print("Nodo: " + node.getValue());
            System.out.print(" Vecinos: ");
            for (NodeG neighbor : node.getNeighbors()) {
                System.out.print(neighbor.getValue() + " ");
            }
            System.out.println();
        }
    }

    // Grafo dirigido
    public void addDirectedEdge(NodeG src, NodeG dest) {
        src.addNeighbors(dest);
    }

    public void getDFS(NodeG start) {
        Set<NodeG> visitados = new HashSet<>();
        System.out.print("DFS: ");
        getDFSutil(start, visitados);
        System.out.println();
    }

    private void getDFSutil(NodeG node, Set<NodeG> visitados) {
        if (visitados.contains(node)) {
            return;
        }
        visitados.add(node);
        System.out.print(node.getValue() + " ");
        for (NodeG neighborNodeG : node.getNeighbors()) {
            getDFSutil(neighborNodeG, visitados);
        }
    }




    // Grafo no dirigido
    public void getBFS(NodeG start) {
        Set<NodeG> visitados = new HashSet<>();
        Queue<NodeG> queue = new LinkedList<>();
        System.out.print("BFS: ");
        queue.add(start);
        visitados.add(start);
        while (!queue.isEmpty()) {
            NodeG node = queue.poll();
            System.out.print(node.getValue() + " ");
            for (NodeG neighborNodeG : node.getNeighbors()) {
                if (!visitados.contains(neighborNodeG)) {
                    queue.add(neighborNodeG);
                    visitados.add(neighborNodeG);
                }
            }
        }
        System.out.println();
    }

    public boolean getDFSPath(NodeG start, NodeG destino) {
        Set<NodeG> visitados = new HashSet<>();
        return getDFSutil(start, destino, visitados);
    }

    private boolean getDFSutil(NodeG node, NodeG destino, Set<NodeG> visitados) {
        if (node.equals(destino)) {
            return true;
        }
        if (visitados.contains(node)) {
            return false;
        }
        visitados.add(node);
        for (NodeG neighborNodeG : node.getNeighbors()) {
            if (getDFSutil(neighborNodeG, destino, visitados)) {
                return true;
            }
        }
        return false;
    }

    public boolean getDFS1(NodeG start, NodeG destino) {
        Set<NodeG> visitados = new HashSet<>();
        Queue<NodeG> queue = new LinkedList<>();
        queue.add(start);
        visitados.add(start);
        while (!queue.isEmpty()) {
            NodeG node = queue.poll();
            if (node.equals(destino)) {
                return true;
            }
            for (NodeG neighborNodeG : node.getNeighbors()) {
                if (!visitados.contains(neighborNodeG)) {
                    queue.add(neighborNodeG);
                    visitados.add(neighborNodeG);
                }
            }
        }
        return false;
    }
}

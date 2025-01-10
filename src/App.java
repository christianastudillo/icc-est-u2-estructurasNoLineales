import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolRecorridos;
import main.Materia.Models.Node;
public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        runArbolBinario();
    }
    public static void runArbolBinario() {
        ArbolBinario arbolBinario = new ArbolBinario();
        int[] valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

        for (int valor : valores) {
            arbolBinario.insert(valor);
        }
        arbolBinario.printTree();
        System.out.println(); 

        Node root = arbolBinario.getRoot();

        ArbolRecorridos arbolRecorridos = new ArbolRecorridos();
        System.out.println("\n Recorrido PreOrder Iterativo");
        arbolRecorridos.preOrderIterativo(root);
        System.out.println("\n Recorrido PreOrder Recursivo");
        arbolRecorridos.preOrderRecursivo(root);
        System.out.println("\n Recorrido PostOrder");
        arbolRecorridos.postOrderRecursivo(root);
        System.out.println("\n Recorrido InOrder");
        arbolRecorridos.inOrderRecursivo(root);
    }
}

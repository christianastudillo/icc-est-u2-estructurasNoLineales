import main.Materia.Controllers.ArbolBinario;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        runArbolBinario();
    }
    public static void runArbolBinario(){
        ArbolBinario arbolBinario = new ArbolBinario();
        int[] valores={40, 20, 60, 10, 30, 50, 70, 5 ,15, 55};

        for(int valor: valores){
            arbolBinario.insert(valor);
        }

        arbolBinario.printTree();
    }
}

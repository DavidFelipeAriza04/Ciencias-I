package AVLTree;

/**
 *
 * @author estudiantes
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Arbol Binario");

        AVLNode Arbol = new AVLNode();
        Arbol.addNode(new AVLNode(4));
        Arbol.addNode(new AVLNode(7));
        Arbol.addNode(new AVLNode(5));
        Arbol.addNode(new AVLNode(8));
        Arbol.addNode(new AVLNode(6));
        Arbol.addNode(new AVLNode(3));
        //Arbol.inorder();
        
        Arbol.balanceFactor();

        // System.out.println("Altura del arbol: " + Arbol.height());
        // System.out.println("Grado arbol: " + Arbol.grade());

        // System.out.println("Eliminar 4");
        // Arbol.deleteNode(Arbol.search(4));

        // System.out.println("Altura del arbol: " + Arbol.height());
        // System.out.println("Grado nodo : " + Arbol.grade());

        // System.out.println("Nivel del nodo 7: " + Arbol.depth(Arbol.search(7)));
        // System.out.println("Grado nodo 7: " + Arbol.grade(Arbol.search(7)));

        // System.out.println("Nivel del nodo 6: " + Arbol.depth(Arbol.search(6)));
        // System.out.println("Grado nodo 6: " + Arbol.grade(Arbol.search(6)));

        // System.out.println(Arbol.search(9));
        // // Si la funcion depth retorna un -1 es porque el nodo no existe
        // System.out.println("Nivel del nodo 4: " + Arbol.depth(Arbol.search(4)));

        // Arbol.deleteNode(Arbol.search(5));
        // Arbol.deleteNode(Arbol.search(7));
        // Arbol.deleteNode(Arbol.search(6));
        // Arbol.deleteNode(Arbol.search(8));

        // System.out.println(Arbol.grade());

    }
}

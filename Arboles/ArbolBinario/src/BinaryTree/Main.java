/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package BinaryTree;

import Tree.BinaryTree;

/**
 *
 * @author estudiantes
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Arbol Binario");

        BinaryTree Arbol = new SortNode();
        Arbol.addNode(new SortNode(4));
        Arbol.addNode(new SortNode(7));
        Arbol.addNode(new SortNode(5));
        Arbol.addNode(new SortNode(8));
        Arbol.addNode(new SortNode(6));
        Arbol.inorder();

        System.out.println("Altura del arbol: " + Arbol.height());
        System.out.println("Grado arbol: " + Arbol.grade());

        System.out.println("Eliminar 4");
        Arbol.deleteNode(Arbol.search(4));

        System.out.println("Altura del arbol: " + Arbol.height());
        System.out.println("Grado nodo : " + Arbol.grade());

        System.out.println("Nivel del nodo 7: " + Arbol.depth(Arbol.search(7)));
        System.out.println("Grado nodo 7: " + Arbol.grade(Arbol.search(7)));

        System.out.println("Nivel del nodo 6: " + Arbol.depth(Arbol.search(6)));
        System.out.println("Grado nodo 6: " + Arbol.grade(Arbol.search(6)));

        System.out.println(Arbol.search(9));
        //Si la funcion depth retorna un -1 es porque el nodo no existe
        System.out.println("Nivel del nodo 4: " + Arbol.depth(Arbol.search(4)));
        
        Arbol.deleteNode(Arbol.search(5));
        Arbol.deleteNode(Arbol.search(7));
        Arbol.deleteNode(Arbol.search(6));
        Arbol.deleteNode(Arbol.search(8));
        
        System.out.println(Arbol.grade());
        

    }
}

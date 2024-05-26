/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AVLTree;
import Vista.AVLTreeVisualizer;
/**
 *
 * @author david
 */
public class Main {
    public static void main(String[] args){
        AVLNode<Integer> Arbol = new AVLNode<>();
        AVLTreeVisualizer<Integer> visualizer = new AVLTreeVisualizer<>(Arbol);
        Arbol.addNode(new AVLNode<>(134));
        Arbol.addNode(new AVLNode<>(72));
        Arbol.addNode(new AVLNode<>(216));
        Arbol.addNode(new AVLNode<>(43));
        Arbol.addNode(new AVLNode<>(100));
        Arbol.addNode(new AVLNode<>(199));
        Arbol.addNode(new AVLNode<>(321));
        Arbol.addNode(new AVLNode<>(32));
        Arbol.addNode(new AVLNode<>(50));
        Arbol.addNode(new AVLNode<>(90));
        Arbol.addNode(new AVLNode<>(110));
        Arbol.addNode(new AVLNode<>(205));
        Arbol.deleteNode(Arbol.search(72));
        Arbol.deleteNode(Arbol.search(110));
        Arbol.deleteNode(Arbol.search(321));
        Arbol.addNode(new AVLNode<>(350));
        Arbol.addNode(new AVLNode<>(253));
        Arbol.addNode(new AVLNode<>(724));
        Arbol.addNode(new AVLNode<>(3));
        Arbol.addNode(new AVLNode<>(123));
        visualizer.setVisible(true);
    }
}

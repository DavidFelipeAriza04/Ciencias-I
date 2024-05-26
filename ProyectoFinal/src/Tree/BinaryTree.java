/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

/**
 *
 * @author estudiantes
 * @param <T>
 */
@SuppressWarnings({"rawtypes"})
public abstract class BinaryTree<T> {

    private BinaryNode root;

    public void addNode(BinaryNode Parent, BinaryNode newNode, boolean isLeft) {
        newNode.setParent(Parent);
        if (isLeft) {
            Parent.setLeft(newNode);
        } else {
            Parent.setRight(newNode);
        }
    }

    public abstract void addNode(BinaryNode newNode);

    public abstract BinaryNode<T> search(T data);

    public abstract void deleteNode(BinaryNode node);
    
    public abstract String depth(BinaryNode node);
    
    public abstract int height();
    
    public abstract int height(int count);
    
    public abstract int grade();
    
    public abstract String grade(BinaryNode node);
    
    public abstract boolean isLeaf();
    public abstract BinaryNode  clone();//METODO PROTOTYPE

    public void inorder() {
        if (getRoot() != null) {
            getRoot().inorder();
        }
    }
    public void preOrder() {
        if (getRoot() != null) {
            getRoot().preOrder();
        }
    }

    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tree;

/**
 *
 * @author estudiantes
 */
public abstract class BinaryNode<T> extends BinaryTree {

    private T data;
    private BinaryNode left;
    private BinaryNode right;
    private BinaryNode parent;

    @Override
    public BinaryNode<T> search(Object data) {
        BinaryNode<T> node;
        if (this.data.equals(data)) {
            return this;
        }
        node = left.search(data);
        if (node == null) {
            node = right.search(data);
        }
        return node;
    }

    @Override
    public void inorder() {
        if (getLeft() != null) {
            getLeft().inorder();
        }
        System.out.println(getData());
        if (getRight() != null) {

            getRight().inorder();
        }
    }

    //PROFUNDIDAD O ALTURA DE UN NODO RESPECTO A LA RAIZ
    @Override
    public String depth(BinaryNode node) {
        BinaryNode aux = node;
        int count = 0;
        if (node == null) {
            return "El nodo no existe";
        }
        while (aux.getParent() != null) {
            aux = aux.getParent();
            count += 1;
        }
        return String.valueOf(count);
    }

    //ALTURA DE ARBOL
    @Override
    public int height() {
        int countR = 0;
        int countL = 0;
        if (this.getRoot() == null) {
            return 0;
        }
        if (this.isLeaf()) {
            return 1;
        }
        if (this.getRight() != null) {
            countR = this.getRight().height(1);
        }
        if (this.getLeft() != null) {
            countL = this.getLeft().height(1);
        }
        if (countL >= countR) {
            return countL;
        }
        return countR;
    }

    @Override
    public int height(int num) {
        int count = num + 1;
        int countL = 0;
        int countR = 0;
        if (this.isLeaf()) {
            return count;
        }
        if (this.getRight() != null) {
            countR = this.getRight().height(count);
        }
        if (this.getLeft() != null) {
            countL = this.getLeft().height(count);
        }
        if (countL >= countR) {
            return countL;
        }
        return countR;
    }
    
    
    @Override
    public String grade(BinaryNode node) {
        if(node == null){
            return "El nodo no existe";
        }
        if (node.isLeaf()) {
            return "0";
        } else if (node.getRight()!=null && node.getLeft() !=null) {
            return "2";
        }
        return "1";
    }
    
    @Override
    public int grade(){
        int gradeR = 0;
        int gradeL = 0;
        if (this.isLeaf()) {
            return 0;
        }else if(getRight()!=null && getLeft() !=null){
            return 2;
        }
        if (this.getRight() != null) {
            if(getRight().isLeaf()){
                gradeR = 1;
            }else{
                gradeR = getRight().grade();
            }
        }
        if (this.getLeft() != null) {
            if(getLeft().isLeaf()){
                gradeL = 1;
            }else{
                gradeL = getLeft().grade();
            }
        }
        if (gradeL >= gradeR) {
            return gradeL;
        }
        return gradeR;
    }
    
    @Override
    public boolean isLeaf() {
        if (this.getLeft() == null && this.getRight() == null) {
            return true;
        }
        return false;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * @return the left
     */
    public BinaryNode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public BinaryNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(BinaryNode right) {
        this.right = right;
    }

    /**
     * @return the parent
     */
    public BinaryNode getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }

}

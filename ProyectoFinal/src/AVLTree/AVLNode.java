package AVLTree;

import Tree.BinaryNode;

/**
 *
 * @author estudiantes
 */
public class AVLNode<T extends Comparable> extends BinaryNode<T> {

    private int balanceFactor;

    public AVLNode() {
    }

    public AVLNode(T data) {
        super.setData(data);
        super.setParent(null);
    }

    @Override
    public void addNode(BinaryNode newNode) {
        if (this.getData() == null) {
            this.setData((T) newNode.getData());
            this.setRoot(this);
        } else if (this.getData().compareTo(newNode.getData()) > 0) {
            if (getLeft() != null) {
                this.getLeft().addNode(newNode);
            } else {
                newNode.setParent(this);
                setLeft(newNode);
            }
        } else {
            if (getRight() != null) {
                this.getRight().addNode(newNode);
            } else {
                newNode.setParent(this);
                // System.out.println(newNode.getParent().getData());
                setRight(newNode);
            }
        }
        balanceFactor();
    }

    @Override
    public void deleteNode(BinaryNode node) {
        AVLNode suc;
        if (node == null) {
            System.out.println("No existe el nodo");
            return;
        }
        if (node.getParent() == null) {
            if (node.getRight() == null && node.getLeft() == null) {
                this.setData(null);
                this.setRoot(null);
            } else if (node.getRight() != null) {
                suc = successor((AVLNode) node.getRight());
                this.setData((T) suc.getData());
                if (suc.getParent() == this.getRoot()) {
                    suc.getParent().setRight(suc.getRight());
                } else {
                    suc.getParent().setLeft(suc.getRight());
                }
            } else {
                this.setData((T) this.getLeft().getData());
                this.setRight(this.getLeft().getRight());
                this.setLeft(this.getLeft().getLeft());
            }
        } // }
        //
        else if (node.getLeft() == null && node.getRight() == null) {
            if (this.izq_o_der((AVLNode) node)) {
                node.getParent().setLeft(null);
            } else {
                node.getParent().setRight(null);
            }
        } else {
            if (node.getRight() != null) {
                suc = successor((AVLNode) node.getRight());
                suc.setParent(node.getParent());
                if (node.getParent().getLeft() != null && node.getParent().getLeft().equals(node)) {
                    node.getParent().setLeft(suc);
                } else if (node.getParent().getRight().equals(node)) {
                    node.getParent().setRight(suc);
                }
            } else {
                node.getParent().setLeft(node.getLeft());
            }
        }
    }

    public AVLNode<T> successor(AVLNode<T> node) {
        if (node.getLeft() != null) {
            return ((AVLNode) node.getLeft()).successor((AVLNode) node.getLeft());
        }
        return node;
    }

    @Override
    public BinaryNode<T> search(Object data) {
        BinaryNode<T> node = null;
        if (this.getData().equals(data)) {
            return this;
        }
        if (getLeft() != null) {
            node = getLeft().search(data);
        }
        if (node == null && getRight() != null) {
            node = getRight().search(data);
        }
        return node;
    }

    public boolean izq_o_der(AVLNode node) {
        return node.getParent().getLeft() == node;
    }

    public void balanceFactor() {
        if (this.getLeft() == null && this.getRight() == null) {
            balanceFactor = 0;
        } else if (getLeft() == null) {
            balanceFactor = getRight().height();
        } else if (getRight() == null) {
            balanceFactor = this.getLeft().height();
        } else {
            balanceFactor = this.getLeft().height() - this.getRight().height();
        }
        System.out.println("Factor de equilibrio: " + balanceFactor);
    }
    
    public void balance(int num1, int num2){
        switch (num1) {
            case 2:
                
                break;
            default:
                throw new AssertionError();
        }
    }
}

package AVLTree;

import Tree.BinaryNode;

/**
 *
 * @author estudiantes
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class AVLNode<T extends Comparable> extends BinaryNode<T> {

    public AVLNode() {
    }

    public AVLNode(AVLNode node) {// CONSTRUCTOR PARA EL PATRON PROTOTYPE
        if (node != null) {
            super.setData((T) node.getData());
            this.setLeft(node.getLeft());
            this.setRight(node.getRight());
            this.setParent(node.getParent());
        }
    }

    public AVLNode(T data) {
        super.setData(data);
        super.setParent(null);
    }

    // AGREGAR NODO
    @Override
    public void addNode(BinaryNode newNode) {
        if (this.getData() == null) {// SI ES RAIZ
            this.setData((T) newNode.getData());
            this.setRoot(this);
            isBalanced(this);
            this.setNodos(getNodos() + 3);
        } else if (this.getData().compareTo(newNode.getData()) > 0) {// SI ES ISQUIERDO O DERECHO
            if (getLeft() != null) {
                this.getLeft().addNode(newNode);
            } else {
                newNode.setParent(this);
                setLeft(newNode);
                isBalanced((AVLNode) this.getLeft());
            }
        } else {
            if (getRight() != null) {
                this.getRight().addNode(newNode);
            } else {
                newNode.setParent(this);
                setRight(newNode);
                isBalanced((AVLNode) this.getRight());
            }
        }
        if (this == this.getRoot()) {
            asignarMemoria(0);
        }
    }

    // BORRAR NODO
    @Override
    public void deleteNode(BinaryNode node) {
        AVLNode suc = (AVLNode) node;
        if (node == null) {
            return;
        } else if (node.getParent() == null) {// CUANDO ES RAIZ
            if (node.getRight() == null && node.getLeft() == null) { // SI ES HOJA
                this.setData(null);
                this.setRoot(null);
            } else if (node.getRight() != null) {// BUSCRAR EL MAS IZQUIERDO DEL DERECHO
                suc = successor((AVLNode) node.getRight());
                this.setData((T) suc.getData());
                if (suc.getParent() == this.getRoot()) {
                    suc.getParent().setRight(suc.getRight());
                } else {
                    suc.getParent().setLeft(suc.getRight());
                }
            } else {// SUBE TODA SU PARTE IZQUIERDA
                this.setData((T) this.getLeft().getData());
                this.setRight(this.getLeft().getRight());
                this.setLeft(this.getLeft().getLeft());
            }

        }
        // SI NO ES RAIZ
        else if (node.getLeft() == null && node.getRight() == null) {// SI ES HOJA PERO NO ES RAIZ
            // System.out.println("Es hoja");
            if (this.izq_o_der((AVLNode) node)) {
                // System.out.println("Es hijo izq");
                node.getParent().setLeft(null);
            } else {
                // System.out.println("Es hijo der");
                node.getParent().setRight(null);
            }
        } else {
            // SI TIENE HIJO DER
            if (node.getRight() != null) {// BUSCAR EL SUCESOR
                suc = successor((AVLNode) node.getRight());

                // ES HIJO IZQ
                if (node.getParent().getLeft() != null && node.getParent().getLeft().equals(node)) {
                    node.setData(suc.getData());
                    if (this.izq_o_der(suc)) {
                        suc.getParent().setLeft(null);
                    } else {
                        suc.getParent().setRight(null);
                    }
                } else if (node.getParent().getRight().equals(node)) { // ES HIJO DER
                    node.getParent().setRight(suc);
                }
            } else {// NO TIENE HIJO DER, SUBIR TODA LA IZQUIERDA
                node.getParent().setLeft(node.getLeft());
            }
        }
        // VERIFICAR SI ESTA BALANCEADO
        // System.out.println("Sucesor: " + suc.getData());
        // System.out.println("Padre: " + suc.getParent().getData());
        isBalanced((AVLNode) suc.getParent());
        if (this == this.getRoot()) {
            asignarMemoria(0);
        }
    }

    // BUSCA EL SUCCESOR
    public AVLNode<T> successor(AVLNode<T> node) {
        if (node.getLeft() != null) {
            return ((AVLNode) node.getLeft()).successor((AVLNode) node.getLeft());
        }
        return node;
    }

    // METODO DE BUSQUEDA DE NODO
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

    // METODO SABER SI ES HIJO IZQ O DERE
    public boolean izq_o_der(AVLNode node) {
        return node.getParent().getLeft() == node;
    }

    // METODO PARA ENCONTRAR EL FACTOR DE BALANCEO
    public int balanceFactor(AVLNode node) {
        if (node.isLeaf()) {
            return 0;
        } else if (node.getLeft() != null && node.getRight() == null) {
            return -node.getLeft().height();
        } else if (node.getRight() != null && node.getLeft() == null) {
            return node.getRight().height();
        }
        return node.getRight().height() - node.getLeft().height();
    }

    // METODO PARA VER SI EL ARBOL ES BALNACEADO
    public void isBalanced(AVLNode node) {
        if (node == null) {
            return;
        }
        if (balanceFactor(node) == 2 || balanceFactor(node) == -2) {// NO ESTA BALANCEADO
            swing(balanceFactor(node), (AVLNode) node);
        }
        isBalanced((AVLNode) node.getParent());
    }

    // METODO PARA BALANCEAR EL ARBOL SEGUN LOS CASOS
    public void swing(int factor, AVLNode node) {
        int factB;
        AVLNode cp = (AVLNode) node.clone();// copia de toda la ramma
        AVLNode cp1;// copia de la rama que queda volando
        switch (factor) {
            case -2:
                if ((AVLNode) node.getLeft().getRight() == null) {
                    cp1 = null;
                } else {
                    cp1 = (AVLNode) node.getLeft().getRight().clone();
                }
                factB = balanceFactor((AVLNode) node.getLeft());
                if (factB == -1 || factB == 0) {
                    node.setData(node.getLeft().getData());
                    node.setLeft(cp.getLeft().getLeft());
                    cp.setLeft(cp1);
                    if (cp1 != null) {
                        cp1.setParent(cp);
                    }
                    if (node.getRight() != null) {
                        node.getRight().setParent(cp);
                    }
                    node.setRight(cp);
                }
                if (factB == 1) {
                    node.setData(node.getLeft().getRight().getData());
                    node.getLeft().setRight(cp1.getLeft());
                    cp.setLeft(cp1.getRight());
                    if (cp1.getRight() != null) {
                        cp1.getRight().setParent(cp);
                    }
                    node.setRight(cp);
                }
                cp.setParent(node);
                isBalanced(node);
                break;

            case 2:
                if ((AVLNode) node.getRight().getLeft() == null) {
                    cp1 = null;
                } else {
                    cp1 = (AVLNode) node.getRight().getLeft().clone();
                }
                factB = balanceFactor((AVLNode) node.getRight());
                if (factB == 1 || factB == 0) {
                    node.setData(node.getRight().getData());
                    node.setRight(cp.getRight().getRight());
                    cp.setRight(cp1);
                    if (cp1 != null) {
                        cp1.setParent(cp);
                    }
                    if (node.getLeft() != null) {
                        node.getLeft().setParent(cp);
                    }
                    node.setLeft(cp);
                }
                if (factB == -1) {
                    node.setData(node.getRight().getLeft().getData());
                    node.getRight().setLeft(cp1.getRight());
                    cp.setRight(cp1.getLeft());
                    if (cp1.getLeft() != null) {
                        cp1.getLeft().setParent(cp);
                    }
                    node.setLeft(cp);
                }
                cp.setParent(node);
                isBalanced(node);
                break;
            default:
                break;
        }
    }

    // PATRON PROTOTYPE
    @Override
    public BinaryNode clone() {
        return new AVLNode(this);
    }
}

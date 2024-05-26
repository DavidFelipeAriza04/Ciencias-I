/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import AVLTree.AVLNode;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AVLTreeVisualizer<T extends Comparable> extends JFrame {

    private AVLNode<T> root;

    public AVLTreeVisualizer(AVLNode<T> Arbol) {
        this.root = Arbol;
        setTitle("AVL Tree Visualization");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        JTextField node = new JTextField(10);

        // Crear el botón "Añadir"
        JButton addNode = new JButton("Añadir");
        addNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para el botón "Añadir"
                try {
                    int nodeData = Integer.parseInt(node.getText());
                    JOptionPane.showMessageDialog(null, "Anadir nodo " + node.getText());
                    Arbol.addNode(new AVLNode<>(nodeData));
                    node.setText("");
                    // Arbol.preOrder();
                    showTree();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El dato dado no es un numero", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
                    node.setText("");
                }
                
            }
        });
        
        JButton delNode = new JButton("Eliminar");
        delNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para el botón "Añadir"
                try {
                    int nodeData = Integer.parseInt(node.getText());
                    JOptionPane.showMessageDialog(null, "Eliminar nodo " + node.getText());
                    Arbol.deleteNode(Arbol.search(nodeData));
                    System.out.println("Elminar "+nodeData+":");
                    node.setText("");
                    Arbol.preOrder();
                    showTree();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El dato dado no es un numero", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    node.setText("");
                }
            }
        });
        
        JButton exit = new JButton("Salir");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Añadir el botón a la ventana
        this.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(WIDTH, 40));
        panel.setBorder(new LineBorder(Color.BLACK));

        JPanel nodePanel = new JPanel();
        nodePanel.add(addNode);
        nodePanel.add(delNode);
        nodePanel.add(node);

        JPanel exitPanel = new JPanel();
        exitPanel.add(exit);

        panel.add(exitPanel, BorderLayout.EAST);
        panel.add(nodePanel, BorderLayout.CENTER);

        this.add(panel, BorderLayout.SOUTH);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (root != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            drawTree(g2d, getWidth() / 2, 100, getWidth() / 4, 50, root);
        }
    }

    private void drawTree(Graphics g, int x, int y, int horizontalSpacing, int verticalSpacing, AVLNode<T> node) {
        if (node != null) {
            // Dibujar el nodo
            g.setColor(Color.WHITE);
            g.fillOval(x - 20, y - 20, 40, 40);
            g.setColor(Color.BLACK);
            g.drawOval(x - 20, y - 20, 40, 40);
            g.drawString(node.getData().toString(), x - 6, y + 5);

            // Dibujar la línea y los hijos
            if (node.getLeft() != null) {
                int childX = x - horizontalSpacing;
                int childY = y + verticalSpacing;
                g.drawLine(x, y + 20, childX, childY - 20);
                drawTree(g, childX, childY, horizontalSpacing / 2, verticalSpacing, (AVLNode<T>) node.getLeft());
            }

            if (node.getRight() != null) {
                int childX = x + horizontalSpacing;
                int childY = y + verticalSpacing;
                g.drawLine(x, y + 20, childX, childY - 20);
                drawTree(g, childX, childY, horizontalSpacing / 2, verticalSpacing, (AVLNode<T>) node.getRight());
            }
        }
    }

    public void showTree() {
        repaint();
    }
}

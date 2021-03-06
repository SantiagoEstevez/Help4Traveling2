/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Fabrica;
import Logica.ManejadorCategoria;
import Logica.Servicio;
import java.util.Iterator;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author yaman
 */
public class verInfoServicio extends javax.swing.JInternalFrame {

    //private DefaultMutableTreeNode modelo;
    public Fabrica fabrica;
    private DefaultTableModel modeloTablaSer;
    private Boolean expandir = true;
    //private DefaultMutableTreeNode modeloCategorias;

    /**
     * Creates new form verInfoServicio
     */
    public verInfoServicio() {
        initComponents();
        fabrica = Fabrica.getInstance();
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categorias");
        DefaultTreeModel modelo = new DefaultTreeModel(raiz);

        MostrarArbol(raiz);
        jTreeCategorias.setModel(modelo);

        jButtonExpandir.setIcon(UIManager.getIcon("Tree.openIcon"));
    }

    public void MostrarArbol(DefaultMutableTreeNode nodo) {
        ManejadorCategoria mc = ManejadorCategoria.getInstance();
        List<String> listaHijos = mc.obtenerCategoriasHijas(nodo.toString());
        Iterator<String> iter = listaHijos.iterator();
        while (iter.hasNext()) {
            String hijo = iter.next();
            System.out.println(hijo);
            DefaultMutableTreeNode nuevoNodo = new DefaultMutableTreeNode(hijo);
            nodo.add(nuevoNodo);
            System.out.println("Agregue el nodo " + hijo);
        }

        for (int j = 0; j < nodo.getChildCount(); j++) {
            MostrarArbol((DefaultMutableTreeNode) nodo.getChildAt(j));
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeCategorias = new javax.swing.JTree();
        jVerServicios = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaServicios = new javax.swing.JTable();
        jButtonExpandir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CATEGORIAS");

        jTreeCategorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTreeCategoriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeCategorias);

        jVerServicios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jVerServicios.setText("Ver Servicios");
        jVerServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jVerServiciosMouseClicked(evt);
            }
        });

        jTablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "servicio", "proveedor", "precio", "origen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablaServicios);

        jButtonExpandir.setText("Expandir Todas");
        jButtonExpandir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExpandirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jVerServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonExpandir)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jVerServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExpandir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTreeCategoriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreeCategoriasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTreeCategoriasMouseClicked

    private void jVerServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jVerServiciosMouseClicked
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTreeCategorias.getLastSelectedPathComponent();
        if (node == null) {
            return;
        } else {
            // JOptionPane.showMessageDialog(null, node.toString());
            List<String> listaServicios = fabrica.getIControladorServicio().listarServiciosCategoria(node.toString());
            Iterator<String> iter = listaServicios.iterator();

            String[] columnasServicios = {"servicio", "proveedor", "precio", "origen"};
            String[] registrosServicios = new String[4];
            modeloTablaSer = new DefaultTableModel(null, columnasServicios);

            while (iter.hasNext()) {
                String ser = iter.next();
                Servicio servicio = fabrica.getIControladorServicio().obtenerServicio(ser);
                System.out.println(servicio.getNombre());
                registrosServicios[0] = servicio.getNombre();
                System.out.println(servicio.getProveedor().getNickname());
                registrosServicios[1] = servicio.getProveedor().getNickname();

                //System.out.println(registrosServicios[0]);
                registrosServicios[2] = Float.toString(servicio.getPrecio());
                registrosServicios[3] = servicio.getOrigen().getNombre();
                //registrosServicios[3] = servicio.getDestino().toString();

                modeloTablaSer.addRow(registrosServicios);
            }
        }
        jTablaServicios.setModel(modeloTablaSer);

    }//GEN-LAST:event_jVerServiciosMouseClicked

    private void jButtonExpandirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExpandirActionPerformed
        //jTree1.expandPath(jTree1.getSelectionPath());
        if (expandir) {
            for (int i = 0; i < jTreeCategorias.getRowCount(); i++) {
                jTreeCategorias.expandRow(i);
            }
            jButtonExpandir.setText("Colapsar Todas");
            expandir = false;
            jButtonExpandir.setIcon(UIManager.getIcon("Tree.closedIcon"));
        } else {
            for (int i = jTreeCategorias.getRowCount(); i > 0; i--) {
                jTreeCategorias.collapseRow(i);
            }
            jButtonExpandir.setText("Expandir Todas");
            expandir = true;
            jButtonExpandir.setIcon(UIManager.getIcon("Tree.openIcon"));
        }
    }//GEN-LAST:event_jButtonExpandirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExpandir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablaServicios;
    private javax.swing.JTree jTreeCategorias;
    private javax.swing.JButton jVerServicios;
    // End of variables declaration//GEN-END:variables

}

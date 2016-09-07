/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.DtServicio;
import Logica.Fabrica;
import Logica.ManejadorCategoria;
import Logica.ManejadorServicio;
import Logica.Servicio;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;

/**
 *
 * @author yaman
 */
public class verInfoServicio extends javax.swing.JInternalFrame {

    //private DefaultMutableTreeNode modelo;
    public Fabrica fabrica;
    private DefaultTableModel modeloTablaSer;
    //private DefaultMutableTreeNode modeloCategorias;

    /**
     * Creates new form verInfoServicio
     */
    public verInfoServicio() {
        initComponents();
        fabrica = Fabrica.getInstance();
        DefaultMutableTreeNode modeloCategorias = new DefaultMutableTreeNode("Categorias");
        DefaultTreeModel modelo = new DefaultTreeModel(modeloCategorias);

        MostrarArbol(modeloCategorias);
        jTreeCategorias.setModel(modelo);
    }

    public void MostrarArbol(DefaultMutableTreeNode modeloCategorias) {
        DefaultMutableTreeNode categoria = null;
        DefaultMutableTreeNode hoja = null;
        ManejadorCategoria mc = ManejadorCategoria.getInstance();
        List<String> padres = mc.obtenerCategoriasPadre();
        Iterator<String> iter = padres.iterator();
        //DefaultMutableTreeNode categoria=null; 
        while (iter.hasNext()) {
            String pad = iter.next();
            categoria = new DefaultMutableTreeNode(pad.toString());

            modeloCategorias.add(categoria);

            List<String> hijas = mc.obtenerCategoriasHijas(pad);
            Iterator<String> iter2 = hijas.iterator();
            //DefaultMutableTreeNode hoja=null;
            while (iter2.hasNext()) {
                String hij = iter2.next();

                hoja = new DefaultMutableTreeNode(hij.toString());
                categoria.add(hoja);
            }
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
                "servicio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablaServicios);

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
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(jVerServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jVerServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

            String[] columnasServicios = {"servicio"};
            String[] registrosServicios = new String[4];
            modeloTablaSer = new DefaultTableModel(null, columnasServicios);

            while (iter.hasNext()) {
                String ser = iter.next();
                System.out.println(ser.toString());
                registrosServicios[0] = ser.toString();
                /*
                System.out.println(registrosServicios[0]);
                registrosServicios[1] = Float.toString(ser.getPrecio());
                registrosServicios[2] = ser.getNomCiuOrigen().toString();
                registrosServicios[3] = ser.getNomCiuDestino().toString();
                */
                modeloTablaSer.addRow(registrosServicios);
            }
        }
        jTablaServicios.setModel(modeloTablaSer);


    }//GEN-LAST:event_jVerServiciosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablaServicios;
    private javax.swing.JTree jTreeCategorias;
    private javax.swing.JButton jVerServicios;
    // End of variables declaration//GEN-END:variables

}

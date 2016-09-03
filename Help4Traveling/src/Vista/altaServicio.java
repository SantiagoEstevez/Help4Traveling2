/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
    import Logica.DtUsuario;
    import Logica.Fabrica;
    import Logica.ControladorUsuario;
    import Logica.Date;
    import javax.swing.JOptionPane;
    import Logica.IControladorUsuario;
/**
 *
 * @author Santiago
 */
public class altaServicio extends javax.swing.JInternalFrame {

    /**
     * Creates new form altaServicio
     */
    public altaServicio() {
        //this.tr_categoria.setVisible(false);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_nombre_s = new javax.swing.JLabel();
        tf_nombre_s = new javax.swing.JTextField();
        lb_origen = new javax.swing.JLabel();
        tf_origen = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tr_categoria = new javax.swing.JTree();
        bt_categoria = new javax.swing.JButton();
        bt_aceptar_s = new javax.swing.JButton();
        bt_cancelar_s = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Nuevo servicio");

        lb_nombre_s.setText("Nombre");

        lb_origen.setText("Origen");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("JTree");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Autos");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Ubicacion");
        javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Playa");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Vuelos");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Tipo");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("LowCost");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Empresas");
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("American Airlines");
        treeNode3.add(treeNode4);
        treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("Iberia");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        tr_categoria.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(tr_categoria);

        bt_categoria.setText("Categoría");
        bt_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_categoriaActionPerformed(evt);
            }
        });

        bt_aceptar_s.setText("Aceptar");
        bt_aceptar_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_aceptar_sActionPerformed(evt);
            }
        });

        bt_cancelar_s.setText("Cancelar");
        bt_cancelar_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelar_sActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_origen)
                            .addComponent(lb_nombre_s))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nombre_s, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_origen, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bt_categoria)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bt_aceptar_s)
                .addGap(18, 18, 18)
                .addComponent(bt_cancelar_s)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nombre_s)
                    .addComponent(tf_nombre_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_origen)
                    .addComponent(tf_origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(bt_categoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_aceptar_s)
                    .addComponent(bt_cancelar_s))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_categoriaActionPerformed
        // TODO add your handling code here:
        this.tr_categoria.setVisible(true);

    }//GEN-LAST:event_bt_categoriaActionPerformed

    private void bt_aceptar_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_aceptar_sActionPerformed
        // TODO add your handling code here:
        String nombre_s = this.tf_nombre_s.getText();
        String origen = this.tf_origen.getText();
        String categoria = this.tr_categoria.getSelectionPath().toString();
        JOptionPane.showMessageDialog(null,categoria );

        this.setVisible(false);
        this.tr_categoria.setVisible(false);
        this.tf_nombre_s.setText("");
        this.tf_origen.setText("");

    }//GEN-LAST:event_bt_aceptar_sActionPerformed

    private void bt_cancelar_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelar_sActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.tr_categoria.setVisible(false);
        this.tf_nombre_s.setText("");
        this.tf_origen.setText("");

    }//GEN-LAST:event_bt_cancelar_sActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar_s;
    private javax.swing.JButton bt_cancelar_s;
    private javax.swing.JButton bt_categoria;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_nombre_s;
    private javax.swing.JLabel lb_origen;
    private javax.swing.JTextField tf_nombre_s;
    private javax.swing.JTextField tf_origen;
    private javax.swing.JTree tr_categoria;
    // End of variables declaration//GEN-END:variables
}
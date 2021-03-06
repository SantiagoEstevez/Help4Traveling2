/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Hekutoru
 */
public class VerRegistroSitio extends javax.swing.JInternalFrame {

    /**
     * Creates new form VerRegistroSitio
     */
    public VerRegistroSitio() {
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

        jLabelItems = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableReg = new javax.swing.JTable();
        jLabelRes = new javax.swing.JLabel();
        jButtonActualizar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVis = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Acceso al Sitio");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/help-icon.png"))); // NOI18N

        jLabelItems.setText("Servicios mas visitados:");

        jTableReg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "IP", "URL", "Browser", "SO"
            }
        ));
        jTableReg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableReg.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableReg.getTableHeader().setReorderingAllowed(false);
        jTableReg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRegMouseClicked(evt);
            }
        });
        jTableReg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableRegKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableReg);

        jLabelRes.setText("Registro de visitas:");

        jButtonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh-icon.png"))); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.setFocusable(false);
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-icon.png"))); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.setFocusable(false);
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jTableVis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Puesto", "Servicio", "Visitas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVis.setColumnSelectionAllowed(true);
        jTableVis.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableVis.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableVis);
        jTableVis.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTableVis.getColumnModel().getColumnCount() > 0) {
            jTableVis.getColumnModel().getColumn(0).setMaxWidth(100);
            jTableVis.getColumnModel().getColumn(1).setMinWidth(400);
            jTableVis.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRes)
                            .addComponent(jLabelItems))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActualizar)
                    .addComponent(jButtonAceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableRegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRegMouseClicked

    }//GEN-LAST:event_jTableRegMouseClicked

    private void jTableRegKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableRegKeyReleased

    }//GEN-LAST:event_jTableRegKeyReleased

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed

    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JLabel jLabelItems;
    private javax.swing.JLabel jLabelRes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableReg;
    private javax.swing.JTable jTableVis;
    // End of variables declaration//GEN-END:variables
}

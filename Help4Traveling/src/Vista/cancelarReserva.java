/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.DtReserva;
import Logica.Fabrica;
import Logica.IControladorReserva;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tecnoinf
 */
public class cancelarReserva extends javax.swing.JInternalFrame {
    private IControladorReserva IControlador;
    private List<DtReserva> listaReservas;
    String [] columnas = {"Número","Fecha","Estado","Total","Cliente"};
    private DefaultTableModel tableModel = new DefaultTableModel(columnas,0);
    
    /**
     * Creates new form cancelarReserva
     */
    
    private void actualizarReservas() {
        this.listaReservas = this.IControlador.listarReservas();
        Iterator<DtReserva> i = this.listaReservas.iterator();
        tableModel.getDataVector().removeAllElements();
        //Integer n=0;
        
        while (i.hasNext()) {
            DtReserva res = i.next();
            Object [] fila = {res.getId(),
                              res.getCreada().getFecha("-"),
                              res.getEstado(),
                              res.getTotal(),
                              res.getCliente()
            };
            
            tableModel.addRow(fila);
            jTableRes.setModel(tableModel);
        }
    }
    
    public cancelarReserva() {
        initComponents();
        
        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador = fabrica.getIControladorReserva();
        
        this.IControlador.setReservasDB();
        actualizarReservas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableRes = new javax.swing.JTable();
        jButtonActual = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cancelar Reserva");

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Reservas:");

        jTableRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Fecha", "Estado", "Total", "Cliente"
            }
        ));
        jTableRes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableRes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableRes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableRes);

        jButtonActual.setText("Actualizar");
        jButtonActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonActual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEliminar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonActual))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        if ((tableModel.getRowCount()!=0)&&(jTableRes.getSelectedRowCount()!=0)) {
            Object[] opciones = { "No", "Si" };
            int respuesta = JOptionPane.showOptionDialog(null, "¿Está seguro de cancelar la reserva?", "Confirmación",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, opciones, opciones[1]);
            
            if (respuesta==1) {
                this.IControlador.cancelarUnaReserva(Long.valueOf(jTableRes.getValueAt(jTableRes.getSelectedRow(),0).toString()));
                
            }
        }
        actualizarReservas();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualActionPerformed
        this.IControlador.setReservasDB();
        actualizarReservas();
    }//GEN-LAST:event_jButtonActualActionPerformed
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActual;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableRes;
    // End of variables declaration//GEN-END:variables
}

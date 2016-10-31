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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tecnoinf
 */
public class CancelarReservaTabla extends javax.swing.JInternalFrame {

    private IControladorReserva IControlador;
    private List<DtReserva> listaReservas;
    String[] columnas = {"Número", "Fecha", "Estado", "Total", "Cliente"};
    private DefaultTableModel tableModel;
    private DefaultTableCellRenderer centerRenderer;
    private DefaultTableCellRenderer rightRenderer;

    /**
     * Creates new form CancelarReservaTabla
     */
    private void refrescarReservas() {
        this.listaReservas = this.IControlador.listarReservas();
        Iterator<DtReserva> i = this.listaReservas.iterator();
        tableModel.getDataVector().removeAllElements();

        while (i.hasNext()) {
            DtReserva res = i.next();
            Object[] fila = {res.getId(),
                res.getCreada().getFecha("-"),
                res.getEstado(),
                res.getTotal(),
                res.getCliente()
            };
            tableModel.addRow(fila);
        }
        jTableRes.setModel(tableModel);
        jTableRes.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTableRes.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTableRes.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jTableRes.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
    }

    public CancelarReservaTabla() {
        this.centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        this.rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

        this.tableModel = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        initComponents();

        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador = fabrica.getIControladorReserva();

        this.IControlador.setReservasDB();
        refrescarReservas();
        if (jTableRes.getRowCount() > 0) {
            jTableRes.setRowSelectionInterval(0, 0);
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

        jButtonEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableRes = new javax.swing.JTable();
        jButtonActual = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cancelar Reserva");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete-icon.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(400, 210));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 210));

        jButtonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete-icon.png"))); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.setFocusable(false);
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione la reserva que desea cancelar entre las disponibles:");

        jTableRes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Número", "Fecha", "Estado", "Total", "Cliente"
            }
        ));
        jTableRes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableRes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableRes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableRes);

        jButtonActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh-icon.png"))); // NOI18N
        jButtonActual.setText("Actualizar");
        jButtonActual.setFocusable(false);
        jButtonActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualActionPerformed(evt);
            }
        });

        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel-icon.png"))); // NOI18N
        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.setFocusable(false);
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonActual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEliminar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEliminar)
                    .addComponent(jButtonActual)
                    .addComponent(jButtonCerrar))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int fila = 0;
        if ((jTableRes.getRowCount() > 0) && (jTableRes.getSelectedRowCount() > 0)) {
            fila = jTableRes.getSelectedRow();
            Object[] opciones = {"No", "Si"};
            int respuesta = JOptionPane.showOptionDialog(null, "¿Está seguro de cancelar la reserva?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);

            Long reserva = Long.valueOf(jTableRes.getValueAt(jTableRes.getSelectedRow(), 0).toString());
            System.out.println("ID: " + reserva);

            if (respuesta == 1) {
                this.IControlador.cancelarUnaReserva(reserva);
                fila = 0;
            }
        }
        refrescarReservas();
        if ((jTableRes.getRowCount() > 0) && (jTableRes.getSelectedRowCount() > 0)) {
            jTableRes.setRowSelectionInterval(fila, fila);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualActionPerformed
        int fila = 0;
        if (jTableRes.getSelectedRowCount() > 0) {
            fila = jTableRes.getSelectedRow();
        }
        this.IControlador.setReservasDB();
        refrescarReservas();
        if (jTableRes.getRowCount() > fila) {
            jTableRes.setRowSelectionInterval(fila, fila);
        }
    }//GEN-LAST:event_jButtonActualActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActual;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableRes;
    // End of variables declaration//GEN-END:variables
}
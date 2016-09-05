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
public class ActualizarReserva extends javax.swing.JInternalFrame {

    private IControladorReserva IControlador;
    private List<DtReserva> listaReservas;
    String[] colReservas = {"Número", "Fecha", "Estado", "Total", "Cliente"};
    private DefaultTableModel tableModelRes;
    private DefaultTableCellRenderer centerRenderer;
    private DefaultTableCellRenderer rightRenderer;

    private void modificarReserva(Integer index) {
        String estado = this.listaReservas.get(index).getEstado().toString();
        Integer reserva = (int) (long) this.listaReservas.get(index).getId();
        System.out.println(estado);
        if (!"REGISTRADA".equals(estado)) {
            JOptionPane.showMessageDialog(this, "El estado inicial debe ser REGISTRADA, pero es " + estado + ".", "Error", JOptionPane.ERROR_MESSAGE
            );
        } else {
            String nuevo = jComboBoxEstado.getSelectedItem().toString();
            Object[] opciones = {"No", "Si"};
            int respuesta = JOptionPane.showOptionDialog(null, "¿Está seguro de cambiar el estado de la reserva a " + nuevo + "?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[1]);
            if (respuesta == 1) {
                this.IControlador.actualizarEstadoDeReserva(reserva, nuevo);
            }
        }
        refrescarReservas();
    }

    /**
     * Creates new form verInfoReserva
     */
    private void refrescarReservas() {
        this.listaReservas = this.IControlador.listarReservas();
        Iterator<DtReserva> i = this.listaReservas.iterator();
        tableModelRes.getDataVector().removeAllElements();

        while (i.hasNext()) {
            DtReserva res = i.next();
            Object[] fila = {res.getId(),
                res.getCreada().getFecha("-"),
                res.getEstado(),
                res.getTotal(),
                res.getCliente()
            };
            tableModelRes.addRow(fila);
        }
        jTableRes.setModel(tableModelRes);
        jTableRes.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTableRes.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTableRes.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        jTableRes.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
    }

    public ActualizarReserva() {
        this.centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        this.rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

        this.tableModelRes = new DefaultTableModel(colReservas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        initComponents();

        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador = fabrica.getIControladorReserva();

        fabrica.getIControladorReserva().setReservasDB();
        refrescarReservas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTableRes = new javax.swing.JTable();
        jLabelRes = new javax.swing.JLabel();
        jButtonActual = new javax.swing.JButton();
        jButtonCerrar = new javax.swing.JButton();
        jButtonMod = new javax.swing.JButton();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jLabelEstado = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actualizar Reserva");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit-icon.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(440, 200));
        setPreferredSize(new java.awt.Dimension(600, 204));

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
        jTableRes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableResMouseClicked(evt);
            }
        });
        jTableRes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableResKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableRes);

        jLabelRes.setText("Seleccione la reserva para la cual desea modificar su estado:");

        jButtonActual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh-icon.png"))); // NOI18N
        jButtonActual.setText("Actualizar");
        jButtonActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualActionPerformed(evt);
            }
        });

        jButtonCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-icon.png"))); // NOI18N
        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jButtonMod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit-icon.png"))); // NOI18N
        jButtonMod.setText("Modificar");
        jButtonMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModActionPerformed(evt);
            }
        });

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PAGADA", "FACTURADA", "CANCELADA" }));

        jLabelEstado.setText("Nuevo estado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelRes)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonActual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelEstado)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonMod)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActual)
                    .addComponent(jButtonCerrar)
                    .addComponent(jButtonMod)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableResMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableResMouseClicked
        if (jTableRes.getSelectedRowCount() != -1) {

        }
    }//GEN-LAST:event_jTableResMouseClicked

    private void jButtonActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualActionPerformed
        this.IControlador.setReservasDB();
        this.IControlador.setItemsDB();
        refrescarReservas();
    }//GEN-LAST:event_jButtonActualActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCerrarActionPerformed
    private void jTableResKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableResKeyReleased
        if (jTableRes.getSelectedRowCount() != -1) {

        }
    }//GEN-LAST:event_jTableResKeyReleased

    private void jButtonModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModActionPerformed
        if (jTableRes.getSelectedRowCount() > 0) {
            modificarReserva(jTableRes.getSelectedRow());
        }
    }//GEN-LAST:event_jButtonModActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActual;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonMod;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelRes;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableRes;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Fabrica;
import Logica.IControladorUsuario;
import java.awt.Dimension;
import javax.swing.JInternalFrame;

/**
 *
 * @author yaman
 */
public class Principal extends javax.swing.JFrame {

    private IControladorUsuario IControlador;
    private String tipo;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fc_seleccionar_archivo.setVisible(false);

    }

    public Principal(IControladorUsuario IControlador) {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador = fabrica.getIControladorUsuario();
        this.tipo = "Cliente";
    }

    public void centrarVentana(JInternalFrame jif) {
        Dimension tamEscritorio = escritorio.getSize();
        Dimension tamVentana = jif.getSize();
        int width = (tamEscritorio.width - tamVentana.width) / 2;
        int height = (tamEscritorio.height - tamVentana.height) / 2;
        jif.setLocation(width, height);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fc_seleccionar_archivo = new javax.swing.JFileChooser();
        jMenuItem1 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        bm_registrar_cliente = new javax.swing.JMenuItem();
        bm_registrar_servicio = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        bm_registrar_reserva = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCancelar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        bm_verInfoCliente = new javax.swing.JMenuItem();
        bm_verInfoProveedor = new javax.swing.JMenuItem();
        jMenuItemVerRes = new javax.swing.JMenuItem();

        fc_seleccionar_archivo.setOpaque(true);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 963, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        jMenu1.setText("Inicio");

        jMenuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-icon.png"))); // NOI18N
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Registros");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        bm_registrar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        bm_registrar_cliente.setText("Registrar Usuario");
        bm_registrar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_registrar_clienteActionPerformed(evt);
            }
        });
        jMenu2.add(bm_registrar_cliente);

        bm_registrar_servicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        bm_registrar_servicio.setText("Registrar Servicio");
        bm_registrar_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_registrar_servicioActionPerformed(evt);
            }
        });
        jMenu2.add(bm_registrar_servicio);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        jMenuItem2.setText("Alta Categoria");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        bm_registrar_reserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        bm_registrar_reserva.setText("Registrar Reserva");
        bm_registrar_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_registrar_reservaActionPerformed(evt);
            }
        });
        jMenu2.add(bm_registrar_reserva);
        jMenu2.add(jSeparator1);

        jMenuItemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete-icon.png"))); // NOI18N
        jMenuItemCancelar.setText("Cancelar Reserva");
        jMenuItemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCancelarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCancelar);

        jMenuBar1.add(jMenu2);
        jMenu2.getAccessibleContext().setAccessibleDescription("");

        jMenu3.setText("Consultas");

        bm_verInfoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        bm_verInfoCliente.setText("VerInfo Cliente");
        bm_verInfoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_verInfoClienteActionPerformed(evt);
            }
        });
        jMenu3.add(bm_verInfoCliente);

        bm_verInfoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        bm_verInfoProveedor.setText("VerInfo Proveedor");
        bm_verInfoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_verInfoProveedorActionPerformed(evt);
            }
        });
        jMenu3.add(bm_verInfoProveedor);

        jMenuItemVerRes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        jMenuItemVerRes.setText("VerInfo Reserva");
        jMenuItemVerRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerResActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemVerRes);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bm_registrar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_registrar_clienteActionPerformed
        // TODO add your handling code here:
        altaUsuario fAltaUsuario = new altaUsuario();
        escritorio.add(fAltaUsuario);
        fAltaUsuario.setVisible(true);
    }//GEN-LAST:event_bm_registrar_clienteActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu2ActionPerformed

    private void bm_registrar_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_registrar_servicioActionPerformed
        // TODO add your handling code here:
        altaServicio fAltaServicio = new altaServicio();
        escritorio.add(fAltaServicio);
        fAltaServicio.setVisible(true);

    }//GEN-LAST:event_bm_registrar_servicioActionPerformed

    private void bm_registrar_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_registrar_reservaActionPerformed
        altaReserva fAltaReserva = new altaReserva();
        //fAltaReserva.setLocationRelativeTo(null);
        escritorio.add(fAltaReserva);
        fAltaReserva.setVisible(true);
    }//GEN-LAST:event_bm_registrar_reservaActionPerformed

    private void bm_verInfoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_verInfoClienteActionPerformed
        verInfoCliente fverInfoCliente = new verInfoCliente();
        escritorio.add(fverInfoCliente);
        fverInfoCliente.setVisible(true);
    }//GEN-LAST:event_bm_verInfoClienteActionPerformed

    private void bm_verInfoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_verInfoProveedorActionPerformed
        verInfoProveedor fverInfoProveedor = new verInfoProveedor();
        escritorio.add(fverInfoProveedor);
        fverInfoProveedor.setVisible(true);
    }//GEN-LAST:event_bm_verInfoProveedorActionPerformed

    private void jMenuItemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCancelarActionPerformed
        cancelarReserva cr = new cancelarReserva();
        escritorio.add(cr);
        centrarVentana(cr);
        cr.setVisible(true);
    }//GEN-LAST:event_jMenuItemCancelarActionPerformed

    private void jMenuItemVerResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerResActionPerformed
        verInfoReserva vir = new verInfoReserva();
        escritorio.add(vir);
        //centrarVentana(vir);
        vir.setVisible(true);
    }//GEN-LAST:event_jMenuItemVerResActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        altaCategoria altacat = new altaCategoria();
        escritorio.add(altacat);
        altacat.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem bm_registrar_cliente;
    private javax.swing.JMenuItem bm_registrar_reserva;
    private javax.swing.JMenuItem bm_registrar_servicio;
    private javax.swing.JMenuItem bm_verInfoCliente;
    private javax.swing.JMenuItem bm_verInfoProveedor;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JFileChooser fc_seleccionar_archivo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemCancelar;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemVerRes;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

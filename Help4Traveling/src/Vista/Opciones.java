/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Conector;
import Logica.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Hekutoru
 */
public class Opciones extends javax.swing.JInternalFrame {

    private Conector conector = Conector.getInstance();
    private Conexion conexion;
    private String servidor;
    private String usuario;
    private String clave;
    private String driver;

    /**
     * Creates new form Opciones
     */
    public Opciones() {
        initComponents();
        bajarDatos();
        ponerDatos();
    }

    public void bajarDatos() {
        servidor = conector.getServidor();
        usuario = conector.getUsuario();
        clave = conector.getClave();
        driver = conector.getDriver();
    }

    public void ponerDatos() {
        Servidor.setText(servidor);
        Usuario.setText(usuario);
        Clave.setText(clave);
        Driver.setText(driver);
    }

    public void sacarDatos() {
        servidor = Servidor.getText();
        usuario = Usuario.getText();
        clave = Clave.getText();
        driver = Driver.getText();
    }

    public void subirDatos() {
        conector.setServidor(servidor);
        conector.setUsuario(usuario);
        conector.setClave(clave);
        conector.setDriver(driver);
    }

    public void imprimirDatos() {
        System.out.println(servidor);
        System.out.println(usuario);
        System.out.println(clave);
        System.out.println(driver);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cancelar = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        Opciones = new javax.swing.JTabbedPane();
        Conexion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Servidor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Clave = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        Driver = new javax.swing.JTextField();
        Revertir = new javax.swing.JButton();
        Aplicar = new javax.swing.JButton();
        Probar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("Opciones");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/options-icon.png"))); // NOI18N

        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel-icon.png"))); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-icon.png"))); // NOI18N
        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        jLabel1.setText("Servidor:");

        Servidor.setText("jdbc:mysql://localhost:3306/help4traveling?autoReconnect=true&useSSL=false");

        jLabel2.setText("Usuario:");

        Usuario.setText("root");

        jLabel3.setText("Clave:");

        Clave.setText("root");

        jLabel4.setText("Driver:");

        Driver.setText("com.mysql.jdbc.Driver");

        Revertir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/undo-icon.png"))); // NOI18N
        Revertir.setText("Revertir");
        Revertir.setToolTipText("");
        Revertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevertirActionPerformed(evt);
            }
        });

        Aplicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit-icon.png"))); // NOI18N
        Aplicar.setText("Aplicar");
        Aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplicarActionPerformed(evt);
            }
        });

        Probar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/db-icon.png"))); // NOI18N
        Probar.setText("Probar");
        Probar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProbarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConexionLayout = new javax.swing.GroupLayout(Conexion);
        Conexion.setLayout(ConexionLayout);
        ConexionLayout.setHorizontalGroup(
            ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConexionLayout.createSequentialGroup()
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConexionLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Usuario)
                            .addComponent(Servidor, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(Clave)
                            .addComponent(Driver, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ConexionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Revertir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Aplicar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Probar)))
                .addContainerGap())
        );
        ConexionLayout.setVerticalGroup(
            ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConexionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Servidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Driver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(ConexionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Probar)
                    .addComponent(Revertir)
                    .addComponent(Aplicar))
                .addContainerGap())
        );

        Opciones.addTab("Conexión", Conexion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Opciones)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Aceptar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aceptar)
                    .addComponent(Cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        sacarDatos();
        subirDatos();
        this.dispose();
    }//GEN-LAST:event_AceptarActionPerformed

    private void ProbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProbarActionPerformed
        try {
            Connection con = new Conexion().getConnection();
            System.out.println(con);
            if ((con != null) && (con.isValid(0))) {
                JOptionPane.showMessageDialog(this,
                        "Conexión establecida exitosamente.",
                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }

        } catch (SQLException ex) {
        }
        //imprimirDatos();
    }//GEN-LAST:event_ProbarActionPerformed

    private void RevertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevertirActionPerformed
        conector.revertir();
        bajarDatos();
        ponerDatos();
        //imprimirDatos();
    }//GEN-LAST:event_RevertirActionPerformed

    private void AplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplicarActionPerformed
        sacarDatos();
        subirDatos();
        //imprimirDatos();
    }//GEN-LAST:event_AplicarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Aplicar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JPasswordField Clave;
    private javax.swing.JPanel Conexion;
    private javax.swing.JTextField Driver;
    private javax.swing.JTabbedPane Opciones;
    private javax.swing.JButton Probar;
    private javax.swing.JButton Revertir;
    private javax.swing.JTextField Servidor;
    private javax.swing.JTextField Usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

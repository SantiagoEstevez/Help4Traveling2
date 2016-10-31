/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Date;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IControladorUsuario;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Santiago
 */
public class altaUsuario extends javax.swing.JInternalFrame {

    private String tipo;
    private IControladorUsuario IControlador;
    private String pathimg;

    /**
     * Creates new form altaCliente
     */
    public altaUsuario() {
        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador = fabrica.getIControladorUsuario();
        this.tipo = "Cliente";
        this.pathimg = null;
        initComponents();
        this.pn_proveedor.setVisible(false);
    }

    /*public altaUsuario(IControladorUsuario iControlador) {
        IControlador = iControlador;
        this.tipo = "Cliente";
        initComponents();
        this.pn_proveedor.setVisible(false);
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fc_seleccionar_archivo = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_apellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_nickname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_correo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sp_dia = new javax.swing.JSpinner();
        sp_mes = new javax.swing.JSpinner();
        sp_anio = new javax.swing.JSpinner();
        btnSeleccionarImagen = new javax.swing.JButton();
        chb_proveedor = new javax.swing.JCheckBox();
        bt_aceptar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        pn_proveedor = new javax.swing.JPanel();
        tf_direccion = new javax.swing.JTextField();
        tf_empresa = new javax.swing.JTextField();
        l_empresa = new javax.swing.JLabel();
        l_direccion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pf_password = new javax.swing.JPasswordField();
        pf_conf_password = new javax.swing.JPasswordField();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Nuevo Usuario");

        jLabel1.setText("Ingrese los siguientes datos");

        jLabel2.setText("Nombre:");

        tf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombreActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido:");

        tf_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_apellidoActionPerformed(evt);
            }
        });

        jLabel4.setText("Nickname:");

        jLabel5.setText("Correo:");

        tf_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_correoActionPerformed(evt);
            }
        });

        jLabel6.setText("Fecha Nacimiento:");

        sp_dia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        sp_mes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        sp_anio.setModel(new javax.swing.SpinnerNumberModel(1980, 1916, 2016, 1));

        btnSeleccionarImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/search-icon.png"))); // NOI18N
        btnSeleccionarImagen.setText("Seleccionar Imagen");
        btnSeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImagenActionPerformed(evt);
            }
        });

        chb_proveedor.setText("Proveedor");
        chb_proveedor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chb_proveedorStateChanged(evt);
            }
        });
        chb_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_proveedorActionPerformed(evt);
            }
        });

        bt_aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-icon.png"))); // NOI18N
        bt_aceptar.setText("Aceptar");
        bt_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_aceptarActionPerformed(evt);
            }
        });

        bt_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete-icon.png"))); // NOI18N
        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

        tf_direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_direccionActionPerformed(evt);
            }
        });

        l_empresa.setText("Empresa:");

        l_direccion.setText("Enlace:");

        javax.swing.GroupLayout pn_proveedorLayout = new javax.swing.GroupLayout(pn_proveedor);
        pn_proveedor.setLayout(pn_proveedorLayout);
        pn_proveedorLayout.setHorizontalGroup(
            pn_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_proveedorLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pn_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_proveedorLayout.createSequentialGroup()
                        .addComponent(l_direccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pn_proveedorLayout.createSequentialGroup()
                        .addComponent(l_empresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pn_proveedorLayout.setVerticalGroup(
            pn_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_proveedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_empresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_direccion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setText("Password:");

        jLabel8.setText("Confirmar Password:");

        pf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pf_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel1)
                .addGap(0, 139, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_aceptar)
                        .addGap(26, 26, 26)
                        .addComponent(bt_cancelar)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(43, 43, 43)
                                    .addComponent(sp_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(sp_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(sp_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnSeleccionarImagen)
                                .addComponent(chb_proveedor)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(22, 22, 22)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tf_correo)
                                        .addComponent(tf_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_apellido, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tf_nickname, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pf_password, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                                    .addComponent(pf_conf_password))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tf_nickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(pf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(pf_conf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sp_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(sp_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sp_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSeleccionarImagen)
                .addGap(18, 18, 18)
                .addComponent(chb_proveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_aceptar)
                    .addComponent(bt_cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombreActionPerformed

    private void tf_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_correoActionPerformed

    private void btnSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImagenActionPerformed
        // TODO add your handling code here:
        this.fc_seleccionar_archivo.setVisible(true);
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fc_seleccionar_archivo.setFileFilter(filtroImagen);
        //fc_seleccionar_archivo.setVisible(true);
        int eleccion = this.fc_seleccionar_archivo.showOpenDialog(null);
        //Seleccionamos el fichero
        if (eleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = this.fc_seleccionar_archivo.getSelectedFile();
            pathimg = fichero.getAbsolutePath();
            System.out.println("pathimg=");
            System.out.println(pathimg);
        }
    }//GEN-LAST:event_btnSeleccionarImagenActionPerformed

    private void chb_proveedorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chb_proveedorStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_chb_proveedorStateChanged

    private void chb_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_proveedorActionPerformed
        // TODO add your handling code here:
        if (this.chb_proveedor.isSelected()) {
            this.pn_proveedor.setVisible(true);
            this.tipo = "Proveedor";
        } else {
            this.pn_proveedor.setVisible(false);
            this.tipo = "Cliente";
        }
    }//GEN-LAST:event_chb_proveedorActionPerformed

    private void bt_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_aceptarActionPerformed
        String mensaje = "";
        String nombre = this.tf_nombre.getText();
        String apellido = this.tf_apellido.getText();
        String nickname = this.tf_nickname.getText();
        char[] arrayPass = this.pf_password.getPassword(); 
        String password = new String(arrayPass);
        char[] arrayRePass = this.pf_conf_password.getPassword(); 
        String confpassword = new String(arrayRePass);
        String correo = this.tf_correo.getText();
        int dia = (int) this.sp_dia.getValue();
        int mes = (int) this.sp_mes.getValue();
        int anio = (int) this.sp_anio.getValue();
        //String mes = this.sp_mes.toString();
        //String anio = this.sp_anio.toString();
        String empresa = this.tf_empresa.getText();
        String direccion = this.tf_direccion.getText();
        System.out.println(mes);
        System.out.println(dia);
        System.out.println(anio);
        Date nacimiento = new Date(dia, mes, anio);
        if (password.equals(""))
            mensaje = "ERROR: La Password no puede ser vacía...";
        else if (confpassword.equals(""))
                mensaje = "ERROR: La Confirmación de la Password no puede ser vacía...";
             else if (!confpassword.equals(password))
                    mensaje = "ERROR: La Password no coincide con su Confirmación...";
                  else {
                    DtUsuario dtu = new DtUsuario(nombre, apellido, nickname, password, correo, nacimiento, this.pathimg, this.tipo, empresa, direccion);
                    mensaje = IControlador.altaDeUsuario(dtu);
                  }
        JOptionPane.showMessageDialog(null, mensaje);
        this.tf_apellido.setText("");
        this.tf_nombre.setText("");
        this.tf_correo.setText("");
        this.pf_password.setText("");
        this.pf_conf_password.setText("");
        this.tf_nickname.setText("");
        this.tf_empresa.setText("");
        this.tf_direccion.setText("");
        this.pn_proveedor.setVisible(false);
        if (mensaje.equals("Se dio de alta al Usuario Cliente.") || mensaje.equals("Se dio de alta al Usuario Proveedor.")) {
            this.setVisible(false);
        }
        this.chb_proveedor.setSelected(false);
        this.tipo = "Cliente";
        this.pathimg = null;
    }//GEN-LAST:event_bt_aceptarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.tf_apellido.setText("");
        this.tf_correo.setText("");
        this.tf_nickname.setText("");
        this.tf_nombre.setText("");

    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void tf_direccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_direccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_direccionActionPerformed

    private void tf_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_apellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_apellidoActionPerformed

    private void pf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pf_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pf_passwordActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton btnSeleccionarImagen;
    private javax.swing.JCheckBox chb_proveedor;
    private javax.swing.JFileChooser fc_seleccionar_archivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_direccion;
    private javax.swing.JLabel l_empresa;
    private javax.swing.JPasswordField pf_conf_password;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JPanel pn_proveedor;
    private javax.swing.JSpinner sp_anio;
    private javax.swing.JSpinner sp_dia;
    private javax.swing.JSpinner sp_mes;
    private javax.swing.JTextField tf_apellido;
    private javax.swing.JTextField tf_correo;
    private javax.swing.JTextField tf_direccion;
    private javax.swing.JTextField tf_empresa;
    private javax.swing.JTextField tf_nickname;
    private javax.swing.JTextField tf_nombre;
    // End of variables declaration//GEN-END:variables
}
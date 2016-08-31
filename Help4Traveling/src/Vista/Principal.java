/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Logica.DataUsuario;
import Logica.Fabrica;
import Logica.ControladorUsuario;
import Logica.Date;
import javax.swing.JOptionPane;
import Logica.IControladorUsuario;

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
        this.if_registrar_cliente.setVisible(false); 
        this.if_registrar_servicio.setVisible(false);
        this.fc_seleccionar_archivo.setVisible(false);
        this.tr_categoria.setVisible(false);
        
    }
    
    public Principal(IControladorUsuario IControlador){
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador= fabrica.getIControladorUsuario();
        this.tipo = "Cliente";
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
        if_registrar_cliente = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_apellido = new javax.swing.JTextField();
        tf_nickname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_correo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sp_dia = new javax.swing.JSpinner();
        sp_mes = new javax.swing.JSpinner();
        sp_anio = new javax.swing.JSpinner();
        bt_aceptar = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();
        btnSeleccionarImagen = new javax.swing.JButton();
        chb_proveedor = new javax.swing.JCheckBox();
        pn_proveedor = new javax.swing.JPanel();
        l_empresa = new javax.swing.JLabel();
        l_direccion = new javax.swing.JLabel();
        tf_empresa = new javax.swing.JTextField();
        tf_direccion = new javax.swing.JTextField();
        if_registrar_servicio = new javax.swing.JInternalFrame();
        bt_cancelar_s = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tr_categoria = new javax.swing.JTree();
        bt_categoria = new javax.swing.JButton();
        lb_origen = new javax.swing.JLabel();
        lb_nombre_s = new javax.swing.JLabel();
        tf_nombre_s = new javax.swing.JTextField();
        tf_origen = new javax.swing.JTextField();
        bt_aceptar_s = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        bm_registrar_cliente = new javax.swing.JMenuItem();
        bm_registrar_servicio = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        fc_seleccionar_archivo.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        if_registrar_cliente.setTitle("Registrar Cliente");
        if_registrar_cliente.setVisible(true);

        jLabel1.setText("Ingrese los siguientes datos");

        jLabel2.setText("Nombre:");

        tf_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_nombreActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido:");

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

        bt_aceptar.setText("Aceptar");
        bt_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_aceptarActionPerformed(evt);
            }
        });

        bt_cancelar.setText("Cancelar");
        bt_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelarActionPerformed(evt);
            }
        });

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

        l_empresa.setText("Empresa:");

        l_direccion.setText("Dirección:");

        javax.swing.GroupLayout pn_proveedorLayout = new javax.swing.GroupLayout(pn_proveedor);
        pn_proveedor.setLayout(pn_proveedorLayout);
        pn_proveedorLayout.setHorizontalGroup(
            pn_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_proveedorLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pn_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(l_empresa)
                    .addComponent(l_direccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );
        pn_proveedorLayout.setVerticalGroup(
            pn_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_proveedorLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_empresa)
                    .addComponent(tf_empresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_proveedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_direccion)
                    .addComponent(tf_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout if_registrar_clienteLayout = new javax.swing.GroupLayout(if_registrar_cliente.getContentPane());
        if_registrar_cliente.getContentPane().setLayout(if_registrar_clienteLayout);
        if_registrar_clienteLayout.setHorizontalGroup(
            if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(if_registrar_clienteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pn_proveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(if_registrar_clienteLayout.createSequentialGroup()
                .addGroup(if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(if_registrar_clienteLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1))
                    .addGroup(if_registrar_clienteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnSeleccionarImagen))
                    .addGroup(if_registrar_clienteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(chb_proveedor))
                    .addGroup(if_registrar_clienteLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(bt_aceptar)
                        .addGap(39, 39, 39)
                        .addComponent(bt_cancelar))
                    .addGroup(if_registrar_clienteLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(137, 137, 137)
                        .addGroup(if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_nickname, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, if_registrar_clienteLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sp_dia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(sp_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(sp_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 51, Short.MAX_VALUE))
        );
        if_registrar_clienteLayout.setVerticalGroup(
            if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(if_registrar_clienteLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGroup(if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(if_registrar_clienteLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(11, 11, 11)
                        .addGroup(if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(11, 11, 11)
                        .addGroup(if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_nickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(11, 11, 11)
                        .addGroup(if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sp_dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(sp_mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sp_anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addComponent(btnSeleccionarImagen)
                        .addGap(26, 26, 26)
                        .addComponent(chb_proveedor)
                        .addGap(2, 2, 2)
                        .addComponent(pn_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(if_registrar_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_aceptar)
                            .addComponent(bt_cancelar))
                        .addContainerGap())
                    .addGroup(if_registrar_clienteLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel6)
                        .addGap(436, 436, 436))))
        );

        if_registrar_servicio.setTitle("Registrar Servicio");
        if_registrar_servicio.setVisible(true);

        bt_cancelar_s.setText("Cancelar");
        bt_cancelar_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelar_sActionPerformed(evt);
            }
        });

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

        lb_origen.setText("Origen");

        lb_nombre_s.setText("Nombre");

        bt_aceptar_s.setText("Aceptar");
        bt_aceptar_s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_aceptar_sActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout if_registrar_servicioLayout = new javax.swing.GroupLayout(if_registrar_servicio.getContentPane());
        if_registrar_servicio.getContentPane().setLayout(if_registrar_servicioLayout);
        if_registrar_servicioLayout.setHorizontalGroup(
            if_registrar_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(if_registrar_servicioLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(if_registrar_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, if_registrar_servicioLayout.createSequentialGroup()
                        .addGroup(if_registrar_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_origen)
                            .addComponent(lb_nombre_s)
                            .addComponent(bt_categoria))
                        .addGap(31, 31, 31)
                        .addGroup(if_registrar_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(if_registrar_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tf_origen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(tf_nombre_s, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, if_registrar_servicioLayout.createSequentialGroup()
                        .addComponent(bt_aceptar_s)
                        .addGap(38, 38, 38)
                        .addComponent(bt_cancelar_s)
                        .addGap(53, 53, 53))))
        );
        if_registrar_servicioLayout.setVerticalGroup(
            if_registrar_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, if_registrar_servicioLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(if_registrar_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_nombre_s)
                    .addComponent(tf_nombre_s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(if_registrar_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_origen)
                    .addComponent(tf_origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(if_registrar_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(if_registrar_servicioLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(bt_categoria)))
                .addGap(85, 85, 85)
                .addGroup(if_registrar_servicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cancelar_s)
                    .addComponent(bt_aceptar_s))
                .addContainerGap(192, Short.MAX_VALUE))
        );

        jMenu1.setText("Inicio");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Registros");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        bm_registrar_cliente.setText("Registrar Cliente");
        bm_registrar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_registrar_clienteActionPerformed(evt);
            }
        });
        jMenu2.add(bm_registrar_cliente);

        bm_registrar_servicio.setText("Registrar Servicio");
        bm_registrar_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_registrar_servicioActionPerformed(evt);
            }
        });
        jMenu2.add(bm_registrar_servicio);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Consultas");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(if_registrar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(if_registrar_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(if_registrar_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(if_registrar_cliente))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bm_registrar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_registrar_clienteActionPerformed
        // TODO add your handling code here:
        this.if_registrar_cliente.setVisible(true);
        this.pn_proveedor.setVisible(false);
    }//GEN-LAST:event_bm_registrar_clienteActionPerformed

    private void tf_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_nombreActionPerformed

    private void tf_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_correoActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void bt_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_aceptarActionPerformed
        // TODO add your handling code here:
        String nombre = this.tf_nombre.getText();
        String apellido = this.tf_apellido.getText();
        String nickname = this.tf_nickname.getText();
        String correo = this.tf_correo.getText();
        String dia = this.sp_dia.toString();
        String mes = this.sp_mes.toString();
        String anio = this.sp_anio.toString();
        String empresa = this.tf_empresa.getText();
        String direccion = this.tf_direccion.getText();
        String imagen = "ruta";
        //String nacimiento = dia+mes+anio;
        
        Integer dd = Integer.parseInt(dia);
        Integer mm = Integer.parseInt(mes);
        Integer aaaa = Integer.parseInt(anio);
        Date nacimiento = new Date(dd, mm, aaaa);
        DataUsuario dtu = new DataUsuario(nombre, apellido, nickname, correo, nacimiento, imagen, this.tipo, empresa, direccion);
        IControlador.altaDeUsuario(dtu);
        this.tf_apellido.setText("");
        this.tf_nombre.setText("");
        this.tf_correo.setText("");
        this.tf_nickname.setText("");
        this.tf_empresa.setText("");
        this.tf_direccion.setText("");
        
        this.if_registrar_cliente.setVisible(false);
        this.chb_proveedor.setSelected(false);
        
    }//GEN-LAST:event_bt_aceptarActionPerformed

    private void bt_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelarActionPerformed
        // TODO add your handling code here:
        this.if_registrar_cliente.setVisible(false);
        this.tf_apellido.setText("");
        this.tf_correo.setText("");
        this.tf_nickname.setText("");
        this.tf_nombre.setText("");
                
    }//GEN-LAST:event_bt_cancelarActionPerformed

    private void btnSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImagenActionPerformed
        // TODO add your handling code here:
        this.fc_seleccionar_archivo.setVisible(true);
        this.fc_seleccionar_archivo.showOpenDialog(null);
        
        
    }//GEN-LAST:event_btnSeleccionarImagenActionPerformed

    private void chb_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_proveedorActionPerformed
        // TODO add your handling code here:
        if (this.chb_proveedor.isSelected()){
            this.pn_proveedor.setVisible(true);
            this.tipo = "Proveedor";
        }
        else {
            this.pn_proveedor.setVisible(false);
            this.tipo = "Cliente";
        }
    }//GEN-LAST:event_chb_proveedorActionPerformed

    private void chb_proveedorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chb_proveedorStateChanged
        // TODO add your handling code here:
        
        
        
        
        
    }//GEN-LAST:event_chb_proveedorStateChanged

    private void bm_registrar_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_registrar_servicioActionPerformed
        // TODO add your handling code here:
        this.if_registrar_servicio.setVisible(true);
       
    }//GEN-LAST:event_bm_registrar_servicioActionPerformed

    private void bt_cancelar_sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelar_sActionPerformed
        // TODO add your handling code here:
        this.if_registrar_servicio.setVisible(false);
        this.tr_categoria.setVisible(false);
        this.tf_nombre_s.setText("");
        this.tf_origen.setText("");
        
    }//GEN-LAST:event_bt_cancelar_sActionPerformed

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
        
        this.if_registrar_servicio.setVisible(false);
        this.tr_categoria.setVisible(false);
        this.tf_nombre_s.setText("");
        this.tf_origen.setText("");
        
        
        
    }//GEN-LAST:event_bt_aceptar_sActionPerformed

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
    private javax.swing.JMenuItem bm_registrar_servicio;
    private javax.swing.JButton bt_aceptar;
    private javax.swing.JButton bt_aceptar_s;
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_cancelar_s;
    private javax.swing.JButton bt_categoria;
    private javax.swing.JButton btnSeleccionarImagen;
    private javax.swing.JCheckBox chb_proveedor;
    private javax.swing.JFileChooser fc_seleccionar_archivo;
    private javax.swing.JInternalFrame if_registrar_cliente;
    private javax.swing.JInternalFrame if_registrar_servicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_direccion;
    private javax.swing.JLabel l_empresa;
    private javax.swing.JLabel lb_nombre_s;
    private javax.swing.JLabel lb_origen;
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
    private javax.swing.JTextField tf_nombre_s;
    private javax.swing.JTextField tf_origen;
    private javax.swing.JTree tr_categoria;
    // End of variables declaration//GEN-END:variables
}

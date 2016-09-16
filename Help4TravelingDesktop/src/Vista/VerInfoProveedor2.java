/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.DtServicio;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IControladorUsuario;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yaman
 */
public class VerInfoProveedor2 extends javax.swing.JInternalFrame {

    private IControladorUsuario IControlador;
    private ArrayList<DtUsuario> listaProveedores;
    private DefaultTableModel modeloTablaPr;
    private DefaultTableModel modeloTablaSer;

    /**
     * Creates new form verInfoProveedor
     */
    public VerInfoProveedor2() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador = fabrica.getIControladorUsuario();

        DefaultListModel modelo = new DefaultListModel();

        this.listaProveedores = this.IControlador.listarProveedores();
        Iterator<DtUsuario> i = this.listaProveedores.iterator();
        while (i.hasNext()) {
            DtUsuario user = i.next();
            modelo.addElement(user.getNombre());
        }

        jListaProveedores.setModel(modelo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaProveedores = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablaServicios = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablaProveedores = new javax.swing.JTable();
        jLabelProveedor = new javax.swing.JLabel();
        jLabelDatos = new javax.swing.JLabel();
        jLabelServicios = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ver Info Proveedor");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N

        jListaProveedores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListaProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListaProveedores);

        jTablaServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Servicio", "Precio", "Origen", "Destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTablaServicios);

        jTablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alias", "Nombre", "Apellido", "Nacimiento", "Empresa", "Enlace"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTablaProveedores);

        jLabelProveedor.setText("Seleccione el proveedor para el cual desea ver mas información:");

        jLabelDatos.setText("Datos:");

        jLabelServicios.setText("Servicios:");

        jButtonAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-icon.png"))); // NOI18N
        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.setFocusable(false);
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonAceptar)
                    .addComponent(jLabelDatos, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProveedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelServicios, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProveedor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelServicios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAceptar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListaProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaProveedoresMouseClicked

        String nombre = jListaProveedores.getSelectedValue();

        String[] columnasProveedores = {"nickname", "nombre", "apellido", "nacimiento", "empresa", "link"};

        String[] registrosProveedores = new String[6];

        String[] columnasServicios = {"servicio", "precio", "origen", "destino"};

        String[] registrosServicios = new String[4];

        modeloTablaPr = new DefaultTableModel(null, columnasProveedores);
        modeloTablaSer = new DefaultTableModel(null, columnasServicios);

        Iterator<DtUsuario> i = this.listaProveedores.iterator();
        boolean es = false;
        while (i.hasNext() & !es) {
            DtUsuario user = i.next();
            if (nombre.equals(user.getNombre())) {
                es = true;

                registrosProveedores[0] = user.getNombre();
                registrosProveedores[1] = user.getApellido();
                registrosProveedores[2] = user.getNickname();
                registrosProveedores[3] = user.getNacimiento().getFecha("-");
                registrosProveedores[4] = user.getEmpresa();
                registrosProveedores[5] = user.getLink();

                modeloTablaPr.addRow(registrosProveedores);
                jTablaProveedores.setModel(modeloTablaPr);

                Fabrica fabrica = Fabrica.getInstance();

                ArrayList<DtServicio> listaServicios = fabrica.getIControladorUsuario().listarServicioProveedor(user);

                Iterator<DtServicio> iter = listaServicios.iterator();
                while (iter.hasNext()) {

                    DtServicio res = iter.next();
                    registrosServicios[0] = res.getNombre();
                    System.out.println(registrosServicios[0]);
                    registrosServicios[1] = Float.toString(res.getPrecio());
                    registrosServicios[2] = res.getNomCiuOrigen();
                    registrosServicios[3] = res.getNomCiuDestino();

                    modeloTablaSer.addRow(registrosServicios);
                }
            }
            jTablaServicios.setModel(modeloTablaSer);
        }
    }//GEN-LAST:event_jListaProveedoresMouseClicked

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JLabel jLabelDatos;
    private javax.swing.JLabel jLabelProveedor;
    private javax.swing.JLabel jLabelServicios;
    private javax.swing.JList<String> jListaProveedores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTablaProveedores;
    private javax.swing.JTable jTablaServicios;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

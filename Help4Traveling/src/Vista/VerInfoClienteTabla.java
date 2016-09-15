/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.DtReserva;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IControladorUsuario;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tecnoinf
 */
public class VerInfoClienteTabla extends javax.swing.JInternalFrame {

    private IControladorUsuario IControlador;
    private ArrayList<DtUsuario> listaClientes;
    private List<DtReserva> listaReservas;
    String[] colCliente = {"Alias", "Nombre", "Apellido", "Nacimiento", "Imagen"};
    String[] colReservas = {"Número", "Fecha", "Estado", "Total"};
    private DefaultTableModel modeloClientes;
    private DefaultTableModel modeloReservas;
    private DefaultTableCellRenderer centerRenderer;
    private DefaultTableCellRenderer rightRenderer;

    /**
     * Creates new form verInfoReserva
     */
    private void refrescarClientes() {
        this.listaClientes = this.IControlador.listarClientes();
        Iterator<DtUsuario> i = this.listaClientes.iterator();
        modeloClientes.getDataVector().removeAllElements();

        while (i.hasNext()) {
            DtUsuario u = i.next();
            Object[] fila = {
                u.getNickname(),
                u.getNombre(),
                u.getApellido(),
                u.getNacimiento().getFecha("-"),
                u.getImagen()
            };
            modeloClientes.addRow(fila);
        }
        Clientes.setModel(modeloClientes);
        Clientes.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
    }

    private void refrescarReservas() {
        Integer index = Clientes.getSelectedRow();
        if (index != -1) {
            DtUsuario u = listaClientes.get(index);
            this.listaReservas = this.IControlador.listarReservasCliente(u);
            modeloReservas.setRowCount(0);

            if (listaReservas != null) {
                Iterator<DtReserva> it = this.listaReservas.iterator();

                while (it.hasNext()) {
                    DtReserva r = it.next();
                    Object[] fila = {
                        r.getId(),
                        r.getCreada().getFecha("-"),
                        r.getEstado(),
                        r.getTotal()
                    };
                    modeloReservas.addRow(fila);
                }
            }

            Reservas.setModel(modeloReservas);
            Reservas.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            Reservas.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            Reservas.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        }
    }

    private void refrescarFoto() {
        Integer index = Clientes.getSelectedRow();
        if (index != -1) {
            DtUsuario u = listaClientes.get(index);
            String ruta = u.getImagen();
            System.out.println("Ruta: " + ruta);
            if (ruta == null) {
                jp_foto.repaint();
            } else {
                File fichero = new File(ruta);
                System.out.println("Fichero: " + fichero);
                mostrarImagen(extraerImagen(fichero));
            }

        }
    }

    public Image extraerImagen(File fichero) {
        Image img = null;
        try {
            img = ImageIO.read(fichero).getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public void mostrarImagen(Image img) {
        jp_foto.getGraphics().drawImage(img, 0, 0, 100, 100, java.awt.Color.BLACK, null);
    }

    public VerInfoClienteTabla() {
        this.centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        this.rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

        this.modeloReservas = new DefaultTableModel(colReservas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.modeloClientes = new DefaultTableModel(colCliente, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        initComponents();

        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador = fabrica.getIControladorUsuario();

        //fabrica.getIControladorReserva().setReservasDB();
        //fabrica.getIControladorReserva().setItemsDB();
        refrescarClientes();
        if (Clientes.getRowCount() > 0) {
            Clientes.setRowSelectionInterval(0, 0);
            refrescarFoto();
            refrescarReservas();
        } else {
            Reservas.setModel(modeloReservas);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Reservas = new javax.swing.JTable();
        lbReservas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Clientes = new javax.swing.JTable();
        lbClientes = new javax.swing.JLabel();
        Actualizar = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        jp_foto = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ver Info Cliente");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(440, 240));
        setPreferredSize(new java.awt.Dimension(600, 336));

        Reservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número", "Fecha", "Estado", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Reservas.setColumnSelectionAllowed(true);
        Reservas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Reservas);
        Reservas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        lbReservas.setText("Reservas correspondientes al cliente seleccionado:");

        Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Alias", "Nombre", "Apellido", "Nacimiento", "Imagen"
            }
        ));
        Clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Clientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        Clientes.getTableHeader().setReorderingAllowed(false);
        Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClientesMouseClicked(evt);
            }
        });
        Clientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ClientesKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(Clientes);

        lbClientes.setText("Seleccione al cliente para el cual desea ver mas información:");

        Actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/refresh-icon.png"))); // NOI18N
        Actualizar.setText("Actualizar");
        Actualizar.setFocusable(false);
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-icon.png"))); // NOI18N
        Aceptar.setText("Aceptar");
        Aceptar.setFocusable(false);
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        jp_foto.setBackground(new java.awt.Color(255, 255, 255));
        jp_foto.setMinimumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout jp_fotoLayout = new javax.swing.GroupLayout(jp_foto);
        jp_foto.setLayout(jp_fotoLayout);
        jp_fotoLayout.setHorizontalGroup(
            jp_fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jp_fotoLayout.setVerticalGroup(
            jp_fotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("Imagen:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Aceptar))
                    .addComponent(lbClientes)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbReservas)
                                .addGap(192, 192, 192)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jp_foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbReservas)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jp_foto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Actualizar)
                    .addComponent(Aceptar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClientesMouseClicked
        if (Clientes.getSelectedRowCount() > 0) {
            refrescarFoto();
            refrescarReservas();
        }
    }//GEN-LAST:event_ClientesMouseClicked

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        int fila = 0;
        if (Clientes.getSelectedRowCount() > 0) {
            fila = Clientes.getSelectedRow();
        }
        //this.IControlador.setReservasDB();
        //this.IControlador.setItemsDB();
        refrescarClientes();
        modeloReservas.getDataVector().removeAllElements();
        Reservas.setModel(modeloReservas);
        if (Clientes.getRowCount() > fila) {
            Clientes.setRowSelectionInterval(fila, fila);
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_AceptarActionPerformed

    private void ClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ClientesKeyReleased
        if (Clientes.getSelectedRowCount() > 0) {
            refrescarFoto();
            refrescarReservas();
        }
    }//GEN-LAST:event_ClientesKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Actualizar;
    private javax.swing.JTable Clientes;
    private javax.swing.JTable Reservas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jp_foto;
    private javax.swing.JLabel lbClientes;
    private javax.swing.JLabel lbReservas;
    // End of variables declaration//GEN-END:variables
}

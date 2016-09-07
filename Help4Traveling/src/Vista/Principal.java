/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Conexion;
import Logica.Fabrica;
import Logica.IControladorUsuario;
import Logica.ScriptRunner;
import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.InternalFrameEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author yaman
 */
public class Principal extends javax.swing.JFrame {

    private IControladorUsuario IControlador;
    private String tipo;
    private String camino;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fc_seleccionar_archivo.setVisible(false);
        LookAndFeel laf = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
        }
        escritorio.updateUI();
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

    public void internalFrameClosing(InternalFrameEvent e) {

    }

    public void internalFrameClosed(InternalFrameEvent e) {

    }

    public void internalFrameOpened(InternalFrameEvent e) {
        jMenuItemCerrarAll.setEnabled(true);
    }

    public void internalFrameIconified(InternalFrameEvent e) {

    }

    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    public void internalFrameActivated(InternalFrameEvent e) {
        jMenuItemCerrar.setEnabled(true);
    }

    public void internalFrameDeactivated(InternalFrameEvent e) {
        jMenuItemCerrar.setEnabled(false);
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
        escritorio = new javax.swing.JDesktopPane() {
            private BufferedImage toBufferedImage(Image img)
            {
                if (img instanceof BufferedImage)
                {
                    return (BufferedImage) img;
                }

                // Create a buffered image with transparency
                BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

                // Draw the image on to the buffered image
                Graphics2D bGr = bimage.createGraphics();
                bGr.drawImage(img, 0, 0, null);
                bGr.dispose();

                // Return the buffered image
                return bimage;
            }
            private BufferedImage getScaledImage(BufferedImage image, int width, int height) {
                int imageWidth  = image.getWidth();
                int imageHeight = image.getHeight();

                double scaleX = (double)width/imageWidth;
                double scaleY = (double)height/imageHeight;
                AffineTransform scaleTransform = AffineTransform.getScaleInstance(scaleX, scaleY);
                AffineTransformOp bilinearScaleOp = new AffineTransformOp(scaleTransform, AffineTransformOp.TYPE_BILINEAR);

                return bilinearScaleOp.filter(
                    image,
                    new BufferedImage(width, height, image.getType()));
            }
            private Image resize(Image originalImage, int newWidth, int newHeight) {
                int type = BufferedImage.TYPE_INT_ARGB;

                BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, type);
                Graphics2D g = resizedImage.createGraphics();

                g.setComposite(AlphaComposite.Src);
                g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g.drawImage(originalImage, 0, 0, newWidth, newHeight, this);
                g.dispose();
                return resizedImage;
            }

            @Override
            protected void paintComponent(Graphics g)
            {
                Image image = new ImageIcon(getClass().getResource("/help4traveling/fondo.png")).getImage();
                //BufferedImage bimage = toBufferedImage(image);
                //g.drawImage((Image)getScaledImage(bimage,getWidth(),getHeight()), 0, 0, java.awt.Color.BLACK, null);
                g.drawImage(resize(image,getWidth(),getHeight()), 0, 0, java.awt.Color.BLACK, null);
            }
        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuInicio = new javax.swing.JMenu();
        jMenuItemCargar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCerrar = new javax.swing.JMenuItem();
        jMenuItemCerrarAll = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuRegistros = new javax.swing.JMenu();
        bm_registrar_cliente = new javax.swing.JMenuItem();
        bm_registrar_servicio = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        bm_registrar_reserva = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItemEstado = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCancelar = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenu();
        bm_verInfoCliente = new javax.swing.JMenuItem();
        VerInfo_promo = new javax.swing.JMenuItem();
        bm_verInfoProveedor = new javax.swing.JMenuItem();
        jMenuItemVerRes = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        fc_seleccionar_archivo.setOpaque(true);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Help4Traveling");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Iconos/logo-icon.png")).getImage());
        setMinimumSize(new java.awt.Dimension(640, 360));

        escritorio.setMinimumSize(new java.awt.Dimension(640, 360));
        escritorio.setPreferredSize(new java.awt.Dimension(960, 540));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        jMenuInicio.setText("Inicio");

        jMenuItemCargar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/db-icon.png"))); // NOI18N
        jMenuItemCargar.setText("Cargar Datos");
        jMenuItemCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarActionPerformed(evt);
            }
        });
        jMenuInicio.add(jMenuItemCargar);
        jMenuInicio.add(jSeparator3);

        jMenuItemCerrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/win-icon.png"))); // NOI18N
        jMenuItemCerrar.setText("Cerrar");
        jMenuItemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCerrarActionPerformed(evt);
            }
        });
        jMenuInicio.add(jMenuItemCerrar);

        jMenuItemCerrarAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCerrarAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/win-icon.png"))); // NOI18N
        jMenuItemCerrarAll.setText("Cerrar Todas");
        jMenuItemCerrarAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCerrarAllActionPerformed(evt);
            }
        });
        jMenuInicio.add(jMenuItemCerrarAll);
        jMenuInicio.add(jSeparator2);

        jMenuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-icon.png"))); // NOI18N
        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuInicio.add(jMenuItemSalir);

        jMenuBar1.add(jMenuInicio);

        jMenuRegistros.setText("Registros");
        jMenuRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegistrosActionPerformed(evt);
            }
        });

        bm_registrar_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        bm_registrar_cliente.setText("Registrar Usuario");
        bm_registrar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_registrar_clienteActionPerformed(evt);
            }
        });
        jMenuRegistros.add(bm_registrar_cliente);

        bm_registrar_servicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        bm_registrar_servicio.setText("Registrar Servicio");
        bm_registrar_servicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_registrar_servicioActionPerformed(evt);
            }
        });
        jMenuRegistros.add(bm_registrar_servicio);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        jMenuItem2.setText("Alta Categoria");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuRegistros.add(jMenuItem2);

        bm_registrar_reserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        bm_registrar_reserva.setText("Registrar Reserva");
        bm_registrar_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_registrar_reservaActionPerformed(evt);
            }
        });
        jMenuRegistros.add(bm_registrar_reserva);
        jMenuRegistros.add(jSeparator4);

        jMenuItemEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit-icon.png"))); // NOI18N
        jMenuItemEstado.setText("Modificar Reserva");
        jMenuItemEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEstadoActionPerformed(evt);
            }
        });
        jMenuRegistros.add(jMenuItemEstado);
        jMenuRegistros.add(jSeparator1);

        jMenuItemCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete-icon.png"))); // NOI18N
        jMenuItemCancelar.setText("Cancelar Reserva");
        jMenuItemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCancelarActionPerformed(evt);
            }
        });
        jMenuRegistros.add(jMenuItemCancelar);

        jMenuBar1.add(jMenuRegistros);
        jMenuRegistros.getAccessibleContext().setAccessibleDescription("");

        jMenuConsultas.setText("Consultas");

        bm_verInfoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        bm_verInfoCliente.setText("VerInfo Cliente");
        bm_verInfoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_verInfoClienteActionPerformed(evt);
            }
        });
        jMenuConsultas.add(bm_verInfoCliente);

        VerInfo_promo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        VerInfo_promo.setText("VerInfo Promocion");
        VerInfo_promo.setToolTipText("");
        VerInfo_promo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInfo_promoActionPerformed(evt);
            }
        });
        jMenuConsultas.add(VerInfo_promo);

        bm_verInfoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        bm_verInfoProveedor.setText("VerInfo Proveedor");
        bm_verInfoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_verInfoProveedorActionPerformed(evt);
            }
        });
        jMenuConsultas.add(bm_verInfoProveedor);

        jMenuItemVerRes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        jMenuItemVerRes.setText("VerInfo Reserva");
        jMenuItemVerRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerResActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItemVerRes);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        jMenuItem3.setText("VerInfo Servicio");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuConsultas.add(jMenuItem3);

        jMenuBar1.add(jMenuConsultas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bm_registrar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_registrar_clienteActionPerformed
        // TODO add your handling code here:
        altaUsuario fAltaUsuario = new altaUsuario();
        escritorio.add(fAltaUsuario);
        centrarVentana(fAltaUsuario);
        fAltaUsuario.setVisible(true);
    }//GEN-LAST:event_bm_registrar_clienteActionPerformed

    private void jMenuRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegistrosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuRegistrosActionPerformed

    private void bm_registrar_servicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_registrar_servicioActionPerformed
        // TODO add your handling code here:
        altaServicio fAltaServicio = new altaServicio();
        escritorio.add(fAltaServicio);
        centrarVentana(fAltaServicio);
        fAltaServicio.setVisible(true);

    }//GEN-LAST:event_bm_registrar_servicioActionPerformed

    private void bm_registrar_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_registrar_reservaActionPerformed
        altaReserva fAltaReserva = new altaReserva();
        //fAltaReserva.setLocationRelativeTo(null);
        escritorio.add(fAltaReserva);
        Dimension desktopSize = Principal.escritorio.getSize();
        Dimension FrameSize = fAltaReserva.getSize();
        fAltaReserva.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        fAltaReserva.setVisible(true);
    }//GEN-LAST:event_bm_registrar_reservaActionPerformed

    private void bm_verInfoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_verInfoClienteActionPerformed
        verInfoCliente fverInfoCliente = new verInfoCliente();
        escritorio.add(fverInfoCliente);
        centrarVentana(fverInfoCliente);
        fverInfoCliente.setVisible(true);
    }//GEN-LAST:event_bm_verInfoClienteActionPerformed

    private void bm_verInfoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bm_verInfoProveedorActionPerformed
        verInfoProveedor fverInfoProveedor = new verInfoProveedor();
        escritorio.add(fverInfoProveedor);
        centrarVentana(fverInfoProveedor);
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
        centrarVentana(vir);
        vir.setVisible(true);
    }//GEN-LAST:event_jMenuItemVerResActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        altaCategoria altacat = new altaCategoria();
        escritorio.add(altacat);
        centrarVentana(altacat);
        altacat.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarActionPerformed
        JInternalFrame ventana = escritorio.getSelectedFrame();
        if (ventana != null) {
            ventana.dispose();
        }
    }//GEN-LAST:event_jMenuItemCerrarActionPerformed

    private void jMenuItemCerrarAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCerrarAllActionPerformed
        JInternalFrame ventana = escritorio.getSelectedFrame();
        while (ventana != null) {
            ventana.dispose();
            ventana = escritorio.selectFrame(true);
        }
        //jMenuItemCerrar.setEnabled(false);
        //jMenuItemCerrarAll.setEnabled(false);
    }//GEN-LAST:event_jMenuItemCerrarAllActionPerformed

    private void jMenuItemCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCargarActionPerformed
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("SQL Scripts", "sql");
        selector.setFileFilter(filter);
        selector.setVisible(true);
        int eleccion = selector.showOpenDialog(null);
        if (eleccion == JFileChooser.APPROVE_OPTION) {
            File datos = selector.getSelectedFile();
            camino = datos.getAbsolutePath();
            System.out.print("Datos ubicados en: ");
            System.out.println(camino);
            cargarDatos();
        }
    }//GEN-LAST:event_jMenuItemCargarActionPerformed

    private void VerInfo_promoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerInfo_promoActionPerformed
        VerInfoPromo altacat = new VerInfoPromo();
        escritorio.add(altacat);
        centrarVentana(altacat);
        altacat.setVisible(true);    }//GEN-LAST:event_VerInfo_promoActionPerformed

    private void jMenuItemEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEstadoActionPerformed
        ActualizarReserva ar = new ActualizarReserva();
        escritorio.add(ar);
        centrarVentana(ar);
        ar.setVisible(true);
    }//GEN-LAST:event_jMenuItemEstadoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        verInfoServicio infoServicio = new verInfoServicio();
        escritorio.add(infoServicio);
        centrarVentana(infoServicio);
        infoServicio.setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public void cargarDatos() {
        System.out.print("Cargando Datos... ");
        Conexion conexion = new Conexion();
        Connection con = conexion.getConnection();
        ScriptRunner runner = new ScriptRunner(con, false, true);
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            runner.runScript(new BufferedReader(new FileReader(camino)));
            this.setCursor(Cursor.getDefaultCursor());
            JOptionPane.showMessageDialog(this, "El script fue ejecutado correctamente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("OK");
        } catch (IOException ex) {
            System.out.println("ERROR");
            Logger
                    .getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "El script no pudo cargarse.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            System.out.println("ERROR");
            Logger
                    .getLogger(Principal.class
                            .getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "El script no pudo ejecutarse.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.setCursor(Cursor.getDefaultCursor());
    }

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
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JMenuItem VerInfo_promo;
    private javax.swing.JMenuItem bm_registrar_cliente;
    private javax.swing.JMenuItem bm_registrar_reserva;
    private javax.swing.JMenuItem bm_registrar_servicio;
    private javax.swing.JMenuItem bm_verInfoCliente;
    private javax.swing.JMenuItem bm_verInfoProveedor;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JFileChooser fc_seleccionar_archivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConsultas;
    private javax.swing.JMenu jMenuInicio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemCancelar;
    private javax.swing.JMenuItem jMenuItemCargar;
    private javax.swing.JMenuItem jMenuItemCerrar;
    private javax.swing.JMenuItem jMenuItemCerrarAll;
    private javax.swing.JMenuItem jMenuItemEstado;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemVerRes;
    private javax.swing.JMenu jMenuRegistros;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    // End of variables declaration//GEN-END:variables
}

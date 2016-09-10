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
    private Boolean shift = false;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.fc_seleccionar_archivo.setVisible(false);
        try {
            UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
        }
        escritorio.updateUI();
        jMenuBar1.updateUI();
    }

    public Principal(IControladorUsuario IControlador) {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador = fabrica.getIControladorUsuario();
        this.tipo = "Cliente";
    }

    public void internalFrameClosing(InternalFrameEvent e) {

    }

    public void internalFrameClosed(InternalFrameEvent e) {

    }

    public void internalFrameOpened(InternalFrameEvent e) {
        cerrarMenu2.setEnabled(true);
    }

    public void internalFrameIconified(InternalFrameEvent e) {

    }

    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    public void internalFrameActivated(InternalFrameEvent e) {
        cerrarMenu.setEnabled(true);
    }

    public void internalFrameDeactivated(InternalFrameEvent e) {
        cerrarMenu.setEnabled(false);
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
        externoMenu = new javax.swing.JMenuItem();
        internoMenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        cerrarMenu = new javax.swing.JMenuItem();
        cerrarMenu2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        opcionesMenu = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        salirMenu = new javax.swing.JMenuItem();
        jMenuRegistros = new javax.swing.JMenu();
        regCatMenu = new javax.swing.JMenuItem();
        regPromoMenu = new javax.swing.JMenuItem();
        refResMenu = new javax.swing.JMenuItem();
        regServMenu = new javax.swing.JMenuItem();
        regUsuMenu = new javax.swing.JMenuItem();
        jMenuConsultas = new javax.swing.JMenu();
        bm_verInfoCliente = new javax.swing.JMenuItem();
        VerInfo_promo = new javax.swing.JMenuItem();
        bm_verInfoProveedor = new javax.swing.JMenuItem();
        conResMenu = new javax.swing.JMenuItem();
        conServMenu = new javax.swing.JMenuItem();
        jMenuModificaciones = new javax.swing.JMenu();
        modResMenu = new javax.swing.JMenuItem();
        modServMenu = new javax.swing.JMenuItem();
        elimResMenu = new javax.swing.JMenuItem();

        fc_seleccionar_archivo.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Help4Traveling");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Iconos/logo-icon.png")).getImage());
        setMinimumSize(new java.awt.Dimension(640, 360));

        escritorio.setMinimumSize(new java.awt.Dimension(640, 360));
        escritorio.setPreferredSize(new java.awt.Dimension(960, 540));
        escritorio.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                escritorioComponentHidden(evt);
            }
        });

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

        externoMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        externoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/db-icon.png"))); // NOI18N
        externoMenu.setText("Ejecutar Script Externo");
        externoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                externoMenuActionPerformed(evt);
            }
        });
        jMenuInicio.add(externoMenu);

        internoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/db-icon.png"))); // NOI18N
        internoMenu.setText("Ejecutar Script  Interno");
        internoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internoMenuActionPerformed(evt);
            }
        });
        jMenuInicio.add(internoMenu);
        jMenuInicio.add(jSeparator1);

        cerrarMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        cerrarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel-icon.png"))); // NOI18N
        cerrarMenu.setText("Cerrar Ventana");
        cerrarMenu.setEnabled(false);
        cerrarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarMenuActionPerformed(evt);
            }
        });
        jMenuInicio.add(cerrarMenu);

        cerrarMenu2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        cerrarMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel-icon.png"))); // NOI18N
        cerrarMenu2.setText("Cerrar Ventanas");
        cerrarMenu2.setEnabled(false);
        cerrarMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarMenu2ActionPerformed(evt);
            }
        });
        jMenuInicio.add(cerrarMenu2);
        jMenuInicio.add(jSeparator2);

        opcionesMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        opcionesMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/options-icon.png"))); // NOI18N
        opcionesMenu.setText("Opciones");
        opcionesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionesMenuActionPerformed(evt);
            }
        });
        jMenuInicio.add(opcionesMenu);
        jMenuInicio.add(jSeparator3);

        salirMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        salirMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-icon.png"))); // NOI18N
        salirMenu.setText("Salir");
        salirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuActionPerformed(evt);
            }
        });
        jMenuInicio.add(salirMenu);

        jMenuBar1.add(jMenuInicio);

        jMenuRegistros.setText("Registros");
        jMenuRegistros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRegistrosActionPerformed(evt);
            }
        });

        regCatMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        regCatMenu.setText("Registrar Categoria");
        regCatMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regCatMenuActionPerformed(evt);
            }
        });
        regCatMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                regCatMenuKeyPressed(evt);
            }
        });
        jMenuRegistros.add(regCatMenu);

        regPromoMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        regPromoMenu.setText("Registrar Promoción");
        regPromoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regPromoMenuActionPerformed(evt);
            }
        });
        jMenuRegistros.add(regPromoMenu);

        refResMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        refResMenu.setText("Registrar Reserva");
        refResMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refResMenuActionPerformed(evt);
            }
        });
        jMenuRegistros.add(refResMenu);

        regServMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        regServMenu.setText("Registrar Servicio");
        regServMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regServMenuActionPerformed(evt);
            }
        });
        jMenuRegistros.add(regServMenu);

        regUsuMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        regUsuMenu.setText("Registrar Usuario");
        regUsuMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regUsuMenuActionPerformed(evt);
            }
        });
        jMenuRegistros.add(regUsuMenu);

        jMenuBar1.add(jMenuRegistros);
        jMenuRegistros.getAccessibleContext().setAccessibleDescription("");

        jMenuConsultas.setText("Consultas");

        bm_verInfoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        bm_verInfoCliente.setText("Consultar Cliente");
        bm_verInfoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_verInfoClienteActionPerformed(evt);
            }
        });
        jMenuConsultas.add(bm_verInfoCliente);

        VerInfo_promo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        VerInfo_promo.setText("Consultar Promocion");
        VerInfo_promo.setToolTipText("");
        VerInfo_promo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerInfo_promoActionPerformed(evt);
            }
        });
        jMenuConsultas.add(VerInfo_promo);

        bm_verInfoProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        bm_verInfoProveedor.setText("Consultar Proveedor");
        bm_verInfoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bm_verInfoProveedorActionPerformed(evt);
            }
        });
        jMenuConsultas.add(bm_verInfoProveedor);

        conResMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        conResMenu.setText("Consultar Reserva");
        conResMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conResMenuActionPerformed(evt);
            }
        });
        jMenuConsultas.add(conResMenu);

        conServMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        conServMenu.setText("Consultar Servicio");
        conServMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conServMenuActionPerformed(evt);
            }
        });
        jMenuConsultas.add(conServMenu);

        jMenuBar1.add(jMenuConsultas);

        jMenuModificaciones.setText("Modificaciones");

        modResMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit-icon.png"))); // NOI18N
        modResMenu.setText("Modificar Reserva");
        modResMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modResMenuActionPerformed(evt);
            }
        });
        jMenuModificaciones.add(modResMenu);

        modServMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit-icon.png"))); // NOI18N
        modServMenu.setText("Modificar Servicio");
        modServMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modServMenuActionPerformed(evt);
            }
        });
        jMenuModificaciones.add(modServMenu);

        elimResMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete-icon.png"))); // NOI18N
        elimResMenu.setText("Eliminar Reserva");
        elimResMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elimResMenuActionPerformed(evt);
            }
        });
        jMenuModificaciones.add(elimResMenu);

        jMenuBar1.add(jMenuModificaciones);

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

    private void regUsuMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regUsuMenuActionPerformed
        // TODO add your handling code here:
        altaUsuario fAltaUsuario = new altaUsuario();
        escritorio.add(fAltaUsuario);
        centrarVentana(fAltaUsuario);
        fAltaUsuario.setVisible(true);
    }//GEN-LAST:event_regUsuMenuActionPerformed

    private void jMenuRegistrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRegistrosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuRegistrosActionPerformed

    private void regServMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regServMenuActionPerformed
        // TODO add your handling code here:
        altaServicio fAltaServicio = new altaServicio();
        escritorio.add(fAltaServicio);
        centrarVentana(fAltaServicio);
        fAltaServicio.setVisible(true);

    }//GEN-LAST:event_regServMenuActionPerformed

    private void refResMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refResMenuActionPerformed
        altaReserva fAltaReserva = new altaReserva();
        //fAltaReserva.setLocationRelativeTo(null);
        escritorio.add(fAltaReserva);
        Dimension desktopSize = Principal.escritorio.getSize();
        Dimension FrameSize = fAltaReserva.getSize();
        fAltaReserva.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        fAltaReserva.setVisible(true);
    }//GEN-LAST:event_refResMenuActionPerformed

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

    private void elimResMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimResMenuActionPerformed
        cancelarReserva cr = new cancelarReserva();
        escritorio.add(cr);
        centrarVentana(cr);
        cr.setVisible(true);
    }//GEN-LAST:event_elimResMenuActionPerformed

    private void conResMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conResMenuActionPerformed
        verInfoReserva vir = new verInfoReserva();
        escritorio.add(vir);
        centrarVentana(vir);
        vir.setVisible(true);
    }//GEN-LAST:event_conResMenuActionPerformed

    private void salirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirMenuActionPerformed

    private void cerrarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarMenuActionPerformed
        JInternalFrame ventana = escritorio.getSelectedFrame();
        if (ventana != null) {
            ventana.dispose();
        }
        System.out.println(escritorio.getAllFrames());
        if (escritorio.getAllFrames() == null) {
            cerrarMenu.setEnabled(false);
            cerrarMenu2.setEnabled(false);
        }
    }//GEN-LAST:event_cerrarMenuActionPerformed

    private void cerrarMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarMenu2ActionPerformed
        JInternalFrame ventana = escritorio.getSelectedFrame();
        while (ventana != null) {
            ventana.dispose();
            ventana = escritorio.selectFrame(true);
        }
        cerrarMenu.setEnabled(false);
        cerrarMenu2.setEnabled(false);
    }//GEN-LAST:event_cerrarMenu2ActionPerformed

    private void externoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_externoMenuActionPerformed
        JFileChooser selector = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("SQL Scripts (.sql)", "sql");
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
    }//GEN-LAST:event_externoMenuActionPerformed

    private void VerInfo_promoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerInfo_promoActionPerformed
        VerInfoPromo altacat = new VerInfoPromo();
        escritorio.add(altacat);
        centrarVentana(altacat);
        altacat.setVisible(true);    }//GEN-LAST:event_VerInfo_promoActionPerformed

    private void modResMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modResMenuActionPerformed
        ActualizarReserva ar = new ActualizarReserva();
        escritorio.add(ar);
        centrarVentana(ar);
        ar.setVisible(true);
    }//GEN-LAST:event_modResMenuActionPerformed

    private void conServMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conServMenuActionPerformed
        // TODO add your handling code here:
        verInfoServicio infoServicio = new verInfoServicio();
        escritorio.add(infoServicio);
        centrarVentana(infoServicio);
        infoServicio.setVisible(true);

    }//GEN-LAST:event_conServMenuActionPerformed

    private void regCatMenuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_regCatMenuKeyPressed
        if (evt.isShiftDown()) {
            shift = true;
        }
    }//GEN-LAST:event_regCatMenuKeyPressed

    private void regCatMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regCatMenuActionPerformed
        //AltaCategoria ac = new AltaCategoria();
        JInternalFrame ac;
        if (shift) {
            ac = new altaCategoria();
        } else {
            ac = new AltaCategoria2();
        }
        escritorio.add(ac);
        centrarVentana(ac);
        ac.setVisible(true);
    }//GEN-LAST:event_regCatMenuActionPerformed

    private void escritorioComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_escritorioComponentHidden
        if (escritorio.getSelectedFrame() == null) {
            cerrarMenu.setEnabled(false);
        }
    }//GEN-LAST:event_escritorioComponentHidden

    private void regPromoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regPromoMenuActionPerformed
        AltaPromocion ap = new AltaPromocion();
        escritorio.add(ap);
        centrarVentana(ap);
        ap.setVisible(true);
    }//GEN-LAST:event_regPromoMenuActionPerformed

    private void opcionesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionesMenuActionPerformed
        Opciones o = new Opciones();
        abrirVentana(o);
    }//GEN-LAST:event_opcionesMenuActionPerformed

    private void modServMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modServMenuActionPerformed
        ActualizarServicio as = new ActualizarServicio();
        abrirVentana(as);
    }//GEN-LAST:event_modServMenuActionPerformed

    private void internoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internoMenuActionPerformed

    }//GEN-LAST:event_internoMenuActionPerformed

    //==========================================================================
    public void abrirVentana(JInternalFrame jif) {
        escritorio.add(jif);
        centrarVentana(jif);
        jif.setVisible(true);
    }

    public void centrarVentana(JInternalFrame jif) {
        Dimension tamEscritorio = escritorio.getSize();
        Dimension tamVentana = jif.getSize();
        int width = (tamEscritorio.width - tamVentana.width) / 2;
        int height = (tamEscritorio.height - tamVentana.height) / 2;
        jif.setLocation(width, height);
        cerrarMenu.setEnabled(true);
        cerrarMenu2.setEnabled(true);
    }

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
    private javax.swing.JMenuItem bm_verInfoCliente;
    private javax.swing.JMenuItem bm_verInfoProveedor;
    private javax.swing.JMenuItem cerrarMenu;
    private javax.swing.JMenuItem cerrarMenu2;
    private javax.swing.JMenuItem conResMenu;
    private javax.swing.JMenuItem conServMenu;
    private javax.swing.JMenuItem elimResMenu;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem externoMenu;
    private javax.swing.JFileChooser fc_seleccionar_archivo;
    private javax.swing.JMenuItem internoMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuConsultas;
    private javax.swing.JMenu jMenuInicio;
    private javax.swing.JMenu jMenuModificaciones;
    private javax.swing.JMenu jMenuRegistros;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem modResMenu;
    private javax.swing.JMenuItem modServMenu;
    private javax.swing.JMenuItem opcionesMenu;
    private javax.swing.JMenuItem refResMenu;
    private javax.swing.JMenuItem regCatMenu;
    private javax.swing.JMenuItem regPromoMenu;
    private javax.swing.JMenuItem regServMenu;
    private javax.swing.JMenuItem regUsuMenu;
    private javax.swing.JMenuItem salirMenu;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.DtCategoria;
import Logica.DtServicio;
import Logica.Fabrica;
import Logica.IControladorServicio;
import Logica.ManejadorCategoria;
import Logica.ManejadorCiudad;
import Logica.ManejadorServicio;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Hekutoru
 */
public class ActualizarServicio extends javax.swing.JInternalFrame {

    private IControladorServicio IControlador;
    private List<DtServicio> listaServicios = new ArrayList<DtServicio>();
    private List<String> listaPaises = new ArrayList<String>();
    private List<String> listaCiudades1 = new ArrayList<String>();
    private List<String> listaCiudades2 = new ArrayList<String>();
    List<String> imagenes = new ArrayList<String>();
    Map<String, DtCategoria> categorias = new HashMap<String, DtCategoria>();
    DefaultListModel modeloListaImagenes = new DefaultListModel();
    DefaultListModel modeloListaCategorias = new DefaultListModel();
    List<DtCategoria> listaCat = new LinkedList<DtCategoria>();
    String origen;
    String destino;
    boolean categoria_seleccionada;
    private Boolean expandir = true;

    /**
     * Creates new form ActualizarServicio
     */
    public ActualizarServicio() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador = fabrica.getIControladorServicio();
        bajarServicios();
        bajarServicio();
        this.lst_imagenes.setModel(modeloListaImagenes);
        this.lst_categorias.setModel(modeloListaCategorias);
        DefaultMutableTreeNode modeloCategorias = new DefaultMutableTreeNode("Categorias");
        DefaultTreeModel modelo = new DefaultTreeModel(modeloCategorias);
        MostrarArbol(modeloCategorias);
        this.tr_categorias.setModel(modelo);
        this.categoria_seleccionada = false;
        //bajarCiudadesOrigen();
        //bajarCiudadesDestino();
    }

    public void MostrarArbol(DefaultMutableTreeNode nodo) {
        ManejadorCategoria mc = ManejadorCategoria.getInstance();
        List<String> listaHijos = mc.obtenerCategoriasHijas(nodo.toString());
        Iterator<String> iter = listaHijos.iterator();
        while (iter.hasNext()) {
            String hijo = iter.next();
            System.out.println(hijo);
            DefaultMutableTreeNode nuevoNodo = new DefaultMutableTreeNode(hijo);
            nodo.add(nuevoNodo);
            System.out.println("Agregue el nodo " + hijo);
        }

        for (int j = 0; j < nodo.getChildCount(); j++) {
            MostrarArbol((DefaultMutableTreeNode) nodo.getChildAt(j));
        }

    }
    
    
    private void bajarServicios() {
        this.cb_nombre.removeAllItems();
        this.listaServicios = ManejadorServicio.getInstance().listarServicios();
        Iterator<DtServicio> iter = listaServicios.iterator();
        while (iter.hasNext()) {
            String servicio = iter.next().getNombre();
            this.cb_nombre.addItem(servicio);
        }
    }

    private void bajarServicio() {
        Integer index = cb_nombre.getSelectedIndex();
        DtServicio servicio = listaServicios.get(index);
        //System.out.println(servicio);
        modeloListaImagenes.clear();
        modeloListaCategorias.clear();
        ta_descripcion.setText(servicio.getDescripcion());
        tf_precio.setText(Float.toString(servicio.getPrecio()));

        bajarPaisesOrigen();
        String ciudadOrigen = servicio.getNomCiuOrigen();
        String paisOrigen = ManejadorCiudad.getInstance().obtenerCiudad(ciudadOrigen).getPais().getNombre();
        cb_pais_origen.setSelectedItem(paisOrigen);
        bajarCiudadesOrigen(paisOrigen);
        cb_ciudad_origen.setSelectedItem(ciudadOrigen);
        if (servicio.getNomCiuDestino() != null) {
            cb_pais_destino.setVisible(true);
            cb_ciudad_destino.setVisible(true);
            lb_destino.setVisible(true);
            bajarPaisesDestino();
            String ciudadDestino = servicio.getNomCiuDestino();
            String paisDestino = ManejadorCiudad.getInstance().obtenerCiudad(ciudadDestino).getPais().getNombre();
            cb_pais_destino.setSelectedItem(paisDestino);
            bajarCiudadesDestino(paisDestino);
            cb_ciudad_destino.setSelectedItem(ciudadDestino);
        }
        else {
            cb_pais_destino.setVisible(false);
            cb_ciudad_destino.setVisible(false);
            lb_destino.setVisible(false);
            
        }
        this.imagenes = servicio.getImagenes();
        for (int i=0; i<imagenes.size(); i++){
            modeloListaImagenes.addElement(imagenes.get(i));
            System.out.println(imagenes.get(i));
        }
        this.categorias = servicio.getDtCategorias();
        Iterator<DtCategoria> iterc = categorias.values().iterator();
        while (iterc.hasNext())
            modeloListaCategorias.addElement(iterc.next().getNombre());
    }
            
        
    private void bajarPaisesOrigen() {
        this.cb_pais_origen.removeAllItems();
        this.listaPaises = ManejadorCiudad.getInstance().listarPaises();
        Iterator<String> iter = this.listaPaises.iterator();
        while (iter.hasNext()) {
            String pais = iter.next();
            this.cb_pais_origen.addItem(pais);
        }
    }

    private void bajarCiudadesOrigen(String pais) {
        this.cb_ciudad_origen.removeAllItems();
        this.listaCiudades1 = ManejadorCiudad.getInstance().listarCiudadesPorPais(pais);
        Iterator<String> iter = this.listaCiudades1.iterator();
        while (iter.hasNext()) {
            String nomciudad = iter.next();
            this.cb_ciudad_origen.addItem(nomciudad);
        }
    }

    private void bajarPaisesDestino() {
        this.cb_pais_destino.removeAllItems();
        this.listaPaises = ManejadorCiudad.getInstance().listarPaises();
        Iterator<String> iter = this.listaPaises.iterator();
        while (iter.hasNext()) {
            String pais = iter.next();
            this.cb_pais_destino.addItem(pais);
        }
    }

    private void bajarCiudadesDestino(String pais) {
        this.cb_ciudad_destino.removeAllItems();
        this.listaCiudades2 = ManejadorCiudad.getInstance().listarCiudadesPorPais(pais);
        Iterator<String> iter = this.listaCiudades2.iterator();
        while (iter.hasNext()) {
            String nomciudad = iter.next();
            this.cb_ciudad_destino.addItem(nomciudad);
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

        Aceptar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jLabNom = new javax.swing.JLabel();
        cb_nombre = new javax.swing.JComboBox<>();
        jLabelServ = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_descripcion = new javax.swing.JTextPane();
        jLabDesc = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelPrecio = new javax.swing.JLabel();
        tf_precio = new javax.swing.JTextField();
        jLabOrig = new javax.swing.JLabel();
        lb_destino = new javax.swing.JLabel();
        cb_pais_origen = new javax.swing.JComboBox<>();
        cb_pais_destino = new javax.swing.JComboBox<>();
        cb_ciudad_destino = new javax.swing.JComboBox<>();
        cb_ciudad_origen = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        btn_seleccionar_imagen = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lst_imagenes = new javax.swing.JList<>();
        jLabOrig1 = new javax.swing.JLabel();
        btn_eliminar_imagen = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tr_categorias = new javax.swing.JTree();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_agregar_categoria = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lst_categorias = new javax.swing.JList<>();
        btn_eliminar_categoria = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Actualizar Servicio");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/edit-icon.png"))); // NOI18N

        Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/check-icon.png"))); // NOI18N
        Aceptar.setText("Aceptar");
        Aceptar.setFocusable(false);
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });

        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancel-icon.png"))); // NOI18N
        Cancelar.setText("Cancelar");
        Cancelar.setFocusable(false);
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        jLabNom.setText("Nombre:");

        cb_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_nombreActionPerformed(evt);
            }
        });

        jLabelServ.setText("Seleccione el nombre del Servicio que desea modificar:");

        jScrollPane1.setViewportView(ta_descripcion);

        jLabDesc.setText("Descripción:");

        jLabelPrecio.setText("Precio:");

        jLabOrig.setText("Origen:");

        lb_destino.setText("Destino:");

        cb_pais_origen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_pais_origenActionPerformed(evt);
            }
        });

        cb_pais_destino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_pais_destinoActionPerformed(evt);
            }
        });

        jLabel3.setText("(USD)");

        btn_seleccionar_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscar.png"))); // NOI18N
        btn_seleccionar_imagen.setText("Seleccionar Imagen");
        btn_seleccionar_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_seleccionar_imagenActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(lst_imagenes);

        jLabOrig1.setText("Imágenes:");

        btn_eliminar_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete-icon.png"))); // NOI18N
        btn_eliminar_imagen.setText("  Eliminar Imagen");
        btn_eliminar_imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_imagenActionPerformed(evt);
            }
        });

        tr_categorias.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                tr_categoriasValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(tr_categorias);

        jLabel4.setText("Categorias:");

        jLabel5.setText("Categorías Disponibles:");

        btn_agregar_categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add-icon.png"))); // NOI18N
        btn_agregar_categoria.setText("Agregar");
        btn_agregar_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_categoriaActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(lst_categorias);

        btn_eliminar_categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/delete-icon.png"))); // NOI18N
        btn_eliminar_categoria.setText("  Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Aceptar))
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabNom)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cb_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabelServ)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabOrig1)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_eliminar_imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_seleccionar_imagen)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabOrig)
                                    .addGap(18, 18, 18)
                                    .addComponent(cb_pais_origen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cb_ciudad_origen, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(lb_destino)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cb_pais_destino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cb_ciudad_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabDesc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelPrecio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btn_eliminar_categoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_agregar_categoria)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelServ)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabNom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabDesc)
                        .addComponent(jLabelPrecio)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabOrig)
                        .addComponent(cb_pais_origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cb_ciudad_origen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cb_pais_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lb_destino)
                        .addComponent(cb_ciudad_destino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabOrig1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_eliminar_imagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_seleccionar_imagen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_agregar_categoria)
                    .addComponent(btn_eliminar_categoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aceptar)
                    .addComponent(Cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_AceptarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private void cb_pais_origenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_pais_origenActionPerformed
        /*
        if (PaisOrigen.get) {
        bajarCiudadesOrigen(PaisOrigen.getSelectedItem().toString());
        }
         */
    }//GEN-LAST:event_cb_pais_origenActionPerformed

    private void cb_pais_destinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_pais_destinoActionPerformed
        /*
        bajarCiudadesDestino(PaisDestino.getSelectedItem().toString());
         */
    }//GEN-LAST:event_cb_pais_destinoActionPerformed

    private void cb_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_nombreActionPerformed
        bajarServicio();
    }//GEN-LAST:event_cb_nombreActionPerformed

    private void btn_seleccionar_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_seleccionar_imagenActionPerformed
        // TODO add your handling code here:
        JFileChooser fc_seleccionar_archivo = new javax.swing.JFileChooser();
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fc_seleccionar_archivo.setFileFilter(filtroImagen);
        fc_seleccionar_archivo.setVisible(true);
        int eleccion = fc_seleccionar_archivo.showOpenDialog(null);
        //Seleccionamos el fichero
        if (eleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc_seleccionar_archivo.getSelectedFile();
            String pathimg = fichero.getAbsolutePath();
            this.imagenes.add(pathimg);
            modeloListaImagenes.addElement(pathimg);
        }
        if (this.imagenes.size() == 3) {
            this.btn_seleccionar_imagen.setEnabled(false);
        }
    }//GEN-LAST:event_btn_seleccionar_imagenActionPerformed

    private void btn_eliminar_imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_imagenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminar_imagenActionPerformed

    private void tr_categoriasValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_tr_categoriasValueChanged
        // TODO add your handling code here:
        this.categoria_seleccionada = true;
    }//GEN-LAST:event_tr_categoriasValueChanged

    private void btn_agregar_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_categoriaActionPerformed
        // TODO add your handling code here:
        if (this.categoria_seleccionada) {
            DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) tr_categorias.getLastSelectedPathComponent();
            String padre = ManejadorCategoria.getInstance().obtenerPadre(nodo.toString());
            DtCategoria cat = new DtCategoria(nodo.toString(), padre);
            this.categorias.put(nodo.toString(), cat);
            modeloListaCategorias.addElement(nodo.toString());
            /*if (padre.equals("Vuelos") || padre.equals("Tipo vuelo")) {
                pn_destinos.setVisible(true);
            } else {
                pn_destinos.setVisible(false);
            }*/
        }
        this.categoria_seleccionada = false;
    }//GEN-LAST:event_btn_agregar_categoriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton btn_agregar_categoria;
    private javax.swing.JButton btn_eliminar_categoria;
    private javax.swing.JButton btn_eliminar_imagen;
    private javax.swing.JButton btn_seleccionar_imagen;
    private javax.swing.JComboBox<String> cb_ciudad_destino;
    private javax.swing.JComboBox<String> cb_ciudad_origen;
    private javax.swing.JComboBox<String> cb_nombre;
    private javax.swing.JComboBox<String> cb_pais_destino;
    private javax.swing.JComboBox<String> cb_pais_origen;
    private javax.swing.JLabel jLabDesc;
    private javax.swing.JLabel jLabNom;
    private javax.swing.JLabel jLabOrig;
    private javax.swing.JLabel jLabOrig1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelServ;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb_destino;
    private javax.swing.JList<String> lst_categorias;
    private javax.swing.JList<String> lst_imagenes;
    private javax.swing.JTextPane ta_descripcion;
    private javax.swing.JTextField tf_precio;
    private javax.swing.JTree tr_categorias;
    // End of variables declaration//GEN-END:variables
}

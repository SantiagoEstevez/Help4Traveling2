/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.DtServicio;
import Logica.Fabrica;
import Logica.IControladorServicio;
import Logica.ManejadorCategoria;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author tecnoinf
 */
public class VerInfoServicioTabla extends javax.swing.JInternalFrame {

    private IControladorServicio IControlador;
    private List<String> listaCategorias;
    private List<DtServicio> listaServicios = new ArrayList<>();
    String[] colServicios = {"Nombre", "Precio", "Origen", "Destino"};
    private DefaultTableModel modeloServicios;
    private DefaultTableCellRenderer centerRenderer;
    private DefaultTableCellRenderer rightRenderer;
    private Boolean expandir = true;

    /**
     * Creates new form verInfoReserva
     */
    private void refrescarCategorias() {
        this.listaCategorias = this.IControlador.listarCategorias();
        Iterator<String> i = this.listaCategorias.iterator();

    }

    private void refrescarServicios() {
        Object nodo = Categorias.getLastSelectedPathComponent();
        if (nodo != null) {

            List<String> servicios = this.IControlador.listarServiciosCategoria(nodo.toString());
            List<DtServicio> listaServiciosCategoria = new ArrayList<>();
            listaServiciosCategoria.addAll(this.listaServicios);
            listaServiciosCategoria.removeIf(p -> !servicios.contains(p.getNombre()));
            modeloServicios.setRowCount(0);

            if (listaServiciosCategoria != null) {
                Iterator<DtServicio> it = listaServiciosCategoria.iterator();

                while (it.hasNext()) {
                    DtServicio s = it.next();
                    Object[] fila = {
                        s.getNombre(),
                        s.getPrecio(),
                        s.getNomCiuOrigen(),
                        s.getNomCiuDestino()
                    };
                    if (fila[3] == null) {
                        fila[3] = "-";
                    }
                    modeloServicios.addRow(fila);
                }
            }

            Servicios.setModel(modeloServicios);
            Servicios.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        }
    }

    public VerInfoServicioTabla() {
        this.centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        this.rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);

        this.modeloServicios = new DefaultTableModel(colServicios, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        initComponents();

        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador = fabrica.getIControladorServicio();

        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categorias");
        DefaultTreeModel modelo = new DefaultTreeModel(raiz);

        MostrarArbol(raiz);
        Categorias.setModel(modelo);
        Expandir.setIcon(javax.swing.UIManager.getIcon("Tree.openIcon"));
        this.listaServicios = this.IControlador.listarServicios();

        //fabrica.getIControladorReserva().setReservasDB();
        //fabrica.getIControladorReserva().setItemsDB();
        refrescarCategorias();
        if (Categorias.getRowCount() > 0) {
            refrescarServicios();
        } else {
            Servicios.setModel(modeloServicios);
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
        Servicios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Actualizar = new javax.swing.JButton();
        Aceptar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Categorias = new javax.swing.JTree();
        Expandir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ver Info Servicios");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/info-icon.png"))); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 240));
        setPreferredSize(new java.awt.Dimension(800, 300));

        Servicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Precio", "Origen", "Destino"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Servicios.setColumnSelectionAllowed(true);
        Servicios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Servicios);
        Servicios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setText("Servicios correspondientes a la categoría seleccionada a la izquierda:");

        jLabel2.setText("Categorías disponibles:");

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

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        Categorias.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        Categorias.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                CategoriasValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(Categorias);

        Expandir.setText("Expandir");
        Expandir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpandirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Actualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(Expandir))
                    .addComponent(jScrollPane3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Aceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Actualizar)
                    .addComponent(Aceptar)
                    .addComponent(Expandir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public final void MostrarArbol(DefaultMutableTreeNode nodo) {
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

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        int fila = 0;
        this.listaServicios = this.IControlador.listarServicios();
        if (Categorias.getSelectionCount() > 0) {
            fila = Categorias.getSelectionRows()[0];
        }
        //this.IControlador.setReservasDB();
        //this.IControlador.setItemsDB();
        refrescarCategorias();
        modeloServicios.getDataVector().removeAllElements();
        Servicios.setModel(modeloServicios);
        if (Categorias.getRowCount() > fila) {
            Categorias.setSelectionRow(fila);
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_AceptarActionPerformed

    private void CategoriasValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_CategoriasValueChanged
        refrescarServicios();
    }//GEN-LAST:event_CategoriasValueChanged

    private void ExpandirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpandirActionPerformed
        //jTree1.expandPath(jTree1.getSelectionPath());
        if (expandir) {
            for (int i = 0; i < Categorias.getRowCount(); i++) {
                Categorias.expandRow(i);
            }
            Expandir.setText("Colapsar");
            expandir = false;
            Expandir.setIcon(javax.swing.UIManager.getIcon("Tree.closedIcon"));
        } else {
            for (int i = Categorias.getRowCount(); i > 0; i--) {
                Categorias.collapseRow(i);
            }
            Expandir.setText("Expandir");
            expandir = true;
            Expandir.setIcon(javax.swing.UIManager.getIcon("Tree.openIcon"));
        }
    }//GEN-LAST:event_ExpandirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar;
    private javax.swing.JButton Actualizar;
    private javax.swing.JTree Categorias;
    private javax.swing.JButton Expandir;
    private javax.swing.JTable Servicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}

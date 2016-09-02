/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.DtUsuario;
import Logica.Fabrica;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import Logica.IControladorUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author yaman
 */
public class verInfoProveedor extends javax.swing.JInternalFrame {
    private IControladorUsuario IControlador;
    private ArrayList<DtUsuario> listaProveedores;
    /**
     * Creates new form verInfoProveedor
     */
    public verInfoProveedor() {
        initComponents();
        Fabrica fabrica = Fabrica.getInstance();
        this.IControlador = fabrica.getIControladorUsuario();        
        
        DefaultListModel modelo = new DefaultListModel();
       
        
         this.listaProveedores = this.IControlador.listarProveedores();
        Iterator<DtUsuario> i = this.listaProveedores.iterator();
        while (i.hasNext()) {
            DtUsuario user = i.next();
            modelo.addElement(user.getNombre()/*()+"   "+user.getApellido()+"   "+user.getNickname()*/);
        }
        
        jList2.setModel(modelo);
        
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
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Proveedores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList2MouseClicked

        String nombre = jList2.getSelectedValue();
        JOptionPane.showMessageDialog(null,nombre);

        Iterator<DtUsuario> i = this.listaProveedores.iterator();
        boolean es = false;
        DtUsuario dtu = new DtUsuario();
        while (i.hasNext() & !es) {
            DtUsuario user = i.next();
            if (nombre.equals(user.getNombre())){
                dtu = user;
                es = true;
                //JOptionPane.showMessageDialog(null,dtu.getNickname()+"  "+dtu.getNombre()+" "+dtu.getApellido());            }

        }
        // JOptionPane.showMessageDialog(null,dtu.getNickname());
        }
    }//GEN-LAST:event_jList2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

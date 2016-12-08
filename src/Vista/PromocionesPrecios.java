/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PromocionesPreciosControl;

/**
 *
 * @author Marce
 */
public class PromocionesPrecios extends javax.swing.JInternalFrame {

    /**
     * Creates new form Promociones
     */
    public PromocionesPrecios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList<>();
        txtProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaComplemento = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        btnMas = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        txtCantidadComplemento = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        btnCrearPromocion = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPromociones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setTitle("PROMOCIONES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("PRODUCTO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel2.setText("GESTION DE PROMOCIONES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel3.setText("ENTRADAS VIP");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, -1, -1));

        jLabel4.setText("ENTRADAS GENERALES");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        jScrollPane1.setViewportView(listaProductos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 190));

        txtProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductoKeyTyped(evt);
            }
        });
        getContentPane().add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, -1));

        jLabel5.setText("COMPLEMENTO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        txtComplemento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 110, -1));

        jScrollPane2.setViewportView(listaComplemento);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 110, 190));

        jLabel6.setText("CANTIDAD");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        txtCantidadProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtCantidadProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 110, -1));

        btnMas.setText("+");
        getContentPane().add(btnMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 50, 30));

        jLabel7.setText("CANTIDAD");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        txtCantidadComplemento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtCantidadComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 110, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setText("PRECIO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        txtPrecio.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 140, -1));

        btnCrearPromocion.setText("CREAR PROMOCION");
        getContentPane().add(btnCrearPromocion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 140, 90));

        tblPromociones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblPromociones);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 490, 230));

        jButton1.setText("GUARDAR PROMOCIONES CREADAS");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 490, 30));

        jButton2.setText("ELIMINAR");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyTyped
        
    }//GEN-LAST:event_txtProductoKeyTyped

    private void txtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyReleased
        try {
            String prod = txtProducto.getText();
            new PromocionesPreciosControl().buscarProducto(prod, listaProductos);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_txtProductoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearPromocion;
    private javax.swing.JToggleButton btnMas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<String> listaComplemento;
    private javax.swing.JList<String> listaProductos;
    private javax.swing.JTable tblPromociones;
    private javax.swing.JTextField txtCantidadComplemento;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}

package Vista;

import Controlador.ComprobantesControl;
import Controlador.LlenarTabla;
import Controlador.Validaciones;
import Modelo.Comprobante;
import Modelo.ComprobanteDAO;
import java.awt.Color;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Comprobantes extends javax.swing.JInternalFrame {

    public Comprobantes(String usuario) throws Exception {
        initComponents();
        getContentPane().setBackground(Color.white);
        LlenarTabla lt = new LlenarTabla();
        lt.LlenarTablaComprobante(tblComprobantes);
        new ComprobantesControl().llenarComboTipoComprobante(cmbTipoComprobante);
        txtUsuario1.setText(usuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtSubTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTipoDePago = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbTipoComprobante = new javax.swing.JComboBox();
        txtUsuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblComprobantes = new javax.swing.JTable();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        btnNuevo = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtUsuario1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("GESTION DE COMPROBANTES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 150, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("FECHA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 150, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("USUARIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 250, -1));

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 250, -1));

        btnEliminar.setText("ANULAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 250, -1));
        getContentPane().add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 150, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("CLIENTE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        getContentPane().add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 150, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("CANTIDAD");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 150, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("SUB TOTAL");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));
        getContentPane().add(txtTipoDePago, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 150, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("RUC");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 150, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("DIRECCION");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("TIPO DE PAGO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel10.setText("TIPO COMPROBANTE");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setText("TOTAL");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        getContentPane().add(cmbTipoComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 250, -1));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 150, -1));

        tblComprobantes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblComprobantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblComprobantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblComprobantes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 115, 850, 560));
        getContentPane().add(jdcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 150, -1));

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 250, -1));

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("COMPROBANTES");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 30));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/comprobar2.png"))); // NOI18N
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(0, 51, 51));
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 90, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(0, 51, 51));
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 90, -1));

        txtUsuario1.setEditable(false);
        txtUsuario1.setBackground(new java.awt.Color(0, 51, 51));
        txtUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, 140, -1));

        jLabel17.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel17.setText("COMPROBANTES");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 20, -1, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 70));

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 0));
        jLabel13.setText("DISCOTECK");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, -1, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel11.setText("DISCOTECK");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1012, 0, -1, -1));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("MISTER JUERGA");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, -1));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel18.setText("MISTER JUERGA");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 0, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, 1150, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

//        if (new Validaciones().validarCampoVacio(txtUsuario)) {
//            if (new Validaciones().validarCampoVacio(txtCliente)) {
//                if (new Validaciones().validarCampoVacio(txtCantidad)) {
//                    if (new Validaciones().validarCampoVacio(txtSubTotal)) {
//                        if (new Validaciones().validarCampoVacio(txtRuc)) {
//                            if (new Validaciones().validarCampoVacio(txtDireccion)) {
//                                if (new Validaciones().validarCampoVacio(txtTipoDePago)) {
//                                    if (new Validaciones().validarCampoVacio(txtTotal)) {
//                                        Date fecha = jdcFecha.getDate();
//                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                                        String f = sdf.format(fecha);
//                                        String Usuario = txtUsuario.getText();
//                                        String Cliente = txtCliente.getText();
//                                        int Cantidad = Integer.parseInt(txtCantidad.getText());
//                                        double SubTotal = Double.parseDouble(txtSubTotal.getText());
//                                        String Ruc = txtRuc.getText();
//                                        String Direccion = txtDireccion.getText();
//                                        String TipodePago = txtTipoDePago.getText();
//                                        double Total = Double.parseDouble(txtTotal.getText());
//                                        int TipoComprobante = Integer.parseInt(cmbTipoComprobante.getSelectedItem().toString());
//                                        try {
//                                            Comprobante c = new Comprobante(f, Usuario, Cliente, Cantidad, SubTotal, Ruc, Direccion, TipodePago, Total, TipoComprobante);
//                                            ComprobanteDAO dc = new ComprobanteDAO();
//                                            dc.Registrar(c);
//                                            new LlenarTabla().RefrescarTablaComprobante(tblComprobantes);
//                                        } catch (Exception e) {
//                                        }
//                                    } else {
//                                        JOptionPane.showMessageDialog(null, "INGRESE TOTAL");
//                                    }
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "INGRESE TIPO DE PAGO");
//                                }
//                            } else {
//                                JOptionPane.showMessageDialog(null, "INGRESE DIRECCION");
//                            }
//                        } else {
//                            JOptionPane.showMessageDialog(null, "INGRESE RUC");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "INGRESE SUBTOTAL");
//                    }
//
//                } else {
//                    JOptionPane.showMessageDialog(null, "INGRESE CANTIDAD");
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "INGRESE CLIENTE");
//            }
//
//        } else {
//            JOptionPane.showMessageDialog(null, "INGRESE USUARIO");
//        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Comprobante c = new Comprobante();
        int fila = tblComprobantes.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(rootPane, "SELECCIONE UN COMPROBANTE");
        } else {
            int id = Integer.parseInt(tblComprobantes.getValueAt(fila, 0).toString());
            c.setIdcomprobante(id);
            c.setFecha(jdcFecha.toString());
            c.setUsuario(txtUsuario.getText());
            c.setCliente(txtCliente.getText());

            ComprobanteDAO dc = new ComprobanteDAO();
            try {
                if (dc.Modificar(c)) {
                    new LlenarTabla().RefrescarTablaComprobante(tblComprobantes);

                    JOptionPane.showMessageDialog(rootPane, "SE ACTUALIZO EL REGISTRO");

                }

            } catch (Exception ex) {
                Logger.getLogger(Comprobante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        ComprobanteDAO dc = new ComprobanteDAO();
        Comprobante c = new Comprobante();
        int fila = tblComprobantes.getSelectedRow();
        int id = Integer.parseInt(tblComprobantes.getValueAt(fila, 0).toString());
        c.setIdcomprobante(id);
        try {
            dc.Anular(c);
            new LlenarTabla().RefrescarTablaComprobante(tblComprobantes);
        } catch (Exception ex) {
            Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblComprobantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprobantesMouseClicked
        try {
            int fila = tblComprobantes.getSelectedRow();
            int id = Integer.parseInt(tblComprobantes.getValueAt(fila, 0).toString());
            Object[] datos = (Object[]) new ComprobantesControl().getCamposConClic(id);
            String fecha = (String) datos[1];
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fec = sdf.parse(fecha);
            jdcFecha.setDate(fec);
            txtUsuario.setText((String) datos[2]);
            txtCliente.setText((String) datos[3]);
            txtCantidad.setText("" + datos[4]);
            txtSubTotal.setText("" + datos[5]);
            txtRuc.setText((String) datos[6]);
            txtDireccion.setText((String) datos[7]);
            txtTipoDePago.setText((String) datos[8]);
            txtTotal.setText("" + datos[9]);
            int idTipoComprobante = Integer.parseInt(tblComprobantes.getValueAt(fila, 10).toString());
            new ComprobantesControl().capturarDescripcionDeComboTipoComprobante(idTipoComprobante, cmbTipoComprobante);

//        try {
//            int fila = tblComprobantes.getSelectedRow();
//            String Fecha = tblComprobantes.getValueAt(fila, 1).toString();
//            String Usuario = tblComprobantes.getValueAt(fila, 2).toString();
//            String Cliente = tblComprobantes.getValueAt(fila, 3).toString();
//            String Cantidad = tblComprobantes.getValueAt(fila, 4).toString();
//            String Sub_Total = tblComprobantes.getValueAt(fila, 5).toString();
//            String Ruc = tblComprobantes.getValueAt(fila, 6).toString();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date dato = null;
//            dato = sdf.parse(Fecha);
//            jdcFecha.setDate(dato);
//            txtUsuario.setText(Usuario);
//            txtCliente.setText(Cliente);
//            txtCantidad.setText(Cantidad);
//            txtSubTotal.setText(Sub_Total);
//            txtDireccion.setText(Ruc);
//        } catch (ParseException ex) {
//            Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (Exception ex) {
            Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tblComprobantesMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        jdcFecha.setDate(null);
        txtUsuario.setText("");
        txtCliente.setText("");
        txtCantidad.setText("");
        txtSubTotal.setText("");
        txtRuc.setText("");
        txtDireccion.setText("");
        txtTipoDePago.setText("");
        txtTotal.setText("");
        tblComprobantes.clearSelection();
    }//GEN-LAST:event_btnNuevoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Comprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Comprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Comprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Comprobantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new Comprobantes().setVisible(true);
//                } catch (Exception ex) {
//                    Logger.getLogger(Comprobantes.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox cmbTipoComprobante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JTable tblComprobantes;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTipoDePago;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuario1;
    // End of variables declaration//GEN-END:variables
}
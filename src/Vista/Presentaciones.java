/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.InsumoControl;
import Controlador.MyiReportVisor;
import Controlador.PresentacionControl;
import Controlador.ProveedorControl;
import Controlador.Validaciones;
import Modelo.Insumo;
import Modelo.MySQLDAO.InsumoDAO;
import Modelo.Presentacion;
import Modelo.MySQLDAO.PresentacionDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo
 */
public class Presentaciones extends javax.swing.JInternalFrame {

    String[] Titulos = {"ID", "DESCRIPCION", "CODIGO"};
    MyiReportVisor mrv;

    public Presentaciones(String usuario) throws Exception {
        initComponents();
        txtDescripcion.requestFocus();
        txtUsuario1.setText(usuario);
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        new PresentacionControl().LlenarTablaPresentacion(tblPresentacion, Titulos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPresentacion = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtUsuario1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO DE PRESENTACIONES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPresentacion.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPresentacionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPresentacion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 460, 290));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        btnNuevo.setBorder(null);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, -1));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnRegistrar.setBorder(null);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 120, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnModificar.setBorder(null);
        btnModificar.setContentAreaFilled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 120, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(153, 0, 0))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("DESCRIPCION");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel3.setText("CODIGO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        jPanel2.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 190, -1));
        jPanel2.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 190, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 300, 100));

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imprimir.png"))); // NOI18N
        btnReporte.setBorder(null);
        btnReporte.setContentAreaFilled(false);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 130, 40));

        jPanel8.setBackground(new java.awt.Color(0, 51, 102));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("PRESENTACIONES");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/rgb.png"))); // NOI18N
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(0, 51, 102));
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 90, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(0, 51, 102));
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 90, -1));

        txtUsuario1.setEditable(false);
        txtUsuario1.setBackground(new java.awt.Color(0, 51, 102));
        txtUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 140, -1));

        jLabel24.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel24.setText("PRESENTACIONES");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 20, -1, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 70));

        jPanel6.setBackground(new java.awt.Color(0, 51, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 0));
        jLabel26.setText("DISCOTECK");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, -1, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel12.setText("DISCOTECK");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(732, 0, -1, -1));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("MISTER JUERGA");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, -1));

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel28.setText("MISTER JUERGA");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 0, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, 380, 870, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtDescripcion.setText("");
        txtCodigo.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtDescripcion.requestFocus();
        tblPresentacion.clearSelection();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (new Validaciones().validarCampoVacio(txtDescripcion)) {
            if (new Validaciones().validarCampoVacio(txtCodigo)) {
                String descripcion = txtDescripcion.getText();
                String codigo = txtCodigo.getText();
                try {
                    Presentacion p = new Presentacion();
                    PresentacionDAO pdao = new PresentacionDAO();
                    p.setDescripcion(descripcion);
                    p.setCodPresentacion(codigo);
                    if (pdao.Registrar(p) == true) {
                        JOptionPane.showMessageDialog(null, "PRESENTACION REGISTRADA");
                        new PresentacionControl().RefrescarTablaPresentacion(tblPresentacion, Titulos);
                        txtDescripcion.setText("");
                        txtCodigo.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, " FALLO EN REGISTRO");
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null, "INGRESE CODIGO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE DESCRIPCION");

        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Presentacion p = new Presentacion();
        int fila = tblPresentacion.getSelectedRow();
        if (new Validaciones().validarCampoVacio(txtDescripcion)) {
            if (new Validaciones().validarCampoVacio(txtCodigo)) {
                if (fila < 0) {
                    JOptionPane.showMessageDialog(rootPane, "SELECCIONE PRESENTACION");
                } else {
                    int id = Integer.parseInt(tblPresentacion.getValueAt(fila, 0).toString());
                    p.setIdPresentacion(id);
                    p.setDescripcion(txtDescripcion.getText());
                    p.setCodPresentacion(txtCodigo.getText());
                    PresentacionDAO idao = new PresentacionDAO();
                    try {
                        if (idao.Modificar(p)) {
                            new PresentacionControl().RefrescarTablaPresentacion(tblPresentacion, Titulos);
                            JOptionPane.showMessageDialog(rootPane, "PRESENTACION ACTUALIZADA");
                            txtDescripcion.setText("");
                            txtCodigo.setText("");
                            tblPresentacion.clearSelection();
                        }
                    } catch (Exception e) {
                        Logger.getLogger(Insumos.class.getName()).log(Level.SEVERE, null, e);
                    }
                } } else {
                JOptionPane.showMessageDialog(null, "INGRESE CODIGO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE DESCRIPCION");

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblPresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPresentacionMouseClicked
        try {
            int fila = tblPresentacion.getSelectedRow();
            int id = Integer.parseInt(tblPresentacion.getValueAt(fila, 0).toString());
            Object[] datos = (Object[]) new PresentacionControl().CapturarDatosPresentacion(id);
            txtDescripcion.setText("" + datos[1]);
            txtCodigo.setText("" + datos[2]);
            btnModificar.setEnabled(true);
            btnRegistrar.setEnabled(false);
            btnEliminar.setEnabled(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_tblPresentacionMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Presentacion p = new Presentacion();
        int fila = tblPresentacion.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(rootPane, "SELECCIONE PRESENTACION");
        } else {
            int id = Integer.parseInt(tblPresentacion.getValueAt(fila, 0).toString());
            p.setIdPresentacion(id);
            PresentacionDAO pdao = new PresentacionDAO();
            try {
                if (pdao.Eliminar(p)) {
                    new PresentacionControl().RefrescarTablaPresentacion(tblPresentacion, Titulos);
                    JOptionPane.showMessageDialog(rootPane, "PRESEMTACION ELIMINADO");
                    txtDescripcion.setText("");
                    txtCodigo.setText("");
                    tblPresentacion.clearSelection();
                }
            } catch (Exception e) {
                Logger.getLogger(Presentaciones.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        txtCodigo.requestFocus();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\PresentacionReport.jrxml");
        mrv.exportarAPdf();
    }//GEN-LAST:event_btnReporteActionPerformed

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
//            java.util.logging.Logger.getLogger(Presentaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Presentaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Presentaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Presentaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new Presentaciones().setVisible(true);
//                } catch (Exception ex) {
//                    Logger.getLogger(Presentaciones.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPresentacion;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtUsuario1;
    // End of variables declaration//GEN-END:variables
}

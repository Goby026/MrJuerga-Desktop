/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Cronometro;
import Controlador.ManejadorFechas;
import Controlador.MedidaControl;
import Controlador.MyiReportVisor;
import Controlador.PresentacionControl;
import Controlador.Validaciones;
import Modelo.Medida;
import Modelo.MySQLDAO.MedidaDAO;
import Modelo.Presentacion;
import Modelo.MySQLDAO.PresentacionDAO;
import java.awt.Color;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo
 */
public class Medidas extends javax.swing.JInternalFrame {

    String[] Titulos = {"ID", "DESCRIPCION"};
    HashMap parametros;
    MyiReportVisor mrv;

    public Medidas(String usuario) throws Exception {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        txtDescripcion.requestFocus();
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        new MedidaControl().LlenarTablaMedida(tblMedida, Titulos);
        new Cronometro().iniciarCronometro(txtHora);
        txtFecha.setText(new ManejadorFechas().getFechaActual());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMedida = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
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
        jLabel1 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("MEDIDAS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblMedida.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMedida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMedidaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMedida);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 490, 310));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-archivo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, 40));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/disquete.png"))); // NOI18N
        btnRegistrar.setText("GUARDAR");
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 150, 40));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/girar.png"))); // NOI18N
        btnModificar.setText("ACTUALIZAR");
        btnModificar.setContentAreaFilled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 150, 40));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 150, 40));

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        btnReporte.setText("IMPRIMIR");
        btnReporte.setContentAreaFilled(false);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 150, 40));

        jPanel8.setBackground(new java.awt.Color(204, 102, 0));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("MEDIDAS");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/medidas.png"))); // NOI18N
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        txtFecha.setBackground(new java.awt.Color(204, 102, 0));
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 90, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(204, 102, 0));
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 90, -1));

        txtUsuario1.setBackground(new java.awt.Color(204, 102, 0));
        txtUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 140, -1));

        jLabel24.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel24.setText("MEDIDAS");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 20, -1, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 70));

        jPanel6.setBackground(new java.awt.Color(204, 102, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 0));
        jLabel26.setText("DISCOTECK");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel12.setText("DISCOTECK");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(642, 0, -1, -1));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("MISTER JUERGA");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, -1, -1));

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel28.setText("MISTER JUERGA");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 0, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 780, 40));

        jLabel1.setText("DESCRIPCION");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        getContentPane().add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 400, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtDescripcion.setText("");
        txtDescripcion.requestFocus();
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        tblMedida.clearSelection();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (new Validaciones().validarCampoVacio(txtDescripcion)) {
            String descripcion = txtDescripcion.getText();
            try {
                Medida m = new Medida();
                MedidaDAO mdao = new MedidaDAO();
                m.setDescripcion(descripcion);
                if (mdao.Registrar(m) == true) {
                    JOptionPane.showMessageDialog(null, "MEDIDA REGISTRADA");
                    new MedidaControl().RefrescarTablaMedida(tblMedida, Titulos);
                    txtDescripcion.setText("");
                    txtDescripcion.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, " FALLO EN REGISTRO");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(null, "INGRESE MEDIDA");

        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Medida m = new Medida();
        int fila = tblMedida.getSelectedRow();
        if (new Validaciones().validarCampoVacio(txtDescripcion)) {
            if (fila < 0) {
                JOptionPane.showMessageDialog(rootPane, "SELECCIONE MEDIDA");
            } else {
                int id = Integer.parseInt(tblMedida.getValueAt(fila, 0).toString());
                m.setIdmedida(id);
                m.setDescripcion(txtDescripcion.getText());
                MedidaDAO mdao = new MedidaDAO();
                try {
                    if (mdao.Modificar(m)) {
                        new MedidaControl().RefrescarTablaMedida(tblMedida, Titulos);
                        JOptionPane.showMessageDialog(rootPane, "MEDIDA ACTUALIZADA");
                        txtDescripcion.setText("");
                        tblMedida.clearSelection();
                    }
                } catch (Exception e) {
                    Logger.getLogger(Insumos.class.getName()).log(Level.SEVERE, null, e);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "INGRESE MEDIDA");

        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Medida m = new Medida();
        int fila = tblMedida.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(rootPane, "SELECCIONE MEDIDA");
        } else {
            int id = Integer.parseInt(tblMedida.getValueAt(fila, 0).toString());
            m.setIdmedida(id);
            MedidaDAO mdao = new MedidaDAO();
            try {
                if (mdao.Eliminar(m)) {
                    new MedidaControl().RefrescarTablaMedida(tblMedida, Titulos);
                    JOptionPane.showMessageDialog(rootPane, "PRESEMTACION ELIMINADO");
                    txtDescripcion.setText("");
                    tblMedida.clearSelection();
                }
            } catch (Exception e) {
                Logger.getLogger(Medidas.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed

    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void tblMedidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMedidaMouseClicked
        try {
            int fila = tblMedida.getSelectedRow();
            int id = Integer.parseInt(tblMedida.getValueAt(fila, 0).toString());
            Object[] datos = (Object[]) new MedidaControl().CapturarDatosMedida(id);
            txtDescripcion.setText("" + datos[1]);
            btnModificar.setEnabled(true);
            btnRegistrar.setEnabled(false);
            btnEliminar.setEnabled(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_tblMedidaMouseClicked

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\MedidaReport.jrxml", parametros);
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
//            java.util.logging.Logger.getLogger(Medidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Medidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Medidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Medidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new Medidas().setVisible(true);
//                } catch (Exception ex) {
//                    Logger.getLogger(Medidas.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMedida;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtUsuario1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.PagonPersonalControl;
import Controlador.Validaciones;
import Modelo.UsuarioGastos;
import Modelo.UsuarioGastosDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marce
 */
public class PagosPersonal extends javax.swing.JInternalFrame {

    //DefaultTableModel modeloPersonal;
    public PagosPersonal() throws Exception {
        initComponents();
        new PagonPersonalControl().titulosTabla(tblPersonal);
        new PagonPersonalControl().cargarComboConcepto(cmbConcepto);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonal = new javax.swing.JTable();
        txtPersonal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPago = new javax.swing.JTextField();
        btnRealizarPago = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbConcepto = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("CONCEPTO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        tblPersonal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPersonal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 530, 130));

        txtPersonal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 260, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("PAGO S/.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        txtPago.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        txtPago.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 170, -1));

        btnRealizarPago.setText("REALIZAR PAGO");
        btnRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPagoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRealizarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 280, 30));

        lblFoto.setText("FOTO");
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 140, 110));

        jButton2.setText("BUSCAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));

        jLabel3.setText("DNI PERSONAL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        getContentPane().add(cmbConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!new Validaciones().validarCampoVacio(txtPago)) {
            try {
                String dni = txtPersonal.getText();
                PagonPersonalControl ppc = new PagonPersonalControl();
                ppc.tablaPersonal(dni, tblPersonal);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "INGRESE NOMBRE DE PERSONAL");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPagoActionPerformed
        try {
            if (!new Validaciones().validarCampoVacio(txtPersonal)) {
                if (!new Validaciones().validarCampoVacio(txtPago)) {
                    int fila = tblPersonal.getSelectedRow();
                    int idUsuario = Integer.parseInt(tblPersonal.getValueAt(fila, 0).toString());
                    int idGasto = new PagonPersonalControl().getIdGasto(cmbConcepto.getSelectedItem().toString());
                    double monto = Double.parseDouble(txtPago.getText());
                    UsuarioGastos ug = new UsuarioGastos();
                    ug.setIdUsuario(idUsuario);
                    ug.setIdGastos(idGasto);
                    ug.setMonto(monto);
                    UsuarioGastosDAO ugdao = new UsuarioGastosDAO();
                    if (ugdao.registrar(ug)) {
                        JOptionPane.showMessageDialog(rootPane, "PAGO REGISTRADO");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "INGRESE MONTO DE PAGO");
                    txtPago.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "INGRESE DNI DE PERSONAL");
                txtPersonal.requestFocus();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnRealizarPagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRealizarPago;
    private javax.swing.JComboBox<String> cmbConcepto;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JTable tblPersonal;
    private javax.swing.JTextField txtPago;
    private javax.swing.JTextField txtPersonal;
    // End of variables declaration//GEN-END:variables
}
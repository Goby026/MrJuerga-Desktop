package Vista;

import Controlador.LoginControl;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author G0by
 */
public class Login extends javax.swing.JFrame {

    /*NOTA: Estoy en la laptop de ammy y acabo de sanear todo el proyecto
    sin embargo no puedo hacer las pruebas de acceso a datos por q el drive de la empresa
    no quiere descargar el script sql para restaurar la base de datos.
    PDTA: Estoy probando las ramas en GITHUB
     */
    public Login() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        Color c = new Color(0, 0, 1, 0.015f);
        this.setBackground(c);
        logo();
    }

    public void logo() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        setIconImage(tk.getImage(getClass().getResource("/img/party1.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lblImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(43, 46, 55));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ideas en software S.A.C.");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 1140, 30));

        jPanel1.setBackground(new java.awt.Color(16, 97, 154));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("MR JUERGA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 70));

        btnCancelar.setBackground(new java.awt.Color(200, 79, 62));
        btnCancelar.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        btnCancelar.setBorder(null);
        btnCancelar.setBorderPainted(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 170, 40));

        jLabel9.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("sistema de apoyo para el control de almacen");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 440, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 70));

        jPanel3.setBackground(new java.awt.Color(43, 46, 55));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setBackground(new java.awt.Color(43, 46, 55));
        txtUsuario.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 20)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtUsuario.setOpaque(false);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel3.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 5, 220, 40));

        txtPass.setBackground(new java.awt.Color(43, 46, 55));
        txtPass.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 20)); // NOI18N
        txtPass.setForeground(new java.awt.Color(204, 255, 255));
        txtPass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPass.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        txtPass.setOpaque(false);
        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });
        jPanel3.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 5, 230, 40));

        btnIniciar.setBackground(new java.awt.Color(84, 142, 215));
        btnIniciar.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("LOGIN");
        btnIniciar.setBorder(null);
        btnIniciar.setBorderPainted(false);
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.setFocusPainted(false);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        jPanel3.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 5, 170, 40));

        jLabel11.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("iniciar sesión");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 5, 120, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1140, 50));

        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admini.jpg"))); // NOI18N
        getContentPane().add(lblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1140, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        try {
            String usu = txtUsuario.getText().toUpperCase();
            String pass = String.valueOf(txtPass.getPassword()).toUpperCase();
            if (new LoginControl().validar(usu, pass)) {
                Menu m = new Menu(usu);
                m.setVisible(true);
                dispose();
            } else {
                if (new LoginControl().verificarRegistroUsuario() > 0) {
                    JOptionPane.showMessageDialog(rootPane, "ERROR DE DATOS, INTENTALO DENUEVO");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "VEO QUE ES LA PRIMERA VEZ QUE INGRESAS A MRJUERGA SYSTEM. POR FAVOR CONFIGURA LOS SIGUIENTES PARÁMETROS");
                    new ConfiguracionInicial().setVisible(true);
                    dispose();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        btnIniciar.doClick();
    }//GEN-LAST:event_txtPassActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtPass.requestFocus();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblImg;
    public javax.swing.JPasswordField txtPass;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

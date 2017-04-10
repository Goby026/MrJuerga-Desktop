/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.FormatoFechas;
import Controlador.GastoControl;
import Controlador.MyiReportVisor;
import Controlador.ProveedorControl;
import Controlador.Validaciones;
import Modelo.Gasto;
import Modelo.MySQLDAO.GastoDAO;
import Modelo.Proveedor;
import Modelo.MySQLDAO.ProveedorDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo
 */
public class Proveedores extends javax.swing.JInternalFrame {

    String[] Titulos = {"ID", "RAZON", "RUC", "DIRECCION", "CIUDAD", "TELF", "EMAIL", "COD.PROV."};
    MyiReportVisor mrv;
    
    
    public Proveedores(String usuario) throws Exception {
        initComponents();
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtUsuario1.setText(usuario);
        new ProveedorControl().LlenarTablaProveedor(tblProveedores, Titulos);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtRazon = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCodPostal = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtUsuario1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO DE PROVEEDORES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("DIRECCION");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 20));

        jLabel3.setText("RAZON");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 20));

        jLabel5.setText("CIUDAD");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 20));

        jLabel6.setText("TEFEFONO");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 20));

        jLabel7.setText("COD. POSTAL");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 20));

        jLabel8.setText("CORREO");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 20));

        jLabel10.setText("CODIGO");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 20));

        txtRazon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonActionPerformed(evt);
            }
        });
        txtRazon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonKeyTyped(evt);
            }
        });
        jPanel2.add(txtRazon, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 200, -1));

        txtRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRucActionPerformed(evt);
            }
        });
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });
        jPanel2.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 200, -1));

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 200, -1));

        jLabel11.setText("RUC");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 20));

        txtCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadActionPerformed(evt);
            }
        });
        txtCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCiudadKeyTyped(evt);
            }
        });
        jPanel2.add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 200, -1));

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 200, -1));

        txtCodPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodPostalActionPerformed(evt);
            }
        });
        txtCodPostal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodPostalKeyTyped(evt);
            }
        });
        jPanel2.add(txtCodPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 200, -1));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 200, -1));
        jPanel2.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 200, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 390, 290));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        btnNuevo.setBorder(null);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 120, 40));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnRegistrar.setBorder(null);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 120, -1));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 120, 40));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setBorder(null);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, -1, -1));

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imprimir.png"))); // NOI18N
        btnReporte.setBorder(null);
        btnReporte.setContentAreaFilled(false);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, -1, -1));

        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 780, -1));

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("PROVEEDORES");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 30));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/scooter.png"))); // NOI18N
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(0, 51, 51));
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 20, 90, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(0, 51, 51));
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 20, 90, -1));

        txtUsuario1.setEditable(false);
        txtUsuario1.setBackground(new java.awt.Color(0, 51, 51));
        txtUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 140, -1));

        jLabel17.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel17.setText("PROVEEDORES");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 20, -1, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 70));

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 0));
        jLabel13.setText("DISCOTECK");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, -1, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel12.setText("DISCOTECK");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1012, 0, -1, -1));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("MISTER JUERGA");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, -1, -1));

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel18.setText("MISTER JUERGA");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 0, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 1220, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRazonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonKeyTyped
        Validaciones v = new Validaciones();
        v.validarCampoNumerico(evt, txtRazon);
    }//GEN-LAST:event_txtRazonKeyTyped

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        Validaciones v = new Validaciones();
        v.validarCampoStringRuc(evt, txtRuc);
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiudadKeyTyped
        Validaciones v = new Validaciones();
        v.validarCampoNumerico(evt, txtCiudad);
    }//GEN-LAST:event_txtCiudadKeyTyped

    private void txtCodPostalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodPostalKeyTyped
        Validaciones v = new Validaciones();
        v.validarCampoString(evt, txtCodPostal);
    }//GEN-LAST:event_txtCodPostalKeyTyped

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtRazon.setText("");
        txtRuc.setText("");
        txtDireccion.setText("");
        txtCiudad.setText("");
        txtCodPostal.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtCodigo.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtRazon.requestFocus();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (new Validaciones().validarCampoVacio(txtRazon)) {
            if (new Validaciones().validarCampoVacio(txtRuc)) {
                if (new Validaciones().validarCampoVacio(txtDireccion)) {
                    if (new Validaciones().validarCampoVacio(txtCiudad)) {
                        if (new Validaciones().validarCampoVacio(txtTelefono)) {
                            if (new Validaciones().validarCampoVacio(txtCodPostal)) {
                                if (new Validaciones().validarCampoVacio(txtCorreo)) {
                                    if (new Validaciones().validarCampoVacio(txtCodigo)) {
                                        String razon = txtRazon.getText();
                                        String ruc = txtRuc.getText();
                                        String direccion = txtDireccion.getText();
                                        String ciudad = txtCiudad.getText();
                                        String telf = txtTelefono.getText();
                                        String pos = txtCodPostal.getText();
                                        String correo = txtCorreo.getText();
                                        String codigo = txtCodigo.getText();
                                        try {
                                            Proveedor p = new Proveedor();
                                            ProveedorDAO pdao = new ProveedorDAO();
                                            p.setRazon(razon);
                                            p.setRuc(ruc);
                                            p.setDireccion(direccion);
                                            p.setCiudad(ciudad);
                                            p.setTelf_prov(telf);
                                            p.setCod_pos(pos);
                                            p.setCorreo(correo);
                                            p.setCodProv(codigo);
                                            if (pdao.Registrar(p) == true) {
                                                JOptionPane.showMessageDialog(null, "PROVEEDOR REGISTRADO");
                                                new ProveedorControl().RefrescarTablaProveedor(tblProveedores, Titulos);
                                                txtRazon.setText("");
                                                txtRuc.setText("");
                                                txtDireccion.setText("");
                                                txtCiudad.setText("");
                                                txtCodPostal.setText("");
                                                txtTelefono.setText("");
                                                txtCorreo.setText("");
                                                txtCodigo.setText("");
                                                txtRazon.requestFocus();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "FALLO EN REGISTRO");
                                            }

                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }

                                    } else {
                                        JOptionPane.showMessageDialog(null, "INGRESE CODIGO");
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "INGRESE CORREO");
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "INGRESE COD.POSTAL");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "INGRESE TELEFONO");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "INGRESE CIUDAD");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "INGRESE DIRECCION");
                }

            } else {
                JOptionPane.showMessageDialog(null, "INGRESE RUC");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE RAZON");

        }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRucActionPerformed
        txtDireccion.requestFocus();
    }//GEN-LAST:event_txtRucActionPerformed

    private void tblProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedoresMouseClicked
        try {
            int fila = tblProveedores.getSelectedRow();
            int id = Integer.parseInt(tblProveedores.getValueAt(fila, 0).toString());
            Object[] datos = (Object[]) new ProveedorControl().CapturarDatosProveedor(id);
            txtRazon.setText((String) datos[0]);
            txtRuc.setText((String) datos[1]);
            txtDireccion.setText((String) datos[2]);
            txtCiudad.setText((String) datos[3]);
            txtTelefono.setText((String) datos[4]);
            txtCodPostal.setText((String) datos[5]);
            txtCorreo.setText((String) datos[6]);
            txtCodigo.setText((String) datos[7]);
            btnModificar.setEnabled(true);
            btnRegistrar.setEnabled(false);
            btnEliminar.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblProveedoresMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (new Validaciones().validarCampoVacio(txtRazon)) {
            if (new Validaciones().validarCampoVacio(txtRuc)) {
                if (new Validaciones().validarCampoVacio(txtDireccion)) {
                    if (new Validaciones().validarCampoVacio(txtCiudad)) {
                        if (new Validaciones().validarCampoVacio(txtTelefono)) {
                            if (new Validaciones().validarCampoVacio(txtCodPostal)) {
                                if (new Validaciones().validarCampoVacio(txtCorreo)) {
                                    if (new Validaciones().validarCampoVacio(txtCodigo)) {
                                        String razon = txtRazon.getText();
                                        String ruc = txtRuc.getText();
                                        String direccion = txtDireccion.getText();
                                        String ciudad = txtCiudad.getText();
                                        String telefono = txtTelefono.getText();
                                        String codpos = txtCodPostal.getText();
                                        String correo = txtCorreo.getText();
                                        String codigo = txtCodigo.getText();
                                        int fila = tblProveedores.getSelectedRow();
                                        int id = Integer.parseInt(tblProveedores.getValueAt(fila, 0).toString());
                                        try {
                                            Proveedor p = new Proveedor();
                                            ProveedorDAO pdao = new ProveedorDAO();
                                            p.setRazon(razon);
                                            p.setRuc(ruc);
                                            p.setDireccion(direccion);
                                            p.setCiudad(ciudad);
                                            p.setTelf_prov(telefono);
                                            p.setCod_pos(codpos);
                                            p.setCorreo(correo);
                                            p.setCodProv(codigo);
                                            p.setIdProveedor(id);
                                            if (pdao.Modificar(p) == true) {
                                                JOptionPane.showMessageDialog(null, "PROVEEDOR ACTUALIZADO");
                                                new ProveedorControl().RefrescarTablaProveedor(tblProveedores, Titulos);
                                                txtRazon.setText("");
                                                txtRuc.setText("");
                                                txtDireccion.setText("");
                                                txtCiudad.setText("");
                                                txtCodPostal.setText("");
                                                txtTelefono.setText("");
                                                txtCorreo.setText("");
                                                txtCodigo.setText("");
                                                txtRazon.requestFocus();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "FALLO EN REGISTRO");
                                            }

                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "INGRESE CODIGO");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "INGRESE CORREO");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "INGRESE CODIGO POSTAL");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "INGRESE TELEFONO");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "INGRESE CIUDAD");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "INGRESE DIRECCION");
                }

            } else {
                JOptionPane.showMessageDialog(null, "INGRESE RUC");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE RAZON");

        }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Proveedor p = new Proveedor();
        int fila = tblProveedores.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(rootPane, "SELECCIONE PROVEEDOR");
        } else {
            int id = Integer.parseInt(tblProveedores.getValueAt(fila, 0).toString());
            p.setIdProveedor(id);
            ProveedorDAO pdao = new ProveedorDAO();
            try {
                if (pdao.Eliminar(p)) {
                    new ProveedorControl().RefrescarTablaProveedor(tblProveedores, Titulos);
                    JOptionPane.showMessageDialog(rootPane, "PROVEEDOR ELIMINADO");
                    txtRazon.setText("");
                    txtRuc.setText("");
                    txtDireccion.setText("");
                    txtCiudad.setText("");
                    txtCodPostal.setText("");
                    txtTelefono.setText("");
                    txtCorreo.setText("");
                    txtCodigo.setText("");
                }
            } catch (Exception e) {
                Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        mrv = new MyiReportVisor(System.getProperty("user.dir")+"\\reportes\\ProveedorReport.jrxml");
        mrv.exportarAPdf();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtRazonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonActionPerformed
       txtRuc.requestFocus();
    }//GEN-LAST:event_txtRazonActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        txtCiudad.requestFocus();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadActionPerformed
       txtTelefono.requestFocus();
    }//GEN-LAST:event_txtCiudadActionPerformed

    private void txtCodPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodPostalActionPerformed
        txtCorreo.requestFocus();
    }//GEN-LAST:event_txtCodPostalActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
      txtCodPostal.requestFocus();
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
       txtCodigo.requestFocus();
    }//GEN-LAST:event_txtCorreoActionPerformed

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
//            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new Proveedores().setVisible(true);
//                } catch (Exception ex) {
//                    Logger.getLogger(Proveedores.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodPostal;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtRazon;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario1;
    // End of variables declaration//GEN-END:variables
}

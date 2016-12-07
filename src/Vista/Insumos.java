/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Cronometro;
import Controlador.InsumoControl;
import Controlador.ManejadorFechas;
import Controlador.MyiReportVisor;
import Controlador.Validaciones;
import Modelo.Insumo;
import Modelo.InsumoDAO;
import java.awt.Color;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Gaby
 */
public class Insumos extends javax.swing.JInternalFrame {

    String[] Titulos = {"ID", "NOMBRE", "EXISTENCIAS"};
    HashMap parametros;
    MyiReportVisor mrv;

    public Insumos(String usuario) throws Exception {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        new Cronometro().iniciarCronometro(txtHora);
        txtFecha.setText(new ManejadorFechas().getFechaActual());
        txtUsuario1.setText(usuario);
        txtNombre.requestFocus();
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        new InsumoControl().LlenarTablaInsumo(tblInsumos, Titulos);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btnImprimirListaInsumos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInsumos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtExistencias = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cmbProducto = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnPreparar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPreparacion = new javax.swing.JTable();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        cmbUnidad = new javax.swing.JComboBox<>();
        cmbInsumo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtCostoPreparacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
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
        setIconifiable(true);
        setMaximizable(true);
        setTitle("INSUMOS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnImprimirListaInsumos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        btnImprimirListaInsumos.setText("IMPRIMIR");
        btnImprimirListaInsumos.setBorderPainted(false);
        btnImprimirListaInsumos.setContentAreaFilled(false);
        jPanel1.add(btnImprimirListaInsumos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, -1, -1));

        tblInsumos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblInsumos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInsumosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInsumos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 500, 240));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-archivo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 120, 40));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/disquete.png"))); // NOI18N
        btnRegistrar.setText("GUARDAR");
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 120, 40));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/girar.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 130, 40));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 120, 40));

        jLabel1.setText("NOMBRE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 300, -1));

        jLabel2.setText("EXISTENCIAS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        txtExistencias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtExistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 80, -1));

        jTabbedPane1.addTab("LISTA INSUMOS", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cmbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 210, -1));

        jLabel3.setText("PRODUCTO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("PREPARACION"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CANTIDAD");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 80, 20));

        jPanel5.setBackground(new java.awt.Color(51, 153, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("INSUMO");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, -1, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 180, 20));

        jPanel7.setBackground(new java.awt.Color(51, 153, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("UNIDAD");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 140, 20));

        btnPreparar.setBackground(new java.awt.Color(0, 153, 0));
        btnPreparar.setForeground(new java.awt.Color(255, 255, 255));
        btnPreparar.setText("PREPARAR");
        jPanel3.add(btnPreparar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 420, -1));

        tblPreparacion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblPreparacion);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 420, 250));

        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 80, -1));

        btnAgregar.setText("AGREGAR +");
        jPanel3.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        cmbUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 140, -1));

        cmbInsumo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cmbInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 180, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 480, 410));

        jLabel7.setText("COSTO PREPARACION");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        txtCostoPreparacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtCostoPreparacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 80, -1));

        jLabel4.setText("PRECIO VENTA");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        txtPrecioVenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 80, -1));

        jTabbedPane1.addTab("PREPARACIONES", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 750, 470));

        jPanel8.setBackground(new java.awt.Color(0, 102, 102));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("INSUMOS");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/equilibrar.png"))); // NOI18N
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(0, 102, 102));
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 90, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(0, 102, 102));
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 90, -1));

        txtUsuario1.setEditable(false);
        txtUsuario1.setBackground(new java.awt.Color(0, 102, 102));
        txtUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 140, -1));

        jLabel24.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel24.setText("INSUMOS");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 20, -1, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 70));

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
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

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 780, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Insumo i = new Insumo();
        int fila = tblInsumos.getSelectedRow();
        if (new Validaciones().validarCampoVacio(txtNombre)) {
            if (new Validaciones().validarCampoVacio(txtExistencias)) {
                if (fila < 0) {
                    JOptionPane.showMessageDialog(rootPane, "SELECCIONE INSUMO");
                } else {
                    int id = Integer.parseInt(tblInsumos.getValueAt(fila, 0).toString());
                    i.setIdinsumo(id);
                    i.setNombre(txtNombre.getText());
                    i.setExistencias(Double.parseDouble(txtExistencias.getText()));
                    InsumoDAO idao = new InsumoDAO();
                    try {
                        if (idao.Modificar(i)) {
                            new InsumoControl().RefrescarTablaInsumo(tblInsumos, Titulos);
                            JOptionPane.showMessageDialog(rootPane, "INSUMO ACTUALIZADO");
                            txtNombre.setText("");
                            txtExistencias.setText("");
                            txtNombre.requestFocus();
                            tblInsumos.clearSelection();
                        }
                    } catch (Exception e) {
                        Logger.getLogger(Insumos.class.getName()).log(Level.SEVERE, null, e);
                    }
                }} else {
                JOptionPane.showMessageDialog(null, "INGRESE EXISTENCIAS");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE NOMBRE");

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtNombre.setText("");
        txtExistencias.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtNombre.requestFocus();
        tblInsumos.clearSelection();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (new Validaciones().validarCampoVacio(txtNombre)) {
            if (new Validaciones().validarCampoVacio(txtExistencias)) {
                String nombre = txtNombre.getText();
                double existencias = Double.parseDouble(txtExistencias.getText());
                try {
                    Insumo i = new Insumo();
                    InsumoDAO idao = new InsumoDAO();
                    i.setNombre(nombre);
                    i.setExistencias(existencias);
                    if (idao.Registrar(i) == true) {
                        JOptionPane.showMessageDialog(null, "INSUMO REGISTRADO");
                        new InsumoControl().RefrescarTablaInsumo(tblInsumos, Titulos);
                        txtNombre.setText("");
                        txtExistencias.setText("");
                        txtNombre.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, " FALLO EN REGISTRO");
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null, "INGRESE EXISTENCIAS");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE NOMBRE");

        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tblInsumosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInsumosMouseClicked
        try {
            int fila = tblInsumos.getSelectedRow();
            int id = Integer.parseInt(tblInsumos.getValueAt(fila, 0).toString());
            Object[] datos = (Object[]) new InsumoControl().CapturarDatosInsumo(id);
            txtNombre.setText((String) datos[0]);
            txtExistencias.setText("" + datos[1]);
            btnModificar.setEnabled(true);
            btnRegistrar.setEnabled(false);
            btnEliminar.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(Insumos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblInsumosMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Insumo i = new Insumo();
        int fila = tblInsumos.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(rootPane, "SELECCIONE INSUMO");
        } else {
            int id = Integer.parseInt(tblInsumos.getValueAt(fila, 0).toString());
            i.setIdinsumo(id);
            InsumoDAO idao = new InsumoDAO();
            try {
                if (idao.Eliminar(i)) {
                    new InsumoControl().RefrescarTablaInsumo(tblInsumos, Titulos);
                    JOptionPane.showMessageDialog(rootPane, "INSUMO ELIMINADO");
                    txtNombre.setText("");
                    txtExistencias.setText("");
                    txtNombre.requestFocus();
                    tblInsumos.clearSelection();
                }
            } catch (Exception e) {
                Logger.getLogger(Insumos.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        txtExistencias.requestFocus();
    }//GEN-LAST:event_txtNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimirListaInsumos;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPreparar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbInsumo;
    private javax.swing.JComboBox cmbProducto;
    private javax.swing.JComboBox<String> cmbUnidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblInsumos;
    private javax.swing.JTable tblPreparacion;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCostoPreparacion;
    private javax.swing.JTextField txtExistencias;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtUsuario1;
    // End of variables declaration//GEN-END:variables
}
package Vista;

import Controlador.ColumnasTablas;
import Modelo.Conexion;
import Modelo.MySQLDAO.PreparacionDAO;
import Modelo.MySQLDAO.ProductoPresentacionDAO;
import Modelo.ProductoPresentacion;
import Modelo.Preparacion;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grover
 */
public class CartaBebidas extends javax.swing.JInternalFrame {

    DefaultTableModel modeloBuscarProductos;
    DefaultTableModel modeloBuscarProductoPresentacion;
    DefaultTableModel modeloPreparaciones;

    public CartaBebidas() {
        initComponents();

        titulosPreparaciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProductos = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBuscarProductos = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtFiltroProducto = new javax.swing.JTextField();
        btnSeleccionarProducto = new javax.swing.JButton();
        panelProductoPresentacion = new javax.swing.JDialog();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblBuscarProductoPresentacion = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtFiltroProductoPresentacion = new javax.swing.JTextField();
        btnSeleccionarProductoPresentacion = new javax.swing.JButton();
        lblCodProducto = new javax.swing.JLabel();
        btnPreparar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPreparacion = new javax.swing.JTable();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBebida = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnProductoBase = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtComponente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblProductoPresentacion = new javax.swing.JLabel();

        tblBuscarProductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblBuscarProductos.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        tblBuscarProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBuscarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscarProductosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblBuscarProductos);

        panelProductos.getContentPane().add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel8.setText("PRODUCTO");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 30));

        txtFiltroProducto.setBackground(new java.awt.Color(204, 204, 204));
        txtFiltroProducto.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        txtFiltroProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFiltroProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroProductoKeyReleased(evt);
            }
        });
        jPanel8.add(txtFiltroProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 250, -1));

        panelProductos.getContentPane().add(jPanel8, java.awt.BorderLayout.NORTH);

        btnSeleccionarProducto.setBackground(new java.awt.Color(153, 255, 153));
        btnSeleccionarProducto.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        btnSeleccionarProducto.setText("seleccionar");
        btnSeleccionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProductoActionPerformed(evt);
            }
        });
        panelProductos.getContentPane().add(btnSeleccionarProducto, java.awt.BorderLayout.PAGE_END);

        tblBuscarProductoPresentacion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblBuscarProductoPresentacion.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        tblBuscarProductoPresentacion.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBuscarProductoPresentacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscarProductoPresentacionMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblBuscarProductoPresentacion);

        panelProductoPresentacion.getContentPane().add(jScrollPane5, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel10.setText("PRODUCTO");
        jPanel9.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 140, 30));

        txtFiltroProductoPresentacion.setBackground(new java.awt.Color(204, 204, 204));
        txtFiltroProductoPresentacion.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        txtFiltroProductoPresentacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFiltroProductoPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroProductoPresentacionKeyReleased(evt);
            }
        });
        jPanel9.add(txtFiltroProductoPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 250, -1));

        panelProductoPresentacion.getContentPane().add(jPanel9, java.awt.BorderLayout.NORTH);

        btnSeleccionarProductoPresentacion.setBackground(new java.awt.Color(153, 255, 153));
        btnSeleccionarProductoPresentacion.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        btnSeleccionarProductoPresentacion.setText("seleccionar");
        btnSeleccionarProductoPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProductoPresentacionActionPerformed(evt);
            }
        });
        panelProductoPresentacion.getContentPane().add(btnSeleccionarProductoPresentacion, java.awt.BorderLayout.PAGE_END);

        setClosable(true);
        setTitle("RECETAS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCodProducto.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 14)); // NOI18N
        lblCodProducto.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(lblCodProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 80, 20));

        btnPreparar.setBackground(new java.awt.Color(0, 153, 0));
        btnPreparar.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        btnPreparar.setForeground(new java.awt.Color(255, 255, 255));
        btnPreparar.setText("GUARDAR RECETA");
        btnPreparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrepararActionPerformed(evt);
            }
        });
        getContentPane().add(btnPreparar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 190, 30));

        tblPreparacion = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
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

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 440, 220));

        txtCantidad.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 100, -1));

        btnAgregar.setBackground(new java.awt.Color(153, 255, 153));
        btnAgregar.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        btnAgregar.setText("AGREGAR +");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, 40));

        jLabel5.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("NOMBRE DE PRODUCTO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnQuitar.setBackground(new java.awt.Color(204, 0, 0));
        btnQuitar.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Trash_16px.png"))); // NOI18N
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 40, 30));

        btnBuscar.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 40, 30));

        txtBebida.setEditable(false);
        txtBebida.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        getContentPane().add(txtBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 400, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 440, 10));

        btnProductoBase.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        btnProductoBase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find.png"))); // NOI18N
        btnProductoBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductoBaseActionPerformed(evt);
            }
        });
        getContentPane().add(btnProductoBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 40, 30));

        jLabel16.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("COMPONENTE");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtComponente.setEditable(false);
        txtComponente.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        txtComponente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtComponente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 400, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("CANTIDAD ML");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 110, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("COD:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 30, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("COD:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 30, -1));

        lblProductoPresentacion.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 14)); // NOI18N
        lblProductoPresentacion.setForeground(new java.awt.Color(51, 51, 51));
        getContentPane().add(lblProductoPresentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 80, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        panelProductos.setBounds(300, 300, 512, 560);
        panelProductos.setVisible(true);

        try {
            LlenarTablaBuscarProductos("");
        } catch (Exception ex) {
            Logger.getLogger(CartaBebidas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtFiltroProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroProductoKeyReleased
        try {
            LlenarTablaBuscarProductos(txtFiltroProducto.getText());
        } catch (Exception ex) {
            Logger.getLogger(CartaBebidas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroProductoKeyReleased

    private void txtFiltroProductoPresentacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroProductoPresentacionKeyReleased
        try {
            LlenarTablaBuscarProductoPresentacion(txtFiltroProductoPresentacion.getText());
        } catch (Exception ex) {
            Logger.getLogger(CartaBebidas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFiltroProductoPresentacionKeyReleased

    private void btnSeleccionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProductoActionPerformed
        LimpiarTabla(tblPreparacion, modeloPreparaciones);
        int fila = tblBuscarProductos.getSelectedRow();
        try {
            if (fila >= 0) {
                int idProducto = Integer.parseInt(tblBuscarProductos.getValueAt(fila, 0).toString());
                PreparacionDAO pdao = new PreparacionDAO();

                if (pdao.Listar(idProducto).size() > 0) {
                    //cargar tabla de preparacion
                    txtBebida.setText(tblBuscarProductos.getValueAt(fila, 1).toString());
                    lblCodProducto.setText(tblBuscarProductos.getValueAt(fila, 0).toString());                    
                    cargarPreparacion(idProducto);                    
                    btnPreparar.setText("MODIFICAR");
                    btnPreparar.setBackground(Color.ORANGE);
                    panelProductos.dispose();
                } else {
                    LimpiarTabla(tblPreparacion, modeloPreparaciones);
                    txtBebida.setText(tblBuscarProductos.getValueAt(fila, 1).toString());
                    lblCodProducto.setText(tblBuscarProductos.getValueAt(fila, 0).toString());
                    btnPreparar.setText("GUARDAR RECETA");
                    btnPreparar.setBackground(new Color(0, 153, 0));
                    panelProductos.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(getRootPane(), "SELECCIONE UN PRODUCTO");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnSeleccionarProductoActionPerformed

    private void tblBuscarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscarProductosMouseClicked
        if (evt.getClickCount() == 2) {
            btnSeleccionarProducto.doClick();
        }
    }//GEN-LAST:event_tblBuscarProductosMouseClicked

    private void btnProductoBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductoBaseActionPerformed
        panelProductoPresentacion.setBounds(300, 300, 512, 560);
        panelProductoPresentacion.setVisible(true);

        try {
            LlenarTablaBuscarProductoPresentacion("");
        } catch (Exception ex) {
            Logger.getLogger(CartaBebidas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProductoBaseActionPerformed

    private void btnSeleccionarProductoPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProductoPresentacionActionPerformed
        int fila = tblBuscarProductoPresentacion.getSelectedRow();
        try {
            if (fila >= 0) {
                txtComponente.setText(tblBuscarProductoPresentacion.getValueAt(fila, 1).toString());
                lblProductoPresentacion.setText(tblBuscarProductoPresentacion.getValueAt(fila, 0).toString());
                panelProductoPresentacion.dispose();
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "SELECCIONE UN PRODUCTO");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnSeleccionarProductoPresentacionActionPerformed

    private void tblBuscarProductoPresentacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscarProductoPresentacionMouseClicked
        if (evt.getClickCount() == 2) {
            btnSeleccionarProductoPresentacion.doClick();
        }
    }//GEN-LAST:event_tblBuscarProductoPresentacionMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!txtBebida.getText().trim().isEmpty()) {
            if (!txtComponente.getText().trim().isEmpty()) {
                if (!txtCantidad.getText().trim().isEmpty()) {
                    String datos[] = new String[3];

                    datos[0] = lblProductoPresentacion.getText();
                    datos[1] = txtComponente.getText();
                    datos[2] = txtCantidad.getText();

                    modeloPreparaciones.addRow(datos);

                    tblPreparacion.setModel(modeloPreparaciones);

                    txtComponente.setText("");
                    lblProductoPresentacion.setText("");
                    txtCantidad.setText("");

                } else {
                    JOptionPane.showMessageDialog(getRootPane(), "INDIQUE LA MEDIDA DEL COMPONENTE");
                }
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "AGREGE UN COMPONENTE");
            }
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "DEBE INDICAR EL PRODUCTO PRINCIPAL");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnPrepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrepararActionPerformed

        try {
            Preparacion p = new Preparacion();
            int c = 0;
            int idProducto = Integer.parseInt(lblCodProducto.getText());
            PreparacionDAO pdao = new PreparacionDAO();
            ProductoPresentacion pp = null;
            for (int i = 0; i < pdao.Listar(idProducto).size(); i++) {
                int idPreparacion = pdao.Listar().get(i).getIdPreparacion();
                pp = new ProductoPresentacionDAO().Obtener(tblPreparacion.getValueAt(i, 1).toString(), 1);
            }
            
            for (int i = 0; i < tblPreparacion.getRowCount(); i++) {
                p.setIdProducto(idProducto);
                p.setIdProductoPresentacion(Integer.parseInt(tblPreparacion.getValueAt(i, 0).toString()));
                p.setCantidad(Integer.parseInt(tblPreparacion.getValueAt(i, 2).toString()));
                p.setDetalles("");
                if (pdao.Registrar(p)) {
                    System.out.println("preparacion registrada");
                    c++;
                }
            }

            if (c > 0) {
                JOptionPane.showMessageDialog(getRootPane(), "SE REGISTRO LA RECETA");
                txtBebida.setText("");
                txtCantidad.setText("");
                txtComponente.setText("");
                lblCodProducto.setText("");
                lblProductoPresentacion.setText("");
                LimpiarTabla(tblPreparacion, modeloPreparaciones);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnPrepararActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        int fila = tblPreparacion.getSelectedRow();

        if (fila >= 0) {
            modeloPreparaciones.removeRow(fila);
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "SELECCIONE UN COMPONENTE");
        }

    }//GEN-LAST:event_btnQuitarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnPreparar;
    public javax.swing.JButton btnProductoBase;
    public javax.swing.JButton btnQuitar;
    public javax.swing.JButton btnSeleccionarProducto;
    public javax.swing.JButton btnSeleccionarProductoPresentacion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCodProducto;
    private javax.swing.JLabel lblProductoPresentacion;
    public javax.swing.JDialog panelProductoPresentacion;
    public javax.swing.JDialog panelProductos;
    public javax.swing.JTable tblBuscarProductoPresentacion;
    public javax.swing.JTable tblBuscarProductos;
    public javax.swing.JTable tblPreparacion;
    public javax.swing.JTextField txtBebida;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtComponente;
    public javax.swing.JTextField txtFiltroProducto;
    public javax.swing.JTextField txtFiltroProductoPresentacion;
    // End of variables declaration//GEN-END:variables

    public void titulosBuscarProductos() {
        String titulos[] = {"ID", "PRODUCTO"};
        modeloBuscarProductos = new DefaultTableModel(null, titulos);
        tblBuscarProductos.setModel(modeloBuscarProductos);
    }

    public void titulosBuscarComponentes() {
        String titulos[] = {"ID", "PRODUCTO", "PRESENTACION"};
        modeloBuscarProductoPresentacion = new DefaultTableModel(null, titulos);
        tblBuscarProductoPresentacion.setModel(modeloBuscarProductoPresentacion);
    }

    public void titulosPreparaciones() {
        String titulos[] = {"COD", "NOMBRE", "MEDIDA ML"};
        modeloPreparaciones = new DefaultTableModel(null, titulos);
        tblPreparacion.setModel(modeloPreparaciones);
    }

    public void LlenarTablaBuscarProductos(String nomProd) throws Exception {
        titulosBuscarProductos();
        LimpiarTabla(tblBuscarProductos, modeloBuscarProductos);
        Conexion con = new Conexion();
        try {
            con.conectar();
            String sql = null;
            if (nomProd.equals("")) {
                sql = "select p.idproducto, p.nombre from producto p\n"
                        + "INNER JOIN productopresentacion pp on p.idproducto = pp.idproducto\n"
                        + "WHERE (pp.idcategoria = 1 OR pp.idcategoria = 2) AND pp.idalmacen = 1";
            } else {
                sql = "select p.idproducto, p.nombre from producto p\n"
                        + "INNER JOIN productopresentacion pp on p.idproducto = pp.idproducto\n"
                        + "WHERE ((pp.idcategoria = 1 OR pp.idcategoria = 2) AND pp.idalmacen = 1) AND p.nombre LIKE '%" + nomProd + "%'";
            }

            Object[] datos = new Object[2];
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                datos[0] = res.getInt(1);
                datos[1] = res.getString(2);

                modeloBuscarProductos.addRow(datos);
            }

            tblBuscarProductos.setModel(modeloBuscarProductos);
            new ColumnasTablas().dosColumnas(tblBuscarProductos, 50, 200);

            pst.close();
            res.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            con.cerrar();
        }
    }

    private void cargarPreparacion(int idProducto) throws SQLException {
        Conexion con = new Conexion();
        try {
            con.conectar();
            String sql = "SELECT productopresentacion.idproductopresentacion, producto.nombre, preparacion.cantidad FROM preparacion\n"
                    + "INNER JOIN productopresentacion ON preparacion.idproductopresentacion = productopresentacion.idproductopresentacion\n"
                    + "INNER JOIN producto ON productopresentacion.idproducto = producto.idproducto\n"
                    + "WHERE preparacion.idproducto = "+idProducto;
            
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            Object datos[] = new Object[3];
            
            while(res.next()){
                datos[0] = res.getInt(1);
                datos[1] = res.getString(2);
                datos[2] = res.getDouble(3);
                
                modeloPreparaciones.addRow(datos);
            }
            
            tblPreparacion.setModel(modeloPreparaciones);
            
            pst.close();
            res.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            con.cerrar();
        }
    }

    public void LlenarTablaBuscarProductoPresentacion(String nomProd) throws Exception {
        titulosBuscarComponentes();
        LimpiarTabla(tblBuscarProductoPresentacion, modeloBuscarProductoPresentacion);
        Conexion con = new Conexion();
        try {
            con.conectar();
            String sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion from producto p\n"
                    + "INNER JOIN productopresentacion pp on p.idproducto = pp.idproducto\n"
                    + "INNER JOIN presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                    + "WHERE (pp.idcategoria > 2  AND pp.idalmacen = 1) AND p.nombre like '%" + nomProd + "%'";

            Object[] datos = new Object[3];
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                datos[0] = res.getInt(1);
                datos[1] = res.getString(2);
                datos[2] = res.getString(3);

                modeloBuscarProductoPresentacion.addRow(datos);
            }

            tblBuscarProductoPresentacion.setModel(modeloBuscarProductoPresentacion);
            new ColumnasTablas().tresColumnas(tblBuscarProductoPresentacion, 50, 200, 100);

            pst.close();
            res.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            con.cerrar();
        }
    }

//    public boolean validarProducto(String nomProd) {
//        try {
//            int producto = new ProductoDAO().getIdProducto(nomProd);
//            if (producto > 0) {
//                return true;
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
    public int calcularStock(double stockProductoBase, int equivalencia) {
        //equivalencias ejm: 1 botella 750 ml = 6 cuba libre
        return (int) (stockProductoBase * equivalencia);
    }

    private void LimpiarTabla(JTable tabla, DefaultTableModel modelo) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }
}

package Vista;

import Modelo.Conexion;
import Controlador.MyiReportVisor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grover
 */
public class Kardex extends javax.swing.JInternalFrame {

    DefaultTableModel modelIngresos, modelSalidas, modelCompras;
    HashMap parametros = new HashMap();
    MyiReportVisor mrv;

    public Kardex(String usuario) {
        initComponents();
        //evento para capturar el valor de una celda jtable con doble click
//        tblEntradas.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent Mouse_evt) {
//                JTable table = (JTable) Mouse_evt.getSource();
//                Point point = Mouse_evt.getPoint();
//                int row = table.rowAtPoint(point);
//                if (Mouse_evt.getClickCount() == 2) {
//                    System.out.println("" + tblEntradas.getValueAt(tblEntradas.getSelectedRow(), 1));
//                }
//            }
//        });
        txtUsuario.setText(usuario);
        cabeceras();
    }

    public void cabeceras() {
        String titulos[] = {"PRODUCTOS", "CANTIDAD", "SUBTOTAL"};
        modelIngresos = new DefaultTableModel(null, titulos);
        modelCompras = new DefaultTableModel(null, titulos);
        modelSalidas = new DefaultTableModel(null, titulos);
        tblSalidas.setModel(modelSalidas);
        tblIngresos.setModel(modelIngresos);
        tblCompras.setModel(modelCompras);
    }

    public void cargarSalidas(int mes) throws Exception {
        limpiarTablaSalidas();
        String datos[] = new String[3];
        Conexion c = new Conexion();
        c.conectar();
        Connection con = c.getConexion();
        try {
            CallableStatement query = con.prepareCall("{call cargar_salidas(?)}");
            query.setInt(1, mes);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                modelSalidas.addRow(datos);
            }
            tblSalidas.setModel(modelSalidas);
            //sumaDeSalidas();
            query.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            c.cerrar();
        }
    }
    
    public void cargarCompras(int mes) throws Exception {
        limpiarTablaCompras();
        String datos[] = new String[3];
        Conexion c = new Conexion();
        c.conectar();
        Connection con = c.getConexion();
        try {
            CallableStatement query = con.prepareCall("{call cargar_compras(?)}");
            query.setInt(1, mes);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                modelCompras.addRow(datos);
            }
            tblCompras.setModel(modelCompras);
            //sumaDeSalidas();
            query.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            c.cerrar();
        }
    }
    
    public void cargarIngresos(int mes) throws Exception {
        limpiarTablaIngresos();
        String datos[] = new String[3];
        Conexion c = new Conexion();
        c.conectar();
        Connection con = c.getConexion();
        try {
            CallableStatement query = con.prepareCall("{call cargar_ingresos(?)}");
            query.setInt(1, mes);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                modelIngresos.addRow(datos);
            }
            tblIngresos.setModel(modelIngresos);
            //sumaDeSalidas();
            query.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            c.cerrar();
        }
    }

    public double sumaDeSalidas() {
        double subtotal = 0.0;
        int numFilas = tblSalidas.getRowCount();
        for (int i = 0; i < numFilas; i++) {
            subtotal += Double.parseDouble(tblSalidas.getValueAt(i, 2).toString());
        }
        return subtotal;
    }

    public double sumaDeEntradas() {
        double subtotal = 0.0;
        int numFilasCompras = tblCompras.getRowCount();
        int numFilasIngresos = tblIngresos.getRowCount();
        for (int i = 0; i < numFilasCompras; i++) {
            subtotal += Double.parseDouble(tblCompras.getValueAt(i, 2).toString());
        }
        for (int i = 0; i < numFilasIngresos; i++) {
            subtotal += Double.parseDouble(tblIngresos.getValueAt(i, 2).toString());
        }
        return subtotal;
    }

    public void cargarEntradas(int mes) throws Exception {
//        limpiarTablaEntradas();
//        Conexion c = new Conexion();
//        c.conectar();
//        Connection con = c.getConexion();
//        String datos[] = new String[5];
//        String sql = "SELECT productopresentacion.idproductopresentacion, producto.nombre, presentacion.descripcion, productopresentacion.stock, productopresentacion.precio\n"
//                + "FROM producto\n"
//                + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
//                + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
//                + "where producto.nombre like '" + art + "%' or producto.nombre like '%" + art + "'\n"
//                + "order by idproductopresentacion";
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                datos[0] = String.valueOf(rs.getInt("productopresentacion.idproductopresentacion"));
//                datos[1] = rs.getString("producto.nombre");
//                datos[2] = rs.getString("presentacion.descripcion");
//                datos[3] = rs.getString("productopresentacion.stock");
//                datos[4] = rs.getString("productopresentacion.precio");
//                modelProductoIngreso.addRow(datos);
//            }
//            tblProductoIngreso.setModel(modelProductoIngreso);
//            //tbl_productos.setModel(new DefaultTableModel());
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(getRootPane(), e.getMessage());
//        }finally{
//            c.cerrar();
//        }
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aSide = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jmcMes = new com.toedter.calendar.JMonthChooser();
        body = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ENTRADAS = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        footerEntradas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        compras = new javax.swing.JPanel();
        headerCompras = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        ingresos = new javax.swing.JPanel();
        headerIngresos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblIngresos = new javax.swing.JTable();
        SALIDAS = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSalidas = new javax.swing.JTable();
        footerSalidas = new javax.swing.JPanel();
        btnCrearReporte = new javax.swing.JButton();
        txtTotalEntradas = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotalSalidas = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Seguimiento de kardex");

        aSide.setBackground(new java.awt.Color(204, 204, 255));
        aSide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel12.setText("MES");
        aSide.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

        btnMostrar.setBackground(new java.awt.Color(51, 153, 0));
        btnMostrar.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("REVISAR");
        btnMostrar.setBorder(null);
        btnMostrar.setBorderPainted(false);
        btnMostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        aSide.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, 40));

        txtUsuario.setEditable(false);
        txtUsuario.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(null);
        aSide.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 170, -1));

        jmcMes.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        aSide.add(jmcMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 150, 30));

        getContentPane().add(aSide, java.awt.BorderLayout.WEST);

        body.setBackground(new java.awt.Color(153, 153, 255));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TOTAL ENTRADAS");
        body.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 650, 150, -1));

        ENTRADAS.setBackground(new java.awt.Color(153, 153, 255));
        ENTRADAS.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new java.awt.CardLayout());

        jLabel10.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("ENTRADAS");
        jPanel3.add(jLabel10, "card2");

        ENTRADAS.add(jPanel3, java.awt.BorderLayout.PAGE_START);
        ENTRADAS.add(footerEntradas, java.awt.BorderLayout.PAGE_END);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        compras.setPreferredSize(new java.awt.Dimension(100, 50));
        compras.setLayout(new java.awt.BorderLayout());

        headerCompras.setBackground(new java.awt.Color(204, 204, 255));
        headerCompras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel1.setText("compras");
        headerCompras.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        compras.add(headerCompras, java.awt.BorderLayout.PAGE_START);

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCompras);

        compras.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(compras);

        ingresos.setPreferredSize(new java.awt.Dimension(100, 50));
        ingresos.setLayout(new java.awt.BorderLayout());

        headerIngresos.setBackground(new java.awt.Color(204, 204, 255));
        headerIngresos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel4.setText("ingresos");
        headerIngresos.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ingresos.add(headerIngresos, java.awt.BorderLayout.PAGE_START);

        tblIngresos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblIngresos);

        ingresos.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(ingresos);

        ENTRADAS.add(jPanel1, java.awt.BorderLayout.CENTER);

        body.add(ENTRADAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 640));

        SALIDAS.setBackground(new java.awt.Color(153, 153, 255));
        SALIDAS.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setLayout(new java.awt.CardLayout());

        jLabel15.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("SALIDAS");
        jPanel6.add(jLabel15, "card2");

        SALIDAS.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        tblSalidas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tblSalidas);

        SALIDAS.add(jScrollPane5, java.awt.BorderLayout.CENTER);
        SALIDAS.add(footerSalidas, java.awt.BorderLayout.PAGE_END);

        body.add(SALIDAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 590, 640));

        btnCrearReporte.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        btnCrearReporte.setText("CREAR REPORTE");
        btnCrearReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearReporteActionPerformed(evt);
            }
        });
        body.add(btnCrearReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 230, 40));

        txtTotalEntradas.setEditable(false);
        txtTotalEntradas.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 20)); // NOI18N
        txtTotalEntradas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalEntradas.setBorder(null);
        body.add(txtTotalEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 650, 170, 30));

        jLabel3.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 20)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("TOTAL SALIDAS");
        body.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 690, 150, -1));

        txtTotalSalidas.setEditable(false);
        txtTotalSalidas.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 20)); // NOI18N
        txtTotalSalidas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalSalidas.setBorder(null);
        body.add(txtTotalSalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 690, 170, 30));

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        try {
            txtTotalEntradas.setText("");
            txtTotalSalidas.setText("");
            
            int mes = jmcMes.getMonth() + 1;
            cargarSalidas(mes);
            cargarCompras(mes);
            cargarIngresos(mes);
            
            txtTotalEntradas.setText(""+ sumaDeEntradas());
            txtTotalSalidas.setText(""+ sumaDeSalidas());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnCrearReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearReporteActionPerformed
//        int idProd = Integer.parseInt(txtCodigo.getText());
//        parametros.put("idProd", idProd);
//        mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\kardex.jrxml", parametros);
//        mrv.exportarAPdf();
    }//GEN-LAST:event_btnCrearReporteActionPerformed
//
//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(Kardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Kardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Kardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Kardex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Kardex().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ENTRADAS;
    private javax.swing.JPanel SALIDAS;
    private javax.swing.JPanel aSide;
    private javax.swing.JPanel body;
    private javax.swing.JButton btnCrearReporte;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JPanel compras;
    private javax.swing.JPanel footerEntradas;
    private javax.swing.JPanel footerSalidas;
    private javax.swing.JPanel headerCompras;
    private javax.swing.JPanel headerIngresos;
    private javax.swing.JPanel ingresos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private com.toedter.calendar.JMonthChooser jmcMes;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTable tblIngresos;
    private javax.swing.JTable tblSalidas;
    private javax.swing.JTextField txtTotalEntradas;
    private javax.swing.JTextField txtTotalSalidas;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void limpiarTablaCompras() {
        for (int i = 0; i < tblCompras.getRowCount(); i++) {
            modelCompras.removeRow(i);
            i -= 1;
        }
    }
    
    public void limpiarTablaSalidas() {
        for (int i = 0; i < tblSalidas.getRowCount(); i++) {
            modelSalidas.removeRow(i);
            i -= 1;
        }
    }
    
    private void limpiarTablaIngresos() {
        for (int i = 0; i < tblIngresos.getRowCount(); i++) {
            modelIngresos.removeRow(i);
            i -= 1;
        }
    }

//    
//    public void getProducto(int fila) {
//        String codProd = tbl_buscar_prod.getValueAt(fila, 0).toString();
//        String nom_prod = tbl_buscar_prod.getValueAt(fila, 1).toString();
//        int stock = Integer.parseInt(tbl_buscar_prod.getValueAt(fila, 5).toString());
////        String proveedor = new ProveedorControl().getNomProveedor(nom_prod);
//        txtProducto.setText(nom_prod);
//        txtCodigo.setText(codProd);
//        txtStock.setText("" + stock);
//        //      txtProveedor.setText(proveedor);
//    }

    
}

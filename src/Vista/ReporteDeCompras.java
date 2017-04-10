package Vista;

import Controlador.ManejadorFechas;
import Controlador.MyiReportVisor;
import Controlador.Validaciones;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gaby
 */
public class ReporteDeCompras extends javax.swing.JInternalFrame {

    MyiReportVisor mrv;
    HashMap parametros = new HashMap();
    DefaultTableModel modelCompras, modelDetalleCompra, model_produc;

    public ReporteDeCompras() throws Exception {
        initComponents();
        //setLocationRelativeTo(null);
        titulos();
    }

    public void titulos() {
        String titulos[] = {"N° COMPRA", "PROVEEDOR", "DOCUMENTO", "N° SERIE", "N°", "MONEDA", "FECHA", "HORA", "ESTADO"};
        String titulos2[] = {"COMPRA", "COD. PROD", "PRODUCTO", "CANTIDAD", "PRECIO", "SUBTOTAL"};
        modelCompras = new DefaultTableModel(null, titulos);
        modelDetalleCompra = new DefaultTableModel(null, titulos2);
        tblCompras.setModel(modelCompras);
        tblDetalleCompras.setModel(modelDetalleCompra);
        tblCompras.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblCompras.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblCompras.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblCompras.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblCompras.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblCompras.getColumnModel().getColumn(5).setPreferredWidth(50);
        tblCompras.getColumnModel().getColumn(6).setPreferredWidth(50);
        tblCompras.getColumnModel().getColumn(7).setPreferredWidth(50);
        tblCompras.getColumnModel().getColumn(8).setPreferredWidth(50);

        tblDetalleCompras.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblDetalleCompras.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblDetalleCompras.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblDetalleCompras.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblDetalleCompras.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblDetalleCompras.getColumnModel().getColumn(5).setPreferredWidth(50);

    }

    public void limpiarTablaCompras() {
        for (int i = 0; i < tblCompras.getRowCount(); i++) {
            modelCompras.removeRow(i);
            i -= 1;
        }
    }

    public void limpiarTablaDetalleCompras() {
        for (int i = 0; i < tblDetalleCompras.getRowCount(); i++) {
            modelDetalleCompra.removeRow(i);
            i -= 1;
        }
    }

    public void cargarRangoCompras() throws Exception {
        limpiarTablaCompras();
        Date inicio = jdcDesde.getDate();
        Date fin = jdcHasta.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fec_inicio = sdf.format(inicio);
        String fec_fin = sdf.format(fin);
        String sql = "SELECT ordencompra.idordencompra, proveedor.razon , tipocomprobante.descripcion, ordencompra.serie, ordencompra.num_comprobante, ordencompra.moneda, ordencompra.fecha, ordencompra.hora,ordencompra.estado \n"
                + "FROM ordencompra\n"
                + "inner join proveedor on ordencompra.iproveedor = proveedor.idproveedor\n"
                + "inner join tipocomprobante on ordencompra.idtipocomprobante = tipocomprobante.idtipocomprobante\n"
                + "WHERE ordencompra.fecha between '" + fec_inicio + "' and '" + fec_fin + "';";
        String datos[] = new String[9];
        Conexion c = new Conexion();
        c.conectar();
        Connection con = c.getConexion();
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("ordencompra.idordencompra");
                datos[1] = rs.getString("proveedor.razon");
                datos[2] = rs.getString("tipocomprobante.descripcion");
                datos[3] = rs.getString("ordencompra.serie");
                datos[4] = rs.getString("ordencompra.num_comprobante");
                datos[5] = rs.getString("ordencompra.moneda");
                datos[6] = rs.getString("ordencompra.fecha");
                datos[7] = rs.getString("ordencompra.hora");
                int estado = rs.getInt("ordencompra.estado");
                if (estado == 1) {
                    datos[8] = "ACTIVO";
                } else {
                    datos[8] = "ANULADO";
                }
                modelCompras.addRow(datos);
            }
            tblCompras.setModel(modelCompras);

            st.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } finally {
            c.cerrar();
        }
    }

    public void cargarDetalleCompra(int id) throws Exception {
        limpiarTablaDetalleCompras();
        String sql = "SELECT detallecompra.idcompra, producto.idproducto, producto.nombre, detallecompra.cantidad, detallecompra.precio, detallecompra.subtotal \n"
                + "FROM ordencompra \n"
                + "INNER JOIN detallecompra ON ordencompra.idordencompra = detallecompra.idcompra \n"
                + "INNER JOIN producto ON producto.idproducto = detallecompra.idproducto\n"
                + "WHERE ordencompra.idordencompra = " + id + "";
        String datos[] = new String[6];
        Conexion c = new Conexion();
        c.conectar();
        Connection con = c.getConexion();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("detallecompra.idcompra");
                datos[1] = rs.getString("producto.idproducto");
                datos[2] = rs.getString("producto.nombre");
                datos[3] = rs.getString("detallecompra.cantidad");
                datos[4] = rs.getString("detallecompra.precio");
                datos[5] = rs.getString("detallecompra.subtotal");
                modelDetalleCompra.addRow(datos);
            }
            tblDetalleCompras.setModel(modelDetalleCompra);

            tblDetalleCompras.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblDetalleCompras.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblDetalleCompras.getColumnModel().getColumn(2).setPreferredWidth(250);
            tblDetalleCompras.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblDetalleCompras.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblDetalleCompras.getColumnModel().getColumn(5).setPreferredWidth(50);

            st.close();
            rs.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } finally {
            c.cerrar();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        jdcHasta = new com.toedter.calendar.JDateChooser();
        jdcDesde = new com.toedter.calendar.JDateChooser();
        btnReporte = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalleCompras = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("REPORTES DE COMPRAS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REPORTES DE COMPRAS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 60));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 900, 210));

        jLabel3.setText("DETALLES DE COMPRA");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, -1));

        jLabel4.setText("HASTA");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        btnMostrar.setBackground(new java.awt.Color(51, 153, 0));
        btnMostrar.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrar.setText("MOSTRAR");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 160, -1));
        getContentPane().add(jdcHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 160, -1));
        getContentPane().add(jdcDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 160, -1));

        btnReporte.setBackground(new java.awt.Color(204, 102, 0));
        btnReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnReporte.setText("CREAR REPORTE");
        btnReporte.setEnabled(false);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        getContentPane().add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 640, 190, 40));

        tblDetalleCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDetalleCompras);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 900, 210));

        jButton2.setBackground(new java.awt.Color(0, 153, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("VER DETALLE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 290, 130, -1));

        jLabel6.setText("CREAR REPORTE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, -1, -1));

        jLabel8.setText("2° Seleccione una compra de la");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel9.setText("ó presionar ALT + N");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, -1, -1));

        jLabel10.setText("compra seleccionada antes.");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        jLabel11.setText("tabla superior");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabel12.setText("seleccionada pulse sobre");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));

        jLabel13.setText("3° Pulse el boton VER DETALLE");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));

        jLabel14.setText("para visualizar los detalles de la");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SELECCIONE PERIODO");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 270, 20));

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblTotal.setText("......");
        getContentPane().add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 590, 160, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setText("S/.");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 590, -1, -1));

        jButton3.setMnemonic('n');
        jButton3.setText("NUEVO REPORTE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 160, -1));

        jLabel15.setText("4° Si desea un reporte de la compra");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        jLabel17.setText("5° Para crear un nuevo reporte ");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, -1, -1));

        jLabel18.setText("clic en el boton NUEVO REPORTE");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, -1, -1));

        jLabel19.setText("DESDE");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel20.setText("TOTAL GRABADO:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 570, -1, -1));

        jLabel21.setText("1° Indique un rango de fechas");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed

        if (jdcDesde.getDate() != null) {
            if (jdcHasta.getDate() != null) {
                try {
                    cargarRangoCompras();
                    limpiarTablaDetalleCompras();
                } catch (Exception ex) {
                    Logger.getLogger(ReporteDeCompras.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "INDIQUE FECHA FINAL");
            }
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "INDIQUE FECHA DE INICIO");
        }


    }//GEN-LAST:event_btnMostrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int fila = tblCompras.getSelectedRow();
        if (fila >= 0) {
            try {
                int id = Integer.parseInt(tblCompras.getValueAt(fila, 0).toString());
                cargarDetalleCompra(id);
                lblTotal.setText("" + new Validaciones().Redondear(sumarTotalDetalles()));
                btnReporte.setEnabled(true);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                btnReporte.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "SELECCIONE UNA COMPRA");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            this.dispose();
            new ReporteDeCompras().setVisible(true);
        } catch (SQLException ex) {
            ex.getMessage();
        } catch (Exception ex) {
            Logger.getLogger(ReporteDeCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        int fila = tblCompras.getSelectedRow();
        if (fila >= 0) {
            int id = Integer.parseInt(tblCompras.getValueAt(fila, 0).toString());//tambien es el numero de compra
            String provee = String.valueOf(tblCompras.getValueAt(fila, 1).toString());
            String doc = String.valueOf(tblCompras.getValueAt(fila, 2).toString());
            String fec = String.valueOf(tblCompras.getValueAt(fila, 6).toString());
            String hor = String.valueOf(tblCompras.getValueAt(fila, 7).toString());
            double total = Double.parseDouble(lblTotal.getText());
            parametros.put("numCompra", id);
            parametros.put("doc", doc);
            parametros.put("fec", fec);
            parametros.put("hor", hor);
            parametros.put("provee", provee);
            parametros.put("total", total);
            parametros.put("id", id);
            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\reporteCompras.jrxml", parametros);
            mrv.exportarAPdf();
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "SELECCIONE UNA COMPRA");
        }
    }//GEN-LAST:event_btnReporteActionPerformed

    public double sumarTotalDetalles() {
        int numFilas = tblDetalleCompras.getRowCount();
        double total = 0.0;
        for (int i = 0; i < numFilas; i++) {
            //sumar toda la columna 5
            total += Double.parseDouble(tblDetalleCompras.getValueAt(i, 5).toString());
        }
        return total;
    }

//    public void cargarComprasDelDia(String fecha) throws Exception {
//        limpiarTablaCompras();
//        String sql = "SELECT `id_compra`, `nom_provee`, `tipo_doc`, `num_serie`, `num_doc_compra`, `forma_pago`, `fecha_compra`, `hora_compra`,estado FROM `tcompras` WHERE `fecha_compra` = '" + fecha + "'";
//        String datos[] = new String[9];
//        Conexion c = new Conexion();
//        c.conectar();
//        Connection con = c.getConexion();
//        try {
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                datos[0] = rs.getString("id_compra");
//                datos[1] = rs.getString("nom_provee");
//                datos[2] = rs.getString("tipo_doc");
//                datos[3] = rs.getString("num_serie");
//                datos[4] = rs.getString("num_doc_compra");
//                datos[5] = rs.getString("forma_pago");
//                datos[6] = rs.getString("fecha_compra");
//                datos[7] = rs.getString("hora_compra");
//                int estado = rs.getInt("estado");
//                if (estado == 0) {
//                    datos[8] = "ACTIVO";
//                } else {
//                    datos[8] = "ANULADO";
//                }
//                modelCompras.addRow(datos);
//                st.close();
//                rs.close();
//            }
//            tblCompras.setModel(modelCompras);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(getRootPane(), e.getMessage());
//        } finally {
//            c.cerrar();
//        }
//    }

    public void cargarNumeroDeCompra(int numBoleta) throws Exception {
        limpiarTablaCompras();
        String sql = "SELECT `id_compra`, `nom_provee`, `tipo_doc`, `num_serie`, `num_doc_compra`, `forma_pago`, `fecha_compra`, `hora_compra`,estado FROM `tcompras` WHERE `num_doc_compra` = '" + numBoleta + "'";
        String datos[] = new String[9];
        Conexion c = new Conexion();
        c.conectar();
        Connection con = c.getConexion();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("id_compra");
                datos[1] = rs.getString("nom_provee");
                datos[2] = rs.getString("tipo_doc");
                datos[3] = rs.getString("num_serie");
                datos[4] = rs.getString("num_doc_compra");
                datos[5] = rs.getString("forma_pago");
                datos[6] = rs.getString("fecha_compra");
                datos[7] = rs.getString("hora_compra");
                int estado = rs.getInt("estado");
                if (estado == 0) {
                    datos[8] = "ACTIVO";
                } else {
                    datos[8] = "ANULADO";
                }
                modelCompras.addRow(datos);
                st.close();
                rs.close();
            }
            tblCompras.setModel(modelCompras);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), e.getMessage());
        } finally {
            c.cerrar();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcDesde;
    private com.toedter.calendar.JDateChooser jdcHasta;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTable tblDetalleCompras;
    // End of variables declaration//GEN-END:variables
}

package Vista;

import Controlador.ReportesControl;
import Modelo.Caja;
import Modelo.Conexion;
import Modelo.MySQLDAO.CajaDAO;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jxl.write.WriteException;

public class ReportesNotaPedido extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTablaVentas;

    public ReportesNotaPedido() throws Exception {
        initComponents();
        datosIniciales();
    }

    public void datosIniciales() throws Exception {
        cargarComboCajas();
        titulosTablaNotaPedido();
    }

    public void titulosTablaNotaPedido() {
        String cabecera[] = {"PRODUCTO", "PRECIO.U", "CANTIDAD", "SUBTOTAL"};
        modeloTablaVentas = new DefaultTableModel(null, cabecera);
        tblDatos.setModel(modeloTablaVentas);
    }

    public void cargarComboCajas() throws Exception {
        CajaDAO cdao = new CajaDAO();
        for (Caja c : cdao.Listar()) {
            cmbCaja.addItem(c.getNomCaja());
        }
    }

    private void LimpiarTabla(JTable tabla, DefaultTableModel modelo) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    private void calculos() {
        double ventas = 0.0;
        double igv = 0.0;
        for (int i = 0; i < tblDatos.getRowCount(); i++) {
            ventas += Double.parseDouble(tblDatos.getValueAt(i, 3).toString());
        }
        txtTotalVentas.setText("" + ventas);
        txtIgvAcumulado.setText("" + (ventas * 0.18));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jmcMeses = new com.toedter.calendar.JMonthChooser();
        jLabel1 = new javax.swing.JLabel();
        btnRevisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnGenerarExcel = new javax.swing.JButton();
        cmbCaja = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTotalVentas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIgvAcumulado = new javax.swing.JTextField();

        setClosable(true);
        setTitle("INFORMES DE NOTAS DE PEDIDO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jmcMeses, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, -1, -1));

        jLabel1.setText("CAJA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        btnRevisar.setText("REVISAR");
        btnRevisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRevisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, -1, -1));

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 990, 640));

        btnGenerarExcel.setText("CREAR EXCEL");
        btnGenerarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarExcelActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerarExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 740, 150, 50));

        getContentPane().add(cmbCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 240, -1));

        jLabel2.setText("NOTA PEDIDO MES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("TOTAL NOTAS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 740, 140, -1));
        getContentPane().add(txtTotalVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 740, 150, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("IGV ACUMULADO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 770, 140, -1));
        getContentPane().add(txtIgvAcumulado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 770, 150, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRevisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevisarActionPerformed
        try {
            int mes = jmcMeses.getMonth() + 1;
            ventaMes(mes, cmbCaja.getSelectedIndex() + 1);
            calculos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnRevisarActionPerformed

    private void btnGenerarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarExcelActionPerformed
        try {
            int filas = tblDatos.getRowCount();
            int columnas = tblDatos.getColumnCount();
            String[][] entrada = new String[filas][columnas];
//            entrada [0][0] = "FECHA";
//            entrada [0][1] = "DOCUMENTO";
//            entrada [0][2] = "SERIE";
//            entrada [0][3] = "VENTA";
//            entrada [0][4] = "BASE-IMP";
//            entrada [0][5] = "IGV";
//            entrada [0][6] = "SUBTOTAL";

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    entrada[i][j] = tblDatos.getValueAt(i, j).toString();
                }
            }

            String ruta = "C:\\Users\\MARCEL\\Desktop\\REPORTE-CONTADORA.xls";

            new ReportesControl().generarExcel(entrada, ruta);
        } catch (IOException ex) {
            Logger.getLogger(ReportesNotaPedido.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ReportesNotaPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarExcel;
    private javax.swing.JButton btnRevisar;
    private javax.swing.JComboBox<String> cmbCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JMonthChooser jmcMeses;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtIgvAcumulado;
    private javax.swing.JTextField txtTotalVentas;
    // End of variables declaration//GEN-END:variables

    //venta de mes serie 3
    public void ventaMes(int mes, int serie) throws Exception {
        LimpiarTabla(tblDatos, modeloTablaVentas);
        Conexion con = new Conexion();
        try {
            con.conectar();
            Object[] datos = new Object[4];
            String sql = "";
            int c = 0;
            switch (serie) {
                case 1://jaime serie 002
                    JOptionPane.showMessageDialog(getRootPane(), "UNSUPPORTED YET");
                    break;
                case 2://burro serie 001
                    sql = "select producto.nombre,count(producto.nombre), sum(ventanota.numCovers), sum(ventanota.total)\n"
                            + "    from notapedido\n"
                            + "    inner join ventanota on notapedido.idnotapedido = ventanota.idnotapedido\n"
                            + "    inner join prodpromocion on ventanota.idprodpromocion = prodpromocion.idprodpromocion\n"
                            + "    inner join productopresentacion on prodpromocion.idproductopresentacion = productopresentacion.idproductopresentacion\n"
                            + "    inner join producto on productopresentacion.idproducto = producto.idproducto\n"
                            + "    where month(notapedido.fechasistema) = " + mes + " \n"
                            + "    group by producto.nombre\n"
                            + "    order by sum(ventanota.total) desc";
                    c++;
                    break;
                case 3://caja 01                    
                    sql = "select producto.nombre, npbarra_prod.preciou, sum(npbarra_prod.cantidad), sum(npbarra_prod.subtotal)\n"
                            + "from npbarra\n"
                            + "inner join npbarra_prod on npbarra.idnpbarra = npbarra_prod.idnpbarra\n"
                            + "inner join productopresentacion on npbarra_prod.idproductopresentacion = productopresentacion.idproductopresentacion\n"
                            + "inner join producto on productopresentacion.idproducto = producto.idproducto\n"
                            + "where month(npbarra.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    c++;
                    break;
                case 4://caja 02
                    sql = "select producto.nombre, npbarra_prod2.preciou, sum(npbarra_prod2.cantidad), sum(npbarra_prod2.subtotal)\n"
                            + "from npbarra2\n"
                            + "inner join npbarra_prod2 on npbarra2.idnpbarra2 = npbarra_prod2.idnpbarra2\n"
                            + "inner join productopresentacion on npbarra_prod2.idproductopresentacion = productopresentacion.idproductopresentacion\n"
                            + "inner join producto on productopresentacion.idproducto = producto.idproducto\n"
                            + "where month(npbarra2.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    c++;
                    break;
                case 5://caja vip
                    sql = "select producto.nombre, npbarra_prod3.preciou, sum(npbarra_prod3.cantidad), sum(npbarra_prod3.subtotal)\n"
                            + "from npbarra3\n"
                            + "inner join npbarra_prod3 on npbarra3.idnpbarra3 = npbarra_prod3.idnpbarra3\n"
                            + "inner join productopresentacion on npbarra_prod3.idproductopresentacion = productopresentacion.idproductopresentacion\n"
                            + "inner join producto on productopresentacion.idproducto = producto.idproducto\n"
                            + "where month(npbarra3.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    c++;
                    break;
                case 6://entrada general 2 alejandro
                    JOptionPane.showMessageDialog(getRootPane(), "UNSUPPORTED YET");
                    break;
            }

            if (c > 0) {
                PreparedStatement pst = con.getConexion().prepareStatement(sql);
                //pst.setInt(1, mes);

                ResultSet rs = pst.executeQuery();
                //estructura para contadora
                //FECHA-TIPODOCUMENTO-SERIE-NROVENTA-BASEIMPONIBLE(/1.18)-IGV(*0.18)-IMPORTETOTAL
                while (rs.next()) {
                    datos[0] = rs.getString(1); // producto
                    datos[1] = rs.getDouble(2);//precio unitario
                    datos[2] = rs.getInt(3);//cantidad
                    datos[3] = rs.getDouble(4);// subtotal

                    modeloTablaVentas.addRow(datos);
                }
                tblDatos.setModel(modeloTablaVentas);
                rs.close();
                pst.close();
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "NO HAY DATOS QUE RECUPERAR");
            }

        } catch (Exception e) {
            throw e;
        } finally {
            con.cerrar();
        }
    }

}

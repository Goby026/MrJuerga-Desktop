package Vista;

import Controlador.ApachePOIExcelWrite;
import Controlador.ManejadorFechas;
import Controlador.ReportesControl;
import Controlador.Validaciones;
import Modelo.Caja;
import Modelo.Conexion;
import Modelo.MySQLDAO.CajaDAO;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jxl.write.WriteException;

public class ReporteContadora extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTablaVentas;
    DefaultTableModel modeloTablaResumenProductos;
    DefaultTableModel modeloTablaJornadas;
    Validaciones v;

    public ReporteContadora() throws Exception {
        initComponents();
        v = new Validaciones();
        datosIniciales();
    }

    public void datosIniciales() throws Exception {
        cargarComboCajas();
        titulosTablaVentas();
        titulosTablaResumenProductos();
        titulosTablaJornadas();
    }

    public void titulosTablaVentas() {
        String cabecera[] = {"FECHA", "DOCUMENTO", "SERIE", "VENTA", "BASE-IMP", "IGV", "SUBTOTAL"};
        modeloTablaVentas = new DefaultTableModel(null, cabecera);
        tblDatos.setModel(modeloTablaVentas);
        columnsSize(1);
    }

    public void titulosTablaResumenProductos() {
        String cabecera[] = {"PRODUCTO", "PRECIO U.", "CANTIDAD", "SUBTOTAL"};
        modeloTablaResumenProductos = new DefaultTableModel(null, cabecera);
        tblResumenProductos.setModel(modeloTablaResumenProductos);
        columnsSize(2);
    }

    public void titulosTablaJornadas() {
        String cabecera[] = {"INICIO", "FIN", "TICKET INICIO", "TICKET FINAL", "SUBTOTAL"};
        modeloTablaJornadas = new DefaultTableModel(null, cabecera);
        tblVentasJornada.setModel(modeloTablaJornadas);
        columnsSize(3);
    }

    private void columnsSize(int opc) {
        if (opc == 1) {
            tblDatos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblDatos.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblDatos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblDatos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblDatos.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblDatos.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblDatos.getColumnModel().getColumn(6).setPreferredWidth(50);
        } else if (opc == 2) {
            tblResumenProductos.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblResumenProductos.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblResumenProductos.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblResumenProductos.getColumnModel().getColumn(3).setPreferredWidth(50);
        } else if (opc == 3) {
            tblVentasJornada.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblVentasJornada.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblVentasJornada.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblVentasJornada.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblVentasJornada.getColumnModel().getColumn(4).setPreferredWidth(50);
        }
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

    private void calculos(int opc) {
        double ventas = 0.0;

        switch (opc) {
            case 1:
                for (int i = 0; i < tblDatos.getRowCount(); i++) {
                    ventas += Double.parseDouble(tblDatos.getValueAt(i, 6).toString());
                    //igv += Double.parseDouble(tblDatos.getValueAt(i, 5).toString());
                }
                txtTotalVentas.setText("" + v.Redondear(ventas));
                txtIgvAcumulado.setText("" + (v.Redondear(ventas * 0.18)));
                break;
            case 2:
                for (int i = 0; i < tblVentasJornada.getRowCount(); i++) {
                    ventas += Double.parseDouble(tblVentasJornada.getValueAt(i, 4).toString());
                    //igv += Double.parseDouble(tblDatos.getValueAt(i, 5).toString());
                }
                txtTotalJornadas.setText("" + v.Redondear(ventas));
                break;
        }

    }

    private String meses(int m) {
        String mes = "";
        switch (m) {
            case 1:
                mes = "ENERO";
                break;
            case 2:
                mes = "FEBRERO";
                break;
            case 3:
                mes = "MARZO";
                break;
            case 4:
                mes = "ABRIL";
                break;
            case 5:
                mes = "MAYO";
                break;
            case 6:
                mes = "JUNIO";
                break;
            case 7:
                mes = "JULIO";
                break;
            case 8:
                mes = "AGOSTO";
                break;
            case 9:
                mes = "SETIEMBRE";
                break;
            case 10:
                mes = "OCTUBRE";
                break;
            case 11:
                mes = "NOVIEMBRE";
                break;
            case 12:
                mes = "DICIEMBRE";
                break;
        }
        return mes;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formVentaJornada = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblVentasJornada = new javax.swing.JTable();
        btnExcelJornadas = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTotalJornadas = new javax.swing.JTextField();
        formTotales = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtVip = new javax.swing.JTextField();
        txtEntradas = new javax.swing.JTextField();
        txtGeneral2 = new javax.swing.JTextField();
        txtGeneral1 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        txtGraciasTotales = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtIgvTotalMes = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMesTotales = new javax.swing.JTextField();
        jmcMeses = new com.toedter.calendar.JMonthChooser();
        jLabel1 = new javax.swing.JLabel();
        btnRevisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        cmbCaja = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTotalVentas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIgvAcumulado = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResumenProductos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnVentaJornada = new javax.swing.JButton();
        btnVentaTotal = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        pruebaPOI = new javax.swing.JButton();
        pruebaPOIDetalles = new javax.swing.JButton();

        formVentaJornada.setTitle("VENTAS POR JORNADA");
        formVentaJornada.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVentasJornada.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblVentasJornada);

        formVentaJornada.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 679, 380));

        btnExcelJornadas.setText("CREAR EXCEL");
        btnExcelJornadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelJornadasActionPerformed(evt);
            }
        });
        formVentaJornada.getContentPane().add(btnExcelJornadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, -1, -1));

        jLabel7.setText("TOTAL");
        formVentaJornada.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, -1, -1));

        txtTotalJornadas.setEditable(false);
        txtTotalJornadas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formVentaJornada.getContentPane().add(txtTotalJornadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 120, -1));

        formTotales.setTitle("MONTOS TOTALES");
        formTotales.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("ENTRADAS");
        formTotales.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel9.setText("GENERAL 01");
        formTotales.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel10.setText("GENERAL 02");
        formTotales.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel11.setText("CAJA VIP");
        formTotales.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        txtVip.setEditable(false);
        txtVip.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formTotales.getContentPane().add(txtVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 130, -1));

        txtEntradas.setEditable(false);
        txtEntradas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formTotales.getContentPane().add(txtEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 130, -1));

        txtGeneral2.setEditable(false);
        txtGeneral2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formTotales.getContentPane().add(txtGeneral2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 130, -1));

        txtGeneral1.setEditable(false);
        txtGeneral1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formTotales.getContentPane().add(txtGeneral1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 130, -1));
        formTotales.getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 210, 10));

        jLabel12.setText("TOTAL");
        formTotales.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        txtGraciasTotales.setEditable(false);
        txtGraciasTotales.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formTotales.getContentPane().add(txtGraciasTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 130, -1));

        jLabel13.setText("IGV TOTAL");
        formTotales.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        txtIgvTotalMes.setEditable(false);
        txtIgvTotalMes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formTotales.getContentPane().add(txtIgvTotalMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 130, -1));
        formTotales.getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 210, 10));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("MONTOS TOTALES");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        formTotales.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 40));

        jLabel15.setText("MES");
        formTotales.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtMesTotales.setEditable(false);
        txtMesTotales.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        formTotales.getContentPane().add(txtMesTotales, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 230, -1));

        setClosable(true);
        setTitle("INFORMES DE VENTAS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jmcMeses.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jmcMeses, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 150, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caja-registradora.png"))); // NOI18N
        jLabel1.setText("CAJA");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        btnRevisar.setBackground(new java.awt.Color(204, 255, 204));
        btnRevisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sincronizate.png"))); // NOI18N
        btnRevisar.setText("REVISAR");
        btnRevisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRevisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 120, 30));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 550, 640));

        cmbCaja.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(cmbCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 220, -1));

        jLabel2.setText("RESUMEN POR PRODUCTOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("TOTAL VENTAS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 780, 140, -1));
        getContentPane().add(txtTotalVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 780, 150, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("IGV ACUMULADO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 810, 140, -1));
        getContentPane().add(txtIgvAcumulado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 810, 150, -1));

        tblResumenProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblResumenProductos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 560, 640));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Schedule.png"))); // NOI18N
        jLabel5.setText("VER VENTAS DE MES");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel6.setText("DETALLE VENTAS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, -1, -1));

        btnVentaJornada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/jornada.png"))); // NOI18N
        btnVentaJornada.setText("VENTAS POR JORNADA");
        btnVentaJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaJornadaActionPerformed(evt);
            }
        });
        getContentPane().add(btnVentaJornada, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        btnVentaTotal.setText("VENTAS TOTALES POR MES");
        btnVentaTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaTotalActionPerformed(evt);
            }
        });
        getContentPane().add(btnVentaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 220, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 1120, 20));

        pruebaPOI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        pruebaPOI.setText("PRODUCTOS");
        pruebaPOI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebaPOIActionPerformed(evt);
            }
        });
        getContentPane().add(pruebaPOI, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 780, -1, -1));

        pruebaPOIDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        pruebaPOIDetalles.setText("DETALLES");
        pruebaPOIDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebaPOIDetallesActionPerformed(evt);
            }
        });
        getContentPane().add(pruebaPOIDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 780, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRevisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevisarActionPerformed
        try {
            int mes = jmcMeses.getMonth() + 1;

            if ((cmbCaja.getSelectedIndex() + 1) == 1 || (cmbCaja.getSelectedIndex() + 1) == 2) {
                ventasEntrada(mes, 2);//detalles
                ventaEntradaPorProducto(mes, 2);//por producto
            } else {
                ventaMes(mes, cmbCaja.getSelectedIndex() + 1);
                ventaPorProducto(mes, cmbCaja.getSelectedIndex() + 1);
            }

            calculos(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnRevisarActionPerformed

    private void btnVentaJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaJornadaActionPerformed
        //679, 444
        formVentaJornada.setVisible(true);
        formVentaJornada.setBounds(450, 400, 695, 510);

        LimpiarTabla(tblVentasJornada, modeloTablaJornadas);

        try {

            int mes = jmcMeses.getMonth() + 1;

            if ((cmbCaja.getSelectedIndex() + 1) == 1 || (cmbCaja.getSelectedIndex() + 1) == 2) {
                JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
            } else {
                ventaPorJornada(mes, cmbCaja.getSelectedIndex() + 1);
                calculos(2);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }//GEN-LAST:event_btnVentaJornadaActionPerformed

    private void btnExcelJornadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelJornadasActionPerformed
        try {
            int filas = tblVentasJornada.getRowCount();
            if (filas > 0) {
                int columnas = tblVentasJornada.getColumnCount();
                String[][] entrada = new String[filas][columnas];

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        entrada[i][j] = tblVentasJornada.getValueAt(i, j).toString();
                    }
                }

                String ruta = "C:\\Users\\MARCEL\\Desktop\\REPORTE-VENTA-JORNADA-" + new ManejadorFechas().getFechaActual() + ".xlsx";

                int res = new ReportesControl().generarExcel(entrada, ruta);

                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "REPORTE CREADO CON EXITO EN LA RUTA: " + ruta);
                } else {
                    JOptionPane.showMessageDialog(null, "EL DOCUMENTO NO TIENE PAGINAS");
                }
            } else {
                JOptionPane.showMessageDialog(null, "DEBE GENERAR DATOS (BOTON REVISAR), PARA EL REPORTE");
            }

        } catch (IOException ex) {
            Logger.getLogger(ReporteContadora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ReporteContadora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcelJornadasActionPerformed

    private void btnVentaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaTotalActionPerformed
        //302, 401
        formTotales.setVisible(true);
        formTotales.setBounds(450, 400, 315, 415);

        try {
            int mes = jmcMeses.getMonth() + 1;

            Double totalGeneral1 = getTotales(mes, 3);
            Double totalGeneral2 = getTotales(mes, 4);
            Double totalVip = getTotales(mes, 5);
            Double totalEntradas = getTotales(mes, 2);

            txtMesTotales.setText(meses(mes));

            txtGeneral1.setText("" + v.Redondear(totalGeneral1));
            txtGeneral2.setText("" + v.Redondear(totalGeneral2));
            txtVip.setText("" + v.Redondear(totalVip));
            txtEntradas.setText("" + v.Redondear(totalEntradas));

            Double total = totalGeneral1 + totalGeneral2 + totalVip + totalEntradas;
            Double igv = total * 0.18;

            txtGraciasTotales.setText("" + v.Redondear(total));
            txtIgvTotalMes.setText("" + v.Redondear(igv));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }//GEN-LAST:event_btnVentaTotalActionPerformed

    private void pruebaPOIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebaPOIActionPerformed
        try {
            int filas = tblResumenProductos.getRowCount();
            if (filas > 0) {
                int columnas = tblResumenProductos.getColumnCount();

                String[] titulos = {"PRODUCTO", "PRECIO. U", "CANTIDAD", "SUBTOTAL"};
                Object[][] entrada = new Object[filas][columnas];

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        entrada[i][j] = tblResumenProductos.getValueAt(i, j);
                    }
                }

                String ruta = "C:\\Users\\MARCEL\\Desktop\\REPORTE-VENTA-PRODUCTOS-" + new ManejadorFechas().getFechaActual() + ".xlsx";

                ApachePOIExcelWrite ape = new ApachePOIExcelWrite(titulos, entrada, ruta);

                if (ape.CrearExcel()) {
                    JOptionPane.showMessageDialog(null, "REPORTE CREADO CON EXITO EN LA RUTA: " + ruta);
                } else {
                    JOptionPane.showMessageDialog(null, "EL DOCUMENTO NO TIENE PAGINAS");
                }
            } else {
                JOptionPane.showMessageDialog(null, "DEBE GENERAR DATOS (BOTON REVISAR), PARA CREAR EL REPORTE");
            }

        } catch (Exception ex) {
            Logger.getLogger(ReporteContadora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pruebaPOIActionPerformed

    private void pruebaPOIDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebaPOIDetallesActionPerformed
        try {
            int filas = tblDatos.getRowCount();
            if (filas > 0) {
                int columnas = tblDatos.getColumnCount();

                String[] titulos = {"FECHA", "DOCUMENTO", "SERIE", "VENTA", "BASE-IMP", "IGV", "SUBTOTAL"};
                Object[][] entrada = new Object[filas][columnas];

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        entrada[i][j] = tblDatos.getValueAt(i, j);
                    }
                }

                String ruta = "C:\\Users\\MARCEL\\Desktop\\REPORTE-DETALLES-" + new ManejadorFechas().getFechaActual() + ".xlsx";

                ApachePOIExcelWrite ape = new ApachePOIExcelWrite(titulos, entrada, ruta);

                if (ape.CrearExcel()) {
                    JOptionPane.showMessageDialog(null, "REPORTE CREADO CON EXITO EN LA RUTA: " + ruta);
                } else {
                    JOptionPane.showMessageDialog(null, "EL DOCUMENTO NO TIENE PAGINAS");
                }
            } else {
                JOptionPane.showMessageDialog(null, "DEBE GENERAR DATOS (BOTON REVISAR), PARA CREAR EL REPORTE");
            }

        } catch (Exception ex) {
            Logger.getLogger(ReporteContadora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pruebaPOIDetallesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcelJornadas;
    private javax.swing.JButton btnRevisar;
    private javax.swing.JButton btnVentaJornada;
    private javax.swing.JButton btnVentaTotal;
    private javax.swing.JComboBox<String> cmbCaja;
    private javax.swing.JDialog formTotales;
    private javax.swing.JDialog formVentaJornada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private com.toedter.calendar.JMonthChooser jmcMeses;
    private javax.swing.JButton pruebaPOI;
    private javax.swing.JButton pruebaPOIDetalles;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTable tblResumenProductos;
    private javax.swing.JTable tblVentasJornada;
    private javax.swing.JTextField txtEntradas;
    private javax.swing.JTextField txtGeneral1;
    private javax.swing.JTextField txtGeneral2;
    private javax.swing.JTextField txtGraciasTotales;
    private javax.swing.JTextField txtIgvAcumulado;
    private javax.swing.JTextField txtIgvTotalMes;
    private javax.swing.JTextField txtMesTotales;
    private javax.swing.JTextField txtTotalJornadas;
    private javax.swing.JTextField txtTotalVentas;
    private javax.swing.JTextField txtVip;
    // End of variables declaration//GEN-END:variables

    //ventas detalladas segun mes y serie
    public void ventaMes(int mes, int serie) throws Exception {
        LimpiarTabla(tblDatos, modeloTablaVentas);
        Conexion con = new Conexion();
        try {
            Object[] datos = new Object[7];
            con.conectar();
            String sql = "";
            String sigla = "";
            switch (serie) {
                case 1:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 3:
                    sql = "select venta.fecha,\"TICKET\" ,\"003\",venta.idventa ,sum(round((ventaproducto.subtotal/1.18),2)) as 'BASE-IMP',sum(round(((ventaproducto.subtotal/1.18)*0.18),2)) as 'IGV' ,sum(ventaproducto.subtotal) \n"
                            + "from venta\n"
                            + "inner join ventaproducto on venta.idventa = ventaproducto.idventa\n"
                            + "where month(fechasistema) = " + mes + "  \n"
                            + "group by venta.idventa";
                    sigla = "3";
                    break;
                case 4:
                    sql = "select venta2.fecha,\"TICKET\" ,\"004\",venta2.idventa2, sum(round((ventaproducto2.subtotal/1.18),2)) as 'BASE-IMP', sum(round(((ventaproducto2.subtotal/1.18)*0.18),2)) as 'IGV' ,sum(ventaproducto2.subtotal)\n"
                            + "from venta2\n"
                            + "inner join ventaproducto2 on venta2.idventa2 = ventaproducto2.idventa\n"
                            + "where month(fechasistema) = " + mes + " \n"
                            + "group by venta2.idventa2";
                    sigla = "4";
                    break;
                case 5:
                    sql = "select venta3.fecha,\"TICKET\" ,\"005\",venta3.idventa3, sum(round((ventaproducto3.subtotal/1.18),2)) as 'BASE-IMP',sum(round(((ventaproducto3.subtotal/1.18)*0.18),2)) as 'IGV' ,sum(ventaproducto3.subtotal) \n"
                            + "from venta3\n"
                            + "inner join ventaproducto3 on venta3.idventa3 = ventaproducto3.idventa\n"
                            + "where month(fechasistema) = " + mes + " \n"
                            + "group by venta3.idventa3";
                    sigla = "5";
                    break;
            }
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            //pst.setInt(1, mes);

            ResultSet rs = pst.executeQuery();
            //estructura para contadora
            //FECHA-TIPODOCUMENTO-SERIE-NROVENTA-BASEIMPONIBLE(/1.18)-IGV(*0.18)-IMPORTETOTAL
            while (rs.next()) {
                datos[0] = rs.getString(1); // fecha de la venta
                datos[1] = "TICKET";//tipo documento
                datos[2] = "00" + sigla;//serie
                datos[3] = rs.getInt(4);// nro de ticket
                datos[4] = rs.getDouble(5); // base imponible
                datos[5] = rs.getDouble(6);
                datos[6] = rs.getDouble(7); // importe
                modeloTablaVentas.addRow(datos);
            }
            tblDatos.setModel(modeloTablaVentas);
            columnsSize(1);
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            con.cerrar();
        }
    }

    //ventas por producto
    public void ventaPorProducto(int mes, int serie) throws Exception {
        LimpiarTabla(tblResumenProductos, modeloTablaResumenProductos);
        Conexion con = new Conexion();
        try {
            Object[] datos = new Object[4];
            con.conectar();
            String sql = "";
            switch (serie) {
                case 1:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 3:
                    sql = "select producto.nombre,ventaproducto.preciou, sum(ventaproducto.cantidad), sum(subtotal) \n"
                            + "from venta \n"
                            + "inner join ventaproducto on venta.idventa = ventaproducto.idventa\n"
                            + "inner join producto on ventaproducto.idproducto = producto.idproducto\n"
                            + "where month(venta.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    break;
                case 4:
                    sql = "select producto.nombre,ventaproducto2.preciou, sum(ventaproducto2.cantidad), sum(subtotal) \n"
                            + "from venta2 \n"
                            + "inner join ventaproducto2 on venta2.idventa2 = ventaproducto2.idventa\n"
                            + "inner join producto on ventaproducto2.idProducto = producto.idproducto\n"
                            + "where month(venta2.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    break;
                case 5:
                    sql = "select producto.nombre,ventaproducto3.preciou, sum(ventaproducto3.cantidad), sum(subtotal) \n"
                            + "from venta3\n"
                            + "inner join ventaproducto3 on venta3.idventa3 = ventaproducto3.idventa\n"
                            + "inner join producto on ventaproducto3.idProducto = producto.idproducto\n"
                            + "where month(venta3.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    break;
            }
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            //pst.setInt(1, mes);

            ResultSet rs = pst.executeQuery();
            //estructura para contadora
            //FECHA-TIPODOCUMENTO-SERIE-NROVENTA-BASEIMPONIBLE(/1.18)-IGV(*0.18)-IMPORTETOTAL
            while (rs.next()) {
                datos[0] = rs.getString(1); // producto
                datos[1] = rs.getDouble(2);//precio u
                datos[2] = rs.getInt(3);//cantidad
                datos[3] = rs.getDouble(4);// subtotal
                modeloTablaResumenProductos.addRow(datos);
            }
            tblResumenProductos.setModel(modeloTablaResumenProductos);
            columnsSize(2);
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            con.cerrar();
        }
    }

    //detalle de ventas en entrada
    public void ventasEntrada(int mes, int serie) throws Exception {
        LimpiarTabla(tblDatos, modeloTablaVentas);
        Conexion con = new Conexion();
        try {
            Object[] datos = new Object[7];
            con.conectar("localhost", "mrjuerga_entradas");
            String sql = "";
            switch (serie) {
                case 1:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 2:
                    sql = "select venta.fecha, \"TICKET\",\"002\",venta.idventa, round((sum(ventaentrada.total)/1.18),2) as 'BASE-IMP', (round((sum(ventaentrada.total)/1.18),2))*0.18 as 'IGV', ventaentrada.total\n"
                            + "from venta\n"
                            + "inner join ventaentrada on venta.idventa = ventaentrada.venta_idventa\n"
                            + "where month(venta.fechasistema)= " + mes + " \n"
                            + "group by venta.idventa";
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
            }
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            //pst.setInt(1, mes);

            ResultSet rs = pst.executeQuery();
            //estructura para contadora
            //FECHA-TIPODOCUMENTO-SERIE-NROVENTA-BASEIMPONIBLE(/1.18)-IGV(*0.18)-IMPORTETOTAL
            while (rs.next()) {
                datos[0] = rs.getString(1); // fecha de la venta
                datos[1] = "TICKET";//tipo documento
                datos[2] = "002";//serie
                datos[3] = rs.getInt(4);// nro de ticket
                datos[4] = rs.getDouble(5); // base imponible
                datos[5] = rs.getDouble(6);//igv
                datos[6] = rs.getDouble(7); // importe
                modeloTablaVentas.addRow(datos);
            }
            tblDatos.setModel(modeloTablaVentas);
            columnsSize(1);
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            con.cerrar();
        }
    }

    //ventas por producto
    public void ventaEntradaPorProducto(int mes, int serie) throws Exception {
        LimpiarTabla(tblResumenProductos, modeloTablaResumenProductos);
        Conexion con = new Conexion();
        try {
            Object[] datos = new Object[4];
            con.conectar("localhost", "mrjuerga_entradas");
            String sql = "";
            switch (serie) {
                case 1:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 2:
                    sql = "select producto.nombre,count(ventaentrada.idproducto),sum(ventaentrada.numPersonas),sum(ventaentrada.total), ventaentrada.idproducto\n"
                            + "from venta\n"
                            + "inner join ventaentrada on venta.idventa = ventaentrada.venta_idventa\n"
                            + "inner join producto on ventaentrada.idproducto = producto.idproducto\n"
                            + "where month(fechasistema) = " + mes + " \n"
                            + "group by ventaentrada.idproducto";
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
            }
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            //pst.setInt(1, mes);

            ResultSet rs = pst.executeQuery();
            //estructura para contadora
            //FECHA-TIPODOCUMENTO-SERIE-NROVENTA-BASEIMPONIBLE(/1.18)-IGV(*0.18)-IMPORTETOTAL
            while (rs.next()) {
                datos[0] = rs.getString(1); // producto
                datos[1] = rs.getDouble(2);//precio u
                datos[2] = rs.getInt(3);//cantidad
                datos[3] = rs.getDouble(4);// subtotal
                modeloTablaResumenProductos.addRow(datos);
            }
            tblResumenProductos.setModel(modeloTablaResumenProductos);
            columnsSize(2);
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            con.cerrar();
        }
    }

    //ventas jornada segun mes y serie
    public void ventaPorJornada(int mes, int serie) throws Exception {
        LimpiarTabla(tblVentasJornada, modeloTablaJornadas);
        Conexion con = new Conexion();
        try {
            Object[] datos = new Object[5];
            con.conectar();
            String sql = "";
            switch (serie) {
                case 1:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 3:
                    sql = "select flujocaja.fecha_inicio, flujocaja.fecha_final, min(venta.idventa),max(venta.idventa), sum(ventaproducto.subtotal) from venta\n"
                            + "inner join ventaproducto on venta.idventa = ventaproducto.idventa\n"
                            + "inner join flujocaja on venta.idflujocaja = flujocaja.idflujocaja\n"
                            + "where month(venta.fechasistema) = " + mes + " \n"
                            + "group by venta.idflujocaja";
                    break;
                case 4:
                    sql = "select flujocaja.fecha_inicio, flujocaja.fecha_final,min(venta2.idventa2),max(venta2.idventa2), sum(ventaproducto2.subtotal) from venta2\n"
                            + "inner join ventaproducto2 on venta2.idventa2 = ventaproducto2.idventa\n"
                            + "inner join flujocaja on venta2.idflujocaja = flujocaja.idflujocaja\n"
                            + "where month(venta2.fechasistema) = " + mes + " \n"
                            + "group by venta2.idflujocaja";
                    break;
                case 5:
                    sql = "select flujocaja.fecha_inicio, flujocaja.fecha_final,min(venta3.idventa3),max(venta3.idventa3), sum(ventaproducto3.subtotal) from venta3\n"
                            + "inner join ventaproducto3 on venta3.idventa3 = ventaproducto3.idventa\n"
                            + "inner join flujocaja on venta3.idflujocaja = flujocaja.idflujocaja\n"
                            + "where month(venta3.fechasistema) = " + mes + " \n"
                            + "group by venta3.idflujocaja";
                    break;
            }
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            //pst.setInt(1, mes);

            ResultSet rs = pst.executeQuery();
            //estructura para contadora
            //FECHA-TIPODOCUMENTO-SERIE-NROVENTA-BASEIMPONIBLE(/1.18)-IGV(*0.18)-IMPORTETOTAL
            while (rs.next()) {
                datos[0] = rs.getString(1); // fecha inicio
                datos[1] = rs.getString(2);//fecha fin
                datos[2] = rs.getInt(3);//ticket inicio
                datos[3] = rs.getInt(4);// ticket fin
                datos[4] = rs.getDouble(5); // subtotal

                modeloTablaJornadas.addRow(datos);
            }
            tblVentasJornada.setModel(modeloTablaJornadas);
            columnsSize(3);
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            con.cerrar();
        }
    }

    private double getTotales(int mes, int serie) throws SQLException {
        Conexion con = new Conexion();
        try {
            String sql = "";
            switch (serie) {
                case 1:
                    JOptionPane.showMessageDialog(null, "UNSUPPORTED YET");
                    break;
                case 2:
                    con.conectar("localhost", "mrjuerga_entradas");
                    sql = "SELECT sum(total) FROM ventaentrada\n"
                            + "WHERE month(fecha) = " + mes + " ";
                    break;
                case 3:
                    con.conectar();
                    sql = "SELECT sum(ventaproducto.subtotal) FROM venta\n"
                            + "INNER JOIN ventaproducto ON venta.idventa = ventaproducto.idventa\n"
                            + "WHERE month(venta.fechasistema) = " + mes + " ";
                    break;
                case 4:
                    con.conectar();
                    sql = "SELECT sum(ventaproducto2.subtotal) FROM venta2\n"
                            + "INNER JOIN ventaproducto2 ON venta2.idventa2 = ventaproducto2.idventa\n"
                            + "WHERE month(venta2.fechasistema) = " + mes + "";
                    break;
                case 5:
                    con.conectar();
                    sql = "SELECT sum(ventaproducto3.subtotal) FROM venta3\n"
                            + "INNER JOIN ventaproducto3 ON venta3.idventa3 = ventaproducto3.idventa\n"
                            + "WHERE month(venta3.fechasistema) = " + mes + " ";
                    break;
            }
            PreparedStatement pst = con.getConexion().prepareStatement(sql);

            ResultSet res = pst.executeQuery();

            if (res.next()) {
                return res.getDouble(1);
            }

        } catch (Exception e) {
        } finally {
            con.cerrar();
        }
        return 0.0;
    }

}

package Vista;

import Controlador.ApachePOIExcelWrite;
import Controlador.ColumnasTablas;
import Controlador.Cronometro;
import Controlador.JTableControl;
import Controlador.ManejadorFechas;
import Modelo.Caja;
import Modelo.Conexion;
import Modelo.FlujoCaja;
import Modelo.MySQLDAO.CajaDAO;
import Modelo.MySQLDAO.FlujoCajaDAO;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author G0by
 */
public class FujosDeCaja extends javax.swing.JInternalFrame {

    JTableControl jcVentaProducto = null;

    public FujosDeCaja(String usuario) throws Exception {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        new Cronometro().iniciarCronometro(txtHora);
        txtFecha.setText(new ManejadorFechas().getFechaActual());
        txtUsuario1.setText(usuario);
        cargarComboCajas();

        String titulos[] = {"PRODUCTO", "PRESENTACION", "CANTIDAD", "SUBTOTAL"};

        jcVentaProducto = new JTableControl(titulos, tblVentaProducto);

        jcVentaProducto.llenarTitulos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jcCalendario = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentaProducto = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblCierre = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lblInicio = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnVerFlujoDelDia = new javax.swing.JButton();
        btnCrearExcel = new javax.swing.JButton();
        cmbCaja = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblGastos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMaster = new javax.swing.JLabel();
        lblVisa = new javax.swing.JLabel();
        lblDescuadre = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        txtUsuario1 = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();

        jPanel6.setBackground(new java.awt.Color(0, 0, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 51, 0));
        jLabel39.setText("DISCOTECK");
        jPanel6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, -1, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel12.setText("DISCOTECK");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(832, 0, -1, -1));

        jLabel40.setBackground(new java.awt.Color(0, 0, 0));
        jLabel40.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("MISTER JUERGA");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, -1, -1));

        jLabel41.setBackground(new java.awt.Color(0, 0, 0));
        jLabel41.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel41.setText("MISTER JUERGA");
        jPanel6.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 0, -1, -1));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("VENTAS DIARIAS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcCalendario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jcCalendario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(jcCalendario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 370, 290));

        tblVentaProducto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblVentaProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblVentaProducto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 530, 400));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CAJA");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 370, 30));

        jPanel5.setBackground(new java.awt.Color(51, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCierre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCierre.setForeground(new java.awt.Color(255, 255, 255));
        lblCierre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCierre.setText("...");
        jPanel5.add(lblCierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 150, 30));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("FLUJO DE CAJA ECONOMICO");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CIERRE:");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 60, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 530, 30));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInicio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInicio.setText("...");
        jPanel8.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 130, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("DETALLE DE INGRESOS");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("INICIO:");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 530, 30));

        lblTotal.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("....");
        jPanel1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 600, 130, -1));

        btnVerFlujoDelDia.setBackground(new java.awt.Color(0, 153, 0));
        btnVerFlujoDelDia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVerFlujoDelDia.setForeground(new java.awt.Color(255, 255, 255));
        btnVerFlujoDelDia.setText("VER FLUJO");
        btnVerFlujoDelDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerFlujoDelDiaActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerFlujoDelDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 200, 40));

        btnCrearExcel.setBackground(new java.awt.Color(204, 204, 204));
        btnCrearExcel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCrearExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/excel.png"))); // NOI18N
        btnCrearExcel.setText("Reporte Excel");
        btnCrearExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearExcelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 200, 40));

        cmbCaja.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.add(cmbCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 370, 30));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("FECHA INICIAL");
        jPanel7.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 30));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 370, 30));

        lblGastos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblGastos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGastos.setText("...");
        jPanel1.add(lblGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 570, 70, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("TOTAL S/.:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 600, -1, -1));

        lblMaster.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblMaster.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblMaster.setText("...");
        jPanel1.add(lblMaster, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 540, 70, -1));

        lblVisa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblVisa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblVisa.setText("...");
        jPanel1.add(lblVisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, 70, -1));

        lblDescuadre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDescuadre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDescuadre.setText("...");
        jPanel1.add(lblDescuadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 600, 70, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("VISA:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 510, 100, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("MASTERCARD:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 540, 100, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("GASTOS:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, 100, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("DESCUADRE:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 600, 100, -1));

        jTabbedPane1.addTab("DIARIO", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 930, 660));

        jPanel20.setBackground(new java.awt.Color(0, 153, 204));
        jPanel20.setForeground(new java.awt.Color(255, 255, 255));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("VENTAS POR DIA");
        jPanel20.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 30));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caja-reg.png"))); // NOI18N
        jPanel20.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        getContentPane().add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 70));

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario1.setEditable(false);
        txtUsuario1.setBackground(new java.awt.Color(51, 51, 51));
        txtUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel21.add(txtUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(51, 51, 51));
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel21.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 90, -1));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(51, 51, 51));
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel21.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 100, -1));

        getContentPane().add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 730, 940, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerFlujoDelDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerFlujoDelDiaActionPerformed
        try {
            jcVentaProducto.LimpiarTabla();

            Date d = jcCalendario.getDate();
            String fecha = obtenerFecha(d);

            Caja caja = (Caja) cmbCaja.getSelectedItem();

            System.out.println("ID caja: " + caja.getIdCaja());
            System.out.println("Fecha: " + fecha);

            FlujoCajaDAO fdao = new FlujoCajaDAO();

            //obtener el idflujocaja
            int idFlujoCaja = fdao.getIdFlujo(fecha, caja.getIdCaja());

            FlujoCaja fc = fdao.Obtener(idFlujoCaja);

            ventasDia(fecha, caja.getIdCaja());

            lblCierre.setText(fc.getFechaFinal());
            lblVisa.setText("" + fc.getVisa());
            lblMaster.setText("" + fc.getMaster());
            lblGastos.setText("" + fc.getEgresos());
            lblDescuadre.setText("" + fc.getDescuadre());
            lblTotal.setText("" + totalVenta());

            lblInicio.setText(fecha);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnVerFlujoDelDiaActionPerformed

    private void btnCrearExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearExcelActionPerformed
        try {
            int filas = tblVentaProducto.getRowCount();
            if (filas > 0) {
                int columnas = tblVentaProducto.getColumnCount();

                String[] titulos = {"PRODUCTO", "PRESENTACION", "CANTIDAD", "SUBTOTAL"};
                Object[][] entrada = new Object[filas][columnas];

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        entrada[i][j] = tblVentaProducto.getValueAt(i, j);
                    }
                }

                
                //matriz de los datos totales
                Object[][] totales = {
                    {"VISA", Double.parseDouble(lblVisa.getText())},
                    {"MASTERCARD", Double.parseDouble(lblMaster.getText())},
                    {"GASTOS", Double.parseDouble(lblGastos.getText())},
                    {"DESCUADRE", Double.parseDouble(lblDescuadre.getText())},
                    {"TOTAL", Double.parseDouble(lblTotal.getText())}
                };

                String ruta = "D:\\reportes contables\\REPORTE-VENTA DIARIA-PRODUCTOS-" + new ManejadorFechas().getFechaActual() + ".xlsx";

                ApachePOIExcelWrite ape = new ApachePOIExcelWrite(titulos, entrada, ruta);

                if (ape.CrearExcel(totales)) {
                    JOptionPane.showMessageDialog(null, "REPORTE CREADO CON EXITO EN LA RUTA: " + ruta);
                } else {
                    JOptionPane.showMessageDialog(null, "EL DOCUMENTO NO TIENE PAGINAS");
                }
            } else {
                JOptionPane.showMessageDialog(null, "DEBE GENERAR DATOS (BOTON VER FLUJO), PARA CREAR EL REPORTE");
            }

        } catch (Exception ex) {
            Logger.getLogger(ReporteContadora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCrearExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearExcel;
    private javax.swing.JButton btnVerFlujoDelDia;
    private javax.swing.JComboBox<Caja> cmbCaja;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.toedter.calendar.JCalendar jcCalendario;
    private javax.swing.JLabel lblCierre;
    private javax.swing.JLabel lblDescuadre;
    private javax.swing.JLabel lblGastos;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblMaster;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblVisa;
    private javax.swing.JTable tblVentaProducto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtUsuario1;
    // End of variables declaration//GEN-END:variables

    public String obtenerFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String f = sdf.format(fecha);
        return f;
    }

    public void cargarComboCajas() throws Exception {
        CajaDAO cdao = new CajaDAO();
        for (Caja c : cdao.Listar()) {
            cmbCaja.addItem(c);
        }
    }

    //ventas detalladas segun dia y serie
    public void ventasDia(String fecha_inicial, int idCaja) throws Exception {
        Conexion con = new Conexion();
        try {
            Object[] datos = new Object[4];
            con.conectar();
            String sql = "";
            switch (idCaja) {
                case 1://jaime
                    sql = "select producto.nombre,presentacion.descripcion,sum(ventaentrada.numCovers) as cantcover, sum(ventaentrada.total) as total \n"
                            + "    from entradageneral\n"
                            + "    inner join ventaentrada on entradageneral.identradageneral = ventaentrada.venta_idventa\n"
                            + "    inner join productopresentacion on ventaentrada.idproducto = productopresentacion.idproductopresentacion\n"
                            + "    inner join producto on productopresentacion.idproducto = producto.idproducto\n"
                            + "    inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                            + "    inner join flujocaja on entradageneral.idflujocaja = flujocaja.idflujocaja\n"
                            + "    where flujocaja.fecha_inicio =  ?  \n"
                            + "    group by producto.nombre";

                    break;
                case 2://burro
                    sql = "select producto.nombre,presentacion.descripcion,if(producto.nombre = 'BOX',sum(ventaentradavip.numPersonas),count(ventaentradavip.numPersonas)) as cantidad,sum(ventaentradavip.total) AS subtotal \n"
                            + "    from entradavip\n"
                            + "    inner join ventaentradavip on entradavip.identradavip = ventaentradavip.venta_idventa\n"
                            + "    inner join productopresentacion on ventaentradavip.idproducto = productopresentacion.idproductopresentacion\n"
                            + "    inner join producto on productopresentacion.idproducto = producto.idproducto\n"
                            + "    inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                            + "    inner join flujocaja on entradavip.idflujocaja = flujocaja.idflujocaja\n"
                            + "    where flujocaja.fecha_inicio = ? \n"
                            + "    group by producto.nombre";
                    break;
                case 3://caja 01
                    sql = "select p.nombre, pre.descripcion, sum(vp.cantidad), sum(vp.subtotal)\n"
                            + "    from venta v\n"
                            + "    inner join ventaproducto vp on v.idventa = vp.idventa\n"
                            + "    inner join productopresentacion pp on vp.idproducto = pp.idproductopresentacion\n"
                            + "    inner join producto p on pp.idproducto = p.idproducto\n"
                            + "    inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "    inner join flujocaja fc on v.idflujocaja = fc.idflujocaja\n"
                            + "    where fc.fecha_inicio = ? \n"
                            + "    group by pp.idproductopresentacion";
                    break;
                case 4://caja 02
                    sql = "select p.nombre, pre.descripcion, sum(vp.cantidad), sum(vp.subtotal)\n"
                            + "    from venta2 v\n"
                            + "    inner join ventaproducto2 vp on v.idventa2 = vp.idventa\n"
                            + "    inner join productopresentacion pp on vp.idproducto = pp.idproductopresentacion\n"
                            + "    inner join producto p on pp.idproducto = p.idproducto\n"
                            + "    inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "    inner join flujocaja fc on v.idflujocaja = fc.idflujocaja\n"
                            + "    where fc.fecha_inicio = ? \n"
                            + "    group by pp.idproductopresentacion";
                    break;
                case 5://caja vip
                    sql = "select p.nombre, pre.descripcion, sum(vp.cantidad), sum(vp.subtotal)\n"
                            + "    from venta3 v\n"
                            + "    inner join ventaproducto3 vp on v.idventa3 = vp.idventa\n"
                            + "    inner join productopresentacion pp on vp.idproducto = pp.idproductopresentacion\n"
                            + "    inner join producto p on pp.idproducto = p.idproducto\n"
                            + "    inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "    inner join flujocaja fc on v.idflujocaja = fc.idflujocaja\n"
                            + "    where fc.fecha_inicio = ? \n"
                            + "    group by pp.idproductopresentacion";
                    break;
                case 6://entrada general 2
                    sql = "select producto.nombre,presentacion.descripcion,sum(ventaentrada2.numCovers) as cantcover, sum(ventaentrada2.total) as total \n"
                            + "    from entradageneral2\n"
                            + "    inner join ventaentrada2 on entradageneral2.identradageneral2 = ventaentrada2.venta_idventa\n"
                            + "    inner join productopresentacion on ventaentrada2.idproducto = productopresentacion.idproductopresentacion\n"
                            + "    inner join producto on productopresentacion.idproducto = producto.idproducto\n"
                            + "    inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                            + "    inner join flujocaja on entradageneral2.idflujocaja = flujocaja.idflujocaja\n"
                            + "    where flujocaja.fecha_inicio = ? \n"
                            + "    group by producto.nombre";
                    break;
            }
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            pst.setString(1, fecha_inicial);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1); // producto
                datos[1] = rs.getString(2);//presentacion
                datos[2] = rs.getInt(3);//cantidad
                datos[3] = rs.getDouble(4);// subtotal

                jcVentaProducto.getModelo().addRow(datos);
            }
            tblVentaProducto.setModel(jcVentaProducto.getModelo());

            new ColumnasTablas().cuatroColumnas(tblVentaProducto, 200, 100, 50, 50);

            rs.close();
            pst.close();
        } catch (Exception e) {
            System.out.println("Error mysql: " + e.getMessage());
        } finally {
            con.cerrar();
        }
    }

    private double totalVenta() {
        Double visa = Double.parseDouble(lblVisa.getText());
        Double master = Double.parseDouble(lblMaster.getText());
        Double egresos = Double.parseDouble(lblGastos.getText());
        Double descuadre = Double.parseDouble(lblDescuadre.getText());

        Double ventas = 0.0;

        for (int i = 0; i < tblVentaProducto.getRowCount(); i++) {
            ventas += Double.parseDouble(tblVentaProducto.getValueAt(i, 3).toString());
        }

        return (ventas - (visa + master + egresos)) + descuadre;

    }

}

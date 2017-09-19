/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Cronometro;
import Controlador.FormatoFechas;
import Controlador.ManejadorFechas;
import Modelo.MySQLDAO.MovimientoDAO;
import Modelo.MySQLDAO.MovimientoProductoDAO;
import Modelo.MySQLDAO.PresentacionDAO;
import Modelo.MySQLDAO.ProductoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARCEL
 */
public class BuscarNotaCompra extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTablaMovimientos;
    DefaultTableModel modeloDetalleMovimiento;

    /**
     * Creates new form BuscarNotaCompra
     */
    public BuscarNotaCompra(String usuario) {
        initComponents();
        txtUsuario.setText(usuario);
        txtFecha.setText(new ManejadorFechas().getFechaActual());
        new Cronometro().iniciarCronometro(txtHora);
        titulos();
        titulosDetalles();
    }

    public void titulos() {
        String titulos[] = {"ID","N° NOTA" ,"FECHA", "HORA", "USUARIO"};
        modeloTablaMovimientos = new DefaultTableModel(null, titulos);
        tblNotaPedido.setModel(modeloTablaMovimientos);
    }
    
    public void titulosDetalles() {
        String titulos[] = {"PRODUCTO","PRESENTACION","CANTIDAD"};
        modeloDetalleMovimiento = new DefaultTableModel(null, titulos);
        tblDetalle.setModel(modeloDetalleMovimiento);
    }

    public void limpiarTablaNotaPedido() {
        for (int i = 0; i < tblNotaPedido.getRowCount(); i++) {
            modeloTablaMovimientos.removeRow(i);
            i -= 1;
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

        DetalleNotaPedido = new javax.swing.JDialog();
        jLabel7 = new javax.swing.JLabel();
        txtProveedor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        btnAceptar = new javax.swing.JButton();
        ConsolidacionFactura = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        txtProveedorConsolidado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCancelarRegistro = new javax.swing.JButton();
        btnRegCompra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNotaPedido = new javax.swing.JTextField();
        btnBuscarFechas = new javax.swing.JButton();
        jdcInicio = new com.toedter.calendar.JDateChooser();
        jdcFin = new com.toedter.calendar.JDateChooser();
        btnBuscarNotaPedido = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnConsolidarCompra = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNotaPedido = new javax.swing.JTable();

        DetalleNotaPedido.setTitle("DETALLE DE NOTA DE PEDIDO");
        DetalleNotaPedido.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("PROVEEDOR");
        DetalleNotaPedido.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        DetalleNotaPedido.getContentPane().add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 110, -1));

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDetalle);

        DetalleNotaPedido.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 380, 220));

        btnAceptar.setBackground(new java.awt.Color(102, 102, 102));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("ACEPTAR");
        DetalleNotaPedido.getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        ConsolidacionFactura.setTitle("CONSOLIDACION DE FACTURA");
        ConsolidacionFactura.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("PROVEEDOR");
        ConsolidacionFactura.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, -1));
        ConsolidacionFactura.getContentPane().add(txtProveedorConsolidado, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 270, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("SERIE");
        ConsolidacionFactura.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, -1));
        ConsolidacionFactura.getContentPane().add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 110, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("FECHA");
        ConsolidacionFactura.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 70, -1));
        ConsolidacionFactura.getContentPane().add(txtFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 110, -1));
        ConsolidacionFactura.getContentPane().add(jdcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 270, -1));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("N° FACTURA");
        ConsolidacionFactura.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 70, -1));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelarRegistro.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelarRegistro.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelarRegistro.setText("CANCELAR");
        jPanel2.add(btnCancelarRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 140, -1));

        btnRegCompra.setBackground(new java.awt.Color(102, 102, 102));
        btnRegCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnRegCompra.setText("REGISTRAR COMPRA");
        jPanel2.add(btnRegCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        ConsolidacionFactura.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 360, 100));

        setClosable(true);
        setTitle("BUSCAR NOTA DE PEDIDO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("FIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, -1));
        getContentPane().add(txtNotaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, -1));

        btnBuscarFechas.setText("BUSCAR");
        btnBuscarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechasActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));
        getContentPane().add(jdcInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 130, -1));
        getContentPane().add(jdcFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 130, -1));

        btnBuscarNotaPedido.setText("BUSCAR");
        btnBuscarNotaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarNotaPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarNotaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel2.setText("HORA");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, -1, -1));

        jLabel3.setText("INICIO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(102, 102, 102));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("CANCELAR");
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        btnConsolidarCompra.setBackground(new java.awt.Color(102, 102, 102));
        btnConsolidarCompra.setForeground(new java.awt.Color(255, 255, 255));
        btnConsolidarCompra.setText("CONSOLIDAR COMPRA");
        btnConsolidarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsolidarCompraActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsolidarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 240, 580, 100));

        jLabel4.setText("NOTA DE PEDIDO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel5.setText("USUARIO");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, -1, -1));

        jLabel6.setText("FECHA");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, -1, -1));

        txtHora.setBorder(null);
        getContentPane().add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 120, 20));

        txtUsuario.setBorder(null);
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 120, 20));

        txtFecha.setBorder(null);
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 120, 20));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 580, 10));

        tblNotaPedido = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblNotaPedido.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 14)); // NOI18N
        tblNotaPedido.setForeground(new java.awt.Color(51, 51, 51));
        tblNotaPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNotaPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNotaPedidoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNotaPedido);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 550, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarNotaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarNotaPedidoActionPerformed
        limpiarTablaNotaPedido();

        String notaPedido = txtNotaPedido.getText();
        MovimientoDAO mdao = new MovimientoDAO();

        try {
            Object datos[] = new Object[5];

            datos[0] = mdao.obtenerPorNotaPedido(notaPedido).getIdMovimiento();
            datos[1] = mdao.obtenerPorNotaPedido(notaPedido).getNumNota();
            datos[2] = mdao.obtenerPorNotaPedido(notaPedido).getFecha();
            datos[3] = mdao.obtenerPorNotaPedido(notaPedido).getHora();
            datos[4] = mdao.obtenerPorNotaPedido(notaPedido).getUsuario();

            modeloTablaMovimientos.addRow(datos);

            tblNotaPedido.setModel(modeloTablaMovimientos);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_btnBuscarNotaPedidoActionPerformed

    private void btnBuscarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechasActionPerformed
        limpiarTablaNotaPedido();
        if (jdcInicio.getDate() != null || jdcFin.getDate() != null) {
            FormatoFechas ff = new FormatoFechas();
            String fechaInicial = ff.getFormatoFec(jdcInicio);
            String fechaFinal = ff.getFormatoFec(jdcFin);

            MovimientoDAO mdao = new MovimientoDAO();
            Object datos[] = new Object[5];
            try {
                int numFilas = mdao.buscarMovimientoPorFechas(fechaInicial, fechaFinal).size();

                for (int i = 0; i < numFilas; i++) {
                    datos[0] = mdao.buscarMovimientoPorFechas(fechaInicial, fechaFinal).get(i).getIdMovimiento();
                    datos[1] = mdao.buscarMovimientoPorFechas(fechaInicial, fechaFinal).get(i).getNumNota();
                    datos[2] = mdao.buscarMovimientoPorFechas(fechaInicial, fechaFinal).get(i).getFecha();
                    datos[3] = mdao.buscarMovimientoPorFechas(fechaInicial, fechaFinal).get(i).getHora();
                    datos[4] = mdao.buscarMovimientoPorFechas(fechaInicial, fechaFinal).get(i).getUsuario();

                    modeloTablaMovimientos.addRow(datos);
                }

                tblNotaPedido.setModel(modeloTablaMovimientos);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "DEBE INDICAR FECHA INICIAL Y FECHA FINAL NECESARIAMENTE");
        }


    }//GEN-LAST:event_btnBuscarFechasActionPerformed

    private void tblNotaPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNotaPedidoMouseClicked
        if (evt.getClickCount() == 2) {
            try {
                int fila = tblNotaPedido.getSelectedRow();
                int idMovimiento = Integer.parseInt(tblNotaPedido.getValueAt(fila, 0).toString());
                
                MovimientoProductoDAO mpdao = new MovimientoProductoDAO();
                ProductoDAO pdao = new ProductoDAO();
                PresentacionDAO predao = new PresentacionDAO();
                int numFilas = mpdao.Listar(idMovimiento).size();
                Object datos[] = new Object[3];
                
                for (int i = 0; i < numFilas; i++) {
                    
                    datos[0] = pdao.obtenerProducto(mpdao.Listar(idMovimiento).get(i).getIdProducto()).getNombre();
                    datos[1] = predao.obtenerPresentacion(mpdao.Listar(idMovimiento).get(i).getIdPresentacion());
                    datos[2] = mpdao.Listar(idMovimiento).get(i).getCantidad();
                    
                    modeloDetalleMovimiento.addRow(datos);
                }
                
                tblDetalle.setModel(modeloDetalleMovimiento);
                
                DetalleNotaPedido.setBounds(100, 300, 400, 350);
                DetalleNotaPedido.setVisible(true);
                                
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_tblNotaPedidoMouseClicked

    private void btnConsolidarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsolidarCompraActionPerformed
        int fila = tblNotaPedido.getSelectedRow();
        
        if (fila>=0) {
            ConsolidacionFactura.setVisible(true);
            ConsolidacionFactura.setBounds(100, 200, 400, 270);
        }else{
            JOptionPane.showMessageDialog(getRootPane(), "Seleccione una nota de pedido a modificar");
        }
    }//GEN-LAST:event_btnConsolidarCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ConsolidacionFactura;
    private javax.swing.JDialog DetalleNotaPedido;
    public javax.swing.JButton btnAceptar;
    public javax.swing.JButton btnBuscarFechas;
    public javax.swing.JButton btnBuscarNotaPedido;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCancelarRegistro;
    public javax.swing.JButton btnConsolidarCompra;
    public javax.swing.JButton btnRegCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public com.toedter.calendar.JDateChooser jdcFecha;
    public com.toedter.calendar.JDateChooser jdcFin;
    public com.toedter.calendar.JDateChooser jdcInicio;
    public javax.swing.JTable tblDetalle;
    private javax.swing.JTable tblNotaPedido;
    public javax.swing.JTextField txtFactura;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtHora;
    public javax.swing.JTextField txtNotaPedido;
    public javax.swing.JTextField txtProveedor;
    public javax.swing.JTextField txtProveedorConsolidado;
    public javax.swing.JTextField txtSerie;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

package Vista;

import Controlador.ContactoControl;
import Controlador.Cronometro;
import Modelo.Conexion;
import Modelo.Gasto;
import Modelo.MySQLDAO.GastoDAO;
import Controlador.FormatoFechas;
import Controlador.GastoControl;
import Controlador.ManejadorFechas;
import Controlador.MyiReportVisor;
import Controlador.Validaciones;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Adolfo
 */
public class Gastos extends javax.swing.JInternalFrame {

    String[] Titulos = {"ID", "CONCEPTO", "MONTO"};
    HashMap parametros;
    MyiReportVisor mrv;

    public Gastos(String usuario) throws Exception {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        txtConcepto.requestFocus();
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        new GastoControl().LlenarTablaGastos(tblGastos, Titulos);
        new Cronometro().iniciarCronometro(txtHora);
        txtFecha.setText(new ManejadorFechas().getFechaActual());
        txtUsuario1.setText(usuario);
        //lbltotal.setText(""+new GastoControl().MontoTotal(tblGastos));

        //new Validaciones().bloquear(btnRegistrar);
        //new Validaciones().bloquear(btnModificar);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtConcepto = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGastos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnReporte = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
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
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO DE EGRESOS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("CONCEPTO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel4.setText("MONTO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txtConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConceptoActionPerformed(evt);
            }
        });
        txtConcepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConceptoKeyTyped(evt);
            }
        });
        getContentPane().add(txtConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 190, -1));

        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 190, -1));

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/disquete.png"))); // NOI18N
        btnRegistrar.setText("GUARDAR");
        btnRegistrar.setBorder(null);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 90, 50));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/girar.png"))); // NOI18N
        btnModificar.setText("ACTUALIZAR");
        btnModificar.setBorder(null);
        btnModificar.setContentAreaFilled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 110, 40));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-eliminar.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(null);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 90, 40));

        tblGastos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblGastos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGastosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGastos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 590, 310));

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-archivo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorder(null);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(153, 0, 0)), "REGISTROS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresora.png"))); // NOI18N
        btnReporte.setText("IMPRIMIR");
        btnReporte.setToolTipText("");
        btnReporte.setBorder(null);
        btnReporte.setContentAreaFilled(false);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel2.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 100, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 630, 400));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 310, 130));

        jPanel8.setBackground(new java.awt.Color(102, 0, 0));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("PAGOS FIJOS");
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 30));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dinero.png"))); // NOI18N
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(102, 0, 0));
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 90, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(102, 0, 0));
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 90, -1));

        txtUsuario1.setEditable(false);
        txtUsuario1.setBackground(new java.awt.Color(102, 0, 0));
        txtUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 140, -1));

        jLabel24.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel24.setText("PAGOS FIJOS");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 20, -1, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 70));

        jPanel6.setBackground(new java.awt.Color(102, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 51, 0));
        jLabel26.setText("DISCOTECK");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, -1, -1));

        jLabel12.setBackground(new java.awt.Color(0, 0, 0));
        jLabel12.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel12.setText("DISCOTECK");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(822, 0, -1, -1));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("MISTER JUERGA");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, -1, -1));

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel28.setText("MISTER JUERGA");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 0, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 960, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (new Validaciones().validarCampoVacio(txtConcepto)) {
            if (new Validaciones().validarCampoVacio(txtMonto)) {
                String concepto = txtConcepto.getText();
                double monto = Double.parseDouble(txtMonto.getText());
                try {
                    Gasto g = new Gasto();
                    GastoDAO gdao = new GastoDAO();
                    g.setConcepto(concepto);
                    g.setMonto(monto);
                    if (gdao.Registrar(g) == true) {
                        JOptionPane.showMessageDialog(null, "GASTO REGISTRADO");
                        new GastoControl().RefrescarTablaGasto(tblGastos, Titulos);
                        txtConcepto.setText("");
                        txtMonto.setText("");
                        txtConcepto.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "FALLO EN REGISTRO");
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null, "INGRESE MONTO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE CONCEPTO");

        }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtConceptoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConceptoKeyTyped
        Validaciones v = new Validaciones();
        v.validarCampoNumerico(evt, txtConcepto);
    }//GEN-LAST:event_txtConceptoKeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Gasto g = new Gasto();
        int fila = tblGastos.getSelectedRow();
        if (new Validaciones().validarCampoVacio(txtConcepto)) {
            if (new Validaciones().validarCampoVacio(txtMonto)) {
                if (fila < 0) {
                    JOptionPane.showMessageDialog(rootPane, "SELECCIONE GASTO");
                } else {
                    int id = Integer.parseInt(tblGastos.getValueAt(fila, 0).toString());
                    g.setIdgastos(id);
                    g.setConcepto(txtConcepto.getText());
                    g.setMonto(Double.parseDouble(txtMonto.getText()));
                    GastoDAO gdao = new GastoDAO();
                    try {
                        if (gdao.Modificar(g)) {
                            new GastoControl().RefrescarTablaGasto(tblGastos, Titulos);
                            JOptionPane.showMessageDialog(rootPane, "GASTO ACTUALIZADO");
                            txtConcepto.setText("");
                            txtMonto.setText("");
                            txtConcepto.requestFocus();
                            tblGastos.clearSelection();
                        }
                    } catch (Exception e) {
                        Logger.getLogger(Gastos.class.getName()).log(Level.SEVERE, null, e);
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "INGRESE MONTO");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INGRESE CONCEPTO");

        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        Validaciones v = new Validaciones();
        v.validarCampoString(evt, txtMonto);
    }//GEN-LAST:event_txtMontoKeyTyped

    private void txtConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConceptoActionPerformed
        txtMonto.requestFocus();
    }//GEN-LAST:event_txtConceptoActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\GastoReport.jrxml", parametros);
        mrv.exportarAPdf();
// TODO add your handling code here:
    }//GEN-LAST:event_btnReporteActionPerformed

    private void tblGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGastosMouseClicked
        try {
            int fila = tblGastos.getSelectedRow();
            int id = Integer.parseInt(tblGastos.getValueAt(fila, 0).toString());
//            pp.setText(fila+"");
            Object[] datos = (Object[]) new GastoControl().CapturarDatosGastos(id);
            txtConcepto.setText((String) datos[0]);
            txtMonto.setText("" + datos[1]);
            btnModificar.setEnabled(true);
            btnRegistrar.setEnabled(false);
            btnEliminar.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(Gastos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblGastosMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtConcepto.setText("");
        txtMonto.setText("");
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        txtConcepto.requestFocus();
        tblGastos.clearSelection();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Gasto g = new Gasto();
        int fila = tblGastos.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(rootPane, "SELECCIONE GASTO");
        } else {
            int id = Integer.parseInt(tblGastos.getValueAt(fila, 0).toString());
            g.setIdgastos(id);
            GastoDAO gdao = new GastoDAO();
            try {
                if (gdao.Eliminar(g)) {
                    new GastoControl().RefrescarTablaGasto(tblGastos, Titulos);
                    JOptionPane.showMessageDialog(rootPane, "GASTO ELIMINADO");
                    txtConcepto.setText("");
                    txtMonto.setText("");
                    tblGastos.clearSelection();
                }
            } catch (Exception e) {
                Logger.getLogger(Gastos.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new Gastos().setVisible(true);
//                } catch (Exception ex) {
//                    Logger.getLogger(Gastos.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGastos;
    private javax.swing.JTextField txtConcepto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtUsuario1;
    // End of variables declaration//GEN-END:variables
}

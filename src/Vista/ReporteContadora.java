package Vista;

import Controlador.ReportesControl;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.write.WriteException;

public class ReporteContadora extends javax.swing.JInternalFrame {


    public ReporteContadora() {
        initComponents();
        datosIniciales();
    }
    
    public void datosIniciales(){
        try {
            new ReportesControl().cargarComboCajas(cmbCaja);
            new ReportesControl().titulosTablaVentas(tblDatos);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

        setClosable(true);
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
        getContentPane().add(btnRevisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, -1, -1));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 990, 630));

        btnGenerarExcel.setText("CREAR EXCEL");
        btnGenerarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarExcelActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerarExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 710, -1, -1));

        getContentPane().add(cmbCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 110, -1));

        jLabel2.setText("VER VENTAS DE MES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRevisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevisarActionPerformed
        try {
            int mes = jmcMeses.getMonth();
            new ReportesControl().llenarTablaVentas(tblDatos, mes, WIDTH);
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
            Logger.getLogger(ReporteContadora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(ReporteContadora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarExcel;
    private javax.swing.JButton btnRevisar;
    private javax.swing.JComboBox<String> cmbCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JMonthChooser jmcMeses;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}

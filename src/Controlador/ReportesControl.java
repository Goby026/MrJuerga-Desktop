package Controlador;

import Modelo.Caja;
import Modelo.MySQLDAO.CajaDAO;
import Modelo.MySQLDAO.VentaDAO;
import java.io.File;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ReportesControl {
    
    DefaultTableModel modeloTablaVentas;

    //METODO PARA GENERAR EL ARCHIVO EXCEL
    public void generarExcel(String[][] entrada, String ruta) throws IOException, WriteException {

        WritableWorkbook wb = null;
        try {
            WorkbookSettings conf = new WorkbookSettings();
            conf.setEncoding("ISO-8859-1");
            wb = Workbook.createWorkbook(new File(ruta));
            WritableSheet ws = wb.createSheet("Resultado", 0);

            for (int i = 0; i < entrada.length; i++) {
                for (int j = 0; j < entrada[i].length; j++) {
                    ws.addCell(new jxl.write.Label(j, i, entrada[i][j]));
                }

            }
            wb.write();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            wb.close();
        }
    }
    
    public void cargarComboCajas(JComboBox cmb) throws Exception {
        CajaDAO cdao = new CajaDAO();
        for (Caja c : cdao.Listar()) {
            cmb.addItem(c.getNomCaja());
        }
    }
    
    public void titulosTablaVentas(JTable tabla){
        String cabecera[] = {"FECHA","DOCUMENTO","SERIE","VENTA","BASE-IMP","IGV","SUBTOTAL"};
        modeloTablaVentas = new DefaultTableModel(null, cabecera);
        tabla.setModel(modeloTablaVentas);
    }
    
    public void llenarTablaVentas(JTable tabla, int mes, int caja) throws Exception{
        try {
            titulosTablaVentas(tabla);
            
            for (int i = 0; i < new VentaDAO().ventaMes(mes,3).length; i++) {
                modeloTablaVentas.addRow(new VentaDAO().ventaMes(mes,3));
                tabla.setModel(modeloTablaVentas);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}

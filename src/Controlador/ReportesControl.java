package Controlador;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class ReportesControl {
    

    //METODO PARA GENERAR EL ARCHIVO EXCEL
    public int generarExcel(String[][] entrada, String ruta) throws IOException, WriteException {
        int c= 0;
        WritableWorkbook wb = null;
        try {
            WorkbookSettings conf = new WorkbookSettings();
            conf.setEncoding("ISO-8859-1");
            wb = Workbook.createWorkbook(new File(ruta));
            WritableSheet ws = wb.createSheet("Resultado", 0);

            for (int i = 0; i < entrada.length; i++) {
                for (int j = 0; j < entrada[i].length; j++) {
                    ws.addCell(new jxl.write.Label(j, i, entrada[i][j]));
                    c++;
                }

            }
            if (c>0) {
                wb.write();
                return 1;
            }
            
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            wb.close();
        }
        return 0;
    }
    
    
    
    
    
//    public void llenarTablaVentas(JTable tabla, int mes, int caja) throws Exception{
//        try {
//            titulosTablaVentas(tabla);
//            
//            for (int i = 0; i < new VentaDAO().ventaMes(mes,3).length; i++) {
//                modeloTablaVentas.addRow(new VentaDAO().ventaMes(mes,3));
//                tabla.setModel(modeloTablaVentas);
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//    }
}

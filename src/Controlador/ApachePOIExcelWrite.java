package Controlador;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author MARCEL
 */
public class ApachePOIExcelWrite {

    String[] titulos;
    Object[][] datos;
    String url;

    public ApachePOIExcelWrite(String[] titulos, Object[][] datos, String url) {
        this.titulos = titulos;
        this.datos = datos;
        this.url = url;
    }

    //private static final String FILE_NAME = "MyFirstExcel.xlsx";
    public boolean CrearExcel() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Ventas");

//        Object[][] datatypes = {
//                {"Datatype", "Type", "Size(in bytes)"},//titulos de tabla
//                {"int", "Primitive", 2},
//                {"float", "Primitive", 4},
//                {"double", "Primitive", 8.8},
//                {"char", "Primitive", "1"},
//                {"String", "Non-Primitive", "No fixed size"}
//        };
        Object[][] datatypes = datos;

        crearTitulos(sheet, titulos);

        int rowNum = 1;
        System.out.println("Creando excel....");

        for (Object[] datatype : datatypes) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : datatype) {
                //sheet.autoSizeColumn(colNum);
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                } else if (field instanceof Double) {
                    cell.setCellValue((Double) field);
                }

            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(url);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (rowNum > 1) {
            System.out.println("Hecho.... :D");
            return true;
        } else {
            return false;
        }
    }

    private void crearTitulos(XSSFSheet sheet, String[] titulos) {
        Row row = sheet.createRow(0);
        int i = 0;
        for (String titulo : titulos) {
            row.createCell(i).setCellValue(titulo);
            i++;
        }

        //sheet.setZoom(150); -> para indicar el zoom de excel
    }

}

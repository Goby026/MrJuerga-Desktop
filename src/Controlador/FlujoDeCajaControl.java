
package Controlador;

import Modelo.VentaProducto;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FlujoDeCajaControl {
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    public String obtenerFecha(Date fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String f = sdf.format(fecha);
        return f;
    }
    
    public void llenarTablaEntrada(JTable tabla) throws Exception {
        tabla.setModel(modelo);
        VentaProducto vp = new VentaProducto();

        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("DNI");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("TELEFONO");

        Object[] columna = new Object[6];

//        int numeroRegistros = cd.Listar().size();
//
//        for (int i = 0; i < numeroRegistros; i++) {
//            columna[0] = cd.Listar().get(i).getIdcliente();
//            columna[1] = cd.Listar().get(i).getNombre();
//            columna[2] = cd.Listar().get(i).getApellido();
//            columna[3] = cd.Listar().get(i).getDni();
//            columna[4] = cd.Listar().get(i).getDireccion();
//            columna[5] = cd.Listar().get(i).getTelefono();
//            modelo.addRow(columna);
//        }
    }
}

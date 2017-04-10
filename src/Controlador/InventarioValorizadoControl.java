
package Controlador;

import Modelo.MySQLDAO.ProductoPresentacionDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InventarioValorizadoControl {
    DefaultTableModel modelo;
    
    public void cabecera(JTable tabla){
        String titulos[] = {"CODIGO","PRODUCTO","PRESENTACION","CATEGORIA","STOCK","PRECIO","VALORIZACION"};
        modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
        
        new ColumnasTablas().sieteColumnas(tabla, 10, 200, 50, 50, 20, 20, 20);
    }
    
    public void llenarTabla(JTable tabla) throws Exception {
        cabecera(tabla);
        ProductoPresentacionDAO ppd = new ProductoPresentacionDAO();

        Object[] columna = new Object[7];

        int numeroRegistros = ppd.getInventario().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = ppd.getInventario().get(i).getCodigo();
            columna[1] = ppd.getInventario().get(i).getProducto();
            columna[2] = ppd.getInventario().get(i).getPresentacion();
            columna[3] = ppd.getInventario().get(i).getCategoria();
            columna[4] = ppd.getInventario().get(i).getStock();
            columna[5] = ppd.getInventario().get(i).getPrecio();
            columna[6] = ppd.getInventario().get(i).getValorizacion();
            modelo.addRow(columna);
        }
        tabla.setModel(modelo);
    }
}

package Controlador;

import Modelo.Almacen;
import Modelo.MySQLDAO.AlmacenDAO;
import Modelo.MySQLDAO.ProductoDAO;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MovimientoAlmacenControl {
    DefaultTableModel modelo;
    
    public void LlenarTablaProductos(JTable tabla, int small, int large, int xl) throws Exception {
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        ProductoDAO ved = new ProductoDAO();

        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PRECIO");
        modelo.addColumn("CATEGORIA");

        Object[] columna = new Object[2];

        int numeroRegistros = ved.listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = ved.listar().get(i).getIdProducto();
            columna[1] = ved.listar().get(i).getNombre();
            //columna[2] = ved.listar().get(i).getIdCategoria();
            
            modelo.addRow(columna);
        }

        tabla.getColumnModel().getColumn(0).setPreferredWidth(small);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(xl);
//        tabla.getColumnModel().getColumn(2).setPreferredWidth(small);
//        tabla.getColumnModel().getColumn(3).setPreferredWidth(small);
    }
    
    public void cargarComboAlmacenes(JComboBox cmb) throws Exception {
        AlmacenDAO adao = new AlmacenDAO();
        for (Almacen a : adao.listar()) {
            cmb.addItem(a.getNombre());
        }
    }
}

package Controlador;

import Modelo.Categoria;
import Modelo.MySQLDAO.CategoriaDAO;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CategoriaControl {
    DefaultTableModel modelo = new DefaultTableModel();
    
    //metodo para llenar tabla de categorias
    public void LlenarTablaCategoria(JTable tabla) throws Exception {

        tabla.setModel(modelo);
        CategoriaDAO dc = new CategoriaDAO();

        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("CODIGO CATEGORIA");

        Object[] columna = new Object[3];

        int numeroRegistros = dc.Listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = dc.Listar().get(i).getIdcategoria();
            columna[1] = dc.Listar().get(i).getDescripcion();
            columna[2] = dc.Listar().get(i).getCodcategoria();
            modelo.addRow(columna);
        }
    }

    public void RefrescarTablaCategoria(JTable tabla) throws Exception {
        tabla.setModel(modelo);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        LlenarTablaCategoria(tabla);

    }
}

package Controlador;

import Modelo.Categoria;
import Modelo.MySQLDAO.CategoriaDAO;
import Modelo.MySQLDAO.ProductoPresentacionDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARCEL
 */
public class ConteoDiarioControl {

    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modeloBuscarProducto = new DefaultTableModel();

    public void tablaBuscarProductos(JTable tabla, String categoria) {
        try {
            ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
            Object[] columna = new Object[3];
            //int numRegistros = ppdao.listar().size();
            modeloBuscarProducto.addColumn("ID");
            modeloBuscarProducto.addColumn("PRODUCTO");
            modeloBuscarProducto.addColumn("PRESENTACION");
            //modeloBuscarProducto.addColumn("SELECCIONAR");

            int numRegistros = ppdao.mostrarProductos(categoria).size();

            for (int i = 0; i < numRegistros; i++) {
                columna[0] = ppdao.mostrarProductos(categoria).get(i).getIdProducto();
                columna[1] = ppdao.mostrarProductos(categoria).get(i).getProducto();
                columna[2] = ppdao.mostrarProductos(categoria).get(i).getPresentacion();
                modeloBuscarProducto.addRow(columna);
            }
            tabla.setModel(modeloBuscarProducto);
            new ColumnasTablas().tresColumnas(tabla, 20, 300, 200);
        } catch (Exception ex) {
            Logger.getLogger(ConteoDiarioControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarComboCategorias(JComboBox jcombo) throws Exception {
        CategoriaDAO cdao = new CategoriaDAO();
        for (Categoria c : cdao.Listar()) {
            jcombo.addItem(c.getDescripcion());
        }
    }   
    
}

package Controlador;

import Modelo.Almacen;
import Modelo.AlmacenDAO;
import Modelo.Categoria;
import Modelo.CategoriaDAO;
import Modelo.Presentacion;
import Modelo.PresentacionDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProductosControl {
    DefaultTableModel modelo;
    
    
    public void LlenarTablaProductos(JTable tabla, int small, int large, int xl) throws Exception {
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        ProductoDAO ved = new ProductoDAO();

        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        //modelo.addColumn("CATEGORIA");

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
        //tabla.getColumnModel().getColumn(2).setPreferredWidth(small);
    }
    
    public Object capturarCamposDeTabla(int idProducto) throws Exception{
        Object[] datos = new Object[3];
        ProductoDAO pdao = new ProductoDAO();
        for (Producto p : pdao.listar()) {
            if (p.getIdProducto()==idProducto) {
                datos[0] = p.getIdProducto();
                datos[1] = p.getNombre();
                //datos[2] = p.getIdCategoria();
            }
        }
        return datos;
    }
    
//    public void cargarComboCategoria(JComboBox cmb) throws Exception{
//        CategoriaDAO cdao = new CategoriaDAO();
//        for (Categoria c : cdao.Listar()) {
//            cmb.addItem(c.getDescripcion());
//        }
//    }
    
    public void cargarComboAlmacen(JComboBox cmb) throws Exception{
        AlmacenDAO adao = new AlmacenDAO();
        for (Almacen a : adao.listar()) {
            cmb.addItem(a.getNombre());
        }
    }
    public void comboCategoriaSeleccionada(JComboBox cmb, int idCategoria) throws Exception{
        CategoriaDAO cdao = new CategoriaDAO();
        for (Categoria c : cdao.Listar()) {
            if (c.getIdcategoria()==idCategoria) {
                cmb.setSelectedItem(c.getDescripcion());
            }
        }
    }
    
    public int getIdCategoriaConNombre(String categoria) throws Exception{
        try {
            CategoriaDAO cdao= new CategoriaDAO();
            for (Categoria c : cdao.Listar()) {
                if (c.getDescripcion().equals(categoria)) {
                    return c.getIdcategoria();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return 0;
    }
    
    public int getIdPresentacionConNombre(String presentacion) throws Exception{
        try {
            PresentacionDAO pdao = new PresentacionDAO();
            for (Presentacion p : pdao.Listar()) {
                if (p.getDescripcion().equals(presentacion)) {
                    return p.getIdPresentacion();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return 0;
    }
    
    //METODO PARA ACTUALIZAR LA TABLA CUANDO SE REGISTRE, ELIMINE O MODIFIQUE UN PRODUCTO
    public void RefrescarTablaProductos(JTable tabla) throws Exception {
        tabla.setModel(modelo);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        LlenarTablaProductos(tabla,50, 100, 150);
    }
    
}

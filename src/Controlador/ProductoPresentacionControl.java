package Controlador;

import Modelo.Almacen;
import Modelo.MySQLDAO.AlmacenDAO;
import Modelo.Categoria;
import Modelo.MySQLDAO.CategoriaDAO;
import Modelo.Presentacion;
import Modelo.MySQLDAO.PresentacionDAO;
import Modelo.Producto;
import Modelo.MySQLDAO.ProductoDAO;
import Modelo.ProductoPresentacion;
import Modelo.MySQLDAO.ProductoPresentacionDAO;
import ModelosTablas.tablaBuscarProducto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marce
 */
public class ProductoPresentacionControl {

    DefaultTableModel modeloProductos = new DefaultTableModel();
    DefaultTableModel modeloTabla;
  

    public void LlenarTablaProductos(JTable tabla) throws Exception {
        cargarTitulosRequerimientos(tabla);
        ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();

        Object[] columna = new Object[4];

        List<tablaBuscarProducto> tbp = ppdao.getProductoPresentacion();

        for (int i = 0; i < tbp.size(); i++) {
            columna[0] = ppdao.getProductoPresentacion().get(i).getIdProducto();
            columna[1] = ppdao.getProductoPresentacion().get(i).getProducto();
            columna[2] = ppdao.getProductoPresentacion().get(i).getPresentacion();
            columna[3] = ppdao.getProductoPresentacion().get(i).getStock();
            modeloProductos.addRow(columna);
        }
        tabla.setModel(modeloProductos);
        new ColumnasTablas().cuatroColumnas(tabla, 10, 100, 100, 10);
    }

public void LlenarTablaBuscarProductos(JTable tabla, String nomProd) throws Exception {
        cargarTitulosRequerimientos(tabla);
        ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();

        Object[] columna = new Object[4];

        int numeroRegistros = ppdao.buscarProducto(nomProd).size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = ppdao.buscarProducto(nomProd).get(i).getIdProducto();
            columna[1] = ppdao.buscarProducto(nomProd).get(i).getProducto();
            columna[2] = ppdao.buscarProducto(nomProd).get(i).getPresentacion();
            columna[3] = ppdao.buscarProducto(nomProd).get(i).getStock();
            modeloProductos.addRow(columna);
        }
        tabla.setModel(modeloProductos);
        new ColumnasTablas().cuatroColumnas(tabla, 10, 100, 100, 10);
    }

    public void cargarComboPresentacion(JComboBox cmb) throws Exception {
        PresentacionDAO pdao = new PresentacionDAO();
        for (Presentacion p : pdao.Listar()) {
            cmb.addItem(p);
        }
    }

    public void cargarComboAlmacen(JComboBox cmb) throws Exception {
        AlmacenDAO adao = new AlmacenDAO();
        for (Almacen a : adao.listar()) {
            cmb.addItem(a.getNombre());
        }
    }

    public void cargarComboCategoria(JComboBox cmb) throws Exception {
        CategoriaDAO cdao = new CategoriaDAO();
        for (Categoria c : cdao.Listar()) {
            cmb.addItem(c.getDescripcion());
        }
    }

    public int getIdCategoriaConNombre(String categoria) throws Exception {
        try {
            CategoriaDAO cdao = new CategoriaDAO();
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

    public int getIdPresentacionConNombre(String presentacion) throws Exception {
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

    public int getIdProductoConNombre(String producto) throws Exception {
        try {
            ProductoDAO pdao = new ProductoDAO();
            for (Producto p : pdao.listar()) {
                if (p.getNombre().equals(producto)) {
                    return p.getIdProducto();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return 0;
    }

    public int getIdAlmacenConNombre(String almacen) throws Exception {
        try {
            AlmacenDAO adao = new AlmacenDAO();
            for (Almacen a : adao.listar()) {
                if (a.getNombre().equals(almacen)) {
                    return a.getId();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return 0;
    }

    public int comprobarGestionProducto(int idproducto, int idpresentacion, int idalmacen) throws Exception {
        try {
            ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
            for (ProductoPresentacion pp : ppdao.Listar()) {
                if (pp.getIdProducto() == idproducto && pp.getIdPresentacion() == idpresentacion && pp.getIdalmacen() == idalmacen) {
                    return pp.getIdProductoPresentacion();
                }
            }
            return 0;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public int guardarGestionProducto(String producto, String categoria, String presentacion, String almacen, int stock, double precio) throws Exception {
        int flag = 0;
        try {
            ProductoPresentacion pp = new ProductoPresentacion();
            pp.setIdProducto(getIdProductoConNombre(producto));
            pp.setIdcategoria(getIdCategoriaConNombre(categoria));
            pp.setIdPresentacion(getIdPresentacionConNombre(presentacion));
            pp.setIdalmacen(getIdAlmacenConNombre(almacen));
            pp.setStock(stock);
            pp.setPrecio(precio);
            int opc = comprobarGestionProducto(getIdProductoConNombre(producto), getIdPresentacionConNombre(presentacion), getIdAlmacenConNombre(almacen));
            if (opc > 0) {
                //modificar
                pp.setIdProductoPresentacion(opc);
                ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
                ppdao.Modificar(pp);
                flag++;
            } else {
                //registrar
                ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
                ppdao.Registrar(pp);
                flag++;
            }
            return flag;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //obtener el nombre de producto con el id
    public String getProductoConId(int idProducto) throws Exception {
        try {
            ProductoDAO pdao = new ProductoDAO();
            for (Producto p : pdao.listar()) {
                if (p.getIdProducto() == idProducto) {
                    return p.getNombre();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return "";
    }

    //metodo para obtener el nombre de categoria con el id
    public String getCategoriaConId(int idCategoria) throws Exception {
        try {
            CategoriaDAO cdao = new CategoriaDAO();
            for (Categoria c : cdao.Listar()) {
                if (c.getIdcategoria() == idCategoria) {
                    return c.getDescripcion();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    //metodo para obtener el nombre de presentacion con id
    public String getPresentacionConId(int idPresentacion) throws Exception {
        try {
            PresentacionDAO pdao = new PresentacionDAO();
            for (Presentacion p : pdao.Listar()) {
                if (p.getIdPresentacion() == idPresentacion) {
                    return p.getDescripcion();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    //metodo para obtener el nombre de almacen con id
    public String getAlmacenConId(int idAlmacen) throws Exception {
        try {
            AlmacenDAO adao = new AlmacenDAO();
            for (Almacen a : adao.listar()) {
                if (a.getId() == idAlmacen) {
                    return a.getNombre();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }

    private void cargarTitulosRequerimientos(JTable tabla) {
        String titulos[] = {"ID", "PRODUCTO", "PRESENTACION","PRECIO"};
        modeloProductos = new DefaultTableModel(null, titulos);
        tabla.setModel(modeloProductos);
    }
}

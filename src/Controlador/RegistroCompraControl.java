package Controlador;

import Modelo.Almacen;
import Modelo.MySQLDAO.AlmacenDAO;
import Modelo.MySQLDAO.CategoriaDAO;
import Modelo.Medida;
import Modelo.MySQLDAO.MedidaDAO;
import Modelo.MySQLDAO.PresentacionDAO;
import Modelo.Producto;
import Modelo.MySQLDAO.ProductoDAO;
import Modelo.Proveedor;
import Modelo.MySQLDAO.ProveedorDAO;
import Modelo.TipoComprobante;
import Modelo.MySQLDAO.TipoComprobanteDAO;
import Modelo.Usuario;
import Modelo.MySQLDAO.UsuarioDAO;
import Modelo.Presentacion;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistroCompraControl {
    
    DefaultTableModel modeloBuscarProveedores;
    DefaultTableModel modeloBuscarProductos;

    public void cargarTipoDocumento(JComboBox combo) throws Exception {
        TipoComprobanteDAO cdao = new TipoComprobanteDAO();
        for (TipoComprobante c : cdao.Listar()) {
            combo.addItem(c.getDescripcion());
        }
    }

    public void cargarComboResponsable(JComboBox combo) throws Exception {
        UsuarioDAO udao = new UsuarioDAO();
        for (Usuario u : udao.listar()) {
            combo.addItem(u.getNombre());
        }
    }

    public void cargarComboProveedor(JComboBox combo) throws Exception {
        ProveedorDAO pdao = new ProveedorDAO();
        for (Proveedor p : pdao.Listar()) {
            combo.addItem(p.getRazon());
        }
    }
    
    public void cargarComboPresentacion(JComboBox combo) throws Exception {
        PresentacionDAO pdao = new PresentacionDAO();
        for (Presentacion p : pdao.Listar()) {
            combo.addItem(p.getDescripcion());
        }
    }
    
    public void cargarComboAlmacen(JComboBox combo) throws Exception {
        AlmacenDAO adao = new AlmacenDAO();
        for (Almacen a : adao.listar()) {
            combo.addItem(a.getNombre());
        }
    }

    public Object camposResponsableSeleccionado(String nombre) throws Exception {
        Object[] datos = new Object[4];
        try {
            UsuarioDAO udao = new UsuarioDAO();

            for (Usuario u : udao.listar()) {
                if (u.getNombre().equals(nombre)) {
                    datos[0] = u.getId();
                    datos[1] = u.getNombre();
                    datos[2] = u.getApellido();
                    datos[3] = u.getDni();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return datos;
    }
    
    public Object camposProveedorSeleccionado(String prov) throws Exception {
        Object[] datos = new Object[6];
        try {
            ProveedorDAO pdao = new ProveedorDAO();
            for (Proveedor p : pdao.Listar()) {
                if (p.getRazon().equals(prov)) {
                    datos[0] = p.getIdProveedor();
                    datos[1] = p.getRazon();
                    datos[2] = p.getTelf_prov();
                    datos[3] = p.getRuc();
                    datos[4] = p.getCorreo();
                    datos[5] = p.getDireccion();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return datos;
    }
    
//    public void cargarListaProductos(JList lista, DefaultListModel modelo) throws Exception{
//        modelo = new DefaultListModel();
//        try {
//            ProductoDAO pdao = new ProductoDAO();
//            for (Producto p : pdao.listar()) {
//                modelo.addElement(p.getNombre());
//            }
//            lista.setModel(modelo);
//        } catch (Exception e) {
//            throw e;
//        }
//    }
    
    public void titulosProveedores(JTable tabla){
        String titulos[] = {"ID","RAZON SOCIAL","RUC"};
        modeloBuscarProveedores = new DefaultTableModel(null, titulos);
        tabla.setModel(modeloBuscarProveedores);
    }
    
    public void LlenarTablaProveedores(JTable tabla) throws Exception {
        titulosProveedores(tabla);
        Proveedor p = new Proveedor();
        ProveedorDAO pd = new ProveedorDAO();

        Object[] columna = new Object[3];

        int numeroRegistros = pd.Listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = pd.Listar().get(i).getIdProveedor();
            columna[1] = pd.Listar().get(i).getRazon();
            columna[2] = pd.Listar().get(i).getRuc();
            modeloBuscarProveedores.addRow(columna);
        }
        tabla.setModel(modeloBuscarProveedores);
    }
    
    public void titulosBuscarProductos(JTable tabla){
        String titulos[] = {"ID","PRODUCTO"};
        modeloBuscarProductos = new DefaultTableModel(null, titulos);
        tabla.setModel(modeloBuscarProductos);
    }
    
    public void LlenarTablaBuscarProductos(JTable tabla) throws Exception {
        titulosBuscarProductos(tabla);
        ProductoDAO pdao = new ProductoDAO();

        Object[] columna = new Object[2];

        int numeroRegistros = pdao.listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = pdao.listar().get(i).getIdProducto();
            columna[1] = pdao.listar().get(i).getNombre();
            modeloBuscarProductos.addRow(columna);
        }        
        tabla.setModel(modeloBuscarProductos);
        new ColumnasTablas().dosColumnas(tabla, 50, 200);
    }
    
    
//    
//    public Object camposProveedorSeleccionado(String nombre) throws Exception {
//        Object[] datos = new Object[6];
//        try {
//            ProveedorDAO pdao = new ProveedorDAO();
//
//            for (Proveedor p : pdao.Listar()) {
//                if (p.getRazon().equals(nombre)) {
//                    datos[0] = p.getIdProveedor();
//                    datos[1] = p.getRazon();
//                    datos[2] = p.getTelf_prov();
//                    datos[3] = p.get
//                    datos[4] = p.getIdArea();
//                }
//            }
//        } catch (Exception ex) {
//            throw ex;
//        }
//        return datos;
//    }

}

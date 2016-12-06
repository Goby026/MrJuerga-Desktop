package Controlador;

import Modelo.Almacen;
import Modelo.AlmacenDAO;
import Modelo.Medida;
import Modelo.MedidaDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Modelo.TipoComprobante;
import Modelo.TipoComprobanteDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;

public class OrdenDeCompraControl {

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
    
    public void cargarComboMedidas(JComboBox combo) throws Exception {
        MedidaDAO mdao = new MedidaDAO();
        for (Medida m : mdao.Listar()) {
            combo.addItem(m.getDescripcion());
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
    
    public void cargarListaProductos(JList lista, DefaultListModel modelo) throws Exception{
        modelo = new DefaultListModel();
        try {
            ProductoDAO pdao = new ProductoDAO();
            for (Producto p : pdao.listar()) {
                modelo.addElement(p.getNombre());
            }
            lista.setModel(modelo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
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

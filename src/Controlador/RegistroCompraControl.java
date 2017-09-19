package Controlador;

import Modelo.Almacen;
import Modelo.MySQLDAO.AlmacenDAO;
import Modelo.MySQLDAO.PresentacionDAO;
import Modelo.Proveedor;
import Modelo.MySQLDAO.ProveedorDAO;
import Modelo.TipoComprobante;
import Modelo.MySQLDAO.TipoComprobanteDAO;
import Modelo.Usuario;
import Modelo.MySQLDAO.UsuarioDAO;
import Modelo.Presentacion;
import javax.swing.JComboBox;

public class RegistroCompraControl {

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
    
}

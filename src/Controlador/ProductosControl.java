package Controlador;

import Modelo.Almacen;
import Modelo.MySQLDAO.AlmacenDAO;
import Modelo.Categoria;
import Modelo.MySQLDAO.CategoriaDAO;
import Modelo.Presentacion;
import Modelo.MySQLDAO.PresentacionDAO;
import Modelo.Producto;
import Modelo.MySQLDAO.ProductoDAO;
import Vista.Productos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JComboBox;

public class ProductosControl  implements ActionListener, WindowListener{
    
    Productos p;

    public ProductosControl(Productos p) {
        this.p = p;
    }

    public ProductosControl() {
        
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == p) {
            
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        if (e.getSource() == p) {
            
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
}

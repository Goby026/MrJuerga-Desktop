package Controlador;

import Modelo.Almacen;
import Modelo.MySQLDAO.AlmacenDAO;
import Modelo.Producto;
import Modelo.MySQLDAO.ProductoDAO;
import Modelo.Usuario;
import Modelo.MySQLDAO.UsuarioDAO;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AlmacenControl {

    DefaultTableModel modelo = new DefaultTableModel();

    public void cargarTablaAlmacenes(JTable tabla) throws Exception {

        tabla.setModel(modelo);
        AlmacenDAO cd = new AlmacenDAO();

        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("CIUDAD");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("RESPONSABLE");

        Object[] columna = new Object[6];

        int numeroRegistros = cd.listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = cd.listar().get(i).getId();
            columna[1] = cd.listar().get(i).getNombre();
            columna[2] = cd.listar().get(i).getDireccion();
            columna[3] = cd.listar().get(i).getCiudad();
            columna[4] = cd.listar().get(i).getTelefono();
            columna[5] = cd.listar().get(i).getResponsable();
            modelo.addRow(columna);
        }
    }

    public void RefrescarTablaAlmacen(JTable tabla) throws Exception {
        tabla.setModel(modelo);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        cargarTablaAlmacenes(tabla);
    }

    public void cargarTablaExistencias(JTable tabla, String nombreAlmacen) throws Exception {
        tabla.setModel(modelo);
        ProductoDAO pdao = new ProductoDAO();

        modelo.addColumn("ID");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");

        Object[] columna = new Object[3];

        int numeroRegistros = pdao.listar().size();

        for (Producto p : pdao.listar()) {
            if (p.getNombre().equals(nombreAlmacen)) {
                columna[0] = p.getIdProducto();
                columna[1] = p.getNombre();
                modelo.addRow(columna);
            }
        }

//        for (int i = 0; i < numeroRegistros; i++) {
//            columna[0] = pdao.listar().get(i).getIdProducto();
//            columna[1] = pdao.listar().get(i).getNombre();
//            columna[2] = pdao.listar().get(i).getPrecio();
//            columna[3] = pdao.listar().get(i).getStock();
//            modelo.addRow(columna);
//        }
    }

    public void RefrescarTablaExistencias(JTable tabla, String nombreAlmacen) throws Exception {
        tabla.setModel(modelo);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        cargarTablaExistencias(tabla, nombreAlmacen);
    }

    public void cargarComboAlmacenes(JComboBox cmb) throws Exception {
        AlmacenDAO adao = new AlmacenDAO();
        for (Almacen a : adao.listar()) {
            cmb.addItem(a.getNombre());
        }
    }

    public void cargarComboResponsable(JComboBox cmb) throws Exception {
        UsuarioDAO udao = new UsuarioDAO();
        for (Usuario u : udao.listar()) {
            cmb.addItem(u.getNombre());
        }
    }

    public Object CargarAlmacenSeleccionado(int id) throws Exception {
        Object[] datos = new Object[6];
        AlmacenDAO adao = new AlmacenDAO();
        for (Almacen a : adao.listar()) {
            if (a.getId() == id) {
                datos[0] = a.getId();
                datos[1] = a.getNombre();
                datos[2] = a.getDireccion();
                datos[3] = a.getCiudad();
                datos[4] = a.getTelefono();
                datos[5] = a.getResponsable();
            }
        }
        return datos;
    }
    
    public Object CargarAlmacenSeleccionadoConNombre(String almacen) throws Exception {
        Object[] datos = new Object[6];
        AlmacenDAO adao = new AlmacenDAO();
        for (Almacen a : adao.listar()) {
            if (a.getNombre().equals(almacen)) {
                datos[0] = a.getId();
                datos[1] = a.getNombre();
                datos[2] = a.getDireccion();
                datos[3] = a.getCiudad();
                datos[4] = a.getTelefono();
                datos[5] = a.getResponsable();
            }
        }
        return datos;
    }

    public void semiSlider() throws Exception {
        AlmacenDAO adao = new AlmacenDAO();
        int var = 0;
        var = adao.listar().size();
        for (int i = 0; i < var; i++) {
            System.out.println(i);
        }
    }
}

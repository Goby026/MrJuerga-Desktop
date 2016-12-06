/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.CategoriaDAO;
import Modelo.ClienteDAO;
import Modelo.ComprobanteDAO;
import Modelo.PerfilDAO;
import Modelo.TipoComprobanteDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author toshiba
 */
public class LlenarTabla {
    DefaultTableModel modelo = new DefaultTableModel();

    public void LlenarTabla(JTable tabla) throws Exception {

        tabla.setModel(modelo);
        ClienteDAO cd = new ClienteDAO();

        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("DNI");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("TELEFONO");

        Object[] columna = new Object[6];

        int numeroRegistros = cd.Listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = cd.Listar().get(i).getIdcliente();
            columna[1] = cd.Listar().get(i).getNombre();
            columna[2] = cd.Listar().get(i).getApellido();
            columna[3] = cd.Listar().get(i).getDni();
            columna[4] = cd.Listar().get(i).getDireccion();
            columna[5] = cd.Listar().get(i).getTelefono();
            modelo.addRow(columna);
        }
    }

    public void LlenarTablaDescripcion(JTable tabla) throws Exception {

        tabla.setModel(modelo);
        PerfilDAO cd = new PerfilDAO();

        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCION");

        Object[] columna = new Object[2];

        int numeroRegistros = cd.Listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = cd.Listar().get(i).getIdperfil();
            columna[1] = cd.Listar().get(i).getDescripcion();
            modelo.addRow(columna);
        }
    }

    public void RefrescarTabla(JTable tabla) throws Exception {
        tabla.setModel(modelo);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        LlenarTabla(tabla);
    }

    public void RefrescarTablaDescripcion(JTable tabla) throws Exception {
        tabla.setModel(modelo);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        LlenarTablaDescripcion(tabla);
    }

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

    public void LlenarTablaTipoComprobante(JTable tabla) throws Exception {

        tabla.setModel(modelo);
        TipoComprobanteDAO dtc = new TipoComprobanteDAO();

        modelo.addColumn("ID");
        modelo.addColumn("DESCRIPCION");
        Object[] columna = new Object[2];

        int numeroRegistros = dtc.Listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = dtc.Listar().get(i).getIdtipocomprobante();
            columna[1] = dtc.Listar().get(i).getDescripcion();

            modelo.addRow(columna);
        }
    }

    public void RefrescarTablaTipoComprobante(JTable tabla) throws Exception {
        tabla.setModel(modelo);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        LlenarTablaTipoComprobante(tabla);

    }

    public void LlenarTablaComprobante(JTable tabla) throws Exception {

        tabla.setModel(modelo);
        ComprobanteDAO dtc = new ComprobanteDAO();
        modelo.addColumn("ID");
        modelo.addColumn("FECHA");
        modelo.addColumn("USUARIO");
        modelo.addColumn("CLIENTE");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("SUBTOTAL");
        modelo.addColumn("RUC");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("TIPO DE PAGO");
        modelo.addColumn("TOTAL");
        modelo.addColumn("TIPO COMPROBANTE");
        Object[] columna = new Object[11];
        int numeroRegistros = dtc.Listar().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = dtc.Listar().get(i).getIdcomprobante();
            columna[1] = dtc.Listar().get(i).getFecha();
            columna[2] = dtc.Listar().get(i).getUsuario();
            columna[3] = dtc.Listar().get(i).getCliente();
            columna[4] = dtc.Listar().get(i).getCantidad();
            columna[5] = dtc.Listar().get(i).getSubTotal();
            columna[6] = dtc.Listar().get(i).getRuc();
            columna[7] = dtc.Listar().get(i).getDireccion();
            columna[8] = dtc.Listar().get(i).getTipo_pago();
            columna[9] = dtc.Listar().get(i).getTotal();
            columna[10] = dtc.Listar().get(i).getIdtipocomprobante();
            modelo.addRow(columna);
        }
    }

    public void RefrescarTablaComprobante(JTable tabla) throws Exception {
        tabla.setModel(modelo);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        
        LlenarTablaTipoComprobante(tabla);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MySQLDAO.ClienteDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author toshiba
 */
public class ClienteControl {
    
    DefaultTableModel modelo = new DefaultTableModel();

    public void LlenarTablaCliente(JTable tabla) throws Exception {

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
    public void RefrescarTablaCliente(JTable tabla) throws Exception {
        tabla.setModel(modelo);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
         LlenarTablaCliente(tabla);
    }
 
}

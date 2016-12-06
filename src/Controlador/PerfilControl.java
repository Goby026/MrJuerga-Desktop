/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.PerfilDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author toshiba
 */
public class PerfilControl {
      
    DefaultTableModel modelo = new DefaultTableModel();
    public void LlenarTablaPerfil(JTable tabla) throws Exception {

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

    public void RefrescarTablaPerfil(JTable tabla) throws Exception {
        tabla.setModel(modelo);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        LlenarTablaPerfil(tabla);
    }
}

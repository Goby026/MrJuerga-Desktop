/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MySQLDAO.TipoComprobanteDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author toshiba
 */
public class TipoComprobanteControl {
    DefaultTableModel modelo = new DefaultTableModel();
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
    

}

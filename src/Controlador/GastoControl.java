/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Gasto;
import Modelo.MySQLDAO.GastoDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adolfo
 */
public class GastoControl {

    DefaultTableModel model;

    public GastoControl() {
    }

    public GastoControl(DefaultTableModel model) {
        this.model = model;
    }

    public void SetTitulos(String[] nombres, JTable tabla) {
        model = new DefaultTableModel(null, nombres);
        tabla.setModel(model);
    }

    public void LlenarTablaGastos(JTable tabla, String[] nombres) throws Exception {
        SetTitulos(nombres, tabla);

        Object[] columna = new Object[4];
        GastoDAO gdao = new GastoDAO();
        int numeroRegistros = gdao.Listar().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = gdao.Listar().get(i).getIdgastos();
            columna[1] = gdao.Listar().get(i).getConcepto();
            columna[2] = gdao.Listar().get(i).getMonto();
            model.addRow(columna);
        }
    }

    public Object CapturarDatosGastos(int cod) throws Exception {
        Object[] datos = new Object[3];
        GastoDAO gdao = new GastoDAO();
        for (Gasto g : gdao.Listar()) {
            if (g.getIdgastos() == cod) {
                datos[0] = g.getConcepto();
                datos[1] = g.getMonto();
            }
        }

        return datos;
    }

    public void RefrescarTablaGasto(JTable tabla, String[] nombres) throws Exception {
        SetTitulos(nombres, tabla);
        tabla.setModel(model);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
        LlenarTablaGastos(tabla, nombres);
    }

    public double MontoTotal(JTable tabla) {
        double monto = 0.0;
        int filas = tabla.getRowCount();
        for (int i = 0; i < filas; i++) {
            monto += Double.parseDouble(tabla.getValueAt(i,3 ).toString());
        }
        return monto;
    }


}

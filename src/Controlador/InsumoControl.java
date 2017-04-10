/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Insumo;
import Modelo.MySQLDAO.InsumoDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adolfo
 */
public class InsumoControl{

    DefaultTableModel model;

    public InsumoControl() {
    }

    public InsumoControl(DefaultTableModel model) {
        this.model = model;
    }

    public void SetTitulosInsumo(String[] nombres, JTable tabla) {
        model = new DefaultTableModel(null, nombres);
        tabla.setModel(model);
    }

    public void LlenarTablaInsumo(JTable tabla, String[] nombres) throws Exception {
        SetTitulosInsumo(nombres, tabla);
        Object[] columna = new Object[6];
        InsumoDAO idao = new InsumoDAO();
        int numeroRegistros = idao.Listar().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = idao.Listar().get(i).getIdinsumo();
            columna[1] = idao.Listar().get(i).getNombre();
            model.addRow(columna);
        }
    }
         

    public void RefrescarTablaInsumo(JTable tabla, String[] nombres) throws Exception {
        SetTitulosInsumo(nombres, tabla);
        tabla.setModel(model);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
        LlenarTablaInsumo(tabla, nombres);
    }
    
     public Object CapturarDatosInsumo(int cod) throws Exception {
        Object[] datos = new Object[2];
        InsumoDAO idao = new InsumoDAO();
        Insumo i = idao.Listar().get(cod-1);
        datos[0] = i.getNombre();
       
        return datos;
    }
     public void RefrescarTablaGasto(JTable tabla, String[] nombres) throws Exception {
        SetTitulosInsumo(nombres, tabla);
        tabla.setModel(model);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
        LlenarTablaInsumo(tabla, nombres);
    }
}




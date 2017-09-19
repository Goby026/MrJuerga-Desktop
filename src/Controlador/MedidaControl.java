/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Medida;
import Modelo.MySQLDAO.MedidaDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adolfo
 */
public class MedidaControl {
    DefaultTableModel model;

    public MedidaControl() {
    }

    public MedidaControl(DefaultTableModel model) {
        this.model = model;
    }
    public void SetTitulosMedida(String[] nombres, JTable tabla) {
        model = new DefaultTableModel(null, nombres);
        tabla.setModel(model);
    }
    public void LlenarTablaMedida(JTable tabla, String[] nombres) throws Exception {
        SetTitulosMedida(nombres, tabla);
        Object[] columna = new Object[3];
        MedidaDAO mdao = new MedidaDAO();
        int numeroRegistros = mdao.Listar().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = mdao.Listar().get(i).getIdmedida();
            columna[1] = mdao.Listar().get(i).getDescripcion();
            columna[2] = mdao.Listar().get(i).getValor();
            model.addRow(columna);
        }

    }
     public void RefrescarTablaMedida(JTable tabla, String[] nombres) throws Exception {
        SetTitulosMedida(nombres, tabla);
        tabla.setModel(model);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
        LlenarTablaMedida(tabla, nombres);
    }
     public Object CapturarDatosMedida(int cod) throws Exception {
       Object[] datos = new Object[3];
        MedidaDAO mdao = new MedidaDAO();
        for (Medida m : mdao.Listar()) {
            if (m.getIdmedida()== cod) {
                datos[0] = m.getIdmedida();
                datos[1] = m.getDescripcion();
                datos[2] = m.getValor();
            }
        }
        return datos;
    }
    
    
    
    
    
    
}

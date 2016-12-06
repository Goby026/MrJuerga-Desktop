/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Contacto;
import Modelo.ContactoDAO;
import Modelo.Medida;
import Modelo.MedidaDAO;
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
        Object[] columna = new Object[6];
        MedidaDAO mdao = new MedidaDAO();
        int numeroRegistros = mdao.Listar().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = mdao.Listar().get(i).getIdmedida();
            columna[1] = mdao.Listar().get(i).getDescripcion();
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
       Object[] datos = new Object[2];
        MedidaDAO mdao = new MedidaDAO();
        for (Medida m : mdao.Listar()) {
            if (m.getIdmedida()== cod) {
                datos[0] = m.getIdmedida();
                datos[1] = m.getDescripcion();
            }
        }
        return datos;
    }
    
    
    
    
    
    
}

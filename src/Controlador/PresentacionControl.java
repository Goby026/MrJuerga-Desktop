/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Presentacion;
import Modelo.MySQLDAO.PresentacionDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adolfo --updated by Grover
 */
public class PresentacionControl {

    DefaultTableModel model;

    public PresentacionControl() {
    }

    public PresentacionControl(DefaultTableModel model) {
        this.model = model;
    }

    public void SetTitulosPresentacion(String[] nombres, JTable tabla) {
        model = new DefaultTableModel(null, nombres);
        tabla.setModel(model);
    }
    
    public void LlenarTablaPresentacion(JTable tabla, String[] nombres) throws Exception {
        SetTitulosPresentacion(nombres, tabla);
        Object[] columna = new Object[3];
        PresentacionDAO pdao = new PresentacionDAO();
        int numeroRegistros = pdao.Listar().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = pdao.Listar().get(i).getIdPresentacion();
            columna[1] = pdao.Listar().get(i).getDescripcion();
            columna[2] = pdao.Listar().get(i).getValorMl();
            model.addRow(columna);
        }
    }
    public Object CapturarDatosPresentacion(int cod) throws Exception {
        Object[] datos = new Object[3];
        PresentacionDAO pdao = new PresentacionDAO();
        for (Presentacion p : pdao.Listar()) {
            if (p.getIdPresentacion()== cod) {
                datos[0] = p.getIdPresentacion();
                datos[1] = p.getDescripcion();
                datos[2] = p.getValorMl();
            }
        }

        return datos;
    }
    
    public void RefrescarTablaPresentacion(JTable tabla, String[] nombres) throws Exception {
        SetTitulosPresentacion(nombres, tabla);
        tabla.setModel(model);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
        LlenarTablaPresentacion(tabla, nombres);
    }
        
     
    
}

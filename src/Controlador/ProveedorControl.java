/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Gasto;
import Modelo.MySQLDAO.GastoDAO;
import Modelo.Proveedor;
import Modelo.MySQLDAO.ProveedorDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adolfo
 */
public class ProveedorControl {
    DefaultTableModel model;
    
    public ProveedorControl() {
    }
     public ProveedorControl(DefaultTableModel model) {
        this.model = model;
    }
     public void SetTitulos(String[] nombres, JTable tabla) {
        model = new DefaultTableModel(null, nombres);
        tabla.setModel(model);
    }
     public void LlenarTablaProveedor(JTable tabla, String[] nombres) throws Exception {
        SetTitulos(nombres, tabla);

        Object[] columna = new Object[8];
        ProveedorDAO pdao = new ProveedorDAO();
        int numeroRegistros = pdao.Listar().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = pdao.Listar().get(i).getIdProveedor();
            columna[1] = pdao.Listar().get(i).getRazon();
            columna[2] = pdao.Listar().get(i).getRuc();
            columna[3] = pdao.Listar().get(i).getDireccion();
            columna[4] = pdao.Listar().get(i).getCiudad();
            columna[5] = pdao.Listar().get(i).getTelf_prov();
//            columna[5] = pdao.Listar().get(i).getCod_pos();
            columna[6] = pdao.Listar().get(i).getCorreo();
            columna[7] = pdao.Listar().get(i).getCodProv();
            model.addRow(columna);
        }
    }
      public Object CapturarDatosProveedor(int cod) throws Exception {
        Object[] datos = new Object[8];
        ProveedorDAO pdao = new ProveedorDAO();
        for (Proveedor p : pdao.Listar()) {
            if (p.getIdProveedor()== cod) {
                datos[0] = p.getRazon();
                datos[1] = p.getRuc();
                datos[2] = p.getDireccion();
                datos[3] = p.getCiudad();
                datos[4] = p.getTelf_prov();
                datos[5] = p.getCod_pos();
                datos[6] = p.getCorreo();
                datos[7] = p.getCodProv();
                
            }
        }

        return datos;
    }
     
     public void RefrescarTablaProveedor(JTable tabla, String[] nombres) throws Exception {
        SetTitulos(nombres, tabla);
        tabla.setModel(model);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
        LlenarTablaProveedor(tabla, nombres);
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

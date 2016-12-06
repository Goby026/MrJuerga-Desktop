/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.ContactoDAO;
import Modelo.Contacto;
import Modelo.Telefono_Contacto;
import Modelo.Telefono_ContactoDAO;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adolfo
 */
public class ContactoControl extends Conexion {

    DefaultTableModel model;

    public ContactoControl() {
    }

    public ContactoControl(DefaultTableModel model) {
        this.model = model;
    }

    public void SetTitulosContacto(String[] nombres, JTable tabla) {
        model = new DefaultTableModel(null, nombres);
        tabla.setModel(model);
    }

    public void LlenarTablaContacto(JTable tabla, String[] nombres) throws Exception {
        SetTitulosContacto(nombres, tabla);
        Object[] columna = new Object[6];
        ContactoDAO cdao = new ContactoDAO();
        int numeroRegistros = cdao.Listar().size();
        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = cdao.Listar().get(i).getIdContacto();
            columna[1] = cdao.Listar().get(i).getNombres();
            columna[2] = cdao.Listar().get(i).getApellidos();
            columna[3] = cdao.Listar().get(i).getDireccion();
            columna[4] = cdao.Listar().get(i).getCorreo();
            columna[5] = cdao.Listar().get(i).getCodContacto();
            model.addRow(columna);
        }

    }

    public void RefrescarTablaContacto(JTable tabla, String[] nombres) throws Exception {
        SetTitulosContacto(nombres, tabla);
        tabla.setModel(model);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
        LlenarTablaContacto(tabla, nombres);
    }

    public Object CapturarDatosContacto(int cod) throws Exception {
       Object[] datos = new Object[6];
        ContactoDAO cdao = new ContactoDAO();
        for (Contacto c : cdao.Listar()) {
            if (c.getIdContacto()== cod) {
                datos[0] = c.getNombres();
                datos[1] = c.getApellidos();
                datos[2] = c.getDireccion();
                datos[3] = c.getCorreo();
                datos[4] = c.getCodContacto();
                datos[5] = c.getIdContacto();
            }
        }
        return datos;
    }
    
    public void GuardarTelefonoContacto(String num1,String num2, String num3, int IdContacto) throws Exception{
        Telefono_Contacto tc = new Telefono_Contacto();
        Telefono_ContactoDAO tcdao = new Telefono_ContactoDAO();
        for (int i = 0; i < 2; i++) {
            tc.setNumero(num1);
            tcdao.Registrar(tc);
        }
        
    
    
    }

}

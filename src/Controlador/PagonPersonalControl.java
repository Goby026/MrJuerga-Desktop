package Controlador;

import Modelo.Gasto;
import Modelo.GastoDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marce
 */
public class PagonPersonalControl {

    DefaultTableModel modelo;

    //metodo para establecer los nombres de las columnas de la tabla personal
    public void titulosTabla(JTable tabla) {
        String titulos[] = {"ID","NOMBRES", "APELLIDOS", "DNI"};
        modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
    }

    //metodo para llenar la tabla de personales cuando se ingrese el dni
    public void tablaPersonal(String dni, JTable tabla) throws Exception {
        try {
            titulosTabla(tabla);
            UsuarioDAO udao = new UsuarioDAO();
            Object[] columna = new Object[4];
            for (Usuario u : udao.listar()) {
                if (u.getDni().equals(dni)) {
                    columna[1] = u.getId();
                    columna[2] = u.getNombre();
                    columna[3] = u.getApellido();
                    columna[4] = u.getDni();
                    modelo.addRow(columna);
                } else {
                    System.out.println("dni no encontrado");
                }
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean registrarPago(String fecha, String concepto, double monto) throws Exception {
        try {
            Gasto g = new Gasto();
            g.setFecha(fecha);
            g.setConcepto(concepto);
            g.setMonto(monto);
            GastoDAO gdao = new GastoDAO();
            if (gdao.Registrar(g)) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void cargarComboConcepto(JComboBox cmb) throws Exception{
        try {
            GastoDAO gdao = new GastoDAO();
            for (Gasto g : gdao.Listar()) {
                cmb.addItem(g.getConcepto());
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public int getIdGasto(String concepto) throws Exception{
        try {
            GastoDAO gdao = new GastoDAO();
            for (Gasto g : gdao.Listar()) {
                if (g.getConcepto().equals(concepto)) {
                    return g.getIdgastos();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return -1;
    }

}

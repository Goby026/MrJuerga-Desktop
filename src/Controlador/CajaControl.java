package Controlador;

import Modelo.Caja;
import Modelo.MySQLDAO.CajaDAO;
import Modelo.Usuario;
import Modelo.UsuarioCaja;
import Modelo.MySQLDAO.UsuarioCajaDAO;
import Modelo.MySQLDAO.UsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marce
 */
public class CajaControl {

    //metodo para guardar caja
    DefaultTableModel modeloTablaUsuarios = new DefaultTableModel();

    public void cargarTablaCajas(JTable tabla) throws Exception {
        try {
            tabla.setModel(modeloTablaUsuarios);
            CajaDAO cdao = new CajaDAO();

            modeloTablaUsuarios.addColumn("ID");
            modeloTablaUsuarios.addColumn("NOMBRES");

            Object[] columna = new Object[2];

            int numeroRegistros = cdao.Listar().size();

            for (int i = 0; i < numeroRegistros; i++) {
                columna[0] = cdao.Listar().get(i).getIdCaja();
                columna[1] = cdao.Listar().get(i).getNomCaja();
                modeloTablaUsuarios.addRow(columna);
                tabla.setModel(modeloTablaUsuarios);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void RefrescarTablaCajas(JTable tabla) throws Exception {
        tabla.setModel(modeloTablaUsuarios);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modeloTablaUsuarios.removeRow(i);
            i -= 1;
        }
        cargarTablaCajas(tabla);
    }

    public String guardarCaja(String nomCaja, JTable tabla) throws Exception {
        try {
            //validar si el nombre de la caja ya existe en la BD
            int opc = 0;
            Caja c = new Caja();
            c.setNomCaja(nomCaja);
            CajaDAO cdao = new CajaDAO();
            for (Caja ca : cdao.Listar()) {
                if (ca.getNomCaja().equals(nomCaja)) {
                    opc++;
                }
            }
            if (opc > 0) {
                tabla.clearSelection();
                return "LA CAJA QUE DESEA REGISTRAR YA EXISTE";
            } else {
                cdao.Registrar(c);
                RefrescarTablaCajas(tabla);
                return "CAJA REGISTRADA";
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void cargarComboCajas(JComboBox cmb) throws Exception {
        CajaDAO cdao = new CajaDAO();
        for (Caja c : cdao.Listar()) {
            cmb.addItem(c.getNomCaja());
        }
    }

    public void cargarTablaUsuarios(JTable tabla) throws Exception {
        try {
            tabla.setModel(modeloTablaUsuarios);
            UsuarioDAO udao = new UsuarioDAO();

            modeloTablaUsuarios.addColumn("ID");
            modeloTablaUsuarios.addColumn("NOMBRES");
            modeloTablaUsuarios.addColumn("APELLIDOS");

            Object[] columna = new Object[3];

            int numeroRegistros = udao.listar().size();

            for (int i = 0; i < numeroRegistros; i++) {
                columna[0] = udao.listar().get(i).getId();
                columna[1] = udao.listar().get(i).getNombre();
                columna[2] = udao.listar().get(i).getApellido();
                modeloTablaUsuarios.addRow(columna);
                tabla.setModel(modeloTablaUsuarios);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    /*METODO PARA OBTENER EL ID DE USUARIO CON EL NOMBRE*/
    public int getIdUsuario(String nombre) throws Exception {
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getNombre().equals(nombre)) {
                    return u.getId();
                }
            }
            return 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /*METODO PARA OBTENER EL ID DE CAJA CON EL NOMBRE*/
    public int getIdCaja(String nomCaja) throws Exception {
        try {
            CajaDAO cdao = new CajaDAO();
            for (Caja c : cdao.Listar()) {
                if (c.getNomCaja().equals(nomCaja)) {
                    return c.getIdCaja();
                }
            }
            return 0;
        } catch (Exception e) {
            throw e;
        }
    }

    /*METODO PARA GUARDAR DATOS DE USUARIO-CAJA*/
    public boolean registrarUsuarioCaja(String nomUsuario, String nomCaja) throws Exception {
        try {
            //validar que el usuario no este registrado en la misma caja varias veces - en caso contrario modificar la caja asignada
            int idUsuario = getIdUsuario(nomUsuario);
            int idCaja = getIdCaja(nomCaja);
            UsuarioCajaDAO cdao = new UsuarioCajaDAO();
            for (UsuarioCaja uc2 : cdao.Listar()) {
                if (uc2.getIdusuario() == idUsuario && uc2.getIdcaja() == idCaja) {
                    //ya tiene asignada una caja este usuario -> modificar
                    
                } else {
                    //no tiene asignada una caja este usuario -> registrar
                    UsuarioCaja uc = new UsuarioCaja();
                    uc.setIdusuario(idUsuario);
                    uc.setIdcaja(idCaja);
                    if (cdao.Registrar(uc)) {
                        return true;
                    }
                }
            }

            return false;
        } catch (Exception e) {
            throw e;
        }
    }

}

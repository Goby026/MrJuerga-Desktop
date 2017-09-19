package Controlador;

import Modelo.Perfil;
import Modelo.MySQLDAO.PerfilDAO;
import Modelo.Usuario;
import Modelo.MySQLDAO.UsuarioDAO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UsuariosControl{

    DefaultTableModel modelo= new DefaultTableModel();;
    FileInputStream entrada;
    FileOutputStream salida;

    public void LlenarTablaUsuarios(JTable tabla, int small, int large, int xl) throws Exception {        
        tabla.setModel(modelo);
        UsuarioDAO ved = new UsuarioDAO();

        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDOS");
        modelo.addColumn("DNI");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("USUARIO");

        Object[] columna = new Object[7];

        int numeroRegistros = ved.listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = ved.listar().get(i).getId();
            columna[1] = ved.listar().get(i).getNombre();
            columna[2] = ved.listar().get(i).getApellido();
            columna[3] = ved.listar().get(i).getDni();
            columna[4] = ved.listar().get(i).getTelefono();
            columna[5] = ved.listar().get(i).getDireccion();
            columna[6] = ved.listar().get(i).getUsuario();
            modelo.addRow(columna);
        }

        tabla.getColumnModel().getColumn(0).setPreferredWidth(small);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(large);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(large);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(small);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(small);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(xl);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(large);
    }


//    public void llenarComboPerfil(JComboBox cmb) throws Exception {
//        try {
//            PerfilDAO pdao = new PerfilDAO();
//            for (Perfil p : pdao.Listar()) {
//                cmb.addItem(p.getDescripcion());
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }

    public Object[] capturarDatosDeTabla(JTable tabla, int id) throws Exception {
        Object datos[] = new Object[9];
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getId() == id) {
                    datos[0] = u.getId();
                    datos[1] = u.getNombre();
                    datos[2] = u.getApellido();
                    datos[3] = u.getDni();
                    datos[4] = u.getTelefono();
                    datos[5] = u.getDireccion();
                    datos[6] = u.getUsuario();
                    datos[7] = u.getPass();
                    return datos;
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
        return null;
    }
    
    public void cargarComboPerfiles(JComboBox perfiles){
        try {
            PerfilDAO pdao = new PerfilDAO();
                    
            for (Perfil p : pdao.Listar()) {
                perfiles.addItem(p);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    

    /*METODO PARA OBTENER EL ULTIMO ID DE USUARIO REGISTRADO*/
    public int getUltimoIdUsuario() throws Exception {
        UsuarioDAO udao = new UsuarioDAO();
        int id = 0;
//        for (Usuario u : udao.listar()) {
//            return u.getId();
//        }
        for (int i = 0; i < udao.listar().size(); i++) {
            id = udao.listar().get(i).getId();
        }
        return id;
    }

    /*METODO PARA OBTENER EL ID DE PERFIL CON EL NOMBRE*/
    public int getIdPerfil(Perfil perfil) throws Exception {
        try {
            PerfilDAO pdao = new PerfilDAO();
            for (Perfil p : pdao.Listar()) {
                if (p.getDescripcion().equals(perfil.getDescripcion())) {
                    return p.getIdperfil();
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return 0;
    }


    /*METODO PARA ABRIR IMAGEN*/
    public byte[] AbrirImagen(File archivo) throws Exception {
        Long l = archivo.length();
        Integer tam = l.intValue();
        byte[] bytesIMG = new byte[tam];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(bytesIMG);
        } catch (Exception e) {
            throw e;
        }
        return bytesIMG;
    }

    /*METODO PARA GUARDAR IMAGEN*/
    public String GuardarImagen(File archivo, byte[] bytesIMG) throws Exception {
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            salida.write(bytesIMG);
            respuesta = "SE GUARDO LA IMAGEN";
        } catch (Exception e) {
            throw e;
        }
        return respuesta;
    }
    
    //METODO PARA ACTUALIZAR LA TABLA CUANDO SE REGISTRE, ELIMINE O MODIFIQUE UN USUARIO
    public void RefrescarTablaArea(JTable tabla) throws Exception {
        tabla.setModel(modelo);
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
        LlenarTablaUsuarios(tabla,50, 100, 150);
    }
    
    //METODO PARA VERIFICAR SI YA EXISTE UN USUARIO REGISTRADO CON EL MISMO NOMBRE O DNI
    public boolean verificarUsuario(Usuario user) throws Exception{
        try {
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                if (u.getUsuario().equals(user.getUsuario()) || u.getDni().equals(user.getDni())) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            throw ex;
        }
    }
}

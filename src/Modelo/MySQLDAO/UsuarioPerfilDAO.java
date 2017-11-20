package Modelo.MySQLDAO;

import Interfaces.UsuarioPerfilCRUD;
import Modelo.Conexion;
import Modelo.Usuario;
import Modelo.UsuarioPerfil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class UsuarioPerfilDAO extends Conexion implements UsuarioPerfilCRUD {

    @Override
    public boolean registrar(UsuarioPerfil up) throws Exception {
        try {
            String sql = "insert into usuarioperfil (idusuario, idperfil) values (?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, up.getIdusuario());
            pst.setInt(2, up.getIdperfil());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean modificar(UsuarioPerfil up) throws Exception {
        try {
            String sql = "update usuarioperfil set idusuario=?, idperfil=? where idusuarioperfil=?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, up.getIdusuario());
            pst.setInt(2, up.getIdperfil());
            pst.setInt(3, up.getIdusuarioperfil());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean eliminar(UsuarioPerfil up) throws Exception {
        try {
            String sql = ("delete from usuarioperfil where idusuarioperfil=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, up.getIdusuarioperfil());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<UsuarioPerfil> listar() throws Exception {
        List<UsuarioPerfil> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from usuarioperfil");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                UsuarioPerfil up = new UsuarioPerfil();
                up.setIdusuarioperfil(rs.getInt("idusuarioperfil"));
                up.setIdusuario(rs.getInt("idusuario"));
                up.setIdperfil(rs.getInt("idperfil"));
                lista.add(up);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    //metodo para obtener usuarios de un determinado perfil
    public List<Usuario> Obtener(int idPerfil) throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select u.idusuario, u.nombre, u.apellido, u.dni, u.ruc, u.telefono, u.direccion, u.imagen, u.usuario, u.pass, u.sueldo, u.sueldofinde, u.planilla \n"
                    + "from usuario u\n"
                    + "inner join usuarioperfil up on u.idusuario = up.idusuario\n"
                    + "where up.idperfil = ? ");
            pst.setInt(1, idPerfil);
            ResultSet res = pst.executeQuery();
            lista = new ArrayList();
            while (res.next()) {
                Usuario u = new Usuario();
                
                u.setId(res.getInt(1));
                u.setNombre(res.getString(2));
                u.setApellido(res.getString(3));
                u.setDni(res.getString(4));
                u.setRuc(res.getString(5));
                u.setTelefono(res.getString(6));
                u.setDireccion(res.getString(7));
                u.setImagen(res.getString(8));
                u.setUsuario(res.getString(9));
                u.setPass(res.getString(10));
                u.setSueldo(res.getDouble(11));
                u.setPlanilla(res.getInt(12));
                
                lista.add(u);
            }
            res.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
}

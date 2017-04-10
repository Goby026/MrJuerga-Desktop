package Modelo.MySQLDAO;

import Interfaces.ConteoProductoCRUD;
import Modelo.Conexion;
import Modelo.ConteoProducto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConteoProductoDAO extends Conexion implements ConteoProductoCRUD {

    String REGISTRAR = "INSERT INTO `conteoproducto`(`idusuario`, `idproducto`, `idpresentacion`, `stock`) VALUES (?,?,?,?)";
    String MODIFICAR = "UPDATE `conteoproducto` SET `idusuario`=?,`idproducto`=?,`idpresentacion`=?,`stock`=?,`fecha`=? WHERE `idconteoproducto`=?";
    String ELIMINAR = "DELETE FROM `conteoproducto` WHERE `idconteoproducto` = ?";
    String LISTAR_TODOS = "SELECT `idconteoproducto`, `idusuario`, `idproducto`, `idpresentacion`, `stock`, `fecha` FROM `conteoproducto`";
    String LISTAR_POR_FECHA = "SELECT `idconteoproducto`, `idusuario`, `idproducto`, `idpresentacion`, `stock`, `fecha` FROM `conteoproducto` WHERE `fecha` = ?";

    @Override
    public boolean Registrar(ConteoProducto cp) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(REGISTRAR);
            pst.setInt(1, cp.getIdUsuario());
            pst.setInt(2, cp.getIdProducto());
            pst.setInt(3, cp.getIdPresentacion());
            pst.setInt(4, cp.getStock());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(ConteoProducto cp) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(MODIFICAR);
            pst.setInt(1, cp.getIdUsuario());
            pst.setInt(2, cp.getIdProducto());
            pst.setInt(3, cp.getIdPresentacion());
            pst.setInt(4, cp.getStock());
            pst.setInt(5, cp.getIdConteoProducto());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Eliminar(ConteoProducto cp) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(ELIMINAR);
            pst.setInt(1, cp.getIdConteoProducto());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<ConteoProducto> Listar() throws Exception {
        List<ConteoProducto> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(LISTAR_TODOS);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                ConteoProducto cp = new ConteoProducto();
                cp.setIdConteoProducto(res.getInt("idconteoproducto"));
                cp.setIdUsuario(res.getInt("idusuario"));
                cp.setIdProducto(res.getInt("idproducto"));
                cp.setIdPresentacion(res.getInt("idpresentacion"));
                cp.setStock(res.getInt("stock"));
                cp.setFecha(res.getDate("fecha"));
                lista.add(cp);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public ConteoProducto obtener(String fecha) throws Exception {
        ConteoProducto cp = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(LISTAR_POR_FECHA);
            pst.setString(1, ELIMINAR);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                cp = new ConteoProducto();
                cp.setIdConteoProducto(res.getInt("idconteoproducto"));
                cp.setIdUsuario(res.getInt("idusuario"));
                cp.setIdProducto(res.getInt("idproducto"));
                cp.setIdPresentacion(res.getInt("idpresentacion"));
                cp.setStock(res.getInt("stock"));
                cp.setFecha(res.getDate("fecha"));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return cp;
    }

}

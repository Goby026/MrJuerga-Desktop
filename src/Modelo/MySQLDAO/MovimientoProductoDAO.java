package Modelo.MySQLDAO;

import Interfaces.MovimientoProductoCRUD;
import Modelo.Conexion;
import Modelo.MovimientoProducto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class MovimientoProductoDAO extends Conexion implements MovimientoProductoCRUD {

    @Override
    public boolean Registrar(MovimientoProducto mp) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO movimientoproducto(idmovimiento,idproducto,idpresentacion,cantidad, valorizacion) VALUES (?,?,?,?,?)");
            pst.setInt(1, mp.getIdMovimiento());
            pst.setInt(2, mp.getIdProducto());
            pst.setInt(3, mp.getIdPresentacion());
            pst.setDouble(4, mp.getCantidad());
            pst.setDouble(5, mp.getValorizacion());
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
    public boolean Modificar(MovimientoProducto mp) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE movimientoproducto SET idmovimiento=?, idproducto=?,idpresentacion=?, cantidad=? ,valorizacion=? WHERE idmovimientoproducto = ?");
            pst.setInt(1, mp.getIdMovimiento());
            pst.setInt(2, mp.getIdProducto());
            pst.setInt(3, mp.getIdPresentacion());
            pst.setDouble(4, mp.getCantidad());
            pst.setDouble(5, mp.getValorizacion());
            pst.setInt(6, mp.getIdMovimientoProducto());
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
    public boolean Eliminar(MovimientoProducto mp) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM movimientoproducto WHERE idmovimiento = ?");
            pst.setInt(1, mp.getIdMovimientoProducto());
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
    public List<MovimientoProducto> Listar() throws Exception {
        List<MovimientoProducto> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM movimientoproducto");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                MovimientoProducto mp = new MovimientoProducto();
                mp.setIdMovimientoProducto(res.getInt("idmovimientoproducto"));
                mp.setIdMovimiento(res.getInt("idmovimiento"));
                mp.setIdProducto(res.getInt("idproducto"));
                mp.setIdPresentacion(res.getInt("idpresentacion"));
                mp.setCantidad(res.getDouble("cantidad"));
                mp.setValorizacion(res.getDouble("valorizacion"));
                lista.add(mp);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    //metodo para listar los productos movidos a partir de un idmovimiento
    public List<MovimientoProducto> Listar(int idMovimiento) throws Exception {
        List<MovimientoProducto> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM movimientoproducto WHERE idmovimiento = ?");
            pst.setInt(1, idMovimiento);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                MovimientoProducto mp = new MovimientoProducto();
                mp.setIdMovimientoProducto(res.getInt("idmovimientoproducto"));
                mp.setIdMovimiento(res.getInt("idmovimiento"));
                mp.setIdProducto(res.getInt("idproducto"));
                mp.setIdPresentacion(res.getInt("idpresentacion"));
                mp.setCantidad(res.getDouble("cantidad"));
                mp.setValorizacion(res.getDouble("valorizacion"));
                lista.add(mp);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public MovimientoProducto obtener(int id) throws Exception {
        MovimientoProducto mp = null;
        try {

            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM movimientoproducto WHERE idmovimiento = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                mp = new MovimientoProducto();
                mp.setIdMovimientoProducto(res.getInt("idmovimientoproducto"));
                mp.setIdMovimiento(res.getInt("idmovimiento"));
                mp.setIdProducto(res.getInt("idproducto"));
                mp.setIdPresentacion(res.getInt("idpresentacion"));
                mp.setCantidad(res.getDouble("cantidad"));
                mp.setValorizacion(res.getDouble("valorizacion"));
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return mp;
    }
}

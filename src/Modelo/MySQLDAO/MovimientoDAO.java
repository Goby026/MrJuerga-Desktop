package Modelo.MySQLDAO;

import Interfaces.MovimientoCRUD;
import Modelo.Conexion;
import Modelo.Movimiento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class MovimientoDAO extends Conexion implements MovimientoCRUD{

    @Override
    public boolean Registrar(Movimiento m) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO movimiento(fecha,hora,idtipomovimiento,idusuario, observacion) VALUES (?,?,?,?,?)");
            pst.setString(1, m.getFecha());
            pst.setString(2, m.getHora());
            pst.setInt(3, m.getIdtipoMovimiento());
            pst.setInt(4, m.getIdUsuario());
            pst.setString(5, m.getObservacion());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(Movimiento m) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE movimiento SET fecha=?, hora=?,idtipomovimiento=?, idusuario=? ,observacion=? WHERE idmovimiento = ?");
            pst.setString(1, m.getFecha());
            pst.setString(2, m.getHora());
            pst.setInt(3, m.getIdtipoMovimiento());
            pst.setInt(4, m.getIdUsuario());
            pst.setString(5, m.getObservacion());
            pst.setInt(6, m.getIdMovimiento());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Eliminar(Movimiento m) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM movimiento WHERE idmovimiento = ?");
            pst.setInt(1, m.getIdMovimiento());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<Movimiento> Listar() throws Exception {
        List<Movimiento> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM movimiento");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Movimiento m = new Movimiento();
                m.setIdMovimiento(res.getInt("idtmovimiento"));
                m.setFecha(res.getString("fecha"));
                m.setHora(res.getString("hora"));
                m.setIdMovimiento(res.getInt("idtipomovimiento"));
                m.setIdUsuario(res.getInt("idusuario"));
                m.setObservacion(res.getString("observacion"));
                lista.add(m);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }

    @Override
    public Movimiento obtener(int id) throws Exception {
        Movimiento m = null;
        try {
            
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM movimiento WHERE idmovimiento = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                 m = new Movimiento();
                 m.setIdMovimiento(rs.getInt("idmovimiento"));
                 m.setFecha(rs.getString("fecha"));
                 m.setHora(rs.getString("hora"));
                 m.setIdtipoMovimiento(rs.getInt("idtipomovimiento"));
                 m.setIdUsuario(rs.getInt("idusuario"));
                 m.setObservacion(rs.getString("observacion"));
            }
            pst.close();
            rs.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return m;
    }
    
    public int getUltimoMovimiento() throws Exception{
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idmovimiento FROM movimiento ORDER BY idmovimiento DESC limit 1");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("idmovimiento");
            }
            pst.close();
            rs.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }
}

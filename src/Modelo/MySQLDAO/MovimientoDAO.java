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
public class MovimientoDAO extends Conexion implements MovimientoCRUD {

    @Override
    public boolean Registrar(Movimiento m) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO movimiento(notaPedido,fecha, hora, observacion, idtipomovimiento, idusuario, idtipoComprobante, idproveedor, idalmacen) VALUES (?,?,?,?,?,?,?,?,?)");
            pst.setString(1, m.getNotaPedido());
            pst.setString(2, m.getFecha());
            pst.setString(3, m.getHora());
            pst.setString(4, m.getObservacion());
            pst.setInt(5, m.getIdtipoMovimiento());
            pst.setInt(6, m.getIdUsuario());
            pst.setInt(7, m.getIdTipoComprobante());
            pst.setInt(8, m.getIdProveedor());
            pst.setInt(9, m.getIdAlmacen());

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
    public boolean Modificar(Movimiento m) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE movimiento SET fecha=?, hora=?, observacion=?, idtipomovimiento=?, idusuario=?, idtipoComprobante=?, idproveedor=?, idalmacen=? WHERE idmovimiento = ?");
            pst.setString(1, m.getNotaPedido());
            pst.setString(2, m.getFecha());
            pst.setString(3, m.getHora());
            pst.setString(4, m.getObservacion());
            pst.setInt(5, m.getIdtipoMovimiento());
            pst.setInt(6, m.getIdUsuario());
            pst.setInt(7, m.getIdTipoComprobante());
            pst.setInt(8, m.getIdProveedor());
            pst.setInt(9, m.getIdAlmacen());
            pst.setInt(10, m.getIdMovimiento());
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
        } finally {
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
                m.setIdMovimiento(res.getInt(1));
                m.setNotaPedido(res.getString(2));
                m.setFecha(res.getString(3));
                m.setHora(res.getString(4));
                m.setObservacion(res.getString(5));
                m.setIdtipoMovimiento(res.getInt(6));
                m.setIdUsuario(res.getInt(7));
                m.setIdTipoComprobante(res.getInt(8));
                m.setIdProveedor(res.getInt(9));
                m.setIdAlmacen(res.getInt(10));
                lista.add(m);
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
    public Movimiento obtener(int id) throws Exception {
        Movimiento m = null;
        try {

            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM movimiento WHERE idmovimiento = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                m = new Movimiento();
                m.setIdMovimiento(res.getInt(1));
                m.setNotaPedido(res.getString(2));
                m.setFecha(res.getString(3));
                m.setHora(res.getString(4));
                m.setObservacion(res.getString(5));
                m.setIdtipoMovimiento(res.getInt(6));
                m.setIdUsuario(res.getInt(7));
                m.setIdTipoComprobante(res.getInt(8));
                m.setIdProveedor(res.getInt(9));
                m.setIdAlmacen(res.getInt(10));
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return m;
    }

    public tablaBuscarMovimiento obtenerPorNotaPedido(String notaPedido) throws Exception {
        tablaBuscarMovimiento m = null;
        try {

            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT m.idmovimiento, m.fecha, m.hora ,u.nombre , u.apellido\n"
                    + "FROM movimiento m\n"
                    + "INNER JOIN usuario u ON m.idusuario = u.idusuario\n"
                    + "WHERE m.notaPedido = ?");
            pst.setString(1, notaPedido);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                m = new tablaBuscarMovimiento();
                m.setIdMovimiento(res.getInt(1));
                m.setFecha(res.getString(2));
                m.setHora(res.getString(3));
                m.setUsuario(res.getString(4)+" "+res.getString(5));
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return m;
    }

    /*METODO PARA BUSCAR REQUERIMIENTOS A PARTIR DE DOS FECHAS*/
    public List<tablaBuscarMovimiento> buscarMovimientoPorFechas(String fechaInicio, String fechaFinal) throws Exception {
        List<tablaBuscarMovimiento> lista = new ArrayList<>();
        tablaBuscarMovimiento tb = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT m.idmovimiento,m.notaPedido ,m.fecha, m.hora,u.nombre , u.apellido\n"
                    + "FROM movimiento m\n"
                    + "INNER JOIN usuario u ON m.idusuario = u.idusuario\n"
                    + "WHERE (m.fecha between ? AND ?) AND m.idtipomovimiento = 1");
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                tb = new tablaBuscarMovimiento();

                tb.setIdMovimiento(res.getInt(1));
                tb.setNumNota(res.getString(2));
                tb.setFecha(res.getString(3));
                tb.setHora(res.getString(4));
                tb.setUsuario(res.getString(5) + " " + res.getString(6));

                lista.add(tb);
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

    public int getUltimoMovimiento() throws Exception {
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

    public class tablaBuscarMovimiento {

        private int idMovimiento;
        private String numNota;
        private String usuario;
        private String fecha;
        private String hora;

        public tablaBuscarMovimiento() {
        }

        public int getIdMovimiento() {
            return idMovimiento;
        }

        public void setIdMovimiento(int idMovimiento) {
            this.idMovimiento = idMovimiento;
        }

        public String getNumNota() {
            return numNota;
        }

        public void setNumNota(String numNota) {
            this.numNota = numNota;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getHora() {
            return hora;
        }

        public void setHora(String hora) {
            this.hora = hora;
        }

        @Override
        public String toString() {
            return "tablaBuscarMovimiento{" + "idMovimiento=" + idMovimiento + ", numNota=" + numNota + ", usuario=" + usuario + ", fecha=" + fecha + ", hora=" + hora + '}';
        }
        
    }
}

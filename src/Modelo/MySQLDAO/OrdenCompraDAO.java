package Modelo.MySQLDAO;

import Interfaces.OrdenCompraCRUD;
import Modelo.Conexion;
import Modelo.OrdenCompra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdenCompraDAO extends Conexion implements OrdenCompraCRUD {

    String REGISTRAR = "INSERT INTO `ordencompra`(`fecha`, `hora`, `estado`, `moneda`, `serie`, `num_comprobante`, `entrega`, `idusuario`, `iproveedor`, `idtipocomprobante`) VALUES (?,?,?,?,?,?,?,?,?,?)";    
    String MODIFICAR = "UPDATE `ordencompra` SET `fecha`=?,`hora`=?,`estado`=?,`moneda`=?,`serie`=?,`num_comprobante`=?,`entrega`=?,`idusuario`=?,`iproveedor`=?,`idtipocomprobante`=? WHERE `idordencompra`=?";
    String ANULAR = "UPDATE ordencompra SET estado = 0 WHERE idordencompra = ?";
    String OBTENER_TODAS = "SELECT * FROM ordencompra";
    String OBTENER_UNA = "SELECT * FROM ordencompra WHERE idordencompra = ?";
    String ULTIMA_COMPRA = "SELECT idordencompra FROM ordencompra ORDER BY idordencompra DESC limit 1";

    @Override
    public boolean registrar(OrdenCompra oc) throws Exception {
        ResultSet rs = null;
        try {
            this.conectar();
//            this.getConexion().setAutoCommit(false);
            PreparedStatement pst = this.conexion.prepareStatement(REGISTRAR);
            pst.setString(1, oc.getFecha());
            pst.setString(2, oc.getHora());
            pst.setInt(3, oc.getEstado());
            pst.setString(4, oc.getMoneda());
            pst.setString(5, oc.getSerie());
            pst.setString(6, oc.getNroComprobante());
            pst.setString(7, oc.getFechaEntrega());
            pst.setInt(8, oc.getIdUsuario());
            pst.setInt(9, oc.getIdProveedor());
            pst.setInt(10, oc.getIdTipoComprobante());
            int res = pst.executeUpdate();
            pst.close();
            if (res>0) {
                return true;
            }
//            this.getConexion().commit();
        } catch (Exception e) {
//            this.getConexion().rollback();
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean modificar(OrdenCompra oc) throws Exception {
        try {

            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(MODIFICAR);
            pst.setString(1, oc.getFecha());
            pst.setString(2, oc.getHora());
            pst.setInt(3, oc.getEstado());
            pst.setString(4, oc.getMoneda());
            pst.setString(5, oc.getSerie());
            pst.setString(6, oc.getNroComprobante());
            pst.setString(7, oc.getFechaEntrega());
            pst.setInt(8, oc.getIdUsuario());
            pst.setInt(9, oc.getIdProveedor());
            pst.setInt(10, oc.getIdTipoComprobante());
            pst.setInt(11, oc.getIdOrdenCompra());

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
    public boolean anular(OrdenCompra oc) throws Exception {
        try {
            //estado 0=anulado - 1=activo
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(ANULAR);
            pst.setInt(1, oc.getIdOrdenCompra());
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
    public List<OrdenCompra> listar() throws Exception {
        List<OrdenCompra> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(OBTENER_TODAS);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                OrdenCompra oc = new OrdenCompra();
                oc.setIdOrdenCompra(rs.getInt("idordencompra"));
                oc.setFecha(rs.getString("fecha"));
                oc.setHora(rs.getString("hora"));
                oc.setEstado(rs.getInt("estado"));
                oc.setMoneda(rs.getString("moneda"));
                oc.setMoneda(rs.getString("serie"));
                oc.setNroComprobante(rs.getString("num_comprobante"));
                oc.setFechaEntrega(rs.getString("entrega"));
                oc.setIdUsuario(rs.getInt("idusuario"));
                oc.setIdProveedor(rs.getInt("idproveedor"));
                oc.setIdTipoComprobante(rs.getInt("idtipocomprobante"));
                lista.add(oc);
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
    
    public int getUltimaCompra() throws Exception{
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(ULTIMA_COMPRA);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("idordencompra");
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

package Modelo.MySQLDAO;

import Interfaces.OrdenCompraCRUD;
import Modelo.Conexion;
import Modelo.OrdenCompra;
import Modelo.Proveedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdenCompraDAO extends Conexion implements OrdenCompraCRUD {

    String REGISTRAR = "INSERT INTO `ordencompra`(`fecha`, `hora`, `estado`, `moneda`, `serie`, `num_comprobante`, `entrega`, `idusuario`, `idproveedor`, `idtipocomprobante`) VALUES (?,?,?,?,?,?,?,?,?,?)";
    String MODIFICAR = "UPDATE `ordencompra` SET `fecha`=?,`hora`=?,`estado`=?,`moneda`=?,`serie`=?,`num_comprobante`=?,`entrega`=?,`idusuario`=?,`idproveedor`=?,`idtipocomprobante`=? WHERE `idordencompra`=?";
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
            if (res > 0) {
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

    public OrdenCompra obtener(int id) throws Exception {
        OrdenCompra oc = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(OBTENER_UNA);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                oc = new OrdenCompra();
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
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        }
        return oc;
    }

    public int getUltimaCompra() throws Exception {
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

    //metodo para obtener proveedor a partir de una compra
    public Proveedor obtenerPorOrdenCompra(int orden) throws Exception {
        Proveedor p = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT proveedor.idProveedor, proveedor.razon, proveedor.ruc, proveedor.direccion, proveedor.ciudad, proveedor.telf_proveedor, proveedor.cod_postal, proveedor.correo, proveedor.codProveedor FROM ordencompra\n"
                    + "INNER JOIN proveedor on ordencompra.idproveedor = proveedor.idproveedor\n"
                    + "WHERE ordencompra.idordencompra =" + orden);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                p = new Proveedor();
                p.setIdProveedor(res.getInt(1));
                p.setRazon(res.getString(2));
                p.setRuc(res.getString(3));
                p.setDireccion(res.getString(4));
                p.setCiudad(res.getString(5));
                p.setTelf_prov(res.getString(6));
                p.setCod_pos(res.getString(7));
                p.setCorreo(res.getString(8));
                p.setCodProv(res.getString(9));
            }

            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return p;
    }

}

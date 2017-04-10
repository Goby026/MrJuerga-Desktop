/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.VentaCRUD;
import Modelo.Conexion;
import Modelo.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author Gaby
 */
public class VentaDAO extends Conexion implements VentaCRUD {

    @Override
    public boolean registrar(Venta v) throws Exception {
        try {
            String sql = "insert into venta (idventa, fecha, hora, idusuario, idcliente, idcomprobante, estado) values (?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, v.getIdVenta());
            pst.setString(2, v.getFecha());
            pst.setString(3, v.getHora());
            pst.setInt(4, v.getIdUsuario());
            pst.setInt(5, v.getIdCliente());
            pst.setInt(6, v.getIdComprobante());
            pst.setInt(7, v.getEstado());
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
    public boolean modificar(Venta v) throws Exception {
        try {
            String sql = "update venta set fecha=?, hora=?, idusuario=?, idcliente=?, idcomprobante=?, estado=? where idventa = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, v.getFecha());
            pst.setString(2, v.getHora());
            pst.setInt(3, v.getIdUsuario());
            pst.setInt(4, v.getIdCliente());
            pst.setInt(5, v.getIdComprobante());
            pst.setInt(6, v.getEstado());
            pst.setInt(7, v.getIdVenta());
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
    public boolean anular(Venta v) throws Exception {
        try {
            //estado 0=anulado - 1=activo
            String sql = "UPDATE venta SET estado = 0 WHERE idventa = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, v.getIdVenta());
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
    public List<Venta> listar() throws Exception {
        List<Venta> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from venta");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Venta v = new Venta();
                v.setIdVenta(rs.getInt("idventa"));
                v.setFecha(rs.getString("fecha"));
                v.setHora(rs.getString("hora"));
                v.setIdUsuario(rs.getInt("idusuario"));
                v.setIdCliente(rs.getInt("idcliente"));
                v.setIdComprobante(rs.getInt("idcomprobante"));
                v.setEstado(rs.getInt("estado"));
                lista.add(v);
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

    //venta de mes serie 3
    public Object[] ventaMes(int mes, int serie) throws Exception {
        Object[] datos = new Object[7];
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select venta.fechasistema, venta.idventa, round((ventaproducto.subtotal/1.18),2) as 'BASE-IMP',round(((ventaproducto.subtotal/1.18)*0.18),2) as 'IGV' ,ventaproducto.subtotal from venta\n"
                    + "inner join ventaproducto on venta.idventa = ventaproducto.idventa\n"
                    + "where month(fechasistema) = " + mes);
            ResultSet rs = pst.executeQuery();
            //estructura para contadora
            //FECHA-TIPODOCUMENTO-SERIE-NROVENTA-BASEIMPONIBLE(/1.18)-IGV(*0.18)-IMPORTETOTAL
            while (rs.next()) {
                datos[0] = rs.getString("venta.fechasistema"); // fecha de la venta
                datos[1] = "TICKET";//tipo documento
                datos[2] = "003";//serie
                datos[3] = rs.getInt("venta.idventa");// nro de ticket
                datos[4] = rs.getDouble("BASE-IMP"); // base imponible
                datos[5] = rs.getDouble("IGV");
                datos[6] = rs.getDouble("ventaproducto.subtotal"); // importe
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return datos;
    }
}

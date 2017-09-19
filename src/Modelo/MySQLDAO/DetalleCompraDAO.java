package Modelo.MySQLDAO;

import Interfaces.DetalleCompraCRUD;
import Modelo.Conexion;
import Modelo.DetalleCompra;
import java.sql.PreparedStatement;
import java.util.List;

public class DetalleCompraDAO extends Conexion implements DetalleCompraCRUD {

    String REGISTRAR_DETALLE = "INSERT INTO `detallecompra`(`idProductoPresentacion`, `idmedida`, `idcompra`, `cantidad`, `precio`, `dcto`, `subtotal`) VALUES (?,?,?,?,?,?,?)";        

    @Override
    public boolean registrar(DetalleCompra dc) throws Exception {
        try {
            this.conectar();
//            this.getConexion().setAutoCommit(false);
            PreparedStatement pst = this.conexion.prepareStatement(REGISTRAR_DETALLE);
            pst.setInt(1, dc.getIdProductoPresentacion());
            pst.setInt(2, dc.getIdMedida());
            pst.setInt(3, dc.getIdCompra());
            pst.setDouble(4, dc.getCantidad());
            pst.setDouble(5, dc.getPrecio());
            pst.setDouble(6, dc.getDcto());
            pst.setDouble(7, dc.getSubtotal());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
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
    public boolean modificar(DetalleCompra dc) throws Exception {
        try {
            this.conectar();
//            this.getConexion().setAutoCommit(false);
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE detallecompra SET idProductoPresentacion = ?, idmedida = ?, cantidad = ?, precio = ?, dcto = ?, subtotal = ? WHERE idcompra = ?");
            pst.setInt(1, dc.getIdProductoPresentacion());
            pst.setInt(2, dc.getIdMedida());
            pst.setDouble(3, dc.getCantidad());
            pst.setDouble(4, dc.getPrecio());
            pst.setDouble(5, dc.getDcto());
            pst.setDouble(6, dc.getSubtotal());
            pst.setInt(7, dc.getIdCompra());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
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
    public boolean anular(DetalleCompra dc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleCompra> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean updateStock(int idProductoPresentacion, int stock){
        try {
            
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

}

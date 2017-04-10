package Modelo.MySQLDAO;

import Interfaces.DetalleCompraCRUD;
import Modelo.Conexion;
import Modelo.DetalleCompra;
import java.sql.PreparedStatement;
import java.util.List;

public class DetalleCompraDAO extends Conexion implements DetalleCompraCRUD {

    String REGISTRAR_DETALLE = "INSERT INTO `detallecompra`(`idProducto`, `idinsumo`, `idmedida`, `idcompra`, `cantidad`, `precio`, `dcto`, `subtotal`) VALUES (?,?,?,?,?,?,?,?)";

    @Override
    public boolean registrar(DetalleCompra dc) throws Exception {
        try {
            this.conectar();
//            this.getConexion().setAutoCommit(false);
            PreparedStatement pst = this.conexion.prepareStatement(REGISTRAR_DETALLE);
            pst.setInt(1, dc.getIdProducto());
            pst.setInt(2, dc.getIdInsumo());
            pst.setInt(3, dc.getIdMedida());
            pst.setInt(4, dc.getIdCompra());
            pst.setInt(5, dc.getCantidad());
            pst.setDouble(6, dc.getPrecio());
            pst.setDouble(7, dc.getDcto());
            pst.setDouble(8, dc.getSubtotal());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean anular(DetalleCompra dc) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetalleCompra> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

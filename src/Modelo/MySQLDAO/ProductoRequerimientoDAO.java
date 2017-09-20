package Modelo.MySQLDAO;

import Interfaces.DAO;
import Modelo.Conexion;
import Modelo.ProductoRequerimiento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class ProductoRequerimientoDAO extends Conexion implements DAO<ProductoRequerimiento> {

    @Override
    public boolean Registrar(ProductoRequerimiento m) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO producto_requerimiento(idrequerimiento, idproductopresentacion, idmedida, cantidad) VALUES(?,?,?,?)");
            pst.setInt(1, m.getIdRequerimiento());
            pst.setInt(2, m.getIdProductoPresentacion());
            pst.setInt(3, m.getMedida().getIdmedida());
            pst.setInt(4, m.getCantidad());
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
    public boolean Modificar(ProductoRequerimiento m) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE producto_requerimiento SET idrequerimiento = ?, idproductopresentacion = ?, idmedida = ?, cantidad = ? WHERE idrequerimiento = ?");
            pst.setInt(1, m.getIdRequerimiento());
            pst.setInt(2, m.getIdProductoPresentacion());
            pst.setInt(3, m.getMedida().getIdmedida());
            pst.setInt(4, m.getCantidad());
            pst.setInt(5, m.getIdProductoRequerimiento());
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
    public boolean Anular(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE producto_requerimiento SET cantidad = 0 WHERE idrequerimiento = ?");
            pst.setInt(1, id);
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
    public List<ProductoRequerimiento> Listar() throws Exception {
        List<ProductoRequerimiento> lista = new ArrayList<>();
        ProductoRequerimiento m = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idproducto_requerimiento, idrequerimiento, idproductopresentacion, idmedida, cantidad FROM producto_requerimiento");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                m = new ProductoRequerimiento();
                m.setIdProductoRequerimiento(res.getInt(1));
                m.setIdRequerimiento(res.getInt(2));
                m.setIdProductoPresentacion(res.getInt(3));
                m.setMedida(new MedidaDAO().Obtener(res.getInt(4)));
                m.setCantidad(res.getInt(5));
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

    public List<tablaDetalleRequerimiento> Listar(int id) throws Exception {
        List<tablaDetalleRequerimiento> lista = new ArrayList<>();
        tablaDetalleRequerimiento m = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT pp.idproducto, p.nombre, pres.descripcion, m.descripcion, pr.cantidad \n"
                    + "FROM requerimiento r\n"
                    + "INNER JOIN producto_requerimiento pr ON r.idrequerimiento = pr.idrequerimiento\n"
                    + "INNER JOIN productopresentacion pp ON pr.idproductopresentacion = pp.idproductopresentacion\n"
                    + "INNER JOIN medida m ON pr.idmedida = m.idmedida\n"
                    + "INNER JOIN presentacion pres ON pp.idpresentacion = pres.idpresentacion\n"
                    + "INNER JOIN producto p ON pp.idproducto = p.idproducto\n"
                    + "WHERE r.idrequerimiento = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                m = new tablaDetalleRequerimiento();
                m.setIdProducto(res.getInt(1));
                m.setProducto(res.getString(2));
                m.setPresentacion(res.getString(3));
                m.setMedida(res.getString(4));
                m.setCantidad(res.getInt(5));
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
    public ProductoRequerimiento Obtener(int id) throws Exception {
        ProductoRequerimiento m = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idproducto_requerimiento, idrequerimiento, idproductopresentacion, idmedida, cantidad FROM producto_requerimiento WHERE idproducto_requerimiento = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                m = new ProductoRequerimiento();
                m.setIdProductoRequerimiento(res.getInt(1));
                m.setIdRequerimiento(res.getInt(2));
                m.setIdProductoPresentacion(res.getInt(3));
                m.setMedida(new MedidaDAO().Obtener(res.getInt(4)));
                m.setCantidad(res.getInt(5));
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

    @Override
    public boolean Eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<tablaDetalleRequerimiento> getDetalleRequerimiento(int id) throws SQLException, Exception {
        List<tablaDetalleRequerimiento> lista = new ArrayList<>();
        tablaDetalleRequerimiento tdr = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT pr.cantidad, m.descripcion,p.nombre\n"
                    + "FROM requerimiento r\n"
                    + "INNER JOIN producto_requerimiento pr ON r.idrequerimiento = pr.idrequerimiento\n"
                    + "INNER JOIN productopresentacion pp ON pr.idproductopresentacion = pp.idproductopresentacion\n"
                    + "INNER JOIN medida m ON pr.idmedida = m.idmedida\n"
                    + "INNER JOIN producto p ON pp.idproducto = p.idproducto\n"
                    + "WHERE r.idrequerimiento = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                tdr = new tablaDetalleRequerimiento();
                tdr.setCantidad(res.getInt(1));
                tdr.setMedida(res.getString(2));
                tdr.setProducto(res.getString(3));

                lista.add(tdr);
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

    //metodo para saber si se agregaron mas productos al requerimiento
    //original, de tal manera se debe insertar dichos productos al detalle de requerimiento original
    //y los productos que ya estaban, si sufren una modificacion solo se deben actualizar
    public boolean verificarProductoPresentacion(int idRequerimiento, int idProductoPresentacion) throws Exception {
        try {
            this.conectar();
            String sql = "select * from producto_requerimiento where idrequerimiento = ? and idproductopresentacion = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, idRequerimiento);
            pst.setInt(2, idProductoPresentacion);
            ResultSet res = pst.executeQuery() ;
            
            if (res.next()) {
                return true;
            }
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }

        return false;
    }

    /* CLASE INTERNA PARA OBTENER LOS DATOS DEL DETALLE DE REQUERIMIENTO */
    public class tablaDetalleRequerimiento {

        private int idProducto;
        private int cantidad;
        private String medida;
        private String producto;
        private String presentacion;

        public tablaDetalleRequerimiento() {
        }

        public int getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(int idProducto) {
            this.idProducto = idProducto;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public String getMedida() {
            return medida;
        }

        public void setMedida(String medida) {
            this.medida = medida;
        }

        public String getProducto() {
            return producto;
        }

        public void setProducto(String producto) {
            this.producto = producto;
        }

        public String getPresentacion() {
            return presentacion;
        }

        public void setPresentacion(String presentacion) {
            this.presentacion = presentacion;
        }

        @Override
        public String toString() {
            return "tablaDetalleRequerimiento{" + "cantidad=" + cantidad + ", medida=" + medida + ", producto=" + producto + ", presentacion=" + presentacion + '}';
        }

    }
}

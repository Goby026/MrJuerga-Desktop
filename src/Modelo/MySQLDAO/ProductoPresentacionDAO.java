/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.ProductoPresentacionCRUD;
import Modelo.Conexion;
import Modelo.ProductoPresentacion;
import ModelosTablas.InventarioValorizado;
import ModelosTablas.tablaBuscarProducto;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class ProductoPresentacionDAO extends Conexion implements ProductoPresentacionCRUD {

    @Override
    public boolean registrar(ProductoPresentacion pp) throws Exception {
        try {
            String sql = "insert into productopresentacion (idproducto, idcategoria, idpresentacion, idalmacen,stock, precio)VALUES (?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProducto());
            pst.setDouble(2, pp.getIdcategoria());
            pst.setInt(3, pp.getIdPresentacion());
            pst.setInt(4, pp.getIdalmacen());
            pst.setDouble(5, pp.getStock());
            pst.setDouble(6, pp.getPrecio());
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
    public boolean modificar(ProductoPresentacion pp) throws Exception {
        try {
            String sql = ("UPDATE productopresentacion set idproducto = ?, idpresentacion=?, idalmacen = ?, stock = ?,precio = ?, idcategoria = ? where idproductopresentacion=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProducto());
            pst.setInt(2, pp.getIdPresentacion());
            pst.setInt(3, pp.getIdalmacen());
            pst.setDouble(4, pp.getStock());
            pst.setDouble(5, pp.getPrecio());
            pst.setDouble(6, pp.getIdcategoria());
            pst.setInt(7, pp.getIdProductoPresentacion());
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
    public boolean eliminar(ProductoPresentacion pp) throws Exception {
        try {
            String sql = ("delete from productopresentacion where idproductopresentacion= ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProductoPresentacion());
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
    public List<ProductoPresentacion> listar() throws Exception {
        List<ProductoPresentacion> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from productopresentacion");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProductoPresentacion pp = new ProductoPresentacion();
                pp.setIdProductoPresentacion(rs.getInt("idproductopresentacion"));
                pp.setIdProducto(rs.getInt("idproducto"));
                pp.setIdPresentacion(rs.getInt("idpresentacion"));
                pp.setIdalmacen(rs.getInt("idalmacen"));
                pp.setStock(rs.getDouble("stock"));
                pp.setPrecio(rs.getDouble("precio"));
                pp.setIdcategoria(rs.getInt("idcategoria"));
                lista.add(pp);
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

    //Metodo para obteber un elemento a partir de su id
    public ProductoPresentacion obtenerProductoPresentacion(int idProductoPresentacion) throws Exception {
        try {
            ProductoPresentacion pp = new ProductoPresentacion();
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idproducto,idpresentacion,idalmacen,stock,precio, idcategoria FROM productopresentacion "
                    + "WHERE idproductopresentacion = " + idProductoPresentacion);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                pp.setIdProducto(rs.getInt("idproducto"));
                pp.setIdPresentacion(rs.getInt("idpresentacion"));
                pp.setIdalmacen(rs.getInt("idalmacen"));
                pp.setStock(rs.getInt("stock"));
                pp.setPrecio(rs.getDouble("precio"));
                pp.setIdcategoria(rs.getInt("idcategoria"));
            }
            rs.close();
            pst.close();
            return pp;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    //Metodo para obteber los datos de la tabla buscar producto en la parte de conteo diario
    public Object[] datosTablaBuscar(String categoria) throws Exception {
        Object[] datos = new Object[3];
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select producto.idproducto, producto.nombre, presentacion.descripcion from producto\n"
                    + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                    + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                    + "inner join categoria on productopresentacion.idcategoria = categoria.idcategoria\n"
                    + "where categoria.descripcion = '" + categoria + "'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getInt("producto.idproducto");
                datos[1] = rs.getString("producto.nombre");
                datos[2] = rs.getString("presentacion.descripcion");
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

    //Metodo para obteber los datos de la tabla buscar producto en la parte de conteo diario
    public List<tablaBuscarProducto> tablaBuscar(String categoria) throws Exception {
        List<tablaBuscarProducto> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select producto.idproducto, producto.nombre, presentacion.descripcion from producto\n"
                    + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                    + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                    + "inner join categoria on productopresentacion.idcategoria = categoria.idcategoria\n"
                    + "where categoria.descripcion = '" + categoria + "'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                tablaBuscarProducto tbp = new tablaBuscarProducto();
                tbp.setIdProducto(rs.getInt("producto.idproducto"));
                tbp.setProducto(rs.getString("producto.nombre"));
                tbp.setPresentacion(rs.getString("presentacion.descripcion"));
                lista.add(tbp);
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
    
    public List<tablaBuscarProducto> mostrarProductos(String categoria) throws Exception {
        List<tablaBuscarProducto> lista = new ArrayList<>();
        try {
            this.conectar();
            CallableStatement query = this.conexion.prepareCall("{call mostrar_conteo(?)}");
            query.setString(1, categoria);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                tablaBuscarProducto tbp = new tablaBuscarProducto();
                tbp.setIdProducto(rs.getInt(1));
                tbp.setProducto(rs.getString(2));
                tbp.setPresentacion(rs.getString(3));
                lista.add(tbp);
            }
            rs.close();
            query.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    public List<InventarioValorizado> getInventario(String orden) throws Exception {
        List<InventarioValorizado> lista = new ArrayList<>();
        try {
            this.conectar();
            CallableStatement cst = this.conexion.prepareCall("{call get_inventario_ordenado(?)}");
            cst.setString(1, orden);
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                InventarioValorizado iv = new InventarioValorizado();
                iv.setCodigo(rs.getInt(1));
                iv.setProducto(rs.getString(2));
                iv.setPresentacion(rs.getString(3));
                iv.setCategoria(rs.getString(4));
                iv.setStock(rs.getDouble(5));
                iv.setValorizacion(rs.getDouble(6));
                lista.add(iv);
            }
            rs.close();
            cst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    public List<InventarioValorizado> getInventario() throws Exception {
        List<InventarioValorizado> lista = new ArrayList<>();
        try {
            this.conectar();
            CallableStatement cst = this.conexion.prepareCall("{call get_inventario}");
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                InventarioValorizado iv = new InventarioValorizado();
                iv.setCodigo(rs.getInt(1));
                iv.setProducto(rs.getString(2));
                iv.setPresentacion(rs.getString(3));
                iv.setCategoria(rs.getString(4));
                iv.setStock(rs.getDouble(5));
                iv.setPrecio(rs.getDouble(6));
                iv.setValorizacion(rs.getDouble(7));
                lista.add(iv);
            }
            rs.close();
            cst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
//    public int getStock(int idproducto) throws Exception {
//        int stock = 0;
//        String sql = "SELECT `stock_pro_medi` FROM `tproducto_medicamento` WHERE id_pro_medi = " + idproducto + "";
//        try {
//            PreparedStatement pst = this.conexion.prepareStatement(sql);
//            ResultSet rs = pst.executeQuery(sql);
//            if (rs.next()) {
//                stock = rs.getInt("stock_pro_medi");
//            } else {
//            }
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        return stock;
//    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.ProductoCRUD;
import Modelo.Conexion;
import Modelo.Producto;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaby
 */
public class ProductoDAO extends Conexion implements ProductoCRUD {

    @Override
    public boolean registrar(Producto p) throws Exception {
        try {
            String sql = "insert into producto (nombre)VALUES (?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, p.getNombre());
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
    public boolean modificar(Producto p) throws Exception {
        try {
            String sql = ("UPDATE producto set nombre = ? where idproducto=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, p.getNombre());
            pst.setInt(2, p.getIdProducto());
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
    public boolean eliminar(Producto p) throws Exception {
        try {
            String sql = ("delete from producto where idproducto=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdProducto());
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
    public List<Producto> listar() throws Exception {
        List<Producto> lista = null;
        try {
            this.conectar();
            CallableStatement cst = this.conexion.prepareCall("{call cargar_productos}");
            lista = new ArrayList();
            ResultSet rs = cst.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setNombre(rs.getString(2));
                lista.add(p);
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
    
    public Producto obtenerProducto(int idProducto) throws SQLException, Exception{
        Producto p = new Producto();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT nombre FROM producto WHERE idproducto = "+idProducto);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                p.setNombre("nombre");
            }            
            pst.close();
            res.close();
            
        } catch (Exception error) {
            throw error;
        }finally{
            this.cerrar();
        }
        return p;
    }
    
    public int getIdProducto(int idproductopresentacion) throws SQLException, Exception{
        int idProducto = 0;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idproducto FROM productopresentacion WHERE idproductopresentacion = "+idproductopresentacion);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                idProducto = res.getInt("idproducto");
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        }finally{
            this.cerrar();
        }
        return idProducto;
    }
    
    public int getIdProducto(String nombre) throws SQLException, Exception{
        int idProducto = 0;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idproducto FROM producto WHERE nombre = '"+nombre+"'");
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                idProducto = res.getInt("idproducto");
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        }finally{
            this.cerrar();
        }
        return idProducto;
    }
    
}

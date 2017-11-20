/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.DAO;
import Modelo.Conexion;
import Modelo.Inventario;
import java.sql.PreparedStatement;
import java.util.List;

/**
 *
 * @author GROVER
 */
public class InventarioDAO extends Conexion implements DAO<Inventario>{

    @Override
    public boolean Registrar(Inventario p) throws Exception {
        try {
            this.conectar();
            String sql = "";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            
            pst.setString(1, p.getFecha());
            pst.setString(2, p.getHora());
            pst.setInt(3, p.getIdusuario());
            pst.setInt(4, p.getIdflujoinventario());
            pst.setInt(5, p.getEstado());
            
            if (pst.executeUpdate() > 0) {
                return true;
            }
            
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally{
            this.cerrar();
        }
        return false;
    }
    
    public boolean Registrar(Inventario p, int idAlmacen) throws Exception {
        try {
            this.conectar();
            String sql = "";
            switch(idAlmacen){
                case 2:
                     sql = "insert into";
                    break;
                case 3:
                    sql = "insert into";
                    break;
            }            
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            
            pst.setString(1, p.getFecha());
            pst.setString(2, p.getHora());
            pst.setInt(3, p.getIdusuario());
            pst.setInt(4, p.getIdflujoinventario());
            pst.setInt(5, p.getEstado());
            
            if (pst.executeUpdate() > 0) {
                return true;
            }
            
            pst.close();
            
        } catch (Exception e) {
            throw e;
        } finally{
            this.cerrar();
        }
        return false;
        
    }

    @Override
    public boolean Modificar(Inventario p) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Anular(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inventario> Listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inventario Obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

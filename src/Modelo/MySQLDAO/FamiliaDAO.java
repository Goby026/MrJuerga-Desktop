
package Modelo.MySQLDAO;

import Interfaces.DAO;
import Modelo.Conexion;
import Modelo.Familia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GROVER
 */
public class FamiliaDAO extends Conexion implements DAO<Familia>{

    @Override
    public boolean Registrar(Familia p) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO familia (codfamilia, nombre, codigo) VALUES (?,?,?)";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            
            pst.setString(1, p.getCodFamilia());
            pst.setString(2, p.getNombre());
            pst.setString(3, p.getCodigo());
            
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
    public boolean Modificar(Familia p) throws Exception {
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
    public List<Familia> Listar() throws Exception {
        List<Familia> lista = null;
        Familia f = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM familia";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            lista = new ArrayList();
            while (res.next()) {
                f = new Familia();
                f.setCodFamilia(res.getString(1));
                f.setNombre(res.getString(2));
                f.setCodigo(res.getString(3));
                
                lista.add(f);
            }
            
            pst.close();
            res.close();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return lista;
    }

    
    public Familia Obtener(String cod) throws Exception {
        Familia f = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM familia WHERE codfamilia = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, cod);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                f = new Familia();
                f.setCodFamilia(res.getString(1));
                f.setNombre(res.getString(2));
                f.setCodigo(res.getString(3));
            }
            
            pst.close();
            res.close();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return f;
    }

    @Override
    public Familia Obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

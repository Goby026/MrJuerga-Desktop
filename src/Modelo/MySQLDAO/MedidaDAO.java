
package Modelo.MySQLDAO;

import Interfaces.MedidasCRUD;
import Modelo.Conexion;
import Modelo.Medida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class MedidaDAO extends Conexion implements MedidasCRUD {

    @Override
    public boolean Registrar(Medida m) throws Exception {        
        try {
            String sql = "INSERT INTO medida(descripcion, valor) VALUES (?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, m.getDescripcion());
            pst.setDouble(2, m.getValor());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(Medida m) throws Exception {
        try {
            String sql = "UPDATE medida SET descripcion = ?, valor=? WHERE idmedida = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, m.getDescripcion());
            pst.setDouble(2, m.getValor());
            pst.setInt(3, m.getIdmedida());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Eliminar(Medida m) throws Exception {
        try {
            String sql = "DELETE FROM medida WHERE idmedida = ? ";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, m.getIdmedida());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<Medida> Listar() throws Exception {
        List<Medida> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM medida");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Medida m = new Medida();
                m.setIdmedida(res.getInt(1));
                m.setDescripcion(res.getString(2));
                m.setValor(res.getDouble(3));
                li.add(m);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }finally{
            this.cerrar();
        }

        return li;
    }
    
    public Medida Obtener(int id) throws Exception {
        Medida m = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM medida WHERE idmedida = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                m = new Medida();
                m.setIdmedida(res.getInt(1));
                m.setDescripcion(res.getString(2));
                m.setValor(res.getDouble(3));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }finally{
            this.cerrar();
        }
        return m;
    }

}


package Modelo;

import Interfaces.InsumosCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class InsumoDAO extends Conexion implements InsumosCRUD{

    @Override
    public boolean Registrar(Insumo i) throws Exception {
        boolean b = false;
        try {
            String sql = "INSERT INTO insumo(nombre,existencias) VALUES (?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, i.getNombre());
            pst.setDouble(2, i.getExistencias());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public boolean Modificar(Insumo i) throws Exception {
       boolean b = false;
        try {
            String sql = "UPDATE insumo SET nombre = ?,existencias = ? WHERE idinsumo = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, i.getNombre());
            pst.setDouble(2, i.getExistencias());
            pst.setInt(3, i.getIdinsumo());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;  
    }

    @Override
    public boolean Eliminar(Insumo i) throws Exception {
      boolean b = false;

        try {
            String sql = "DELETE FROM insumo WHERE idinsumo = ? ";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, i.getIdinsumo());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public List<Insumo> Listar() throws Exception {
         List<Insumo> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM insumo");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Insumo i = new Insumo();
                i.setIdinsumo(res.getInt("idinsumo"));
                i.setNombre(res.getString("nombre"));
                i.setExistencias(res.getDouble("existencias"));
                li.add(i);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

        return li;
    }
    
}

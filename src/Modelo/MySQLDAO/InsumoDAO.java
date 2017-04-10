
package Modelo.MySQLDAO;

import Interfaces.InsumosCRUD;
import Modelo.Conexion;
import Modelo.Insumo;
import java.sql.CallableStatement;
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
        try {
            this.conectar();
            CallableStatement cst = this.conexion.prepareCall("{call insertar_insumo(?,?)}");
            cst.setString(1, i.getNombre());
            cst.setDouble(2, i.getStock());
            int res = cst.executeUpdate();
            if (res > 0) {
                return true;
            }
            cst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(Insumo i) throws Exception {
       boolean b = false;
        try {
            this.conectar();
            CallableStatement cst = this.conexion.prepareCall("{call modificar_insumo(?,?,?)}");
            cst.setString(1, i.getNombre());
            cst.setDouble(2, i.getStock());
            cst.setInt(3, i.getIdinsumo());
            int res = cst.executeUpdate();
            if (res > 0) {
                b = true;
            }
            cst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;  
    }

    @Override
    public boolean Eliminar(Insumo i) throws Exception {
        try {
            this.conectar();
            CallableStatement cst = this.conexion.prepareCall("{call borrar_insumo(?)}");
            cst.setInt(1, i.getIdinsumo());
            int res = cst.executeUpdate();
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
    public List<Insumo> Listar() throws Exception {
         List<Insumo> li = new ArrayList<>();
        try {
            this.conectar();
            CallableStatement cst = this.conexion.prepareCall("{call listar_insumo}");
            ResultSet res = cst.executeQuery();
            while (res.next()) {
                Insumo i = new Insumo();
                i.setIdinsumo(res.getInt(1));
                i.setNombre(res.getString(2));
                i.setStock(res.getDouble(3));
                li.add(i);
            }
            cst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

        return li;
    }
    
}

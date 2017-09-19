/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.DAO;
import Modelo.Conexion;
import Modelo.Conteo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARCEL
 */
public class ConteoDAO extends Conexion implements DAO<Conteo> {

    @Override
    public boolean Registrar(Conteo c) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO conteo(idusuario, fecha, hora) VALUES(?,?,?)");
            pst.setInt(1, c.getIdusuario());
            pst.setString(2, c.getFecha());
            pst.setString(3, c.getHora());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(Conteo c) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE conteo SET idusuario=?, fecha = ?, hora = ? WHERE idconteo = ?");
            pst.setInt(1, c.getIdusuario());
            pst.setString(2, c.getFecha());
            pst.setString(3, c.getHora());
            pst.setInt(4, c.getIdConteo());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Eliminar(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("DELETE FROM conteo WHERE idconteo = ?");
            pst.setInt(1, id);
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<Conteo> Listar() throws Exception {
        Conteo c = null;
        List<Conteo> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM conteo");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                c = new Conteo();
                c.setIdConteo(res.getInt(1));
                c.setIdusuario(res.getInt(2));
                c.setFecha(res.getString(3));
                c.setHora(res.getString(4));
                lista.add(c);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public Conteo Obtener(int ID) throws Exception {
        Conteo c = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM conteo WHERE idconteo = ?");
            pst.setInt(1, ID);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                c = new Conteo();
                c.setIdConteo(res.getInt(1));
                c.setIdusuario(res.getInt(2));
                c.setFecha(res.getString(3));
                c.setHora(res.getString(4));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return c;
    }

    //metodo para obtener el ultimo conteo registrado
    public int getLastId() throws Exception {
        int id = 0;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT MAX(idconteo) FROM conteo ORDER BY idconte DESC LIMIT 1");
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                id = res.getInt(1);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return id;
    }

    @Override
    public boolean Anular(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

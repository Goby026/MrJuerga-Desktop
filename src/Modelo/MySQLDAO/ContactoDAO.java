/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.ContactosCRUD;
import Modelo.Conexion;
import Modelo.Contacto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class ContactoDAO extends Conexion implements ContactosCRUD{

    @Override
    public boolean Registrar(Contacto c) throws Exception {
       try {
            String sql = "INSERT INTO contacto(nombres,apellidos,direccion,correo,codContacto) VALUES (?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, c.getNombres());
            pst.setString(2, c.getApellidos());
            pst.setString(3, c.getDireccion());
            pst.setString(4, c.getCorreo());
            pst.setString(5, c.getCodContacto());
            int res = pst.executeUpdate();
            if (res > 0) {
                return  true;
            }
        } catch (Exception ex) {            
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(Contacto c) throws Exception {

        try {
            String sql = ("UPDATE contacto SET nombres = ?,apellidos = ? ,direccion = ?,correo = ?,codContacto = ? WHERE idContacto = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, c.getNombres());
            pst.setString(2, c.getApellidos());
            pst.setString(3, c.getDireccion());
            pst.setString(4, c.getCorreo());
            pst.setString(5, c.getCodContacto());
            pst.setInt(6, c.getIdContacto());
            int res = pst.executeUpdate();
            if (res > 0) {
                return  true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Eliminar(Contacto c) throws Exception {
        try {
            String sql = "DELETE FROM contacto WHERE idContacto = ? ";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, c.getIdContacto());
            int res = pst.executeUpdate();
            if (res > 0) {
                return  true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<Contacto> Listar() throws Exception {
        List<Contacto> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM contacto");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Contacto c = new Contacto();
                c.setIdContacto(res.getInt("idContacto"));
                c.setNombres(res.getString("nombres"));
                c.setApellidos(res.getString("apellidos"));
                c.setDireccion(res.getString("direccion"));
                c.setCorreo(res.getString("correo"));
                c.setCodContacto(res.getString("codContacto"));
                li.add(c);
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
    
    
}

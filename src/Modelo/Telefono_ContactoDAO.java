/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.Telefono_ContactosCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class Telefono_ContactoDAO extends Conexion implements Telefono_ContactosCRUD{

    @Override
    public boolean Registrar(Telefono_Contacto tc) throws Exception {
        boolean b = false;
        try {
            String sql = "INSERT INTO telefono_contacto(numero,idcontacto) VALUES (?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, tc.getNumero());
            pst.setInt(2, tc.getIdContacto());
          
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
            pst.close();

        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public boolean Modificar(Telefono_Contacto tc) throws Exception {
        boolean b = false;

        try {
            String sql = "UPDATE telefono_contacto SET numero = ?,idcontacto = ? WHERE idtelefono = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, tc.getNumero());
            pst.setInt(2, tc.getIdContacto());
            pst.setInt(3, tc.getIdTelefono());
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
    public boolean Eliminar(Telefono_Contacto tc) throws Exception {
        boolean b = false;

        try {
            String sql = "DELETE FROM telefono_contacto WHERE idtelefono = ? ";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, tc.getIdTelefono());
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
    public List<Telefono_Contacto> Listar() throws Exception {
     List<Telefono_Contacto> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM telefono_contacto");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Telefono_Contacto tc = new Telefono_Contacto();
                tc.setIdTelefono(res.getInt("idtelefono"));
                tc.setNumero(res.getString("numero"));
                tc.setIdContacto(res.getInt("idcontacto"));
                li.add(tc);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

        return li;    
    }
    
}

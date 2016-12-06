/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.PerfilCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author toshiba
 */
public class PerfilDAO extends Conexion implements PerfilCRUD {

    @Override
    public boolean Registrar(Perfil p) throws Exception {
        try {
            String sql = "INSERT INTO perfil(descripcion)VALUE (?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, p.getDescripcion());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(Perfil p) throws Exception {
        try {
            String sql = ("UPDATE perfil set descripcion = ? where idperfil=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, p.getDescripcion());
            pst.setInt(2, p.getIdperfil());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }

        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public void Eliminar(Perfil p) throws Exception {
        try {
            boolean b = false;
            String sql = ("delete from perfil where idperfil=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdperfil());

            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }

        } catch (Exception e) {
            e.getMessage();
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<Perfil> Listar() throws Exception {
        List<Perfil> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM perfil");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Perfil p = new Perfil();
                p.setIdperfil(res.getInt("idperfil"));
                p.setDescripcion(res.getString("descripcion"));

                li.add(p);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        } finally {
            this.cerrar();
        }
        return li;
    }

}

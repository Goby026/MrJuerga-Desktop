/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Interfaces.CartaCRUD;
import Modelo.Carta;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARCEL
 */
public class CartaDAO extends Conexion implements CartaCRUD{

    @Override
    public boolean Registrar(Carta ca) throws Exception {
        try {
            String sql = "INSERT INTO carta(nomBebida)VALUE (?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, ca.getNomBebida());
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
    public boolean Modificar(Carta ca) throws Exception {
        try {
            String sql = ("UPDATE carta SET nomBebida = ? WHERE idcarta = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, ca.getNomBebida());
            pst.setInt(2, ca.getIdCarta());
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
    public boolean Eliminar(Carta ca) throws Exception {
        try {            
            String sql = ("delete from carta where idcarta =?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, ca.getIdCarta());

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
    public List<Carta> Listar() throws Exception {
        List<Carta> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM carta");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Carta c = new Carta();
                c.setIdCarta(res.getInt("idcarta"));
                c.setNomBebida(res.getString("nomBebida"));
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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Interfaces.ProveedorCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class ProveedorDAO extends Conexion implements ProveedorCRUD {

    @Override
    public boolean Registrar(Proveedor p) throws Exception {
        boolean b = false;
        try {
            String sql = "INSERT INTO proveedor(razon,ruc,direccion,ciudad,telf_proveedor,cod_postal,correo,codProveedor) VALUES (?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, p.getRazon());
            pst.setString(2, p.getRuc());
            pst.setString(3, p.getDireccion());
            pst.setString(4, p.getCiudad());
            pst.setString(5, p.getTelf_prov());
            pst.setString(6, p.getCod_pos());
            pst.setString(7, p.getCorreo());
            pst.setString(8, p.getCodProv());
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
    public boolean Modificar(Proveedor p) throws Exception {
        boolean b = false;
        try {
            String sql = "UPDATE proveedor SET razon = ?, ruc = ?,direccion = ? ,ciudad = ?,telf_proveedor = ?,cod_postal = ?,correo = ?,codProveedor = ? WHERE idProveedor = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, p.getRazon());
            pst.setString(2, p.getRuc());
            pst.setString(3, p.getDireccion());
            pst.setString(4, p.getCiudad());
            pst.setString(5, p.getTelf_prov());
            pst.setString(6, p.getCod_pos());
            pst.setString(7, p.getCorreo());
            pst.setString(8, p.getCodProv());
            pst.setInt(9, p.getIdProveedor());
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
    public boolean Eliminar(Proveedor p) throws Exception {
        boolean b = false;

        try {
            String sql = "DELETE FROM proveedor WHERE idProveedor = ? ";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdProveedor());
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
    public List<Proveedor> Listar() throws Exception {
        List<Proveedor> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM proveedor");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Proveedor p = new Proveedor();
                p.setIdProveedor(res.getInt("idProveedor"));
                p.setRazon(res.getString("razon"));
                p.setRuc(res.getString("ruc"));
                p.setDireccion(res.getString("direccion"));
                p.setCiudad(res.getString("ciudad"));
                p.setTelf_prov(res.getString("telf_proveedor"));
                p.setCod_pos(res.getString("cod_postal"));
                p.setCorreo(res.getString("correo"));
                p.setCodProv(res.getString("codProveedor"));
                li.add(p);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }

        return li;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Adolfo
 */
public class Proveedor implements Serializable{
    
    private Integer idProveedor;
    private String razon;
    private String ruc;
    private String direccion;
    private String ciudad;
    private String telf_prov;
    private String cod_pos;
    private String correo;
    private String codProv;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor, String razon,String ruc, String direccion, String ciudad, String telf_prov, String cod_pos, String correo, String codProv) {
        this.idProveedor = idProveedor;
        this.razon = razon;
        this.ruc = ruc;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telf_prov = telf_prov;
        this.cod_pos = cod_pos;
        this.correo = correo;
        this.codProv = codProv;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelf_prov() {
        return telf_prov;
    }

    public void setTelf_prov(String telf_prov) {
        this.telf_prov = telf_prov;
    }

    public String getCod_pos() {
        return cod_pos;
    }

    public void setCod_pos(String cod_pos) {
        this.cod_pos = cod_pos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodProv() {
        return codProv;
    }

    public void setCodProv(String codProv) {
        this.codProv = codProv;
    }

    @Override
    public String toString() {
        return razon;
    }
    
}

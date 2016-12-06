/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author toshiba
 */

public class Perfil {
    int idperfil;
    String descripcion;
    
    public Perfil(int idperfil,String descripcion){
        this.idperfil=idperfil;
        this.descripcion =descripcion;
    }
    
    
    public Perfil(){
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

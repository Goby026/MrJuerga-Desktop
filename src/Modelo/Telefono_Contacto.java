/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Adolfo
 */
public class Telefono_Contacto {
    private int idTelefono;
    private String numero;
    private int idContacto;

    public Telefono_Contacto() {
    }

    public Telefono_Contacto(Integer idTelefono, String numero, Integer idContacto) {
        this.idTelefono = idTelefono;
        this.numero = numero;
        this.idContacto = idContacto;
    }

    public Integer getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }
    
    
}

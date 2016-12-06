
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Adolfo
 */
public class Contacto implements Serializable{
    
    private Integer idContacto;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String correo;
    private String codContacto;

    public Contacto() {
    }

    public Contacto(Integer idContacto, String nombres, String direccion, String correo, String codContacto) {
        this.idContacto = idContacto;
        this.nombres = nombres;
        this.direccion = direccion;
        this.correo = correo;
        this.codContacto = codContacto;
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodContacto() {
        return codContacto;
    }

    public void setCodContacto(String codContacto) {
        this.codContacto = codContacto;
    }
    
    
    
}


package Modelo;

/**
 *
 * @author GROVER
 */
public class Familia {
    private String codFamilia;
    private String nombre;
    private String codigo;

    public Familia(String codFamilia, String nombre, String codigo) {
        this.codFamilia = codFamilia;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public Familia() {
    }

    public String getCodFamilia() {
        return codFamilia;
    }

    public void setCodFamilia(String codFamilia) {
        this.codFamilia = codFamilia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}

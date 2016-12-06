package Modelo;
/**
 *
 * @author Adolfo
 */
public class Insumo {

    private Integer Idinsumo;
    private String nombre;
    private double existencias;

    public Insumo() {
    }

    public Insumo(Integer Idinsumo, String nombre, double existencias) {
        this.Idinsumo = Idinsumo;
        this.nombre = nombre;
        this.existencias = existencias;
    }

    public Integer getIdinsumo() {
        return Idinsumo;
    }

    public void setIdinsumo(Integer Idinsumo) {
        this.Idinsumo = Idinsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getExistencias() {
        return existencias;
    }

    public void setExistencias(double existencias) {
        this.existencias = existencias;
    }

}

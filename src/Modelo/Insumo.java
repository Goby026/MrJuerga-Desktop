package Modelo;
/**
 *
 * @author Adolfo
 */
public class Insumo {

    private int Idinsumo;
    private String nombre;
    private double stock;

    public Insumo() {
    }

    public Insumo(int Idinsumo, String nombre, double stock) {
        this.Idinsumo = Idinsumo;
        this.nombre = nombre;
        this.stock = stock;
    }

    public int getIdinsumo() {
        return Idinsumo;
    }

    public void setIdinsumo(int Idinsumo) {
        this.Idinsumo = Idinsumo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Insumo{" + "Idinsumo=" + Idinsumo + ", nombre=" + nombre + ", stock=" + stock + '}';
    }

}

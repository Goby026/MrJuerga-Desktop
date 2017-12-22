
package Modelo;

/**
 *
 * @author Grover
 */
public class InventarioProducto {
    private int idinventarioproducto;
    private int idinventario;
    private int idproductopresentacion;
    private double cantidad;

    public InventarioProducto(int idinventarioproducto, int idinventario, int idproductopresentacion, double cantidad) {
        this.idinventarioproducto = idinventarioproducto;
        this.idinventario = idinventario;
        this.idproductopresentacion = idproductopresentacion;
        this.cantidad = cantidad;
    }

    public InventarioProducto() {
    }

    public int getIdinventarioproducto() {
        return idinventarioproducto;
    }

    public void setIdinventarioproducto(int idinventarioproducto) {
        this.idinventarioproducto = idinventarioproducto;
    }

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public int getIdproductopresentacion() {
        return idproductopresentacion;
    }

    public void setIdproductopresentacion(int idproductopresentacion) {
        this.idproductopresentacion = idproductopresentacion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    
}

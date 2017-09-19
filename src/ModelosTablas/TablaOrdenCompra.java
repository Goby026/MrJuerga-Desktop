
package ModelosTablas;

public class TablaOrdenCompra {
    private int idProducto;
    private String nomProd;
    private String presentacion;
    private int cantidad;

    public TablaOrdenCompra() {
    }

    public TablaOrdenCompra(int idProducto, String nomProd, String presentacion, int cantidad) {
        this.idProducto = idProducto;
        this.nomProd = nomProd;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
    }
    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}

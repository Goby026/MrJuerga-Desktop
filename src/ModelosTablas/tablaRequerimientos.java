package ModelosTablas;

//Clase para presentar los datos en la tabla buscarProductos del formulario ConteoDiario
public class tablaRequerimientos {

    int idProducto;
    String producto;
    String presentacion;
    int cantidad;

    public tablaRequerimientos(int idProducto, String producto, String presentacion, int cantidad) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
    }

    public tablaRequerimientos() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getStock() {
        return cantidad;
    }

    public void setStock(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "tablaBuscarProducto{" + "idProducto=" + idProducto + ", producto=" + producto + ", presentacion=" + presentacion + ", stock=" + cantidad + '}';
    }
    
}

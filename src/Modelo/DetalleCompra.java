package Modelo;

public class DetalleCompra {

    private int idDetalleCompra;
    private int idProductoPresentacion;
    private Integer idMedida;
    private int idCompra;
    private double cantidad;
    private double precio;
    private double dcto;
    private double subtotal;

    public DetalleCompra() {
    }

    public DetalleCompra(int idDetalleCompra, int idProductoPresentacion, int idMedida, int idCompra, double cantidad, double precio, double dcto, double subtotal) {
        this.idDetalleCompra = idDetalleCompra;
        this.idProductoPresentacion = idProductoPresentacion;
        this.idMedida = idMedida;
        this.idCompra = idCompra;
        this.cantidad = cantidad;
        this.precio = precio;
        this.dcto = dcto;
        this.subtotal = subtotal;
    }

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public int getIdProductoPresentacion() {
        return idProductoPresentacion;
    }

    public void setIdProductoPresentacion(int idProductoPresentacion) {
        this.idProductoPresentacion = idProductoPresentacion;
    }
    
    public int getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Integer idMedida) {
        this.idMedida = idMedida;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDcto() {
        return dcto;
    }

    public void setDcto(double dcto) {
        this.dcto = dcto;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" + "idDetalleCompra=" + idDetalleCompra + ", idProducto=" + idProductoPresentacion + ", idMedida=" + idMedida + ", idCompra=" + idCompra + ", cantidad=" + cantidad + ", precio=" + precio + ", dcto=" + dcto + ", subtotal=" + subtotal + '}';
    }
    
}

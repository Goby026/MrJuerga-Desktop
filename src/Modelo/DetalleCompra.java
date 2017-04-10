package Modelo;

public class DetalleCompra {

    private int idDetalleCompra;
    private int idProducto;
    private Integer idInsumo;
    private Integer idMedida;
    private int idCompra;
    private int cantidad;
    private double precio;
    private double dcto;
    private double subtotal;

    public DetalleCompra() {
    }

    public DetalleCompra(int idDetalleCompra, int idProducto, int idInsumo, int idMedida, int idCompra, int cantidad, double precio, double dcto, double subtotal) {
        this.idDetalleCompra = idDetalleCompra;
        this.idProducto = idProducto;
        this.idInsumo = idInsumo;
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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Integer idInsumo) {
        this.idInsumo = idInsumo;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
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
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idDetalleCompra;
        hash = 41 * hash + this.idProducto;
        hash = 41 * hash + this.idInsumo;
        hash = 41 * hash + this.idMedida;
        hash = 41 * hash + this.idCompra;
        hash = 41 * hash + this.cantidad;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.dcto) ^ (Double.doubleToLongBits(this.dcto) >>> 32));
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.subtotal) ^ (Double.doubleToLongBits(this.subtotal) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalleCompra other = (DetalleCompra) obj;
        if (this.idDetalleCompra != other.idDetalleCompra) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idInsumo != other.idInsumo) {
            return false;
        }
        if (this.idMedida != other.idMedida) {
            return false;
        }
        if (this.idCompra != other.idCompra) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (Double.doubleToLongBits(this.dcto) != Double.doubleToLongBits(other.dcto)) {
            return false;
        }
        if (Double.doubleToLongBits(this.subtotal) != Double.doubleToLongBits(other.subtotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" + "idDetalleCompra=" + idDetalleCompra + ", idProducto=" + idProducto + ", idInsumo=" + idInsumo + ", idMedida=" + idMedida + ", idCompra=" + idCompra + ", cantidad=" + cantidad + ", precio=" + precio + ", dcto=" + dcto + ", subtotal=" + subtotal + '}';
    }
}

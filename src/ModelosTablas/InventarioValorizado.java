
package ModelosTablas;

import java.util.Objects;

public class InventarioValorizado {
    int codigo;
    String producto;
    String presentacion;
    String categoria;
    double stock;
    double precio;
    double valorizacion;

    public InventarioValorizado() {
    }

    public InventarioValorizado(int codigo, String producto, String presentacion, String categoria, double stock, double precio, double valorizacion) {
        this.codigo = codigo;
        this.producto = producto;
        this.presentacion = presentacion;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;
        this.valorizacion = valorizacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getValorizacion() {
        return valorizacion;
    }

    public void setValorizacion(double valorizacion) {
        this.valorizacion = valorizacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.codigo;
        hash = 47 * hash + Objects.hashCode(this.producto);
        hash = 47 * hash + Objects.hashCode(this.presentacion);
        hash = 47 * hash + Objects.hashCode(this.categoria);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.stock) ^ (Double.doubleToLongBits(this.stock) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.valorizacion) ^ (Double.doubleToLongBits(this.valorizacion) >>> 32));
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
        final InventarioValorizado other = (InventarioValorizado) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.stock) != Double.doubleToLongBits(other.stock)) {
            return false;
        }
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorizacion) != Double.doubleToLongBits(other.valorizacion)) {
            return false;
        }
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        if (!Objects.equals(this.presentacion, other.presentacion)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "inventarioValorizado{" + "codigo=" + codigo + ", producto=" + producto + ", presentacion=" + presentacion + ", categoria=" + categoria + ", stock=" + stock + ", precio=" + precio + ", valorizacion=" + valorizacion + '}';
    }
}

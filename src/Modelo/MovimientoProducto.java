
package Modelo;

public class MovimientoProducto {
    private int idMovimientoProducto;
    private int idMovimiento;
    private int idProducto;
    private int idPresentacion;
    private double cantidad;
    private double valorizacion;

    public MovimientoProducto() {
    }

    public MovimientoProducto(int idMovimientoProducto, int idMovimiento, int idProducto, int idPresentacion, double cantidad, double valorizacion) {
        this.idMovimientoProducto = idMovimientoProducto;
        this.idMovimiento = idMovimiento;
        this.idProducto = idProducto;
        this.idPresentacion = idPresentacion;
        this.cantidad = cantidad;
        this.valorizacion = valorizacion;
    }

    public int getIdMovimientoProducto() {
        return idMovimientoProducto;
    }

    public void setIdMovimientoProducto(int idMovimientoProducto) {
        this.idMovimientoProducto = idMovimientoProducto;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
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
        hash = 53 * hash + this.idMovimientoProducto;
        hash = 53 * hash + this.idMovimiento;
        hash = 53 * hash + this.idProducto;
        hash = 53 * hash + this.idPresentacion;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.cantidad) ^ (Double.doubleToLongBits(this.cantidad) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.valorizacion) ^ (Double.doubleToLongBits(this.valorizacion) >>> 32));
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
        final MovimientoProducto other = (MovimientoProducto) obj;
        if (this.idMovimientoProducto != other.idMovimientoProducto) {
            return false;
        }
        if (this.idMovimiento != other.idMovimiento) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idPresentacion != other.idPresentacion) {
            return false;
        }
        if (Double.doubleToLongBits(this.cantidad) != Double.doubleToLongBits(other.cantidad)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorizacion) != Double.doubleToLongBits(other.valorizacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MovimientoProducto{" + "idMovimientoProducto=" + idMovimientoProducto + ", idMovimiento=" + idMovimiento + ", idProducto=" + idProducto + ", idPresentacion=" + idPresentacion + ", cantidad=" + cantidad + ", valorizacion=" + valorizacion + '}';
    }
    
}


package Modelo;

import java.util.Date;
import java.util.Objects;

public class ConteoProducto {
    int idConteoProducto;
    int idUsuario;
    int idProducto;
    int idPresentacion;
    int stock;
    Date fecha;

    public ConteoProducto() {
    }

    public ConteoProducto(int idConteoProducto, int idUsuario, int idProducto, int idPresentacion, int stock) {
        this.idConteoProducto = idConteoProducto;
        this.idUsuario = idUsuario;
        this.idProducto = idProducto;
        this.idPresentacion = idPresentacion;
        this.stock = stock;
    }

    public int getIdConteoProducto() {
        return idConteoProducto;
    }

    public void setIdConteoProducto(int idConteoProducto) {
        this.idConteoProducto = idConteoProducto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idConteoProducto;
        hash = 11 * hash + this.idUsuario;
        hash = 11 * hash + this.idProducto;
        hash = 11 * hash + this.idPresentacion;
        hash = 11 * hash + this.stock;
        hash = 11 * hash + Objects.hashCode(this.fecha);
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
        final ConteoProducto other = (ConteoProducto) obj;
        if (this.idConteoProducto != other.idConteoProducto) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idPresentacion != other.idPresentacion) {
            return false;
        }
        if (this.stock != other.stock) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConteoProducto{" + "idConteoProducto=" + idConteoProducto + ", idUsuario=" + idUsuario + ", idProducto=" + idProducto + ", idPresentacion=" + idPresentacion + ", stock=" + stock + '}';
    }
    
}



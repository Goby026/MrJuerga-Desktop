
package Modelo;

import java.util.Objects;

public class OrdenCompra {
    private int idOrdenCompra;
    private String fecha;
    private String hora;
    private int estado;
    private String moneda;
    private String serie;
    private String nroComprobante;
    private String fechaEntrega;
    private int idUsuario;
    private int idProveedor;
    private int idTipoComprobante;

    public OrdenCompra() {
    }

    public OrdenCompra(int idOrdenCompra, String fecha, String hora, int estado, String moneda, String serie, String nroComprobante, String fechaEntrega, int idUsuario, int idProveedor, int idTipoComprobante) {
        this.idOrdenCompra = idOrdenCompra;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.moneda = moneda;
        this.serie = serie;
        this.nroComprobante = nroComprobante;
        this.fechaEntrega = fechaEntrega;
        this.idUsuario = idUsuario;
        this.idProveedor = idProveedor;
        this.idTipoComprobante = idTipoComprobante;
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(String nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(int idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.idOrdenCompra;
        hash = 83 * hash + Objects.hashCode(this.fecha);
        hash = 83 * hash + Objects.hashCode(this.hora);
        hash = 83 * hash + this.estado;
        hash = 83 * hash + Objects.hashCode(this.moneda);
        hash = 83 * hash + Objects.hashCode(this.serie);
        hash = 83 * hash + Objects.hashCode(this.nroComprobante);
        hash = 83 * hash + Objects.hashCode(this.fechaEntrega);
        hash = 83 * hash + this.idUsuario;
        hash = 83 * hash + this.idProveedor;
        hash = 83 * hash + this.idTipoComprobante;
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
        final OrdenCompra other = (OrdenCompra) obj;
        if (this.idOrdenCompra != other.idOrdenCompra) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (this.idProveedor != other.idProveedor) {
            return false;
        }
        if (this.idTipoComprobante != other.idTipoComprobante) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (!Objects.equals(this.moneda, other.moneda)) {
            return false;
        }
        if (!Objects.equals(this.serie, other.serie)) {
            return false;
        }
        if (!Objects.equals(this.nroComprobante, other.nroComprobante)) {
            return false;
        }
        if (!Objects.equals(this.fechaEntrega, other.fechaEntrega)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrdenCompra{" + "idOrdenCompra=" + idOrdenCompra + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + ", moneda=" + moneda + ", serie=" + serie + ", nroComprobante=" + nroComprobante + ", fechaEntrega=" + fechaEntrega + ", idUsuario=" + idUsuario + ", idProveedor=" + idProveedor + ", idTipoComprobante=" + idTipoComprobante + '}';
    }
}

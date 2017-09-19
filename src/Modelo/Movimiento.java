/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Marce
 */
public class Movimiento {
    
    private int idMovimiento;
    private String notaPedido;
    private String fecha;
    private String hora;
    private String observacion;
    private int idtipoMovimiento;
    private int idUsuario;    
    private int idTipoComprobante;
    private int idProveedor;
    private int idAlmacen;

    public Movimiento() {
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getNotaPedido() {
        return notaPedido;
    }

    public void setNotaPedido(String notaPedido) {
        this.notaPedido = notaPedido;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdtipoMovimiento() {
        return idtipoMovimiento;
    }

    public void setIdtipoMovimiento(int idtipoMovimiento) {
        this.idtipoMovimiento = idtipoMovimiento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(int idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", hora=" + hora + ", observacion=" + observacion + ", idtipoMovimiento=" + idtipoMovimiento + ", idUsuario=" + idUsuario + ", idTipoComprobante=" + idTipoComprobante + ", idProveedor=" + idProveedor + ", idAlmacen=" + idAlmacen + '}';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Objects;

/**
 *
 * @author Marce
 */
public class Movimiento {
    
    private int idMovimiento;
    private String fecha;
    private String hora;
    private int idtipoMovimiento;
    private int idUsuario;
    private String observacion;    
    
    public Movimiento() {
    }

    public Movimiento(int idMovimiento, String fecha, String hora, int idtipoMovimiento, int idUsuario, String observacion) {
        this.idMovimiento = idMovimiento;
        this.fecha = fecha;
        this.hora = hora;
        this.idtipoMovimiento = idtipoMovimiento;
        this.idUsuario = idUsuario;
        this.observacion = observacion;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idMovimiento;
        hash = 89 * hash + Objects.hashCode(this.fecha);
        hash = 89 * hash + Objects.hashCode(this.hora);
        hash = 89 * hash + this.idtipoMovimiento;
        hash = 89 * hash + this.idUsuario;
        hash = 89 * hash + Objects.hashCode(this.observacion);
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
        final Movimiento other = (Movimiento) obj;
        if (this.idMovimiento != other.idMovimiento) {
            return false;
        }
        if (this.idtipoMovimiento != other.idtipoMovimiento) {
            return false;
        }
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (!Objects.equals(this.observacion, other.observacion)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", hora=" + hora + ", idtipoMovimiento=" + idtipoMovimiento + ", idUsuario=" + idUsuario + ", observacion=" + observacion + '}';
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Adolfo
 */
public class Medida {
    private Integer idmedida;
    private String descripcion;
    private double valor;

    public Medida() {
    }

    public Medida(Integer idmedida, String descripcion, double valor) {
        this.idmedida = idmedida;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public Integer getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(Integer idmedida) {
        this.idmedida = idmedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Medida{" + "idmedida=" + idmedida + ", descripcion=" + descripcion + ", valor=" + valor + '}';
    }
    
}

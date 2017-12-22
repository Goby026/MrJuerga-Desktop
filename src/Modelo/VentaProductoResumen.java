/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MARCEL
 */
public class VentaProductoResumen {

    private int cod;
    private String producto;
    private String presentacion;
    private double cantidad;

    public VentaProductoResumen() {
    }

    public VentaProductoResumen(int cod, String producto, String presentacion, double cantidad) {
        this.cod = cod;
        this.producto = producto;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

}

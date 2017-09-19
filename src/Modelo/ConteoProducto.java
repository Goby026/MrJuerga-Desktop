
package Modelo;

public class ConteoProducto {
    private int idConteoProducto;
    private int idconteo;
    private int idProducto;
    private int idPresentacion;
    private Medida medida;
    private int stock;

    public ConteoProducto() {
    }

    public ConteoProducto(int idConteoProducto, int idconteo, int idProducto, int idPresentacion, Medida medida, int stock) {
        this.idConteoProducto = idConteoProducto;
        this.idconteo = idconteo;
        this.idProducto = idProducto;
        this.idPresentacion = idPresentacion;
        this.medida = medida;
        this.stock = stock;
    }

    public int getIdConteoProducto() {
        return idConteoProducto;
    }

    public void setIdConteoProducto(int idConteoProducto) {
        this.idConteoProducto = idConteoProducto;
    }

    public int getIdconteo() {
        return idconteo;
    }

    public void setIdconteo(int idconteo) {
        this.idconteo = idconteo;
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

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ConteoProducto{" + "idConteoProducto=" + idConteoProducto + ", idconteo=" + idconteo + ", idProducto=" + idProducto + ", presentacion=" + idPresentacion + ", medida=" + medida + ", stock=" + stock + '}';
    }
}



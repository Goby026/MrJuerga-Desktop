
package Modelo;

/**
 *
 * @author MARCEL
 */
public class Traslado {
    private int idTraslado;
    private String fecha;
    private String hora;
    private int idUsuario;
    private int idTipoTraslado;
    

    public Traslado() {
    }

    public Traslado(int idTraslado, String fecha, String hora, int idUsuario, int idTipoTraslado) {
        this.idTraslado = idTraslado;
        this.fecha = fecha;
        this.hora = hora;
        this.idUsuario = idUsuario;
        this.idTipoTraslado = idTipoTraslado;
    }
    
    public int getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(int idTraslado) {
        this.idTraslado = idTraslado;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdTipoTraslado() {
        return idTipoTraslado;
    }

    public void setIdTipoTraslado(int idTipoTraslado) {
        this.idTipoTraslado = idTipoTraslado;
    }

    @Override
    public String toString() {
        return "Traslado{" + "idTraslado=" + idTraslado + ", fecha=" + fecha + ", hora=" + hora + ", idUsuario=" + idUsuario + ", idTipoTraslado=" + idTipoTraslado + '}';
    }
        
}


package Modelo;

/**
 *
 * @author MARCEL
 */
public class Carta {
    int idCarta;
    String nomBebida;

    public Carta() {
    }

    public Carta(int idCarta, String nomBebida) {
        this.idCarta = idCarta;
        this.nomBebida = nomBebida;
    }

    public int getIdCarta() {
        return idCarta;
    }

    public void setIdCarta(int idCarta) {
        this.idCarta = idCarta;
    }

    public String getNomBebida() {
        return nomBebida;
    }

    public void setNomBebida(String nomBebida) {
        this.nomBebida = nomBebida;
    }

    @Override
    public String toString() {
        return "Carta{" + "idCarta=" + idCarta + ", nomBebida=" + nomBebida + '}';
    }    
    
}

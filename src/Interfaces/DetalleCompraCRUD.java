
package Interfaces;

import Modelo.DetalleCompra;
import java.util.List;

public interface DetalleCompraCRUD {
    public boolean registrar(DetalleCompra dc) throws Exception;

    public boolean modificar(DetalleCompra dc) throws Exception;

    public boolean anular(DetalleCompra dc) throws Exception;

    public List<DetalleCompra> listar() throws Exception;
}

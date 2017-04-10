
package Interfaces;

import Modelo.OrdenCompra;
import java.util.List;

public interface OrdenCompraCRUD {
    
    public boolean registrar(OrdenCompra oc) throws Exception;

    public boolean modificar(OrdenCompra oc) throws Exception;

    public boolean anular(OrdenCompra oc) throws Exception;

    public List<OrdenCompra> listar() throws Exception;
}

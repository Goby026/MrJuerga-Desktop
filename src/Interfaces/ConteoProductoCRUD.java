
package Interfaces;

import Modelo.ConteoProducto;
import java.util.List;


public interface ConteoProductoCRUD {
    public boolean Registrar(ConteoProducto cp) throws Exception;
    public boolean Modificar(ConteoProducto cp)throws Exception;
    public boolean Eliminar(ConteoProducto cp)throws Exception;
    public List<ConteoProducto>Listar()throws Exception;
    public ConteoProducto obtener(String fecha)throws Exception;
}

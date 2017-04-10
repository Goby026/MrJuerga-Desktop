package Interfaces;

import Modelo.MovimientoProducto;
import java.util.List;

public interface MovimientoProductoCRUD {

    public boolean Registrar(MovimientoProducto mp) throws Exception;

    public boolean Modificar(MovimientoProducto mp) throws Exception;

    public boolean Eliminar(MovimientoProducto mp) throws Exception;

    public List<MovimientoProducto> Listar() throws Exception;
    
    public MovimientoProducto obtener(int id) throws Exception;
}

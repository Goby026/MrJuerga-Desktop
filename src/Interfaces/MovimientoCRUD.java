package Interfaces;

import Modelo.Movimiento;
import java.util.List;

public interface MovimientoCRUD {

    public boolean Registrar(Movimiento m) throws Exception;

    public boolean Modificar(Movimiento m) throws Exception;

    public boolean Eliminar(Movimiento m) throws Exception;

    public List<Movimiento> Listar() throws Exception;
    
    public Movimiento obtener(int id) throws Exception;
}

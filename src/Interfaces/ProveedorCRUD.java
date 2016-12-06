/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Gasto;
import Modelo.Proveedor;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface ProveedorCRUD {
    public boolean Registrar(Proveedor p)throws Exception;
    public boolean Modificar(Proveedor p)throws Exception;
    public boolean Eliminar(Proveedor p)throws Exception;
    public List<Proveedor> Listar()throws Exception;
}

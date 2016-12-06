/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Gasto;
import Modelo.Insumo;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface InsumosCRUD {
    public boolean Registrar(Insumo i)throws Exception;
    public boolean Modificar(Insumo i)throws Exception;
    public boolean Eliminar(Insumo i)throws Exception;
    public List<Insumo> Listar()throws Exception;
}

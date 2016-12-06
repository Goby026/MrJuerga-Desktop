/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Insumo;
import Modelo.Medida;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface MedidasCRUD {
    public boolean Registrar(Medida m)throws Exception;
    public boolean Modificar(Medida m)throws Exception;
    public boolean Eliminar(Medida m)throws Exception;
    public List<Medida> Listar()throws Exception;
}

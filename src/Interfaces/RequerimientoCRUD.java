/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Requerimiento;
import java.util.List;

/**
 *
 * @author toshiba
 */
public interface RequerimientoCRUD {

    public boolean Registrar(Requerimiento r) throws Exception;

    public boolean Modificar(Requerimiento r) throws Exception;

    public boolean Anular(Requerimiento r) throws Exception;

    public List<Requerimiento> Listar() throws Exception;
    
    public Requerimiento obtener(int id)throws Exception;
}

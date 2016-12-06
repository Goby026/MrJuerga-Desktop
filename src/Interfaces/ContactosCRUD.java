/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Contacto;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface ContactosCRUD {
    
    public boolean Registrar(Contacto c)throws Exception;
    public boolean Modificar(Contacto c)throws Exception;
    public boolean Eliminar(Contacto c)throws Exception;
    public List<Contacto> Listar()throws Exception;
    
}

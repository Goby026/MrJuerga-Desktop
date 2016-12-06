/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Proveedor;
import Modelo.Telefono_Contacto;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public interface Telefono_ContactosCRUD {
    public boolean Registrar(Telefono_Contacto  tc)throws Exception;
    public boolean Modificar(Telefono_Contacto tc)throws Exception;
    public boolean Eliminar(Telefono_Contacto tc)throws Exception;
    public List<Telefono_Contacto> Listar()throws Exception; 
}

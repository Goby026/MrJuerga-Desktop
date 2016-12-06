/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Perfil;
import java.util.List;

/**
 *
 * @author toshiba
 */
public interface PerfilCRUD {
    public boolean Registrar(Perfil p) throws Exception;
    public boolean Modificar(Perfil p) throws Exception;
    public void Eliminar(Perfil p) throws Exception;
    public List <Perfil> Listar() throws Exception;
}

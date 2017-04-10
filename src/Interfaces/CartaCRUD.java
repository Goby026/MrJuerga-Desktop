/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Carta;
import java.util.List;

/**
 *
 * @author toshiba
 */
public interface CartaCRUD {
    public boolean Registrar(Carta ca) throws Exception;

    public boolean Modificar(Carta ca) throws Exception;

    public boolean Eliminar(Carta ca) throws Exception;

    public List<Carta> Listar() throws Exception;
}

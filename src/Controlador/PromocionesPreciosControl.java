/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Modelo.ProductoDAO;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author ELMER_03
 */
public class PromocionesPreciosControl {
    DefaultListModel listaProducto;
    public void buscarProducto(String prod, JList lista) throws Exception{
        try {
            listaProducto = new DefaultListModel();
            ProductoDAO pdao =  new ProductoDAO();
            for (Producto p : pdao.listar()) {
                if (p.getNombre().startsWith(prod)) {
                    listaProducto.addElement(p.getNombre());
                    lista.setModel(listaProducto);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}

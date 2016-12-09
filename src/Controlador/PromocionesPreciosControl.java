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

    public void buscarProducto(String prod, JList lista) throws Exception {
        try {
            int flag = 0;            
            listaProducto = new DefaultListModel();
            ProductoDAO pdao = new ProductoDAO();
            String []nombres = new String[pdao.listar().size()];
            for (Producto p : pdao.listar()) {                
                nombres[flag] = p.getNombre();                
                flag++;
            }
            for (String n : nombres) {
                if (n.startsWith(prod.trim())) {
                    //System.out.println(n+" empieza con "+prod);
                    listaProducto.addElement(n);
                    lista.setModel(listaProducto);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
                    
}

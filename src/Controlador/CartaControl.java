/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Insumo;
import Modelo.Medida;
import Modelo.MySQLDAO.CartaDAO;
import Modelo.MySQLDAO.CategoriaDAO;
import Modelo.MySQLDAO.InsumoDAO;
import Modelo.MySQLDAO.MedidaDAO;
import Modelo.MySQLDAO.ProductoDAO;
import Vista.CartaBebidas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARCEL
 */
public class CartaControl implements ActionListener, InternalFrameListener, KeyListener, MouseListener {

    DefaultTableModel modeloBuscarProductos;
    DefaultTableModel modeloPreparaciones;
    int idProducto = -1;
    int opcionProductos = 0;

    CartaBebidas vistaBebidas;
    CartaDAO cdao;

    public CartaControl(CartaBebidas vistaBebidas, CartaDAO cdao) {
        this.vistaBebidas = vistaBebidas;
        this.cdao = cdao;

        this.vistaBebidas.addInternalFrameListener(this);
        this.vistaBebidas.btnBuscar.addActionListener(this);
        this.vistaBebidas.btnAgregar.addActionListener(this);
        this.vistaBebidas.btnPreparar.addActionListener(this);
        this.vistaBebidas.btnSeleccionarProducto.addActionListener(this);
        this.vistaBebidas.txtBebida.addKeyListener(this);
        this.vistaBebidas.txtProducto.addMouseListener(this);
    }

    public void titulosBuscarProductos(JTable tabla) {
        String titulos[] = {"ID", "PRODUCTO"};
        modeloBuscarProductos = new DefaultTableModel(null, titulos);
        tabla.setModel(modeloBuscarProductos);
    }

    public void titulosPreparaciones(JTable tabla) {
        String titulos[] = {"ID", "PRODUCTO", "INSUMO", "MEDIDA", "CANTIDAD"};
        modeloPreparaciones = new DefaultTableModel(null, titulos);
        tabla.setModel(modeloPreparaciones);
    }

    public void LlenarTablaBuscarProductos(JTable tabla) throws Exception {
        titulosBuscarProductos(tabla);
        ProductoDAO pdao = new ProductoDAO();

        Object[] columna = new Object[2];

        int numeroRegistros = pdao.listar().size();

        for (int i = 0; i < numeroRegistros; i++) {
            columna[0] = pdao.listar().get(i).getIdProducto();
            columna[1] = pdao.listar().get(i).getNombre();
            modeloBuscarProductos.addRow(columna);
        }
        tabla.setModel(modeloBuscarProductos);
        new ColumnasTablas().dosColumnas(tabla, 50, 200);
    }

    public void cargarComboMedida(JComboBox combo) {
        try {
            MedidaDAO mdao = new MedidaDAO();
            for (Medida m : mdao.Listar()) {
                combo.addItem(m.getDescripcion());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarComboCategoria(JComboBox combo) {
        try {
            CategoriaDAO cdao = new CategoriaDAO();
            for (Categoria c : cdao.Listar()) {
                combo.addItem(c.getDescripcion());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarComboInsumos(JComboBox combo) {
        try {
            InsumoDAO idao = new InsumoDAO();
            for (Insumo i : idao.Listar()) {
                combo.addItem(i.getNombre());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean validarProducto(String nomProd) {
        try {
            int producto = new ProductoDAO().getIdProducto(nomProd);
            if (producto > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void panelProductos(int opcion) {
        if (vistaBebidas.tblBuscarProductos.getSelectedRow() >= 0) {
            idProducto = Integer.parseInt(vistaBebidas.tblBuscarProductos.getValueAt(vistaBebidas.tblBuscarProductos.getSelectedRow(), 0).toString());
            String nomProd = vistaBebidas.tblBuscarProductos.getValueAt(vistaBebidas.tblBuscarProductos.getSelectedRow(), 1).toString();
            if (opcion == 1) {
                vistaBebidas.txtBebida.setText(nomProd);
            } else {
                vistaBebidas.txtProducto.setText(nomProd);
            }

            vistaBebidas.panelProductos.dispose();
        } else {
            JOptionPane.showMessageDialog(vistaBebidas.getRootPane(), "SELECCIONE UN PRODUCTO");
        }
    }

    //EVENTOS DE ACTIONPERFORMED (botones)
    @Override
    public void actionPerformed(ActionEvent e) {

        //boton buscar producto
        if (e.getSource() == vistaBebidas.btnBuscar) {
            try {
                idProducto = 1;
                vistaBebidas.panelProductos.setVisible(true);
                vistaBebidas.panelProductos.setBounds(400, 50, 590, 900);
                vistaBebidas.panelProductos.setVisible(true);
                vistaBebidas.panelProductos.setTitle("SELECCIONAR PRODUCTO");
                LlenarTablaBuscarProductos(vistaBebidas.tblBuscarProductos);

                //vistaBebidas.lblProducto.setText(vistaBebidas.txtProducto.getText());

                //vistaBebidas.txtCantidad.requestFocus();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        //boton modal seleccionar producto
        if (e.getSource() == vistaBebidas.btnSeleccionarProducto) {
            panelProductos(idProducto);
        }

        //boton agregar
        if (e.getSource() == vistaBebidas.btnAgregar) {
            titulosPreparaciones(vistaBebidas.tblPreparacion);
            Object datos[] = new Object[5];

            datos[0] = idProducto;
            datos[1] = vistaBebidas.txtProducto.getText();
            datos[2] = vistaBebidas.cmbInsumo.getSelectedItem().toString();
            datos[3] = vistaBebidas.cmbUnidad.getSelectedItem().toString();
            datos[4] = vistaBebidas.txtCantidad.getText();

            modeloPreparaciones.addRow(datos);

            vistaBebidas.tblPreparacion.setModel(modeloPreparaciones);

        }

        //boton crear receta
        if (e.getSource() == vistaBebidas.btnPreparar) {

        }

    }

    //EVENTOS DE INTERNALFRAME
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        if (e.getSource() == vistaBebidas) {
            cargarComboMedida(vistaBebidas.cmbUnidad);
            cargarComboCategoria(vistaBebidas.cmbCategorias);
            cargarComboInsumos(vistaBebidas.cmbInsumo);
            titulosPreparaciones(vistaBebidas.tblPreparacion);
            //System.out.println("cargo internalFrameOpened");
        }
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {

    }

    //EVENTOS DE TECLADO
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vistaBebidas.txtBebida) {
            vistaBebidas.lblProducto.setText(vistaBebidas.txtBebida.getText());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vistaBebidas.txtProducto) {
            idProducto = 2;
            try {
                vistaBebidas.panelProductos.setVisible(true);
                vistaBebidas.panelProductos.setBounds(400, 50, 590, 900);
                vistaBebidas.panelProductos.setVisible(true);
                vistaBebidas.panelProductos.setTitle("SELECCIONAR PRODUCTO");
                LlenarTablaBuscarProductos(vistaBebidas.tblBuscarProductos);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}

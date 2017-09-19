package Controlador;

import Modelo.Categoria;
import Modelo.Conteo;
import Modelo.ConteoProducto;
import Modelo.Medida;
import Modelo.MySQLDAO.CategoriaDAO;
import Modelo.MySQLDAO.ConteoDAO;
import Modelo.MySQLDAO.ConteoProductoDAO;
import Modelo.MySQLDAO.MedidaDAO;
import Modelo.MySQLDAO.PresentacionDAO;
import Modelo.MySQLDAO.ProductoPresentacionDAO;
import Modelo.MySQLDAO.UsuarioDAO;
import Vista.ConteoDiario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARCEL
 */
public class ConteoDiarioControl implements ActionListener, InternalFrameListener, MouseListener {

    ConteoDiario cd;
    DefaultTableModel modeloContados = new DefaultTableModel();
    DefaultTableModel modeloBuscarProducto = new DefaultTableModel();
    HashMap parametros = new HashMap();
    MyiReportVisor mrv;

    public ConteoDiarioControl(ConteoDiario cd) {
        this.cd = cd;
        this.cd.btnAgregar.addActionListener(this);
        this.cd.btnCancelar.addActionListener(this);
        this.cd.btnCrearReporte.addActionListener(this);
        this.cd.btnGuardar.addActionListener(this);
        this.cd.btnLimpiar.addActionListener(this);
        this.cd.btnQuitar.addActionListener(this);
        this.cd.cmbCategorias.addActionListener(this);
        this.cd.cmbMedida.addActionListener(this);
        this.cd.tblBuscarProductos.addMouseListener(this);
        this.cd.tblContados.addMouseListener(this);
        this.cd.addInternalFrameListener(this);
    }

    public void titulosProductos() {
        String cabecera[] = {"ID", "PRODUCTO", "PRESENTACION"};
        modeloBuscarProducto = new DefaultTableModel(null, cabecera);
        cd.tblBuscarProductos.setModel(modeloBuscarProducto);
    }

    public void titulosContados() {
        String cabecera[] = {"ID", "PRODUCTO", "PRESENTACION", "CUENTA"};
        modeloContados = new DefaultTableModel(null, cabecera);
        cd.tblContados.setModel(modeloContados);
    }

    public void tablaBuscarProductos(String categoria) {
        try {
            ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
            Object[] columna = new Object[3];

            int numRegistros = ppdao.mostrarProductos(categoria).size();

            for (int i = 0; i < numRegistros; i++) {
                columna[0] = ppdao.mostrarProductos(categoria).get(i).getIdProducto();
                columna[1] = ppdao.mostrarProductos(categoria).get(i).getProducto();
                columna[2] = ppdao.mostrarProductos(categoria).get(i).getPresentacion();
                modeloBuscarProducto.addRow(columna);
            }
            cd.tblBuscarProductos.setModel(modeloBuscarProducto);
            new ColumnasTablas().tresColumnas(cd.tblBuscarProductos, 20, 300, 200);
        } catch (Exception ex) {
            Logger.getLogger(ConteoDiarioControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargarComboCategorias() throws Exception {
        CategoriaDAO cdao = new CategoriaDAO();
        for (Categoria c : cdao.Listar()) {
            cd.cmbCategorias.addItem(c.getDescripcion());
        }
    }

    public void cargarComboMedidas() throws Exception {
        MedidaDAO mdao = new MedidaDAO();
        for (Medida m : mdao.Listar()) {
            cd.cmbMedida.addItem(m);
        }
    }

    /* ACTION PERFORMED - PARA BOTONES */
    @Override
    public void actionPerformed(ActionEvent e) {

        //para agregar elementos a la tabla conteo
        if (e.getSource() == cd.btnAgregar) {
            int fila = cd.tblBuscarProductos.getSelectedRow();
            if (fila >= 0 && !cd.txtCantidad.getText().trim().isEmpty()) {
                //agregar a tabla contados
                String datos[] = new String[4];
                datos[0] = cd.tblBuscarProductos.getValueAt(fila, 0).toString();
                datos[1] = cd.tblBuscarProductos.getValueAt(fila, 1).toString();
                datos[2] = cd.tblBuscarProductos.getValueAt(fila, 2).toString();
                datos[3] = cd.txtCantidad.getText();
                modeloBuscarProducto.addRow(datos);
                cd.tblContados.setModel(modeloBuscarProducto);
                cd.txtCantidad.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "DEBE INDICAR PRODUCTO Y CANTIDAD");
            }
        }

        //boton cancelar
        if (e.getSource() == cd.btnCancelar) {
            cd.tblBuscarProductos.clearSelection();
            cd.txtCantidad.setText("");
            cd.txtCantidad.setEnabled(false);
        }

        //boton guardar
        if (e.getSource() == cd.btnGuardar) {
            if (cd.tblContados.getRowCount() > 0) {
                //validar si ya se realizo la cuenta
                int opc = JOptionPane.showConfirmDialog(null, "¿DESEA GUARDAR LA LISTA?", "GUARDAR CONTEO " + new ManejadorFechas().getFechaActual(), JOptionPane.YES_NO_OPTION);
                if (opc == 0) { //verdadero
                    int contador = 0;
                    try {
                        //primero registrar el conteo
                        Conteo c = new Conteo();
                        UsuarioDAO udao = new UsuarioDAO();
                        int idUsuario = udao.getIdUsuario(cd.lblUsuario.getText());
                        c.setIdusuario(idUsuario);
                        c.setFecha(new ManejadorFechas().getFechaActualMySQL());
                        c.setHora(new ManejadorFechas().getHoraActual());

                        ConteoDAO cdao = new ConteoDAO();

                        if (cdao.Registrar(c)) {
                            int idConteo = cdao.getLastId();
                            for (int i = 0; i < cd.tblContados.getRowCount(); i++) {
                                ConteoProducto cp = new ConteoProducto();
                                cp.setIdconteo(idConteo);
                                cp.setIdProducto(Integer.parseInt(cd.tblContados.getValueAt(i, 0).toString()));
                                cp.setIdPresentacion(new PresentacionDAO().getIdPresentacion(cd.tblContados.getValueAt(i, 2).toString()));
                                cp.setMedida((Medida) cd.cmbMedida.getSelectedItem());
                                cp.setStock(Integer.parseInt(cd.tblContados.getValueAt(i, 3).toString()));
                                new ConteoProductoDAO().Registrar(cp);
                                contador++;
                            }
                        }

                        if (contador > 0) {
                            JOptionPane.showMessageDialog(cd.getRootPane(), "SE REGISTRO EL CONTEO EXITOSAMENTE");
                            parametros.put("fecha", cd.lblFecha.getText());
                            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\ConteoProductos.jrxml", parametros, new ColumnasTablas().getPageSize(cd.tblContados));
                            mrv.setNombreArchivo("Conteo" + cd.lblFecha.getText());
                            mrv.exportarAPdf();
                            mrv.dispose();
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {//falso
                }
            } else {
                JOptionPane.showMessageDialog(cd.getRootPane(), "NO SE PUEDE REGISTRAR UN CONTEO VACIO, INGRESE PRODUCTOS CONTADOS");
            }
        }

        //boton quitar
        if (e.getSource() == cd.btnQuitar) {
            int fila = cd.tblContados.getSelectedRow();
            if (fila >= 0) {
                modeloContados = (DefaultTableModel) cd.tblContados.getModel();
                modeloContados.removeRow(fila);
            } else {
                JOptionPane.showMessageDialog(cd.getRootPane(), "DEBE INDICAR EL PRODUCTO QUE DESEA QUITAR");
            }
        }

        //combo categorias
        if (e.getSource() == cd.cmbCategorias) {
            try {
                //String categoria = cd.cmbCategorias.getSelectedItem().toString();
                Categoria c = (Categoria) cd.cmbCategorias.getSelectedItem();
                tablaBuscarProductos(c.getDescripcion());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    /* EVENTOS DE INTERNAL FRAME */
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {

//datos iniciales
        if (e.getSource() == cd) {
            try {
                cargarComboCategorias();
                cargarComboMedidas();
                titulosContados();
                titulosProductos();
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
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

    /* EVENTOS DE MOUSE */
    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == cd.tblBuscarProductos) {
            try {
                int fila = cd.tblBuscarProductos.getSelectedRow();

                if (fila >= 0) {
                    cd.txtCantidad.setEnabled(true);
                } else {
                    cd.txtCantidad.setEnabled(false);
                }
            } catch (Exception error) {
                System.out.println(error.getMessage());
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

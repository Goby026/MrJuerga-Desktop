package Controlador;

import Modelo.Comprobante;
import Modelo.ComprobanteDAO;
import Modelo.TipoComprobante;
import Modelo.TipoComprobanteDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

public class ComprobantesControl {

    public Object getCamposConClic(int idComprobante) throws Exception {
        try {
            Object[] datos = new Object[11];
            ComprobanteDAO cdao = new ComprobanteDAO();
            for (Comprobante c : cdao.Listar()) {
                if (c.getIdcomprobante() == idComprobante) {
                    datos[0] = c.getIdcomprobante();
                    datos[1] = c.getFecha();
                    datos[2] = c.getUsuario();
                    datos[3] = c.getCliente();
                    datos[4] = c.getCantidad();
                    datos[5] = c.getSubTotal();
                    datos[6] = c.getRuc();
                    datos[7] = c.getDireccion();
                    datos[8] = c.getTipo_pago();
                    datos[9] = c.getTotal();
                    datos[10] = c.getIdtipocomprobante();
                    return datos;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
    
    public void llenarComboTipoComprobante(JComboBox cmb) throws Exception{
        try {
            TipoComprobanteDAO tcdao = new TipoComprobanteDAO();
            for (TipoComprobante tc : tcdao.Listar()) {
                cmb.addItem(tc.getDescripcion());
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public void capturarDescripcionDeComboTipoComprobante(int idTipoComprobante, JComboBox cmb) throws Exception{
        try {
            TipoComprobanteDAO tcdao = new TipoComprobanteDAO();
            for (TipoComprobante tc : tcdao.Listar()) {
                if (tc.getIdtipocomprobante() == idTipoComprobante) {
                    cmb.setSelectedItem(tc.getDescripcion());
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}

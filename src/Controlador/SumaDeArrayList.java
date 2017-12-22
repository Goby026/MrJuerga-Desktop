/*
Clase para solucionar el caso de suma de tablas de mysql ya que mediante consulta directa no se pudo solucionar
 */
package Controlador;

import Modelo.Conexion;
import Modelo.VentaProductoResumen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARCEL
 */
public class SumaDeArrayList {

    public SumaDeArrayList() {
    }

    //obtener los datos de la consulta y almacenarlos en un arrayList    
    public static List<VentaProductoResumen> Listar(int mes, int idCaja) throws Exception {

        Conexion con = new Conexion();
        String sql = "";
        List<VentaProductoResumen> li = null;
        try {

            switch (idCaja) {
                case 1://entrada general
                    sql = "select productopresentacion.idproductopresentacion, producto.nombre, sum(ventaentrada.numCovers) as cantcover, sum(ventaentrada.total) as total \n"
                            + "from entradageneral \n"
                            + "inner join ventaentrada on entradageneral.identradageneral = ventaentrada.venta_idventa\n"
                            + "inner join productopresentacion on ventaentrada.idproducto = productopresentacion.idproductopresentacion\n"
                            + "inner join producto on productopresentacion.idproducto = producto.idproducto\n"
                            + "inner join usuario on entradageneral.idusuario = usuario.idusuario\n"
                            + "where month(entradageneral.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    break;
                case 2://entrada vip
                    sql = "select productopresentacion.idproductopresentacion, producto.nombre,if(producto.nombre = 'BOX',sum(ventaentradavip.numPersonas),count(ventaentradavip.numPersonas)) as cantidad,sum(ventaentradavip.total) AS subtotal from entradavip \n"
                            + "inner join ventaentradavip on entradavip.identradavip = ventaentradavip.venta_idventa\n"
                            + "inner join productopresentacion on ventaentradavip.idproducto = productopresentacion.idproductopresentacion\n"
                            + "inner join producto on productopresentacion.idproducto = producto.idproducto\n"
                            + "where month(entradavip.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    break;
                case 3://caja 01
                    sql = "select productopresentacion.idproductopresentacion, producto.nombre, sum(ventaproducto.cantidad), sum(subtotal) \n"
                            + "from venta \n"
                            + "inner join ventaproducto on venta.idventa = ventaproducto.idventa\n"
                            + "inner join producto on ventaproducto.idproducto = producto.idproducto\n"
                            + "where month(venta.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    break;
                case 4://caja 02
                    sql = "select productopresentacion.idproductopresentacion, producto.nombre, sum(ventaproducto2.cantidad), sum(subtotal) \n"
                            + "from venta2 \n"
                            + "inner join ventaproducto2 on venta2.idventa2 = ventaproducto2.idventa\n"
                            + "inner join producto on ventaproducto2.idProducto = producto.idproducto\n"
                            + "where month(venta2.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    break;
                case 5://caja vip
                    sql = "select productopresentacion.idproductopresentacion, producto.nombre, sum(ventaproducto3.cantidad), sum(subtotal) \n"
                            + "from venta3\n"
                            + "inner join ventaproducto3 on venta3.idventa3 = ventaproducto3.idventa\n"
                            + "inner join producto on ventaproducto3.idProducto = producto.idproducto\n"
                            + "where month(venta3.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    break;
                case 6://entrada general 2
                    sql = "select productopresentacion.idproductopresentacion, producto.nombre,sum(ventaentrada2.numCovers) as cantcover, sum(ventaentrada2.total) as total from entradageneral2\n"
                            + "inner join ventaentrada2 on entradageneral2.identradageneral2 = ventaentrada2.venta_idventa\n"
                            + "inner join productopresentacion on ventaentrada2.idproducto = productopresentacion.idproductopresentacion\n"
                            + "inner join producto on productopresentacion.idproducto = producto.idproducto\n"
                            + "inner join usuario on entradageneral2.idusuario = usuario.idusuario\n"
                            + "where month(entradageneral2.fechasistema) = " + mes + " \n"
                            + "group by producto.nombre";
                    break;
            }

            li = new ArrayList<>();
            VentaProductoResumen vp = null;

            con.conectar();
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                vp = new VentaProductoResumen();
                vp.setCod(res.getInt(1));
                vp.setProducto(res.getString(2));
                vp.setPresentacion(res.getString(3));
                vp.setCantidad(res.getDouble(4));
                li.add(vp);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        } finally {
            con.cerrar();
        }

        return li;
    }

    public static List<VentaProductoResumen> TotalProductos() {
        List<VentaProductoResumen> total = null;
        try {

            VentaProductoResumen vp1 = new VentaProductoResumen(1, "CUBA LIBRE", "JARRA", 5);
            VentaProductoResumen vp2 = new VentaProductoResumen(2, "CUBA LIBRE", "JARRA", 1);

            VentaProductoResumen vp3 = new VentaProductoResumen(3, "CUBA LIBRE", "JARRA", 6);
            VentaProductoResumen vp4 = new VentaProductoResumen(4, "CUBA LIBRE", "JARRA", 8);

            VentaProductoResumen vp5 = new VentaProductoResumen(5, "CUBA LIBRE", "JARRA", 2);
            VentaProductoResumen vp6 = new VentaProductoResumen(6, "CUBA LIBRE", "JARRA", 18);

            List<VentaProductoResumen> lista1 = new ArrayList<>();
            List<VentaProductoResumen> lista2 = new ArrayList<>();
            List<VentaProductoResumen> lista3 = new ArrayList<>();

            lista1.add(vp1);
            lista1.add(vp2);

            lista2.add(vp3);
            lista2.add(vp4);

            lista3.add(vp5);
            lista3.add(vp6);

            lista1.addAll(lista2);
            lista1.addAll(lista3);

            //total de jarras vendidas
//            Iterator<VentaProducto> it = lista1.iterator();
//            
//            while (it.hasNext()) {
//                if (lista2.contains(it.hasNext())) {
//                    it.remove();
//                }
//                
//            }
//            lista1.addAll(lista2);
            total.addAll(lista1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return total;
    }


}

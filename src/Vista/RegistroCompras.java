package Vista;

import Controlador.ColumnasTablas;
import Controlador.Cronometro;
import Controlador.FormatoFechas;
import Controlador.ManejadorFechas;
import Controlador.RegistroCompraControl;
import Modelo.DetalleCompra;
import Modelo.MySQLDAO.DetalleCompraDAO;
import Modelo.MySQLDAO.OrdenCompraDAO;
import Modelo.MySQLDAO.TipoComprobanteDAO;
import Modelo.MySQLDAO.UsuarioDAO;
import Modelo.OrdenCompra;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author G0by
 */
public class RegistroCompras extends javax.swing.JInternalFrame {

    DefaultListModel modelo;
    DefaultTableModel modeloAdd;
    int idProveedor = 1;
    int idProducto = -1;
    int idTipoComprobante = -1;

    public RegistroCompras(String usuario) throws Exception {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        datosIniciales(usuario);
    }

    public void datosIniciales(String usuario) throws Exception {
        txtUsuario.setText(usuario);
        txtFecha.setText(new ManejadorFechas().getFechaActual());
        titulosTablaProductos();
        new RegistroCompraControl().cargarTipoDocumento(comboDocumento);
        new RegistroCompraControl().cargarComboPresentacion(cmbPresentacion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProductos = new javax.swing.JDialog();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBuscarProductos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnSeleccionarProducto = new javax.swing.JButton();
        buscarProveedor = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtBuscarProveedor = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBuscarProveedor = new javax.swing.JTable();
        btnSeleccionarProveedor = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        footer = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        cmbMoneda = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        documento = new javax.swing.JPanel();
        comboDocumento = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        txtSerie = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtNumComprobante = new javax.swing.JTextField();
        titulosParametros = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        parametros = new javax.swing.JPanel();
        txtProducto = new javax.swing.JTextField();
        cmbPresentacion = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtSubtotal = new javax.swing.JTextField();
        botonesParametros = new javax.swing.JPanel();
        btnAgregarProducto = new javax.swing.JButton();
        btnNuevoProducto = new javax.swing.JButton();
        btnBorrarCampos = new javax.swing.JButton();
        pedidos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        btnQuitarProducto = new javax.swing.JButton();
        proveedor = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        txtRazonSocial = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        btnBuscarProveedor = new javax.swing.JButton();
        btbRegistrarProveedor = new javax.swing.JButton();
        btnRegCompra = new javax.swing.JButton();

        tblBuscarProductos.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        tblBuscarProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblBuscarProductos);

        panelProductos.getContentPane().add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel8.setText("PRODUCTO");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 140, 30));

        jTextField7.setBackground(new java.awt.Color(204, 204, 204));
        jTextField7.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 250, -1));

        jLabel11.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel11.setText("CATEGORIA");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 140, 30));

        jComboBox1.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox1.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 250, -1));

        panelProductos.getContentPane().add(jPanel3, java.awt.BorderLayout.NORTH);

        btnSeleccionarProducto.setBackground(new java.awt.Color(153, 255, 153));
        btnSeleccionarProducto.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        btnSeleccionarProducto.setText("seleccionar");
        btnSeleccionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProductoActionPerformed(evt);
            }
        });
        panelProductos.getContentPane().add(btnSeleccionarProducto, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel10.setText("RAZON SOCIAL");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtBuscarProveedor.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        txtBuscarProveedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtBuscarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 250, 40));

        buscarProveedor.getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        tblBuscarProveedor.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        tblBuscarProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblBuscarProveedor);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        btnSeleccionarProveedor.setBackground(new java.awt.Color(0, 153, 51));
        btnSeleccionarProveedor.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        btnSeleccionarProveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnSeleccionarProveedor.setText("SELECCIONAR");
        btnSeleccionarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionarProveedor, java.awt.BorderLayout.PAGE_END);

        buscarProveedor.getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("ORDEN DE COMPRA");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TOTAL");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 770, 200, -1));

        jLabel7.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        jLabel7.setText("S/.");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 80, 90));

        header.setBackground(new java.awt.Color(102, 102, 102));
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("REGISTRO DE COMPRAS");
        header.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 30));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/carro-de-la-compra2.png"))); // NOI18N
        header.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(102, 102, 102));
        txtFecha.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        header.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 90, -1));

        txtUsuario.setEditable(false);
        txtUsuario.setBackground(new java.awt.Color(102, 102, 102));
        txtUsuario.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        header.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 140, -1));

        jLabel36.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel36.setText("REGISTRO DE COMPRAS");
        header.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 20, -1, 30));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 70));

        footer.setBackground(new java.awt.Color(102, 102, 102));
        footer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 51, 0));
        jLabel37.setText("DISCOTECK");
        footer.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, -1, -1));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel13.setText("DISCOTECK");
        footer.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 0, -1, -1));

        jLabel38.setBackground(new java.awt.Color(0, 0, 0));
        jLabel38.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("MISTER JUERGA");
        footer.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, -1, -1));

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel39.setText("MISTER JUERGA");
        footer.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(722, 0, -1, -1));

        getContentPane().add(footer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 810, 1030, -1));

        txtTotal.setFont(new java.awt.Font("Consolas", 0, 40)); // NOI18N
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 680, 200, 90));

        jLabel32.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel32.setText("FECHA DE ENTREGA");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, -1, -1));

        jdcFechaInicio.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        getContentPane().add(jdcFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, 140, -1));

        cmbMoneda.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        cmbMoneda.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "S/. SOL", "$ DOLAR", "€ EURO" }));
        getContentPane().add(cmbMoneda, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 120, 140, -1));

        jLabel34.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel34.setText("MONEDA");
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, -1, -1));

        documento.setBackground(new java.awt.Color(255, 255, 255));
        documento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DOCUMENTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 12))); // NOI18N
        documento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboDocumento.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        comboDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDocumentoActionPerformed(evt);
            }
        });
        documento.add(comboDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 27, 190, 30));

        jLabel41.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel41.setText("  SERIE  ");
        documento.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        txtSerie.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtSerie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSerie.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        documento.add(txtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 27, 90, 30));

        jLabel42.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel42.setText("  NUMERO  ");
        documento.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 32, -1, -1));

        txtNumComprobante.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtNumComprobante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumComprobante.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        documento.add(txtNumComprobante, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 27, 210, 30));

        getContentPane().add(documento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 670, 70));

        titulosParametros.setBackground(new java.awt.Color(104, 212, 188));
        titulosParametros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        titulosParametros.setLayout(new java.awt.GridLayout(1, 0));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRODUCTO");
        titulosParametros.add(jLabel1);

        jLabel9.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PRESENTACION");
        titulosParametros.add(jLabel9);

        jLabel2.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CANTIDAD");
        titulosParametros.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PRECIO");
        titulosParametros.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DESCUENTO");
        titulosParametros.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SUBTOTAL");
        titulosParametros.add(jLabel5);

        getContentPane().add(titulosParametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 980, 30));

        parametros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        parametros.setLayout(new java.awt.GridLayout(1, 0));

        txtProducto.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProducto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtProductoMouseClicked(evt);
            }
        });
        parametros.add(txtProducto);

        cmbPresentacion.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        parametros.add(cmbPresentacion);

        txtCantidad.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        parametros.add(txtCantidad);

        txtPrecio.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        parametros.add(txtPrecio);

        txtDescuento.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtDescuento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDescuento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        parametros.add(txtDescuento);

        txtSubtotal.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtSubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSubtotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        parametros.add(txtSubtotal);

        getContentPane().add(parametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 259, 980, 30));

        botonesParametros.setBackground(new java.awt.Color(255, 255, 255));
        botonesParametros.setLayout(new java.awt.GridLayout(1, 0));

        btnAgregarProducto.setBackground(new java.awt.Color(0, 255, 0));
        btnAgregarProducto.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setText("AGREGAR");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        botonesParametros.add(btnAgregarProducto);

        btnNuevoProducto.setBackground(new java.awt.Color(0, 153, 255));
        btnNuevoProducto.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnNuevoProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoProducto.setText("NUEVO PRODUCTO");
        botonesParametros.add(btnNuevoProducto);

        btnBorrarCampos.setBackground(new java.awt.Color(255, 0, 0));
        btnBorrarCampos.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnBorrarCampos.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrarCampos.setText("BORRAR CAMPOS");
        botonesParametros.add(btnBorrarCampos);

        getContentPane().add(botonesParametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 298, 980, 30));

        pedidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        pedidos.setLayout(new java.awt.BorderLayout());

        tblProductos.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        pedidos.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        btnQuitarProducto.setBackground(new java.awt.Color(204, 51, 0));
        btnQuitarProducto.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnQuitarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitarProducto.setText("QUITAR");
        btnQuitarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProductoActionPerformed(evt);
            }
        });
        jPanel10.add(btnQuitarProducto);

        pedidos.add(jPanel10, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 980, 310));

        proveedor.setBackground(new java.awt.Color(255, 255, 255));
        proveedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PROVEEDOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 12))); // NOI18N
        proveedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel31.setText("  RAZON SOCIAL  ");
        proveedor.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 32, -1, -1));

        txtRazonSocial.setEditable(false);
        txtRazonSocial.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtRazonSocial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRazonSocial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        proveedor.add(txtRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 24, 146, 30));

        jLabel40.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jLabel40.setText("  RUC  ");
        proveedor.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 32, -1, -1));

        txtRuc.setEditable(false);
        txtRuc.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        txtRuc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRuc.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        proveedor.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 24, 146, 30));

        btnBuscarProveedor.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btnBuscarProveedor.setText("BUSCAR");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });
        proveedor.add(btnBuscarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 25, -1, 30));

        btbRegistrarProveedor.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        btbRegistrarProveedor.setText("REGISTRAR");
        btbRegistrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbRegistrarProveedorActionPerformed(evt);
            }
        });
        proveedor.add(btbRegistrarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 25, -1, 30));

        getContentPane().add(proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 670, 70));

        btnRegCompra.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        btnRegCompra.setText("REGISTRAR COMPRA");
        btnRegCompra.setPreferredSize(new java.awt.Dimension(137, 100));
        btnRegCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegCompraActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 720, 270, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProductoMouseClicked
        try {
            panelProductos.setBounds(400, 50, 590, 900);
            panelProductos.setVisible(true);
            panelProductos.setTitle("SELECCIONAR PRODUCTO");

            new RegistroCompraControl().LlenarTablaBuscarProductos(tblBuscarProductos);

            txtCantidad.requestFocus();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_txtProductoMouseClicked

    private void btbRegistrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbRegistrarProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btbRegistrarProveedorActionPerformed

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        try {
            buscarProveedor.setVisible(true);
            buscarProveedor.setBounds(200, 200, 490, 400);
            //new RegistroCompraControl().titulosProveedores(tblBuscarProveedor);
            new RegistroCompraControl().LlenarTablaProveedores(tblBuscarProveedor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void btnSeleccionarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProveedorActionPerformed
        if (tblBuscarProveedor.getSelectedRow() >= 0) {
            Object datos[] = new Object[2];
            idProveedor = Integer.parseInt(tblBuscarProveedor.getValueAt(tblBuscarProveedor.getSelectedRow(), 0).toString());
            datos[0] = tblBuscarProveedor.getValueAt(tblBuscarProveedor.getSelectedRow(), 1);
            datos[1] = tblBuscarProveedor.getValueAt(tblBuscarProveedor.getSelectedRow(), 2);

            txtRazonSocial.setText(String.valueOf(datos[0]));
            txtRuc.setText(String.valueOf(datos[1]));

            buscarProveedor.dispose();
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "SELECIONE UN PROVEEDOR");
        }
    }//GEN-LAST:event_btnSeleccionarProveedorActionPerformed

    private void btnSeleccionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProductoActionPerformed
        if (tblBuscarProductos.getSelectedRow() >= 0) {
            idProducto = Integer.parseInt(tblBuscarProductos.getValueAt(tblBuscarProductos.getSelectedRow(), 0).toString());
            String nomProd = tblBuscarProductos.getValueAt(tblBuscarProductos.getSelectedRow(), 1).toString();
            txtProducto.setText(nomProd);

            panelProductos.dispose();
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "SELECIONE UN PRODUCTO");
        }
    }//GEN-LAST:event_btnSeleccionarProductoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        if (!txtProducto.getText().trim().isEmpty() && !txtPrecio.getText().trim().isEmpty() && !txtCantidad.getText().trim().isEmpty()) {
            Object datos[] = new Object[7];
//            "ID","PRODUCTO", "PRESENTACION","CANTIDAD", "PRECIO", "DESCUENTO", "SUB-TOTAL"
            datos[0] = idProducto;
            datos[1] = txtProducto.getText();
            datos[2] = cmbPresentacion.getSelectedItem().toString();
            datos[3] = txtCantidad.getText();
            datos[4] = txtPrecio.getText();
            datos[5] = txtDescuento.getText();
            datos[6] = txtSubtotal.getText();

            modeloAdd.addRow(datos);
            tblProductos.setModel(modeloAdd);

            new ColumnasTablas().sieteColumnas(tblProductos, 20, 200, 30, 30, 30, 30, 30);

            limpiarCampos();
            txtTotal.setText("" + calcularMonto());

        } else {
            JOptionPane.showMessageDialog(getRootPane(), "DEBE INDICAR PRODUCTO, PRECIO Y CANTIDAD NECESARIAMENTE");
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnQuitarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProductoActionPerformed
        int fila = tblProductos.getSelectedRow();
        if (fila >= 0) {
            modeloAdd.removeRow(fila);
            txtTotal.setText("" + calcularMonto());
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "SELECCIONE UN PRODUCTO A QUITAR");
        }
    }//GEN-LAST:event_btnQuitarProductoActionPerformed

    private void btnRegCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegCompraActionPerformed
        int numFilas = tblProductos.getRowCount();
        if (numFilas > 0) {
            try {
                OrdenCompra oc = new OrdenCompra();

                oc.setFecha(new ManejadorFechas().getFechaActualMySQL());
                oc.setHora(new ManejadorFechas().getHoraActual());
                oc.setEstado(1);//1= activo, 0=anulado
                oc.setMoneda(cmbMoneda.getSelectedItem().toString());
                oc.setSerie(txtSerie.getText());
                oc.setNroComprobante(txtNumComprobante.getText());
                oc.setFechaEntrega(new FormatoFechas().setFormatoFec(jdcFechaInicio));
                oc.setIdUsuario(new UsuarioDAO().getIdUsuario(txtUsuario.getText()));
                oc.setIdProveedor(idProveedor);
                oc.setIdTipoComprobante(idTipoComprobante);
                System.out.println("compra creada");
                if (new OrdenCompraDAO().registrar(oc)) {//si registro bien la compra se procede a registrar el detalle de compra
                    System.out.println("compra registrada");
                    int idUltimaCompra = new OrdenCompraDAO().getUltimaCompra();
                    System.out.println(idUltimaCompra);
                    int count = 0;
                    for (int i = 0; i < tblProductos.getRowCount(); i++) {
                        System.out.println(i);
                        try {
                            DetalleCompra dc = new DetalleCompra();
                            dc.setIdProducto(Integer.parseInt(tblProductos.getValueAt(i, 0).toString()));
                            dc.setIdInsumo(1);
                            dc.setIdMedida(1);
                            dc.setIdCompra(idUltimaCompra);
                            dc.setCantidad(Integer.parseInt(tblProductos.getValueAt(i, 3).toString()));
                            dc.setPrecio(Double.parseDouble(tblProductos.getValueAt(i, 4).toString()));
                            dc.setDcto(Double.parseDouble(tblProductos.getValueAt(i, 5).toString()));
                            dc.setSubtotal(Double.parseDouble(tblProductos.getValueAt(i, 6).toString()));
                            if (new DetalleCompraDAO().registrar(dc)) {
                                count++;
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    if (count > 0) {
                        JOptionPane.showMessageDialog(getRootPane(), "SE REGISTRO LA COMPRA");
                        System.out.println("detalles registrados");
                    }
                } else {
                    System.out.println("no se registro la compra");
                }
                //List<DetalleCompra> lista = new ArrayList<>();
//                for (int i = 0; i < tblProductos.getRowCount(); i++) {
//                    DetalleCompra dc = new DetalleCompra();
//                    dc.setIdProducto(Integer.parseInt(tblProductos.getValueAt(i, 0).toString()));
//                    dc.setIdInsumo(0);
//                    dc.setIdMedida(1);
//                    dc.setCantidad(Integer.parseInt(tblProductos.getValueAt(i, 3).toString()));
//                    dc.setPrecio(Double.parseDouble(tblProductos.getValueAt(i, 4).toString()));
//                    dc.setDcto(Double.parseDouble(tblProductos.getValueAt(i, 5).toString()));
//                    dc.setSubtotal(Double.parseDouble(tblProductos.getValueAt(i, 6).toString()));
//                    lista.add(dc);
//                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(getRootPane(), "DEBE AGREGAR PRODUCTOS A LA COMPRA");
        }
//        if (txtRazonSocial.getText().trim().isEmpty()) {
//            //0=si------1=no------2=cancelar
//            int opc_proveedor = JOptionPane.showOptionDialog(getRootPane(), "SE REGISTRARÁ LA COMPRA SIN INDICAR PROVEEDOR, ¿DESEA CONTINUAR?", "showOptionDialog", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No", "Cancelar"}, "Si");
//            if (opc_proveedor == 0) {
//                if (txtNumComprobante.getText().trim().isEmpty() || txtSerie.getText().trim().isEmpty()) {
//                    int opc_comprobante = JOptionPane.showOptionDialog(getRootPane(), "FALTAN DATOS DE COMPROBANTE, ¿DESEA CONTINUAR?", "showOptionDialog", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No", "Cancelar"}, "Si");
//                    if (opc_comprobante == 0) {
//
//                    }
//                }
//            }
//        } else {
//        }
    }//GEN-LAST:event_btnRegCompraActionPerformed

    private void comboDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDocumentoActionPerformed
        try {
            idTipoComprobante = new TipoComprobanteDAO().getIdComprobante(comboDocumento.getSelectedItem().toString());
            System.out.println(idTipoComprobante);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_comboDocumentoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(RegistroCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(RegistroCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(RegistroCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(RegistroCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new RegistroCompras().setVisible(true);
//                } catch (Exception ex) {
//                    Logger.getLogger(RegistroCompras.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botonesParametros;
    private javax.swing.JButton btbRegistrarProveedor;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBorrarCampos;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnNuevoProducto;
    private javax.swing.JButton btnQuitarProducto;
    private javax.swing.JButton btnRegCompra;
    private javax.swing.JButton btnSeleccionarProducto;
    private javax.swing.JButton btnSeleccionarProveedor;
    private javax.swing.JDialog buscarProveedor;
    private javax.swing.JComboBox cmbMoneda;
    private javax.swing.JComboBox<String> cmbPresentacion;
    private javax.swing.JComboBox<String> comboDocumento;
    private javax.swing.JPanel documento;
    private javax.swing.JPanel footer;
    private javax.swing.JPanel header;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField7;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JDialog panelProductos;
    private javax.swing.JPanel parametros;
    private javax.swing.JPanel pedidos;
    private javax.swing.JPanel proveedor;
    private javax.swing.JTable tblBuscarProductos;
    private javax.swing.JTable tblBuscarProveedor;
    private javax.swing.JTable tblProductos;
    private javax.swing.JPanel titulosParametros;
    private javax.swing.JTextField txtBuscarProveedor;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNumComprobante;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSerie;
    private javax.swing.JTextField txtSubtotal;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public void titulosTablaProductos() { //titulos de la tabla de pedidos
        String titulos[] = {"ID", "PRODUCTO", "PRESENTACION", "CANTIDAD", "PRECIO", "DESCUENTO", "SUB-TOTAL"};
        modeloAdd = new DefaultTableModel(null, titulos);
        tblProductos.setModel(modeloAdd);
    }

    public void limpiarCampos() {
        txtProducto.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtDescuento.setText("");
        txtSubtotal.setText("");
    }

    public double calcularMonto() {
        double monto = 0;
        for (int i = 0; i < tblProductos.getRowCount(); i++) {
            monto += Double.parseDouble(tblProductos.getValueAt(i, 6).toString());
        }
        return monto;
    }

}

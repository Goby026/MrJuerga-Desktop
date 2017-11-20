package Vista;

import Controlador.JTableControl;
import Modelo.Almacen;
import Modelo.Conexion;
import Modelo.Familia;
import Modelo.MySQLDAO.AlmacenDAO;
import Modelo.MySQLDAO.FamiliaDAO;
import Modelo.MySQLDAO.UsuarioPerfilDAO;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GROVER
 */
public class GestionInventarios extends javax.swing.JInternalFrame {

    JTableControl jc = null;
    JTableControl jc2 = null;
    JTableControl jc3 = null;

    int idalmacen = 0;

    public GestionInventarios(String usuario) {
        initComponents();
        cargarComboAlmacen();
        lblUsuario.setText(usuario);

        String titulos_inventario[] = {"COD", "PRODUCTO", "PRESENTACION", "CANTIDAD"};
        String titulos_nuevo_inventario[] = {"COD", "PRODUCTO", "PRESENTACION", "CANTIDAD"};
        String titulos_tblFamilia[] = {"COD", "PRODUCTO", "PRESENTACION"};

        jc = new JTableControl(titulos_inventario, tblInventario);
        jc2 = new JTableControl(titulos_nuevo_inventario, tblNuevoInventario);
        jc3 = new JTableControl(titulos_tblFamilia, tblFamiliaProducto);

        jc.llenarTitulos();
        jc2.llenarTitulos();
        jc3.llenarTitulos();

    }

    public GestionInventarios() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formNuevoInventario = new javax.swing.JDialog();
        cmbFamilia = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFamiliaProducto = new javax.swing.JTable();
        btnRegistrarInventario = new javax.swing.JButton();
        btnAddProducto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNuevoInventario = new javax.swing.JTable();
        cbAlmacenGeneral = new javax.swing.JCheckBox();
        cbBarraGeneral = new javax.swing.JCheckBox();
        cbBarraVip = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        formConfgNuevoInventario = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbBarman = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        grupoTipoInventario = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();
        cmbAlmacen = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnNuevoInventario = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jlabelu = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jlabelf = new javax.swing.JLabel();
        jlabelh = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnCrearReporte = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();

        formNuevoInventario.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbFamilia.setBackground(new java.awt.Color(204, 204, 204));
        cmbFamilia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbFamilia.setForeground(new java.awt.Color(51, 51, 51));
        cmbFamilia.setBorder(null);
        cmbFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFamiliaActionPerformed(evt);
            }
        });
        formNuevoInventario.getContentPane().add(cmbFamilia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 280, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("FAMILIA");
        formNuevoInventario.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 70, 30));

        tblFamiliaProducto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblFamiliaProducto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblFamiliaProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFamiliaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFamiliaProductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFamiliaProducto);

        formNuevoInventario.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 460, 330));

        btnRegistrarInventario.setText("REGISTRAR INVENTARIO");
        btnRegistrarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarInventarioActionPerformed(evt);
            }
        });
        formNuevoInventario.getContentPane().add(btnRegistrarInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 440, -1, -1));

        btnAddProducto.setText(">");
        btnAddProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductoActionPerformed(evt);
            }
        });
        formNuevoInventario.getContentPane().add(btnAddProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 70, -1));

        tblNuevoInventario = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblNuevoInventario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblNuevoInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblNuevoInventario);

        formNuevoInventario.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, 330));

        cbAlmacenGeneral.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbAlmacenGeneral.setText("ALMACEN GENERAL");
        cbAlmacenGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlmacenGeneralActionPerformed(evt);
            }
        });
        formNuevoInventario.getContentPane().add(cbAlmacenGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        cbBarraGeneral.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbBarraGeneral.setText("BARRA GENERAL");
        cbBarraGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBarraGeneralActionPerformed(evt);
            }
        });
        formNuevoInventario.getContentPane().add(cbBarraGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        cbBarraVip.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbBarraVip.setText("BARRA VIP");
        cbBarraVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBarraVipActionPerformed(evt);
            }
        });
        formNuevoInventario.getContentPane().add(cbBarraVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        formNuevoInventario.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        formConfgNuevoInventario.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("BARMAN");
        formConfgNuevoInventario.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("BARRA");
        formConfgNuevoInventario.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        cmbBarman.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        formConfgNuevoInventario.getContentPane().add(cmbBarman, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 310, -1));

        jButton4.setText("CONFIRMAR");
        formConfgNuevoInventario.getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 180, 30));

        jCheckBox1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCheckBox1.setText("GENERAL");
        formConfgNuevoInventario.getContentPane().add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jCheckBox2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCheckBox2.setText("VIP");
        formConfgNuevoInventario.getContentPane().add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("FECHA");
        formConfgNuevoInventario.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jCheckBox3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCheckBox3.setText("APERTURA");
        formConfgNuevoInventario.getContentPane().add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jCheckBox4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCheckBox4.setText("CIERRE");
        formConfgNuevoInventario.getContentPane().add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));
        formConfgNuevoInventario.getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 400, 10));
        formConfgNuevoInventario.getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 400, 10));
        formConfgNuevoInventario.getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 400, 10));
        formConfgNuevoInventario.getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 400, 10));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("TIPO INVENTARIO");
        formConfgNuevoInventario.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jDateChooser2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        formConfgNuevoInventario.getContentPane().add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 210, 30));

        setBackground(new java.awt.Color(204, 204, 204));
        setClosable(true);
        setTitle("GESTION DE INVENTARIOS");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInventario = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblInventario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblInventario);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 550, 520));

        cmbAlmacen.setBackground(new java.awt.Color(204, 204, 204));
        cmbAlmacen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbAlmacen.setForeground(new java.awt.Color(51, 51, 51));
        cmbAlmacen.setBorder(null);
        getContentPane().add(cmbAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 340, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("ALMACEN");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 30));

        btnNuevoInventario.setBackground(new java.awt.Color(8, 102, 0));
        btnNuevoInventario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnNuevoInventario.setForeground(new java.awt.Color(51, 51, 51));
        btnNuevoInventario.setText("NUEVO INVENTARIO");
        btnNuevoInventario.setContentAreaFilled(false);
        btnNuevoInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoInventario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNuevoInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoInventarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevoInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 170, -1));

        btnCancelar.setBackground(new java.awt.Color(8, 102, 0));
        btnCancelar.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText("cancelar");
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 120, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("GESTION DE INVENTARIOS");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("_____");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 8, 200, -1));

        lblHora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("____");
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 8, 180, -1));

        jlabelu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlabelu.setForeground(new java.awt.Color(255, 255, 255));
        jlabelu.setText("usuario:");
        jPanel1.add(jlabelu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        lblFecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("____");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 8, 150, -1));

        jlabelf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlabelf.setForeground(new java.awt.Color(255, 255, 255));
        jlabelf.setText("fecha:");
        jPanel1.add(jlabelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 8, -1, -1));

        jlabelh.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlabelh.setForeground(new java.awt.Color(255, 255, 255));
        jlabelh.setText("hora:");
        jPanel1.add(jlabelh, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 8, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 740, 30));

        jDateChooser1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 180, 30));

        btnCrearReporte.setBackground(new java.awt.Color(120, 113, 109));
        btnCrearReporte.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        btnCrearReporte.setForeground(new java.awt.Color(51, 51, 51));
        btnCrearReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Print_32px_1.png"))); // NOI18N
        btnCrearReporte.setBorderPainted(false);
        btnCrearReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnCrearReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 620, 70, -1));

        jButton6.setBackground(new java.awt.Color(153, 153, 153));
        jButton6.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Delete_32px.png"))); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 570, 70, -1));

        btnLimpiar.setBackground(new java.awt.Color(153, 153, 153));
        btnLimpiar.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(51, 51, 51));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Broom_32px.png"))); // NOI18N
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 520, 70, -1));

        btnQuitar.setBackground(new java.awt.Color(153, 153, 153));
        btnQuitar.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(51, 51, 51));
        btnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Erase_32px.png"))); // NOI18N
        btnQuitar.setBorderPainted(false);
        btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 70, -1));

        btnGuardar.setBackground(new java.awt.Color(153, 153, 153));
        btnGuardar.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(51, 51, 51));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Save_32px.png"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, 70, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/find.png"))); // NOI18N
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        jCheckBox5.setBackground(new java.awt.Color(204, 204, 204));
        grupoTipoInventario.add(jCheckBox5);
        jCheckBox5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCheckBox5.setText("FINAL");
        getContentPane().add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, -1, 30));

        jCheckBox6.setBackground(new java.awt.Color(204, 204, 204));
        grupoTipoInventario.add(jCheckBox6);
        jCheckBox6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jCheckBox6.setText("INICIAL");
        getContentPane().add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nPerformed

    }//GEN-LAST:event_nPerformed

    private void btnNuevoInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoInventarioActionPerformed
        formNuevoInventario.setVisible(true);
        formNuevoInventario.setBounds(400, 250, 1101, 528);
        cargarComboFamilia();
    }//GEN-LAST:event_btnNuevoInventarioActionPerformed

    private void btnRegistrarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarInventarioActionPerformed
        formConfgNuevoInventario.setVisible(true);
        formConfgNuevoInventario.setBounds(500, 300, 410, 340);
        cargarComboBarman(10);
    }//GEN-LAST:event_btnRegistrarInventarioActionPerformed

    private void btnAddProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductoActionPerformed
        int fila = tblFamiliaProducto.getSelectedRow();
        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("CANTIDAD"));
        if (fila >= 0) {
            if (cantidad > 0) {
                Object dato[] = new Object[4];

                dato[0] = tblFamiliaProducto.getValueAt(fila, 0);//idproductopresentacion
                dato[1] = tblFamiliaProducto.getValueAt(fila, 1);//nombre
                dato[2] = tblFamiliaProducto.getValueAt(fila, 2);//presentacion
                dato[3] = cantidad;

                jc2.getModelo().addRow(dato);

                tblNuevoInventario.setModel(jc2.getModelo());

            } else {
                JOptionPane.showMessageDialog(getRootPane(), "LA CANTIDAD DEBE SER MAYOR A 0");
            }
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "SELECCIONE UN PRODUCTO");
        }
    }//GEN-LAST:event_btnAddProductoActionPerformed

    private void cmbFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFamiliaActionPerformed


    }//GEN-LAST:event_cmbFamiliaActionPerformed

    private void tblFamiliaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFamiliaProductoMouseClicked
        if (evt.getClickCount() == 2) {
            btnAddProducto.doClick();
        }
    }//GEN-LAST:event_tblFamiliaProductoMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            if (idalmacen != 0) {
                jc3.LimpiarTabla();

                Familia fam = (Familia) cmbFamilia.getSelectedItem();

                llenarTablaFamiliaProducto(fam.getCodFamilia(), idalmacen);
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "SELECCIONE UN ALMACEN");
            }

        } catch (SQLException ex) {
            Logger.getLogger(GestionInventarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbAlmacenGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlmacenGeneralActionPerformed
        if (cbAlmacenGeneral.isSelected()) {
            idalmacen = 1;
        }
    }//GEN-LAST:event_cbAlmacenGeneralActionPerformed

    private void cbBarraGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBarraGeneralActionPerformed
        if (cbBarraGeneral.isSelected()) {
            idalmacen = 2;
        }
    }//GEN-LAST:event_cbBarraGeneralActionPerformed

    private void cbBarraVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBarraVipActionPerformed
        if (cbBarraVip.isSelected()) {
            idalmacen = 3;
        }
    }//GEN-LAST:event_cbBarraVipActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProducto;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCrearReporte;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnNuevoInventario;
    public javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnRegistrarInventario;
    private javax.swing.JCheckBox cbAlmacenGeneral;
    private javax.swing.JCheckBox cbBarraGeneral;
    private javax.swing.JCheckBox cbBarraVip;
    public javax.swing.JComboBox<Almacen> cmbAlmacen;
    private javax.swing.JComboBox<Usuario> cmbBarman;
    public javax.swing.JComboBox<Familia> cmbFamilia;
    private javax.swing.JDialog formConfgNuevoInventario;
    private javax.swing.JDialog formNuevoInventario;
    private javax.swing.ButtonGroup grupoTipoInventario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    public javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel jlabelf;
    private javax.swing.JLabel jlabelh;
    private javax.swing.JLabel jlabelu;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblHora;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tblFamiliaProducto;
    public javax.swing.JTable tblInventario;
    private javax.swing.JTable tblNuevoInventario;
    // End of variables declaration//GEN-END:variables

    private void llenarTablaInventario() {
        Conexion con = new Conexion();
        try {
            con.conectar();
            String sql = "select * from ";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {

        }
    }

    private void llenarTablaFamiliaProducto(String codFamilia, int idalmacen) throws SQLException {
        Conexion con = new Conexion();
        try {
            con.conectar();
            String sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion from productopresentacion pp\n"
                    + "inner join producto p on pp.idproducto = p.idproducto\n"
                    + "inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                    + "WHERE pp.codfamilia = ? AND pp.idalmacen = ? AND pp.estado = 1";
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            pst.setString(1, codFamilia);
            pst.setInt(2, idalmacen);

            ResultSet res = pst.executeQuery();
            String datos[] = new String[3];
            while (res.next()) {
                datos[0] = res.getString(1);
                datos[1] = res.getString(2);
                datos[2] = res.getString(3);

                jc3.getModelo().addRow(datos);
            }

            tblFamiliaProducto.setModel(jc3.getModelo());

            pst.close();
            res.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            con.cerrar();
        }
    }

    private void cargarComboFamilia() {
        try {
            FamiliaDAO fdao = new FamiliaDAO();

            for (Familia f : fdao.Listar()) {
                cmbFamilia.addItem(f);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void cargarComboAlmacen() {
        try {
            AlmacenDAO adao = new AlmacenDAO();

            for (Almacen a : adao.listar()) {
                cmbAlmacen.addItem(a);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //el id de perfil sera 10 estatico, por que asi esta en la tabla
    private void cargarComboBarman(int idPerfil) {
        try {
            UsuarioPerfilDAO updao = new UsuarioPerfilDAO();

            for (Usuario u : updao.Obtener(idPerfil)) {
                cmbBarman.addItem(u);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}

package Vista;

import Controlador.AlmacenControl;
import Controlador.Cronometro;
import Controlador.ManejadorFechas;
import Modelo.Almacen;
import Modelo.MySQLDAO.AlmacenDAO;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Almacenes extends javax.swing.JInternalFrame {

    public Almacenes(String usuario) throws Exception {
        initComponents();
        this.getContentPane().setBackground(Color.WHITE);
        txtUsuario.setText(usuario);
        new Cronometro().iniciarCronometro(txtHora);
        txtFecha.setText(new ManejadorFechas().getFechaActual());
        new AlmacenControl().cargarTablaAlmacenes(tblAlmacenes);
        new AlmacenControl().cargarComboAlmacenes(cmbAlmacen);
        new AlmacenControl().cargarComboResponsable(cmbResponsable);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbAlmacen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        btnReporteSalidas = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExistencias = new javax.swing.JTable();
        btnReportesExistencias = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnReporteEntradas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntradas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnSalidas = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSalidas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblAlmacenes = new javax.swing.JTable();
        cmbResponsable = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnModificar1 = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("GESTION DE ALMACENES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ALMACEN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        cmbAlmacen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbAlmacen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR" }));
        cmbAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlmacenActionPerformed(evt);
            }
        });
        getContentPane().add(cmbAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 160, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("RESPONSABLE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("CODIGO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("NOMBRE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel6.setText("DIRECCION");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setText("CIUDAD");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setText("TELEFONO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, -1, -1));

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 160, -1));

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 160, -1));

        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 160, -1));

        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 160, -1));

        txtCiudad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 160, -1));

        btnNuevo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-archivo.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.setBorder(null);
        btnNuevo.setBorderPainted(false);
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 80, -1));

        btnRegistrar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/disquete.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.setBorder(null);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseExited(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 110, -1));

        btnModificar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/girar.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(null);
        btnModificar.setBorderPainted(false);
        btnModificar.setContentAreaFilled(false);
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, 110, -1));

        btnMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/camion.png"))); // NOI18N
        btnMovimientos.setText("MOVIMIENTOS");
        btnMovimientos.setBorder(null);
        btnMovimientos.setBorderPainted(false);
        btnMovimientos.setContentAreaFilled(false);
        btnMovimientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMovimientosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMovimientosMouseExited(evt);
            }
        });
        getContentPane().add(btnMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 590, 140, 30));

        btnReporteSalidas.setBackground(new java.awt.Color(102, 102, 102));
        btnReporteSalidas.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        btnReporteSalidas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblExistencias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblExistencias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 210));

        btnReportesExistencias.setText("REPORTE DE EXISTENCIAS");
        btnReportesExistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesExistenciasActionPerformed(evt);
            }
        });
        jPanel1.add(btnReportesExistencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        btnReporteSalidas.addTab("EXISTENCIAS", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReporteEntradas.setText("REPORTE DE ENTRADAS");
        jPanel2.add(btnReporteEntradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        tblEntradas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblEntradas);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 210));

        btnReporteSalidas.addTab("ENTRADAS", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalidas.setText("REPORTE DE SALIDAS");
        jPanel3.add(btnSalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        tblSalidas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblSalidas);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 210));

        btnReporteSalidas.addTab("SALIDAS", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblAlmacenes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAlmacenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlmacenesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblAlmacenes);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 210));

        btnReporteSalidas.addTab("LISTA DE ALMACENES", jPanel4);

        getContentPane().add(btnReporteSalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 760, 300));

        cmbResponsable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmbResponsable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NULL" }));
        getContentPane().add(cmbResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 160, -1));

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 51, 0));
        jLabel13.setText("DISCOTECK");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, -1, -1));

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel11.setText("DISCOTECK");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(662, 0, -1, -1));

        jLabel16.setBackground(new java.awt.Color(0, 0, 0));
        jLabel16.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("MISTER JUERGA");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Bauhaus 93", 0, 24)); // NOI18N
        jLabel5.setText("MISTER JUERGA");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 0, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 800, 40));

        jPanel8.setBackground(new java.awt.Color(153, 153, 255));
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("ALMACENES");
        jPanel8.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 30));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/almacen.png"))); // NOI18N
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 70));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(153, 153, 255));
        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "FECHA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 90, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(153, 153, 255));
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHora.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "HORA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 90, -1));

        txtUsuario.setEditable(false);
        txtUsuario.setBackground(new java.awt.Color(153, 153, 255));
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 140, -1));

        jLabel17.setFont(new java.awt.Font("Bauhaus 93", 0, 36)); // NOI18N
        jLabel17.setText("ALMACENES");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 20, -1, 30));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 70));

        btnModificar1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnModificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton-eliminar.png"))); // NOI18N
        btnModificar1.setText("ELIMINAR");
        btnModificar1.setBorder(null);
        btnModificar1.setBorderPainted(false);
        btnModificar1.setContentAreaFilled(false);
        btnModificar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        txtCodigo.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtCiudad.setText("");
        txtTelefono.setText("");
        //cmbResponsable.setSelectedIndex(1);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            Almacen a = new Almacen();
            a.setNombre(txtNombre.getText());
            a.setDireccion(txtDireccion.getText());
            a.setCiudad(txtCiudad.getText());
            a.setTelefono(txtTelefono.getText());
            a.setResponsable(cmbResponsable.getSelectedItem().toString());
            
            AlmacenDAO adao = new AlmacenDAO();
            if (adao.Registrar(a)) {
                JOptionPane.showMessageDialog(getRootPane(), "SE REGISTRO EL ALMACEN");
                new AlmacenControl().RefrescarTablaAlmacen(tblAlmacenes);
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "ERROR AL REGISTRAR EL ALMACEN");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tblAlmacenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlmacenesMouseClicked
        try {
            int fila = tblAlmacenes.getSelectedRow();
            int id = Integer.parseInt(tblAlmacenes.getValueAt(fila, 0).toString());
            Object[] datos = (Object[])new AlmacenControl().CargarAlmacenSeleccionado(id);
            txtCodigo.setText(""+datos[0]);
            txtNombre.setText(""+datos[1]);
            txtDireccion.setText(""+datos[2]);
            txtCiudad.setText(""+datos[3]);
            txtTelefono.setText(""+datos[4]);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_tblAlmacenesMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            Almacen a = new Almacen();
            a.setNombre(txtNombre.getText());
            a.setCiudad(txtCiudad.getText());
            a.setDireccion(txtDireccion.getText());
            a.setTelefono(txtTelefono.getText());
            a.setResponsable(cmbResponsable.getSelectedItem().toString());
            a.setId(Integer.parseInt(txtCodigo.getText()));
            AlmacenDAO adao = new AlmacenDAO();
            if (adao.modificar(a)) {
                JOptionPane.showMessageDialog(getRootPane(), "SE MODIFICO EL ALMACEN: "+txtCodigo.getText());
                new AlmacenControl().RefrescarTablaAlmacen(tblAlmacenes);
            }else{
                JOptionPane.showMessageDialog(getRootPane(), "ERROR");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void cmbAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlmacenActionPerformed
        try {
            String almacen = cmbAlmacen.getSelectedItem().toString();
            Object datos[] = (Object[]) new AlmacenControl().CargarAlmacenSeleccionadoConNombre(almacen);
            txtCodigo.setText(""+datos[0]);
            txtNombre.setText(""+datos[1]);
            txtDireccion.setText(""+datos[2]);
            txtCiudad.setText(""+datos[3]);
            txtTelefono.setText(""+datos[4]);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_cmbAlmacenActionPerformed

    private void btnMovimientosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMovimientosMouseEntered
        btnMovimientos.setBackground(Color.white);
        btnMovimientos.setForeground(Color.black);
    }//GEN-LAST:event_btnMovimientosMouseEntered

    private void btnMovimientosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMovimientosMouseExited
        btnMovimientos.setBackground(Color.BLACK);
        btnMovimientos.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnMovimientosMouseExited

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btnRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseEntered
        btnRegistrar.setBackground(Color.white);
        btnRegistrar.setForeground(Color.black);
    }//GEN-LAST:event_btnRegistrarMouseEntered

    private void btnRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseExited
        btnRegistrar.setBackground(Color.BLACK);
        btnRegistrar.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnRegistrarMouseExited

    private void btnReportesExistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesExistenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesExistenciasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnReporteEntradas;
    private javax.swing.JTabbedPane btnReporteSalidas;
    private javax.swing.JButton btnReportesExistencias;
    private javax.swing.JButton btnSalidas;
    private javax.swing.JComboBox<String> cmbAlmacen;
    private javax.swing.JComboBox cmbResponsable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblAlmacenes;
    private javax.swing.JTable tblEntradas;
    private javax.swing.JTable tblExistencias;
    private javax.swing.JTable tblSalidas;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

package Vista;

import Controlador.ConteoDiarioControl;
import Controlador.FormatoFechas;
import Modelo.Medida;
import javax.swing.JOptionPane;

/**
 *
 * @author Marce
 */
public class ConteoDiario extends javax.swing.JInternalFrame {

    ConteoDiarioControl cdc;

    public ConteoDiario(String usuario) {
        initComponents();
        cdc = new ConteoDiarioControl(this);
        lblUsuario.setText(usuario);
    }

    public ConteoDiario() {
    }


    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConteosPorFecha = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
        jdcFechas = new com.toedter.calendar.JDateChooser();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBuscarProductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cmbCategorias = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cmbMedida = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jlabelu = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jlabelf = new javax.swing.JLabel();
        jlabelh = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContados = new javax.swing.JTable();
        btnCrearReporte = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        ConteosPorFecha.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("CREAR REPORTE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ConteosPorFecha.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 220, 40));

        jdcFechas.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ConteosPorFecha.getContentPane().add(jdcFechas, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 370, 40));

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 107, 83));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1050, 300));

        jLabel3.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("cantidad");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, -1, -1));

        cmbCategorias.setBackground(new java.awt.Color(255, 107, 83));
        cmbCategorias.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        cmbCategorias.setForeground(new java.awt.Color(255, 255, 255));
        cmbCategorias.setBorder(null);
        jPanel4.add(cmbCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 100, 300, 30));

        jLabel8.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("categoria");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("datos de producto");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        txtCantidad.setBackground(new java.awt.Color(255, 107, 83));
        txtCantidad.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(255, 255, 255));
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        txtCantidad.setEnabled(false);
        jPanel4.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 450, 130, -1));

        btnAgregar.setBackground(new java.awt.Color(8, 102, 0));
        btnAgregar.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("agregar");
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel4.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 120, -1));

        btnCancelar.setBackground(new java.awt.Color(8, 102, 0));
        btnCancelar.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("cancelar");
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel4.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 450, 120, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Leelawadee", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("CONTEO DIARIO");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cmbMedida.setBackground(new java.awt.Color(255, 107, 83));
        cmbMedida.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        cmbMedida.setForeground(new java.awt.Color(255, 255, 255));
        cmbMedida.setBorder(null);
        jPanel4.add(cmbMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 300, 30));

        jLabel10.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("medida");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 1070, 490));

        jPanel1.setBackground(new java.awt.Color(85, 74, 70));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("_____");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, -1));

        lblHora.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setText("____");
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 180, -1));

        jlabelu.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jlabelu.setForeground(new java.awt.Color(255, 255, 255));
        jlabelu.setText("usuario:");
        jPanel1.add(jlabelu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblFecha.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("____");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 150, -1));

        jlabelf.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jlabelf.setForeground(new java.awt.Color(255, 255, 255));
        jlabelf.setText("fecha:");
        jPanel1.add(jlabelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, -1));

        jlabelh.setFont(new java.awt.Font("Leelawadee", 0, 24)); // NOI18N
        jlabelh.setForeground(new java.awt.Color(255, 255, 255));
        jlabelh.setText("hora:");
        jPanel1.add(jlabelh, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 870, 1070, 50));

        jPanel9.setBackground(new java.awt.Color(120, 113, 109));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblContados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblContados);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1050, 310));

        btnCrearReporte.setBackground(new java.awt.Color(120, 113, 109));
        btnCrearReporte.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        btnCrearReporte.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearReporte.setText("crear reportes");
        btnCrearReporte.setBorderPainted(false);
        btnCrearReporte.setContentAreaFilled(false);
        btnCrearReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearReporte.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel9.add(btnCrearReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 330, 180, -1));

        btnGuardar.setBackground(new java.awt.Color(8, 102, 0));
        btnGuardar.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("guardar");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nPerformed(evt);
            }
        });
        jPanel9.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 120, -1));

        btnQuitar.setBackground(new java.awt.Color(8, 102, 0));
        btnQuitar.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        btnQuitar.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitar.setText("quitar");
        btnQuitar.setBorderPainted(false);
        btnQuitar.setContentAreaFilled(false);
        btnQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnQuitar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel9.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 120, -1));

        btnLimpiar.setBackground(new java.awt.Color(8, 102, 0));
        btnLimpiar.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("limpiar");
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel9.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 120, -1));

        jButton6.setBackground(new java.awt.Color(8, 102, 0));
        jButton6.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("cancelar");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel9.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 120, -1));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 1070, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nPerformed
        
    }//GEN-LAST:event_nPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(getRootPane(), new FormatoFechas().FormatoFec(jdcFechas));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ConteosPorFecha;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCancelar;
    public javax.swing.JButton btnCrearReporte;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnQuitar;
    public javax.swing.JComboBox<String> cmbCategorias;
    public javax.swing.JComboBox<Medida> cmbMedida;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcFechas;
    private javax.swing.JLabel jlabelf;
    private javax.swing.JLabel jlabelh;
    private javax.swing.JLabel jlabelu;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblHora;
    public javax.swing.JLabel lblUsuario;
    public javax.swing.JTable tblBuscarProductos;
    public javax.swing.JTable tblContados;
    public javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
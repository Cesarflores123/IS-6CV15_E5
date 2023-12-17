package test;

import coneccion.*;
import damain.ContadorID;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VGVAManual extends javax.swing.JFrame {

    static int idd = 0;

    Conexion conectar = Conexion.getInstance();

    public VGVAManual() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("ASISTENCIA MANUAL");
        regresar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtBoleta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jbtnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(108, 23, 43));

        jPanel3.setBackground(java.awt.Color.lightGray);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("Agregar manualmente");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(102, 102, 102))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Número de boleta:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre del alumno:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre(s)         Apellido paterno       Apellido materno");

        jtxtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtNombreKeyTyped(evt);
            }
        });

        jbtnAgregar.setBackground(java.awt.Color.lightGray);
        jbtnAgregar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtNombre)
                            .addComponent(jtxtBoleta)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jbtnAgregar)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtBoleta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(jbtnAgregar)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void regresar() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    pantallaAnterior();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pantallaAnterior() {
        this.dispose();
        VGAsistencia vEAsistencia = new VGAsistencia();
        vEAsistencia.setVisible(true);
    }

    public void setValor(String grupo) {
        idd = -1;
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT id_grupo FROM Grupo WHERE grupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, grupo);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        idd = resultSet.getInt("id_grupo");
                    }
                }
            }
            conectar.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int obtenerIdAlumnoPorBoleta(String boleta) {
        int idAlumno = -1;
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT id_alumno FROM Alumno WHERE boleta = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, boleta);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        idAlumno = resultSet.getInt("id_alumno");
                    }
                }
            }
            conectar.cerrarConexion();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idAlumno;
    }

    private void insertarAsistencia(Connection conexion, int id_asistencia, int id_InfoAlumno) throws SQLException {
        String consultaAsistencia = "INSERT INTO Asistencia (id_asistencia, id_InfoAlumno, asistencia, fecha) VALUES (?, ?, 'x', CURRENT_DATE)";
        try (PreparedStatement pstmtAsistencia = conexion.prepareStatement(consultaAsistencia)) {
            pstmtAsistencia.setInt(1, id_asistencia);
            pstmtAsistencia.setInt(2, id_InfoAlumno);
            pstmtAsistencia.executeUpdate();
        }
    }

    private void actualizarIdAsistenciaEnInfoAlumno(Connection conexion, int id_asistencia, int id_InfoAlumno) throws SQLException {
        String consultaActualizarIdAsistencia = "UPDATE InfoAlumno SET id_asistencia = ? WHERE id_infoAlumno = ?";
        try (PreparedStatement pstmtActualizarIdAsistencia = conexion.prepareStatement(consultaActualizarIdAsistencia)) {
            pstmtActualizarIdAsistencia.setInt(1, id_asistencia);
            pstmtActualizarIdAsistencia.setInt(2, id_InfoAlumno);
            pstmtActualizarIdAsistencia.executeUpdate();
        }
    }

    private void agregarAlumnoAGrupo(Connection conexion, int id_boleta) throws SQLException {
        String nombreAlumno = jtxtNombre.getText();
        int id_asistencia = ContadorID.obtenerMaxId(conectar, "asistencia") + 1;
        int id_InfoAlumno = ContadorID.obtenerMaxId(conectar, "InfoAlumno") + 1;
        insertarAsistencia(conexion, id_asistencia, id_InfoAlumno);
        String insertarInfoAlumno = "INSERT INTO infoAlumno (id_InfoAlumno, id_alumno, id_asistencia, id_grupo) VALUES (?,?,?,?)";
        try (PreparedStatement pstmtInsertar = conexion.prepareStatement(insertarInfoAlumno)) {
            pstmtInsertar.setInt(1, id_InfoAlumno);
            pstmtInsertar.setInt(2, id_boleta);
            pstmtInsertar.setInt(3, id_asistencia);
            pstmtInsertar.setInt(4, idd);
            pstmtInsertar.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //}
    }

    private void agregarNuevoAlumno(Connection conexion, String boleta) throws SQLException {
        if (!existeAlumno(conexion, boleta)) {
            int opcion = JOptionPane.showConfirmDialog(null, "Alumno no existente \n ¿Desea agregarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                String nombreAlumno = jtxtNombre.getText();
                try {
                    String consultaInsertarAlumno = "INSERT INTO Alumno (id_alumno, nombre_completo, boleta) VALUES (?, ?, ?)";
                    try (PreparedStatement pstmtInsertarAlumno = conexion.prepareStatement(consultaInsertarAlumno)) {
                        int nuevoIdAlumno = ContadorID.obtenerMaxId(conectar, "alumno") + 1;
                        pstmtInsertarAlumno.setInt(1, nuevoIdAlumno);
                        pstmtInsertarAlumno.setString(2, nombreAlumno);
                        pstmtInsertarAlumno.setString(3, boleta);
                        pstmtInsertarAlumno.executeUpdate();

                        int id_asistencia = ContadorID.obtenerMaxId(conectar, "asistencia") + 1;
                        int id_InfoAlumno = ContadorID.obtenerMaxId(conectar, "InfoAlumno") + 1;
                        insertarAsistencia(conexion, id_asistencia, id_InfoAlumno);

                        String insertarInfoAlumno = "INSERT INTO infoAlumno (id_InfoAlumno, id_alumno, id_asistencia, id_grupo) VALUES (?,?,?,?)";
                        try (PreparedStatement pstmtInsertar = conexion.prepareStatement(insertarInfoAlumno)) {
                            pstmtInsertar.setInt(1, id_InfoAlumno);
                            pstmtInsertar.setInt(2, nuevoIdAlumno);
                            pstmtInsertar.setInt(3, id_asistencia);
                            pstmtInsertar.setInt(4, idd);
                            pstmtInsertar.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {
                jtxtBoleta.setText(boleta);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El alumno ya existe en la base de datos.");
            int id_boleta = obtenerIdAlumnoPorBoleta(boleta);
            agregarAlumnoAGrupo(conexion, id_boleta);
        }
        jtxtBoleta.setText("");
        jtxtNombre.setText("");
    }

    private boolean existeAlumno(Connection conexion, String boleta) {
        String consultaExisteAlumno = "SELECT COUNT(*) FROM Alumno WHERE boleta = ?";
        try (PreparedStatement pstmtExisteAlumno = conexion.prepareStatement(consultaExisteAlumno)) {
            pstmtExisteAlumno.setString(1, boleta);
            try (ResultSet resultSet = pstmtExisteAlumno.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        String boleta = jtxtBoleta.getText();
        int id_boleta = obtenerIdAlumnoPorBoleta(boleta);
        int id_grupo = idd;

        try (Connection conexion = conectar.conectar()) {
            String consultaInfoAlumno = "SELECT id_infoAlumno, id_alumno, id_grupo FROM InfoAlumno WHERE id_alumno = ?";

            try (PreparedStatement pstmtInfoAlumno = conexion.prepareStatement(consultaInfoAlumno)) {
                pstmtInfoAlumno.setInt(1, id_boleta);

                try (ResultSet resultadoInfoAlumno = pstmtInfoAlumno.executeQuery()) {
                    if (resultadoInfoAlumno.next()) {
                        int id_alumno = resultadoInfoAlumno.getInt("id_alumno");
                        int id_grupo_infoAlumno = resultadoInfoAlumno.getInt("id_grupo");

                        if (id_grupo_infoAlumno == id_grupo) {
                            int id_asistencia = ContadorID.obtenerMaxId(conectar, "asistencia") + 1;
                            int id_InfoAlumno = resultadoInfoAlumno.getInt("id_infoAlumno");

                            insertarAsistencia(conexion, id_asistencia, id_InfoAlumno);

                            actualizarIdAsistenciaEnInfoAlumno(conexion, id_asistencia, id_InfoAlumno);

                        } else {
                            int opcion = JOptionPane.showConfirmDialog(null, "Alumno no existente \n ¿Desea agregarlo?", "Confirmación", JOptionPane.YES_NO_OPTION);
                            if (opcion == JOptionPane.YES_OPTION) {
                                agregarAlumnoAGrupo(conexion, id_boleta);
                            }
                        }
                    } else {
                        agregarNuevoAlumno(conexion, boleta);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jtxtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNombreKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if (Character.isLowerCase(caracter)) {
            evt.setKeyChar(Character.toUpperCase(caracter));
        }
    }//GEN-LAST:event_jtxtNombreKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VGVAManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VGVAManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VGVAManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VGVAManual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VGVAManual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JTextField jtxtBoleta;
    private javax.swing.JTextField jtxtNombre;
    // End of variables declaration//GEN-END:variables
}

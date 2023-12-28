/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package test;

import coneccion.*;
import damain.ContadorID;
import damain.ExportarExcel;
import damain.ObtenerID;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Gabriela
 */
public class VGVer extends javax.swing.JFrame {
    static String idd_grupo = "";
    static String idd_cicloescolar = "";
    Conexion conectar = Conexion.getInstance();

    public VGVer() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("INFORMACIÓN GRUPO");
        regresar();
        setValor(idd_grupo, idd_cicloescolar);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jbtnAsistencia = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnExportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxtaObservaciones = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(108, 23, 43));
        jPanel1.setPreferredSize(new java.awt.Dimension(655, 425));

        jPanel2.setBackground(java.awt.Color.lightGray);

        jbtnAsistencia.setBackground(java.awt.Color.lightGray);
        jbtnAsistencia.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnAsistencia.setText("Pase de lista");
        jbtnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAsistenciaActionPerformed(evt);
            }
        });

        jbtnEliminar.setBackground(java.awt.Color.lightGray);
        jbtnEliminar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });

        jbtnExportar.setBackground(java.awt.Color.lightGray);
        jbtnExportar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jbtnExportar.setText("Exportar");
        jbtnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jbtnAsistencia)
                .addGap(148, 148, 148)
                .addComponent(jbtnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnExportar)
                .addGap(53, 53, 53))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAsistencia)
                    .addComponent(jbtnEliminar)
                    .addComponent(jbtnExportar))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTableDatos.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        jTableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BOLETA", "NOMBRE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDatos);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reporte de anomalías");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        jtxtaObservaciones.setColumns(1);
        jtxtaObservaciones.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jtxtaObservaciones.setLineWrap(true);
        jtxtaObservaciones.setRows(1);
        jtxtaObservaciones.setTabSize(1);
        jScrollPane2.setViewportView(jtxtaObservaciones);
        jtxtaObservaciones.getAccessibleContext().setAccessibleParent(jtxtaObservaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setValor(String id_grupo, String cicloEscolar) {
        idd_grupo = "";
        idd_cicloescolar = "";
        idd_grupo = id_grupo;
        idd_cicloescolar = cicloEscolar;
        Font personalizar = new Font("Times New Roman", Font.BOLD, 28);
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"BOLETA", "NOMBRE"}, 0);
        JLabel etiqueta = new JLabel(id_grupo + "-" + cicloEscolar);
        etiqueta.setBounds(250, 100, 180, 40);
        etiqueta.setFont(personalizar);
        etiqueta.setForeground(white);
        VGVAManual manual = new VGVAManual();
        manual.setValor(id_grupo);
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT Alumno.nombre_completo, Alumno.boleta "
        + "FROM Alumno "
        + "JOIN InfoAlumno ON Alumno.id_alumno = InfoAlumno.id_alumno "
        + "JOIN InfoGrupo ON InfoAlumno.id_grupo = InfoGrupo.id_grupo "
        + "JOIN Grupo ON InfoGrupo.id_grupo = Grupo.id_grupo "
        + "WHERE Grupo.grupo = ? "
        + "ORDER BY Alumno.nombre_completo ASC"; 

            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setString(1, id_grupo);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String nombre = resultSet.getString("nombre_completo");
                        String boleta = resultSet.getString("boleta");
                        tableModel.addRow(new Object[]{boleta, nombre});
                    }
                }
            }
            tableModel.fireTableDataChanged();
            jTableDatos.setModel(tableModel);
            jPanel1.add(etiqueta);
            jPanel1.validate();
            jPanel1.repaint();

            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    public void regresar() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    pantallaAnterior();
                    try {
                        guardarContenido();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pantallaAnterior() {
        this.dispose();
    }

    private void guardarContenido() throws SQLException {
        try {
            Connection conexion = conectar.conectar();
            int idGrupo = ObtenerID.obtenerIDG(conectar, idd_grupo);
            int idObservaciones = ContadorID.obtenerMaxIdO(conectar, "observaciones") + 1;
            int idInfoGrupo = ObtenerID.obtenerIDIG(conectar, idGrupo);
            String contenido = jtxtaObservaciones.getText();

            if (!contenido.isEmpty()) {
                String query = "INSERT INTO Observaciones (id_observacion, observacion, id_infoGrupo, fecha) VALUES (?, ?, ?, CURRENT_DATE)";
                String ActualizarIdObservacion = "UPDATE InfoGrupo SET id_observacion = ? WHERE id_infoGrupo = ?";
                try (PreparedStatement preparedStatement = conexion.prepareStatement(query); PreparedStatement pstmtActualizarIdOb = conexion.prepareStatement(ActualizarIdObservacion)) {
                    preparedStatement.setInt(1, idObservaciones);
                    preparedStatement.setString(2, contenido);
                    preparedStatement.setInt(3, idInfoGrupo);
                    preparedStatement.executeUpdate();

                    pstmtActualizarIdOb.setInt(1, idObservaciones);
                    pstmtActualizarIdOb.setInt(2, idInfoGrupo);
                    pstmtActualizarIdOb.executeUpdate();
                }

            }
            jtxtaObservaciones.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Integer> obtenerIdsInfoGrupo(int idGrupo) {
        List<Integer> idsInfoGrupo = new ArrayList<>();
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT id_InfoGrupo, id_laboratorio FROM InfoGrupo WHERE id_grupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int idInfoGrupo = resultSet.getInt("id_InfoGrupo");
                    int idLaboratorio = resultSet.getInt("id_laboratorio");
                    idsInfoGrupo.add(idInfoGrupo);
                    idsInfoGrupo.add(idLaboratorio);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return idsInfoGrupo;
    }

    private List<Integer> obtenerIdsInfoAlumno(int idGrupo) {
        List<Integer> idsInfoAlumno = new ArrayList<>();
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT id_InfoAlumno FROM InfoAlumno WHERE id_grupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idInfoAlumno = resultSet.getInt("id_InfoAlumno");
                    idsInfoAlumno.add(idInfoAlumno);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idsInfoAlumno;
    }

    private List<Integer> obtenerIdsObservaciones(int idGrupo) {
        List<Integer> idsObservaciones = new ArrayList<>();
        int idInfoGrupo = ObtenerID.obtenerIDIG(conectar, idGrupo);
        try {
            Connection conexion = conectar.conectar();
            String query = "SELECT id_observacion FROM observaciones WHERE id_infoGrupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
                preparedStatement.setInt(1, idInfoGrupo);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int idObservacion = resultSet.getInt("id_observacion");
                    idsObservaciones.add(idObservacion);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return idsObservaciones;
    }

    private void eliminarLaboratorio(Connection conexion, int idLaboratorio) {
        try {
            String eliminar = "DELETE FROM laboratorio WHERE id_laboratorio = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(eliminar)) {
                preparedStatement.setInt(1, idLaboratorio);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarInfoGrupo(Connection conexion, int idInfoGrupo) {
        try {
            String eliminar = "DELETE FROM InfoGrupo WHERE id_infoGrupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(eliminar)) {
                preparedStatement.setInt(1, idInfoGrupo);
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void eliminarInfoAlumno(Connection conexion, int idInfoAlumno) {
        try {
            String eliminar = "DELETE FROM InfoAlumno WHERE id_InfoAlumno = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(eliminar)) {
                preparedStatement.setInt(1, idInfoAlumno);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    private void eliminarAsistencia(Connection conexion, List<Integer> idsInfoAlumno) {
        try {
            String consultar = "SELECT id_Asistencia FROM Asistencia WHERE id_InfoAlumno = ?";
            String eliminar = "DELETE FROM Asistencia WHERE id_asistencia = ?";
            try (PreparedStatement consultaStatement = conexion.prepareStatement(consultar); PreparedStatement eliminarStatement = conexion.prepareStatement(eliminar)) {
                for (int idInfoAlumno : idsInfoAlumno) {
                    consultaStatement.setInt(1, idInfoAlumno);
                    ResultSet resultSet = consultaStatement.executeQuery();
                    while (resultSet.next()) {
                        int idAsistencia = resultSet.getInt("id_asistencia");
                        eliminarStatement.setInt(1, idAsistencia);
                        eliminarStatement.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void eliminarObservaciones(Connection conexion, int idInfoGrupo) {
        try {
            String eliminar = "DELETE FROM observaciones WHERE id_infogrupo = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(eliminar)) {
                preparedStatement.setInt(1, idInfoGrupo);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    public void eliminarDocenteYGrupoPorIdGrupo(Connection conexion, int idGrupo) {
        try {
            int idDocente = ObtenerID.obtenerIDD(conectar, idGrupo);
            String eliminarGrupo = "DELETE FROM Grupo WHERE id_grupo = ?";
            try (PreparedStatement eliminarGrupoStatement = conexion.prepareStatement(eliminarGrupo)) {
                eliminarGrupoStatement.setInt(1, idGrupo);
                eliminarGrupoStatement.executeUpdate();
            }

            if (idDocente != -1) {
                String eliminarDocente = "DELETE FROM Docente WHERE id_docente = ?";
                try (PreparedStatement eliminarDocenteStatement = conexion.prepareStatement(eliminarDocente)) {
                    eliminarDocenteStatement.setInt(1, idDocente);
                    eliminarDocenteStatement.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void jbtnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAsistenciaActionPerformed
        VGAsistencia asistencia = new VGAsistencia();
        asistencia.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jbtnAsistenciaActionPerformed
    private void jbtnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExportarActionPerformed
        String grupo = idd_grupo;
        String ciclo = idd_cicloescolar;
        try {
            ExportarExcel.exportarHojaAsistencia(conectar, grupo, grupo + ciclo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jbtnExportarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea borrar este grupo?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            try (Connection conexion = conectar.conectar()) {
                int idGrupoEliminar = ObtenerID.obtenerIDG(conectar, idd_grupo);
                List<Integer> idsInfoGrupo = obtenerIdsInfoGrupo(idGrupoEliminar);
                List<Integer> idsInfoAlumno = obtenerIdsInfoAlumno(idGrupoEliminar);
                List<Integer> idsObservaciones = obtenerIdsObservaciones(idGrupoEliminar);

                int idInfoGrupo = idsInfoGrupo.get(0);
                int idLaboratorio = idsInfoGrupo.get(1);

                eliminarInfoGrupo(conexion, idInfoGrupo);
                eliminarLaboratorio(conexion, idLaboratorio);
                eliminarObservaciones(conexion, idInfoGrupo);
                
                for (int idInfoAlumno : idsInfoAlumno) {
                    eliminarInfoAlumno(conexion, idInfoAlumno);
                }
                for (int idObservacion : idsObservaciones) {
                    eliminarObservaciones(conexion, idObservacion);
                }
                eliminarAsistencia(conexion, idsInfoAlumno);

                eliminarDocenteYGrupoPorIdGrupo(conexion, idGrupoEliminar);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        this.dispose();
    }//GEN-LAST:event_jbtnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(VGVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VGVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VGVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VGVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VGVer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableDatos;
    private javax.swing.JButton jbtnAsistencia;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnExportar;
    private javax.swing.JTextArea jtxtaObservaciones;
    // End of variables declaration//GEN-END:variables
}

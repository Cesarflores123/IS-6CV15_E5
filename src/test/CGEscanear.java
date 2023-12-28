/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package test;

import coneccion.*;
import damain.*;
import java.sql.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class CGEscanear extends javax.swing.JFrame {

    Conexion conectar = Conexion.getInstance();
    int id_grupo;

    public CGEscanear() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("AGREGAR ALUMNOS");
        this.setVisible(true);
        regresar();
        QRCodeScanner escanear = new QRCodeScanner();
        escanear.startScanning();
        //escanearYActualizarTabla();
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
        jLabel1 = new javax.swing.JLabel();
        jbtnFinalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableAlumno = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(108, 23, 43));
        jPanel1.setPreferredSize(new java.awt.Dimension(655, 425));

        jPanel2.setBackground(java.awt.Color.lightGray);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setText("REGISTRO DE ALUMNOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jbtnFinalizar.setBackground(java.awt.Color.lightGray);
        jbtnFinalizar.setText("Finalizar");
        jbtnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFinalizarActionPerformed(evt);
            }
        });

        jtableAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtableAlumno);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jbtnFinalizar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnFinalizar)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void regresar() {
        try {
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowAnterior(WindowEvent e) {
                    pantallaAnterior();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pantallaAnterior() {
        CrearGrupo vCGrupo = new CrearGrupo();
        vCGrupo.setVisible(true);
        this.dispose();
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
    
    public void escanearYActualizarTabla(String url) {
        //DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"BOLETA", "NOMBRE"}, 0);

        try {
            // Conecta y obtén el HTML de la página
            Document doc = Jsoup.connect(url).timeout(20000).get();

            // Busca el div con el nombre del alumno
            Element nombreDiv = doc.select("div.nombre").first();
            String nombre = nombreDiv.text();

            // Busca el div con la boleta del alumno
            Element boletaDiv = doc.select("div.boleta").first();
            String boleta = boletaDiv.text();
            System.out.println(nombre);
            System.out.println(boleta);

            // Agrega una nueva fila a la tabla
            DefaultTableModel tableModel = (DefaultTableModel) jtableAlumno.getModel();
            tableModel.addRow(new Object[]{boleta, nombre});
            tableModel.fireTableDataChanged();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void escanearYActualizarTabla() {
        String[] urls = {
            "https://servicios.dae.ipn.mx/vcred/?h=c92dc665d216a4efdeaa796b50a3aa854a16279cf7293befe610fc5e366067f0",
            "https://servicios.dae.ipn.mx/vcred/?h=3cc826172e535d19d9527815e04d528267beffd82ac6e1b0555aeabebeca4a61",
            "https://servicios.dae.ipn.mx/vcred/?h=a97aa3a97d8ace1bba101f414d4139721f78585d7591cd002ac4b423834a27a6",
            "https://servicios.dae.ipn.mx/vcred/?h=27e34b3ab0c6bfb35571fd675caa6e75cab09e289b02d2268a4558c16841c0cc",

            "https://servicios.dae.ipn.mx/vcred/?h=48c45c3595d54e2c634f488a6ffe4021aae89bb0080ce1767f009127f2a815da",
            "https://servicios.dae.ipn.mx/vcred/?h=8bfeebb974b8603ff444ab0181f52de53cc16e74c0013849a5ad198c12499e19",
            "https://servicios.dae.ipn.mx/vcred/?h=fe09fc5757c0b925e35118b4782893887ce6eb490b8b1fe3eac2af737859655e",
            "https://servicios.dae.ipn.mx/vcred/?h=8d0ca457518fca24f21b18f2019a232d40ae2a69a499f81afba9a3139f59987d",
            "https://servicios.dae.ipn.mx/vcred/?h=18011c5ffcfca729f56fd966c3f6ee0ffacdf223200a223dc495f919d702a37d"
        };
        for (String url : urls) {
            escanearYActualizarTabla(url);
        }
    }*/

    public void setIdGrupo(Integer idGrupo) {
        id_grupo = idGrupo;
    }

    private void jbtnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFinalizarActionPerformed
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea concluir el registro de alumnos?", "Confirmacion", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"BOLETA", "NOMBRE"}, 0);
            this.setVisible(false);
            try {
                Connection conexion = conectar.conectar();
                conexion.setAutoCommit(false);

                PreparedStatement consultarBoleta = conexion.prepareStatement("SELECT id_alumno FROM Alumno WHERE boleta = ?");
                PreparedStatement insertarAl = conexion.prepareStatement("INSERT INTO Alumno (id_alumno, nombre_completo, boleta) VALUES (?, ?, ?)");
                PreparedStatement insertarIA = conexion.prepareStatement("INSERT INTO InfoAlumno(id_InfoAlumno, id_alumno, id_grupo) VALUES (?, ?, ?)");
                int idAlumno = ContadorID.obtenerMaxIdA(conectar) + 1;
                System.out.println("idAlumno = " + idAlumno);
                int idInfoAlumno = ContadorID.obtenerMaxId(conectar, "infoalumno") + 1;
                System.out.println("idInfoAlumno = " + idInfoAlumno);
                int id_asistencia = ContadorID.obtenerMaxId(conectar, "asistencia") + 1;
                
                
                for (int fila = 0; fila < jtableAlumno.getRowCount(); fila++) {

                    String boleta = jtableAlumno.getValueAt(fila, 0).toString().trim();
                    String nombre = jtableAlumno.getValueAt(fila, 1).toString().trim();
                    // Consultar si la boleta ya existe
                    consultarBoleta.setString(1, boleta);
                    ResultSet resultSet = consultarBoleta.executeQuery();

                    if (resultSet.next()) {
                        int idAlumnoExistente = resultSet.getInt("id_alumno");
                        insertarIA.setInt(1, idInfoAlumno);
                        insertarIA.setInt(2, idAlumnoExistente);
                        insertarIA.setInt(3, id_grupo);
                        insertarIA.executeUpdate();
                        insertarAsistencia(conexion, id_asistencia, idInfoAlumno);
                        actualizarIdAsistenciaEnInfoAlumno(conexion, id_asistencia, idInfoAlumno);
                        idInfoAlumno++;
                        id_asistencia++;
                    } else {
                        insertarAl.setInt(1, idAlumno);
                        insertarAl.setString(2, nombre);
                        insertarAl.setString(3, boleta);
                        insertarAl.executeUpdate();

                        insertarIA.setInt(1, idInfoAlumno);
                        insertarIA.setInt(2, idAlumno);
                        insertarIA.setInt(3, id_grupo);
                        insertarIA.executeUpdate();
                        insertarAsistencia(conexion, id_asistencia, idInfoAlumno);
                        actualizarIdAsistenciaEnInfoAlumno(conexion, id_asistencia, idInfoAlumno);
                        idInfoAlumno++;
                        id_asistencia++;
                        idAlumno++;
                    }

                }
                conexion.commit();
                conectar.cerrarConexion();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
            tableModel.setRowCount(0);
            jtableAlumno.setModel(tableModel);
            this.dispose();
        }

    }//GEN-LAST:event_jbtnFinalizarActionPerformed

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
            java.util.logging.Logger.getLogger(CGEscanear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CGEscanear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CGEscanear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CGEscanear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CGEscanear().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnFinalizar;
    private javax.swing.JTable jtableAlumno;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package test;

import coneccion.*;
import damain.ContadorID;
import damain.TextPrompt;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Parametros extends javax.swing.JFrame {

    Conexion conectar = Conexion.getInstance();

    public Parametros() {
        initComponents();
        this.setTitle("PARAMETROS");
        this.setLocationRelativeTo(null);
        regresar();
        TextPrompt placeholderM = new TextPrompt("Materia", jtxtMateria);
        TextPrompt placeholderC = new TextPrompt("CicloEscolar ej.20241", jtxtCiclo);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtMateria = new javax.swing.JTextField();
        jtxtCiclo = new javax.swing.JTextField();
        jbtnMateria = new javax.swing.JButton();
        jbtnCiclo = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(108, 23, 43));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Materia:");

        jPanel2.setBackground(java.awt.Color.lightGray);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setText("AGREGAR PARÁMETROS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ciclo escolar:");

        jtxtMateria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtMateriaKeyTyped(evt);
            }
        });

        jtxtCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCicloActionPerformed(evt);
            }
        });
        jtxtCiclo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCicloKeyTyped(evt);
            }
        });

        jbtnMateria.setBackground(java.awt.Color.lightGray);
        jbtnMateria.setText("Agregar");
        jbtnMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMateriaActionPerformed(evt);
            }
        });

        jbtnCiclo.setBackground(java.awt.Color.lightGray);
        jbtnCiclo.setText("Agregar");
        jbtnCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCicloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtMateria, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jtxtCiclo))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnMateria)
                    .addComponent(jbtnCiclo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnMateria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnCiclo))
                .addGap(57, 57, 57))
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
        Inicio vInicio = new Inicio();
        vInicio.setVisible(true);
    }

    private boolean elementoExiste(Connection conexion, String tabla, String campo, String valor) throws SQLException {
        String consulta = "SELECT COUNT(*) FROM " + tabla + " WHERE " + campo + " = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, valor);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // Devuelve true si existe al menos un registro con ese valor
                }
            }
        }
        return false;
    }
    private void jbtnMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMateriaActionPerformed
        try {
            Connection conexion = conectar.conectar();
            conexion.setAutoCommit(false);

            // Verificar si la asignatura ya existe
            String nombreAsignatura = jtxtMateria.getText().trim();
            if (elementoExiste(conexion, "asignatura", "asignatura",nombreAsignatura)) {
                JOptionPane.showMessageDialog(null, "La asignatura ya existe");
                jtxtMateria.setText("");
            } else {
                // La asignatura no existe, proceder a insertarla
                PreparedStatement insertara = conexion.prepareStatement("INSERT INTO asignatura (id_asignatura, asignatura) VALUES (?, ?)");
                int idAsignatura = ContadorID.obtenerMaxId(conectar, "asignatura") + 1;
                insertara.setInt(1, idAsignatura);
                insertara.setString(2, nombreAsignatura);
                insertara.executeUpdate();

                jtxtMateria.setText("");

                conexion.commit();
                JOptionPane.showMessageDialog(null, "Dato Registrado");
            }

            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_jbtnMateriaActionPerformed

    private void jtxtMateriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtMateriaKeyTyped
        char caracter = evt.getKeyChar();
        if (Character.isLowerCase(caracter)) {
            evt.setKeyChar(Character.toUpperCase(caracter));
        }
    }//GEN-LAST:event_jtxtMateriaKeyTyped

    private void jtxtCicloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCicloKeyTyped
        char caracter = evt.getKeyChar();
        if (Character.isLowerCase(caracter)) {
            evt.setKeyChar(Character.toUpperCase(caracter));
        }
    }//GEN-LAST:event_jtxtCicloKeyTyped

    private void jbtnCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCicloActionPerformed
        try {
            Connection conexion = conectar.conectar();
            conexion.setAutoCommit(false);
            // Verificar si la asignatura ya existe
            String nombreCiclo = jtxtCiclo.getText().trim();
            if (elementoExiste(conexion, "cicloescolar", "cicloescolar", nombreCiclo)) {
                JOptionPane.showMessageDialog(null, "El ciclo Escolar ya existe");
                jtxtCiclo.setText("");
            } else {
                PreparedStatement insertarc = conexion.prepareStatement("INSERT INTO cicloescolar (id_cicloEscolar, cicloEscolar) values(?, ?)");
                int idCicloEscolar = ContadorID.obtenerMaxId(conectar, "cicloEscolar") + 1;
                insertarc.setInt(1, idCicloEscolar);
                insertarc.setString(2, jtxtCiclo.getText().trim());
                insertarc.executeUpdate();

                jtxtCiclo.setText("");

                conexion.commit();
                JOptionPane.showMessageDialog(null, "Dato Registrado");
            }

            conectar.cerrarConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }//GEN-LAST:event_jbtnCicloActionPerformed

    private void jtxtCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCicloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCicloActionPerformed

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
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Parametros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Parametros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton jbtnCiclo;
    private javax.swing.JButton jbtnMateria;
    private javax.swing.JTextField jtxtCiclo;
    private javax.swing.JTextField jtxtMateria;
    // End of variables declaration//GEN-END:variables
}

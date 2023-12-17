/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package test;

import coneccion.*;
import java.sql.*;
import damain.TextPrompt;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class VerGrupos extends javax.swing.JFrame {

    Conexion conectar = Conexion.getInstance();
    private JPanel panelGrupos;
    public ArrayList<Component> componentes = new ArrayList<>();

    public VerGrupos() {
        initComponents();
        TextPrompt placeholder = new TextPrompt("Buscar grupo ej. 1CV11-20241", jtxtBuscador);
        this.setLocationRelativeTo(null);
        this.setTitle("VER GRUPOS");
        generarBotones();
        regresar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtxtBuscador = new javax.swing.JTextField();
        jbtnBuscador = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(108, 23, 43));
        jPanel1.setPreferredSize(new java.awt.Dimension(655, 425));

        jtxtBuscador.setToolTipText("");

        jbtnBuscador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        jbtnBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscadorActionPerformed(evt);
            }
        });

        jScrollPane.setBackground(new java.awt.Color(108, 23, 43));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jtxtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnBuscador))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtxtBuscador)
                    .addComponent(jbtnBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
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

    public void generarBotones() {
        try {
            // Tu código de conexión a la base de datos...
            Connection conexion = conectar.conectar();
            String query = "SELECT Grupo.grupo, CicloEscolar.cicloEscolar "
                    + "FROM Grupo "
                    + "JOIN InfoGrupo ON Grupo.id_grupo = InfoGrupo.id_grupo "
                    + "JOIN CicloEscolar ON InfoGrupo.id_cicloEscolar = CicloEscolar.id_cicloEscolar";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            JPanel panelGrupos = new JPanel();
            panelGrupos.setBackground(new Color(108, 23, 43));
            panelGrupos.setLayout(null);
            int y = 30;

            while (resultSet.next()) {
                String nombreGrupo = resultSet.getString("grupo");
                String cicloEscolar = resultSet.getString("cicloEscolar");

                JLabel etiqueta = new JLabel(nombreGrupo + "-" + cicloEscolar);
                JButton boton = new JButton("VER");

                Font personalizar = new Font("Times New Roman", Font.BOLD, 18);
                etiqueta.setFont(personalizar);
                boton.setFont(personalizar);
                etiqueta.setForeground(Color.WHITE);
                etiqueta.setBounds(75, y, 150, 30);
                boton.setBounds(250, y, 100, 30);

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        VGVer grupo = new VGVer();
                        grupo.setValor(nombreGrupo, cicloEscolar);
                        grupo.setVisible(true);
                        generarBotones();
                    }
                });

                componentes.add(etiqueta);
                componentes.add(boton);

                panelGrupos.add(etiqueta);
                panelGrupos.add(boton);

                y += 50;
            }

            panelGrupos.setPreferredSize(new Dimension(panelGrupos.getWidth(), y));
            jScrollPane.setViewportView(panelGrupos);
            jScrollPane.validate();
            jScrollPane.repaint();
            conectar.cerrarConexion();
        } catch (SQLException e) {
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
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pantallaAnterior() {
        this.dispose();
    }

    private void jbtnBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscadorActionPerformed
        String textoBusqueda = jtxtBuscador.getText().toLowerCase();
        int y = 30; // Reinicializa la posición y
        for (Component componente : componentes) {
            if (componente instanceof JLabel) {
                JLabel etiqueta = (JLabel) componente;
                String nombreGrupo = etiqueta.getText().toLowerCase();

                // Utiliza startsWith para mostrar solo los grupos que comienzan con el texto de búsqueda
                boolean grupoCoincide = nombreGrupo.startsWith(textoBusqueda);
                etiqueta.setVisible(grupoCoincide);

                // Encuentra el botón correspondiente al grupo actual
                int indice = componentes.indexOf(etiqueta);
                if (indice + 1 < componentes.size()) {
                    JButton boton = (JButton) componentes.get(indice + 1);
                    boton.setVisible(grupoCoincide);

                    // Ajusta la posición del grupo y el botón si es visible
                    if (grupoCoincide) {
                        etiqueta.setBounds(75, y, 150, 30);
                        boton.setBounds(250, y, 100, 30);
                        y += 50;
                    }
                }
            }
        }
        jtxtBuscador.setText("");
        if (textoBusqueda.isEmpty()) {
            for (Component componente : componentes) {
                componente.setVisible(true);
            }
        }
    }//GEN-LAST:event_jbtnBuscadorActionPerformed

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
            java.util.logging.Logger.getLogger(VerGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerGrupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton jbtnBuscador;
    private javax.swing.JTextField jtxtBuscador;
    // End of variables declaration//GEN-END:variables
}

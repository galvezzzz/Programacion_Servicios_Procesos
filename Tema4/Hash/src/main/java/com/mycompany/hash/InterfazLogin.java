/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.hash;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Alberto
 */
public class InterfazLogin extends javax.swing.JFrame {

    /**
     * Creates new form InterfazLogin
     */
    public InterfazLogin() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textboxCorreo = new javax.swing.JTextField();
        textBoxContrasenya = new javax.swing.JTextField();
        botonRegistrar = new javax.swing.JButton();
        lblAvisoRegistro = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textboxCorreo2 = new javax.swing.JTextField();
        textBoxContrasenya2 = new javax.swing.JTextField();
        botonInicio = new javax.swing.JButton();
        lblAvisoRegistro2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Regístrate");

        jLabel2.setText("Usuario");

        jLabel3.setText("Contraseña");

        botonRegistrar.setText("Registrarse");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Inicia sesión");

        jLabel5.setText("Usuario");

        jLabel6.setText("Contraseña");

        botonInicio.setText("Iniciar sesión");
        botonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(411, 411, 411)
                        .addComponent(lblAvisoRegistro2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonInicio)
                                .addGap(490, 490, 490))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textboxCorreo2)
                                    .addComponent(textBoxContrasenya2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(botonRegistrar)
                                    .addGap(501, 501, 501))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(textboxCorreo)
                                        .addComponent(textBoxContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAvisoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(lblAvisoRegistro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textboxCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textBoxContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addComponent(botonRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textboxCorreo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textBoxContrasenya2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addComponent(botonInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(lblAvisoRegistro2)
                .addGap(93, 93, 93))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static void mostrarResumenHexadecimal(byte[] resumen) {
        String resumenHexadecimal = String.format("%064x", new BigInteger(1, resumen));
        System.out.println(resumenHexadecimal);
    }

    private static final String ENCODING_TYPE = "UTF-8";

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        // TODO add your handling code here:
        String identificador = textboxCorreo.getText();
        String password = textBoxContrasenya.getText();

        if (textboxCorreo.getText().equals("")) {
            lblAvisoRegistro.setText("Campo usuario vacío");
            lblAvisoRegistro.setForeground(Color.red);

        } else if (textBoxContrasenya.getText().equals("")) {
            lblAvisoRegistro.setText("Campo contraseña vacío");
            lblAvisoRegistro.setForeground(Color.red);
            
        } else {
            try {
                byte[] resumen = Hash.getDigest(password.getBytes(ENCODING_TYPE));
                Files.write(new File(identificador + ".credencial").toPath(), resumen);
                mostrarResumenHexadecimal(resumen);
                lblAvisoRegistro.setForeground(Color.black);
                lblAvisoRegistro.setText("¡Usuario registrado con éxito!");
                System.out.println("Usuario registrado");
            } catch (Exception e) {
                e.printStackTrace();
            }

            textboxCorreo.setText("");
            textBoxContrasenya.setText("");
        }


    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void botonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInicioActionPerformed
        // TODO add your handling code here:
        String identificador = textboxCorreo2.getText();
        String password = textBoxContrasenya2.getText();

        if (textboxCorreo2.getText().equals("")) {
            lblAvisoRegistro2.setText("Campo usuario vacío");
            lblAvisoRegistro2.setForeground(Color.red);

        } else if (textBoxContrasenya2.getText().equals("")) {
            lblAvisoRegistro2.setText("Campo contraseña vacío");
            lblAvisoRegistro2.setForeground(Color.red);

        } else {
            try {
                byte[] resumen = Hash.getDigest(password.getBytes(ENCODING_TYPE));
                // No se controla que el fichero no exista
                byte[] resumenAlmacenado = Files.readAllBytes(new File(identificador + ".credencial").toPath());

                if (Hash.compararResumenes(resumen, resumenAlmacenado)) {
                    lblAvisoRegistro2.setForeground(Color.black);
                    lblAvisoRegistro2.setText("¡Usuario autorizado!");
                    System.out.println("Autorizado");
                } else {
                    lblAvisoRegistro2.setText("Error de validación");
                    System.out.println("Error en la validación");
                }
                mostrarResumenHexadecimal(resumen);
                mostrarResumenHexadecimal(resumenAlmacenado);

                textboxCorreo2.setText("");
                textBoxContrasenya2.setText("");
            } catch (NoSuchAlgorithmException | IOException e) {
                System.out.println("No puedes validar un usuario que no existe: " + e.getMessage());
                lblAvisoRegistro2.setForeground(Color.red);
                lblAvisoRegistro2.setText("Recuerda registrar un usuario");
            }
        }
    }//GEN-LAST:event_botonInicioActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonInicio;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAvisoRegistro;
    private javax.swing.JLabel lblAvisoRegistro2;
    private javax.swing.JTextField textBoxContrasenya;
    private javax.swing.JTextField textBoxContrasenya2;
    private javax.swing.JTextField textboxCorreo;
    private javax.swing.JTextField textboxCorreo2;
    // End of variables declaration//GEN-END:variables
}

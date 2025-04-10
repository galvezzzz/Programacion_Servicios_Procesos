/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.almacenamientoseguro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import javax.swing.JFileChooser;

/**
 *
 * @author Alberto
 */
public class InterfazAES extends javax.swing.JFrame {

    /**
     * Creates new form InterfazAES
     */
    public InterfazAES() {
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
        txtFichero = new javax.swing.JTextField();
        txtContrasenya = new javax.swing.JTextField();
        btnCifrar = new javax.swing.JButton();
        btnDescifrar = new javax.swing.JButton();
        lblEventos = new javax.swing.JLabel();
        btnFichero = new javax.swing.JButton();
        lblFichero = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("AES");

        jLabel2.setText("Contraseña");

        jLabel3.setText("Nombre fichero");

        btnCifrar.setText("Cifrar");
        btnCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCifrarActionPerformed(evt);
            }
        });

        btnDescifrar.setText("Descifrar");
        btnDescifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescifrarActionPerformed(evt);
            }
        });

        lblEventos.setBackground(new java.awt.Color(102, 102, 102));
        lblEventos.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N

        btnFichero.setText("Fichero");
        btnFichero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFicheroActionPerformed(evt);
            }
        });

        lblFichero.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFichero)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(btnCifrar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDescifrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFichero, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtFichero, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                                        .addComponent(txtContrasenya))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(73, 73, 73)
                        .addComponent(lblEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblEventos))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFichero)
                    .addComponent(lblFichero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFichero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCifrar)
                    .addComponent(btnDescifrar))
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCifrarActionPerformed
        // TODO add your handling code here:

        final int LONGITUD_BLOQUE = 16; // Expresado en bytes
        final String NOMBRE_FICHERO = txtFichero.getText() + ".txt";
        final String PASSWORD = txtContrasenya.getText();
        final String TEXTO_EN_CLARO = "No tienes enemigos";

        if (txtContrasenya.getText().length() < 16) {
            lblEventos.setText("La contraseña debe tener al menos 16 caracteres.");
        }

        if (!txtFichero.getText().equals("")) {
            try {
                Key clave = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD_BLOQUE);
                String textoEnClaro = TEXTO_EN_CLARO;
                String textoCifrado = AESSimpleManager.cifrar(textoEnClaro, clave);

                PrintWriter pw = new PrintWriter(NOMBRE_FICHERO);
                pw.write(textoCifrado);
                pw.close();
                System.out.println("El mensaje se ha cifrado correctamente");
                lblEventos.setText("Fichero cifrado");

                txtFichero.setText("");
                txtContrasenya.setText("");

            } catch (Exception e) {
                System.out.println("Error cifrando el fichero: " + e.getMessage());
            }
        } else {
            lblEventos.setText("El nombre del fichero es demasiado corto.");
        }

    }//GEN-LAST:event_btnCifrarActionPerformed

    private void btnDescifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescifrarActionPerformed
        // TODO add your handling code here:

        final int LONGITUD_BLOQUE = 16; // Expresado en bytes
        final String NOMBRE_FICHERO = txtFichero.getText() + ".txt";
        final String PASSWORD = txtContrasenya.getText();

        if (txtContrasenya.getText().length() < 16) {
            lblEventos.setText("La contraseña debe tener al menos 16 caracteres.");
        }

        if (!txtFichero.getText().equals("")) {
            try {
                File file = new File(NOMBRE_FICHERO);
                Key clave = AESSimpleManager.obtenerClave(PASSWORD, LONGITUD_BLOQUE);
                BufferedReader br = new BufferedReader(new FileReader(file));
                String textoCifrado = br.readLine();
                String textoEnClaro = AESSimpleManager.descifrar(textoCifrado, clave);
                br.close();
                System.out.println("El texto descifrado es: " + textoEnClaro);

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_FICHERO))) {
                    writer.write(textoEnClaro);
                    System.out.println("Archivo escrito correctamente.");
                } catch (IOException e) {
                    System.err.println("Error al escribir en el archivo: " + e.getMessage());
                }

                lblEventos.setText("Fichero descifrado");

                txtFichero.setText("");
                txtContrasenya.setText("");
            } catch (Exception e) {
                System.out.println("Error descifrando el fichero: " + e.getMessage());
            }
        } else {
            lblEventos.setText("El nombre del fichero es demasiado corto.");
        }

    }//GEN-LAST:event_btnDescifrarActionPerformed

    private void btnFicheroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFicheroActionPerformed
        // TODO add your handling code here:
        JFileChooser jf = new JFileChooser();
        jf.setCurrentDirectory(new File(System.getProperty("user.dir")));
        jf.showSaveDialog(null);
        FileReader fr;
        String cadena = "";

        try {
            System.out.println(jf.getSelectedFile().getAbsolutePath());
            fr = new FileReader(jf.getSelectedFile().getAbsolutePath());
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();

            while (linea != null) {
                cadena += linea + "\n";
                lblFichero.setText(cadena);
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnFicheroActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazAES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazAES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazAES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazAES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazAES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCifrar;
    private javax.swing.JButton btnDescifrar;
    private javax.swing.JButton btnFichero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblEventos;
    private javax.swing.JLabel lblFichero;
    private javax.swing.JTextField txtContrasenya;
    private javax.swing.JTextField txtFichero;
    // End of variables declaration//GEN-END:variables
}

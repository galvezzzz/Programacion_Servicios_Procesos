
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto
 */
public class ChatServer extends javax.swing.JFrame {

    ServerSocket ServerSocket;
    Socket miSocket;
    OutputStream os;
    InputStream is;
    DataInputStream dis;
    DataOutputStream dos;

    public ChatServer() {
        try {

            this.ServerSocket = new ServerSocket(49171);
            this.miSocket = ServerSocket.accept();
            this.is = miSocket.getInputStream();
            this.os = miSocket.getOutputStream();
            this.dis = new DataInputStream(is);
            this.dos = new DataOutputStream(os);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        initComponents();

        Thread listenerThread = new Thread(() -> {
            String mensaje;
            while (true) {
                try {
                    mensaje = dis.readUTF();
                    textArea.append("Cliente: " + mensaje + "\n");

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
            }
        });
        listenerThread.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        textBox = new javax.swing.JTextField();
        labelCliente = new javax.swing.JLabel();
        button_Enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        labelCliente.setFont(new java.awt.Font("Sitka Display", 0, 24)); // NOI18N
        labelCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCliente.setText("SERVER");

        button_Enviar.setFont(new java.awt.Font("Sitka Display", 0, 14)); // NOI18N
        button_Enviar.setText("Enviar");
        button_Enviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_EnviarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textBox, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_Enviar, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                    .addComponent(labelCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textBox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_Enviar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Evento click
    private void button_EnviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_EnviarMouseClicked

        try {

            dos.writeUTF(textBox.getText());
            textArea.append("Server: " + textBox.getText() + "\n");
            textBox.setText("");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_button_EnviarMouseClicked

    public static void main(String args[]) {

        // Form
        java.awt.EventQueue.invokeLater(() -> {
            new ChatServer().setVisible(true);
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Enviar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField textBox;
    // End of variables declaration//GEN-END:variables
}

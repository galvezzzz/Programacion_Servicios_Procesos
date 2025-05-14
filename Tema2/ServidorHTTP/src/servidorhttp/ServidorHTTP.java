
package servidorhttp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alberto
 */
public class ServidorHTTP {

    private static final int PUERTO = 8080; 

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor HTTP en puerto: " + PUERTO);

            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Nueva conexión aceptada: " + cliente.getInetAddress());
                new ClienteHTTP(cliente).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

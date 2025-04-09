/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidorhttp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alberto
 */
public class ServidorHTTP {

    private static final int PUERTO = 8080; // Puerto donde escucha el servidor

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor HTTP en ejecución en el puerto " + PUERTO);

            while (true) {
                Socket cliente = serverSocket.accept();
                System.out.println("Nueva conexión aceptada: " + cliente.getInetAddress());

                // Crear un nuevo hilo para manejar la petición
                new ClienteHTTP(cliente).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

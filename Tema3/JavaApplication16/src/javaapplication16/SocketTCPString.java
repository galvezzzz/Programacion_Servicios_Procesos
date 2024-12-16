/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication16;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketTCPString {
    public static void main(String[] args) {
        String servidor = "localhost"; // Dirección del servidor
        int puerto = 12345;            // Puerto del servidor
        String mensaje = "Hola desde el cliente!";

        try (Socket socket = new Socket(servidor, puerto)) {
            // Obtiene el flujo de salida del socket
            OutputStream outputStream = socket.getOutputStream();

            // Convierte el string en bytes y lo envía al servidor
            outputStream.write(mensaje.getBytes("UTF-8"));
            outputStream.flush(); // Asegura que se envíen todos los datos

            System.out.println("Mensaje enviado al servidor.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

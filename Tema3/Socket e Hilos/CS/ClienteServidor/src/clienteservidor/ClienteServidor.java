package clienteservidor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Alberto
 */
public class ClienteServidor {
    
    // SERVIDOR
    public static void main(String[] args) {
        int puerto = 12345; 
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor esperando conexiones en el puerto " + puerto);

            while (true) {
                try (Socket socketCliente = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                     PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true)) {

                    System.out.println("Cliente conectado");

                    // Leer el nombre y la ruta del archivo enviados por el cliente
                    String rutaFichero = in.readLine();
                    System.out.println("Ruta solicitada: " + rutaFichero);

                    // Leer el contenido del archivo
                    File file = new File(rutaFichero);
                    if (file.exists() && file.isFile()) {
                        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = fileReader.readLine()) != null) {
                                out.println(line); // Enviar línea al cliente
                            }
                        }
                        System.out.println("Archivo enviado exitosamente.");
                    } else {
                        out.println("ERROR: El archivo no existe o no es un archivo válido.");
                        System.out.println("Archivo no encontrado o inválido.");
                    }
                } catch (IOException e) {
                    System.err.println("Error al manejar cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }

}

package clienteservidor2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Alberto
 */
public class ClienteServidor2 {

    // CLIENTE
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = "localhost"; 
        int puerto = 12345; 
        

        try (Socket socket = new Socket(ip, puerto); 
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Conectado al servidor en " + ip + ":" + puerto);

            // Solicitar al usuario el nombre y la ruta del archivo
            System.out.print("Introduce la ruta completa del archivo a leer: ");
            String rutaFichero = br.readLine();

            // Enviar la ruta al servidor
            out.println(rutaFichero);
            System.out.println("");
            
            // Recibir y mostrar el contenido del archivo
            System.out.println("Archivo recibido:");
            String linea;
            while ((linea = in.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }

}

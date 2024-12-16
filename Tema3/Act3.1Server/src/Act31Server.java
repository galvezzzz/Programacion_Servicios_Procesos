import java.io.InputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Act31Server {
    public static void main(String[] args) {
        int puerto = 12345; // Puerto en el que el servidor escucha

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor esperando conexión...");

            // Espera a que un cliente se conecte
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado.");

            // Obtiene el flujo de entrada del socket
            InputStream inputStream = socket.getInputStream();

            // Lee los datos enviados por el cliente
            byte[] buffer = new byte[1024]; // Tamaño del búfer
            int bytesRead = inputStream.read(buffer);

            // Convierte los bytes leídos a un string
            String mensaje = new String(buffer, 0, bytesRead, "UTF-8");
            System.out.println("Mensaje recibido del cliente: " + mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

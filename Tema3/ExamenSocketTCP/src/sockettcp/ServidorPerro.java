package sockettcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorPerro {

    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream is;
    private OutputStream os;
    private int serverPort;
    private String serverIP;

    public ServidorPerro(int puerto, String servidor) {

    }

    private static Perro[] listaPerros = {
        new Perro("Balto", 98),
        new Perro("Chonino", 40),
        new Perro("Laika", 66),
        new Perro("Stubby", 50),
        new Perro("Smoky", 51),
        new Perro("Barry", 223),
        new Perro("Old Drum", 154)
    };

    public void start(int puerto) throws IOException {
        System.out.println("(ServidorPerro) Esperando conexión con cliente perro...");
        Socket socket = new Socket();

    }

    public static void main(String[] args) {
        ServidorPerro servidor = new ServidorPerro(50001, "localhost");

        try {
            servidor.start(50001);
            
            //System.out.println("Mensaje del cliente perro: " + servidor.is.read());
            
            
        } catch(IOException e){
            
        }
    }

}

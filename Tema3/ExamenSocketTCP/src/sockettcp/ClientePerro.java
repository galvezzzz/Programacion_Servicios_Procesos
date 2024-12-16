package sockettcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientePerro {

    private String serverIP;
    private int serverPort;
    private Socket socket;
    private InputStream is;
    private OutputStream os;

    public ClientePerro(String localhost, int par) {

    }

    public void start(int puerto) throws IOException {

        System.out.println("(ClientePerro) Estableciento conexión con servidor perro...");
        Socket socket = new Socket(serverIP, serverPort);
        os = socket.getOutputStream();
        is = socket.getInputStream();
        System.out.println("(ClientePerro) Conexión establecida.");
    }

    public void accept() {

    }

    public void get() {

    }

    public static void main(String[] artgs) {
        ClientePerro cliente = new ClientePerro("localhost", 50001);
        Scanner sc = new Scanner(System.in);
        String mensajeCliente;

        try {
            cliente.start(50001);

            System.out.print("(ClientePerro) Introduce tu mensaje: ");
            mensajeCliente = sc.next();

            while (!mensajeCliente.equals("Dame Perro") || !mensajeCliente.equals("dame perro")) {
                System.out.print("(ClientePerro) Introduce tu mensaje: ");
                mensajeCliente = sc.next();
            }
            
            

        } catch (IOException e) {
        }
    }

}

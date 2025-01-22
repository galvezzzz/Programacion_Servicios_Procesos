import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClient {

    private String ip;
    private int puerto;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public TCPClient(int puerto, String ip) throws IOException {
        this.ip = ip;
        this.puerto = puerto;
    }

    public void start() throws IOException {
        Socket socket = new Socket(ip, puerto);
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        System.out.println("(Cliente) Conexion abierta.");
    }

    public void stop() throws IOException {
        socket.close();
        inputStream.close();
        outputStream.close();
        System.out.println("(Cliente) Conexion cerrada.");
    }

    public void abrirCanalesTexto() throws IOException {
        dataInputStream = new DataInputStream(inputStream);
        dataOutputStream = new DataOutputStream(outputStream);
        System.out.println("(Cliente) Canales de texto abiertos.");
    }

    public void cerrarCanalesTexto() throws IOException {
        dataInputStream.close();
        dataOutputStream.close();
        System.out.println("(Cliente) Canales de texto cerrados.");
    }

    public void enviarMensaje(String mensaje) throws IOException {
        dataOutputStream.writeUTF(mensaje);
        System.out.println("(Cliente) Mensaje enviado.");

    }

    public String recibirMensaje() throws IOException {
        System.out.println("(Cliente) Mensaje recibido.");
        return dataInputStream.readUTF();

    }
}

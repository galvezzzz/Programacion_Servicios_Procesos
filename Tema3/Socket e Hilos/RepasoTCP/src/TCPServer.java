import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private ServerSocket serverSocket;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    public TCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException {
        socket = serverSocket.accept();
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        System.out.println("(Servidor) Conexion abierta.");
    }

    public void stop() throws IOException {
        socket.close();
        serverSocket.close();
        inputStream.close();
        outputStream.close();
        System.out.println("(Servidor) Conexion cerrada.");
    }

    public void abrirCanalesTexto() throws IOException {
        dataInputStream = new DataInputStream(inputStream);
        dataOutputStream = new DataOutputStream(outputStream);
        System.out.println("(Servidor) Canales de texto abiertos.");
    }

    public void cerrarCanalesTexto() throws IOException {
        dataInputStream.close();
        dataOutputStream.close();
        System.out.println("(Servidor) Canales de texto cerrados.");
    }

    public void enviarMensaje(String mensaje) throws IOException {
        dataOutputStream.writeUTF(mensaje);
        System.out.println("(Servidor) Mensaje enviado.");

    }

    public String recibirMensaje() throws IOException {
        System.out.println("(Servidor) Mensaje recibido.");
        return dataInputStream.readUTF();

    }


}

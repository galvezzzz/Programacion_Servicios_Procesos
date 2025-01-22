package sockettcp;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPServer {

    private Socket socket;
    private ServerSocket serverSocket;

    // String
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;

    // Números
    private InputStream inputStream;
    private OutputStream outputStream;

    // Objetos
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public SocketTCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException {
        socket = serverSocket.accept();
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        System.out.println("(Servidor) Conexion establecida.");
    }

    public void stop() throws IOException {
        socket.close();
        serverSocket.close();
        inputStream.close();
        outputStream.close();
        System.out.println("(Servidor) Conexion cerrada.");
    }

    public void abrirCanalesDeTexto() throws IOException {
        dataOutputStream = new DataOutputStream(outputStream);
        dataInputStream = new DataInputStream(inputStream);
        System.out.println("(Servidor) Canales de texto abiertos.");
    }


    // TEXTO

    public void cerrarCanalesDeTexto() throws IOException {
        dataOutputStream.close();
        dataInputStream.close();
        System.out.println("(Servidor) Canales de texto cerrados.");
    }

    public void enviarMensajeTexto(String mensaje) throws IOException {
        dataOutputStream.writeUTF(mensaje);
        System.out.println("(Servidor) Mensaje enviado.");
    }

    public String recibirMensajeTexto() throws IOException {
        String mensajeRecibido = dataInputStream.readUTF();
        System.out.println("(Servidor) Mensaje recibido.");
        return mensajeRecibido;
    }


    // OBJETO

    public void abrirCanalesDeObjeto() throws IOException {
        objectOutputStream = new ObjectOutputStream(outputStream);
        objectInputStream = new ObjectInputStream(inputStream);
        System.out.println("(Servidor) Canales de objeto abiertos.");
    }

    public void cerrarCanalesDeObjeto() throws IOException {
        objectOutputStream.close();
        objectInputStream.close();
        System.out.println("(Servidor) Canales de objeto cerrados.");
    }

    public void enviarMensajeObjeto(String mensaje) throws IOException {
        objectOutputStream.writeObject(mensaje);
        System.out.println("(Servidor) Mensaje enviado.");
    }

    public Object recibirMensajeObjeto() throws IOException {
        String objetoRecibido = objectInputStream.readUTF();
        System.out.println("(Servidor) Objeto recibido.");
        return objetoRecibido;
    }

}

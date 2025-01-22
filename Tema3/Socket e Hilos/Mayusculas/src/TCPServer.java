import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    ServerSocket serverSocket;
    Socket socket;
    InputStream in;
    OutputStream out;
    DataInputStream din;
    DataOutputStream dout;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;

    public TCPServer(int puerto) throws IOException {
        serverSocket = new ServerSocket(puerto);
    }

    public void start() throws IOException {
        socket = serverSocket.accept();
        in = socket.getInputStream();
        out = socket.getOutputStream();
        System.out.println("(Servidor) Conexiones abiertas.");
    }

    public void stop() throws IOException {
        socket.close();
        serverSocket.close();
        in.close();
        out.close();
        System.out.println("(Servidor) Conexiones cerradas.");
    }

    public void abrirCanalesTexto() throws IOException {
        din = new DataInputStream(socket.getInputStream());
        dout = new DataOutputStream(socket.getOutputStream());
        System.out.println("(Servidor) Canales de texto abiertos.");
    }

    public void cerrarCanalesTexto() throws IOException {
        dout.close();
        din.close();
        System.out.println("(Servidor) Canales de texto cerrados.)");
    }

    public void abrirObjetos() throws IOException {
        objectOutputStream = new ObjectOutputStream(out);
        objectInputStream = new ObjectInputStream(in);
        System.out.println("(Cliente) Objeto abierto.");
    }

    public void cerrarObjetos() throws IOException {
        objectInputStream.close();
        objectOutputStream.close();
        System.out.println("(Cliente) Objeto cerrado.)");
    }

    public void enviarObjeto(Object object) throws IOException {
        objectOutputStream.writeObject(object);
        System.out.println("(Cliente) Objeto enviado.");

    }

    public Object recibirObjeto() throws IOException, ClassNotFoundException {
        System.out.println("(Cliente) Objeto recibido.");
        Object object = objectInputStream.readObject();
        return object;
    }

    public void enviarMensaje(String mensaje) throws IOException {
        dout.writeUTF(mensaje);
        System.out.println("(Servidor) Mensaje enviado.");
    }

    public String recibirMensaje() throws IOException {
        System.out.println("(Servidor) Mensaje recibido.");
        return din.readUTF();
    }
}

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPClient {

    int puerto;
    String ip;
    Socket socket;
    InputStream in;
    OutputStream out;
    DataInputStream din;
    DataOutputStream dout;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;

    public TCPClient(String ip, int puerto) throws IOException {
        this.ip = ip;
        this.puerto = puerto;
    }

    public void start() throws IOException {
        socket = new Socket(ip, puerto);
        in = socket.getInputStream();
        out = socket.getOutputStream();
        System.out.println("(Cliente) Conexiones abiertas.");
    }

    public void stop() throws IOException {
        socket.close();
        in.close();
        out.close();
        System.out.println("(Cliente) Conexiones cerradas.");
    }

    public void abrirCanalesTexto() throws IOException {
        din = new DataInputStream(socket.getInputStream());
        dout = new DataOutputStream(socket.getOutputStream());
        System.out.println("(Cliente) Canales de texto abiertos.");
    }

    public void cerrarCanalesTexto() throws IOException {
        dout.close();
        din.close();
        System.out.println("(Cliente) Canales de texto cerrados.)");
    }

    public void abrirObjetos() throws IOException {
        objectInputStream = new ObjectInputStream(in);
        objectOutputStream = new ObjectOutputStream(out);
        System.out.println("(Cliente) Objeto abierto.");
    }

    public void cerrarObjetos() throws IOException {
        objectInputStream.close();
        objectOutputStream.close();
        System.out.println("(Cliente) Objeto cerrado.)");
    }

    public void enviarMensaje(String mensaje) throws IOException {
        dout.writeUTF(mensaje);
        System.out.println("(Cliente) Mensaje enviado.");
    }

    public String recibirMensaje() throws IOException {
        System.out.println("(Cliente) Mensaje recibido.");
        return din.readUTF();
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
}

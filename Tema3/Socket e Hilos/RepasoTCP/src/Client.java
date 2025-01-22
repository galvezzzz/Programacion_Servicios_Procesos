import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        TCPClient cliente = new TCPClient(1000, "localhost");
        cliente.start();
        cliente.abrirCanalesTexto();
        cliente.recibirMensaje();
        cliente.enviarMensaje("C:\\Users\\Alberto\\Desktop\\fichero.txt");
        System.out.println(cliente.recibirMensaje());
    }
}

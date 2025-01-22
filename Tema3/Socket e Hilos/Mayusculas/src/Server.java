import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        TCPServer server = new TCPServer(4000);
        Perro perro = new Perro("Miguel", 2);


            server.start();

            server.start();
            server.abrirCanalesTexto();

            String mensaje = server.recibirMensaje();
            System.out.println(mensaje);
            server.enviarMensaje(mensaje.toUpperCase());
            server.stop();




/*
        server.abrirObjetos();
        server.enviarObjeto(perro);
        server.cerrarObjetos();
*/
    }
}
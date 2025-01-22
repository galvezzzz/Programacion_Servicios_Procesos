import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TCPClient client = new TCPClient("localhost", 4000);


            client.start();
            client.abrirCanalesTexto();
            client.enviarMensaje("Qué pasó jefe");

            System.out.println("Mensaje recibido: " + client.recibirMensaje());
            client.stop();



 /*
        client.abrirObjetos();
        Perro perro = (Perro) client.recibirObjeto();
        System.out.println(perro);
        client.cerrarObjetos();

  */

    }
}

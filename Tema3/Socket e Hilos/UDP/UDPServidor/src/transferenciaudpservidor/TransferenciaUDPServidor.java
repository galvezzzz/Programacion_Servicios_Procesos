package transferenciaudpservidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TransferenciaUDPServidor {
    /**
     *
     * @autor Alberto
     */
    public static void main(String[] args) {

        DatagramSocket socket;

        try {
            System.out.println("Servidor: Creando socket...");
            socket = new DatagramSocket(33333);

            System.out.println("Servidor: Recibiendo datagrama...");
            byte[] bufferLectura = new byte[64];
            String cdn = "";

            DatagramPacket datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
            socket.receive(datagramaEntrada);
            System.out.println("Servidor: Mensaje recibido: " + new String(bufferLectura));

            while (!"FIN".equals(cdn)) {
                datagramaEntrada = new DatagramPacket(bufferLectura, bufferLectura.length);
                socket.receive(datagramaEntrada);
                cdn = new String(datagramaEntrada.getData(), 0, datagramaEntrada.getLength());
                System.out.println("(Servidor) Mensaje recibido: " + cdn);
            }

            System.out.println("Servidor: Cerrado sockets...");
            socket.close();
            System.out.println("Servidor: Socket cerrado.");

        } catch (SocketException e) {
        } catch (IOException e) {
        }
    }

}

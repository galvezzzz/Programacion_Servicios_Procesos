import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        TCPServer server = new TCPServer(1000);
        server.start();
        server.abrirCanalesTexto();
        server.enviarMensaje("Introduce el nombre de un fichero");

        try (FileReader fr = new FileReader(server.recibirMensaje())) {
            BufferedReader br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                server.enviarMensaje(linea);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
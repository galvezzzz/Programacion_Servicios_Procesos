package servidorhttp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;

/**
 *
 * @author Alberto
 */
public class ClienteHTTP extends Thread {

    private Socket cliente;
    private static final String DIRECTORIO_RAIZ = "webs"; // Carpeta donde están los archivos

    public ClienteHTTP(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try (
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream())); OutputStream salida = cliente.getOutputStream()) {
            String linea = entrada.readLine();
            if (linea == null) {
                return;
            }

            System.out.println("Petición recibida: " + linea);
            String[] partes = linea.split(" ");
            if (partes.length < 2) {
                return;
            }

            String metodo = partes[0];
            String recurso = partes[1];

            if (recurso.equals("/")) {
                recurso = "/index.html"; // Página por defecto
            }
            File archivo = new File(DIRECTORIO_RAIZ + recurso);

            if (metodo.equals("GET")) {
                if (archivo.exists() && !archivo.isDirectory()) {
                    byte[] contenido = Files.readAllBytes(archivo.toPath());
                    enviarRespuesta(salida, "200 OK", "text/html", contenido);
                } else {
                    enviarError(salida, "404 Not Found", "Archivo no encontrado");
                }
            } else if (metodo.equals("POST")) {
                // Procesar datos enviados en el cuerpo de la petición
                StringBuilder cuerpo = new StringBuilder();
                while (entrada.ready()) {
                    cuerpo.append((char) entrada.read());
                }
                System.out.println("Datos POST recibidos: " + cuerpo.toString());
                String respuesta = "<html><body><h1>Datos Recibidos</h1><p>" + cuerpo.toString() + "</p></body></html>";
                enviarRespuesta(salida, "200 OK", "text/html", respuesta.getBytes());
            } else {
                enviarError(salida, "405 Method Not Allowed", "Método no permitido");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void enviarRespuesta(OutputStream salida, String codigo, String tipo, byte[] contenido) throws IOException {
        salida.write(("HTTP/1.1 " + codigo + "\r\n").getBytes());
        salida.write(("Content-Type: " + tipo + "\r\n").getBytes());
        salida.write(("Content-Length: " + contenido.length + "\r\n").getBytes());
        salida.write("\r\n".getBytes());
        salida.write(contenido);
        salida.flush();
    }

    private void enviarError(OutputStream salida, String codigo, String mensaje) throws IOException {
        String respuesta = "<html><body><h1>" + codigo + "</h1><p>" + mensaje + "</p></body></html>";
        enviarRespuesta(salida, codigo, "text/html", respuesta.getBytes());
    }
}

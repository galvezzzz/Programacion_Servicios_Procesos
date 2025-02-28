import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {

        String esquema = "https://";
        String servidor = "www.thesportsdb.com/api/v1/json/3/searchteams.php?t=";
        String recurso = new String("Chelsea").toLowerCase();

        Main gestor = new Main();

        try {
            int codigoEstado = gestor.almacenarPagina(esquema, servidor, recurso, "resultado.html");

            if (codigoEstado == HttpURLConnection.HTTP_OK) {
                System.out.println("Descarga finalizada");
            } else {
                System.err.println("Error " + codigoEstado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int almacenarPagina(String esquema, String servidor, String recurso, String path) throws Exception {

        recurso = URLEncoder.encode(recurso, StandardCharsets.UTF_8);
        String direccion = esquema + servidor + recurso;

        HttpClient httpCliente = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(direccion))
                .headers("Content-Type","text-plain")
                .setHeader("User-Agent","Mozilla/5.0")
                .build();

        HttpResponse<Path> response = httpCliente.send(request,
                HttpResponse.BodyHandlers.ofFile(Path.of(path)));

        return response.statusCode();
    }

}
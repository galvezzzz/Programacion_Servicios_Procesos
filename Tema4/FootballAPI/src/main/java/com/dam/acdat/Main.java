package com.dam.acdat;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        String apiUrl = "https://www.thesportsdb.com/api/v1/json/3/searchteams.php?t=Chelsea";
        try {
            // Realizar la solicitud HTTP
            String jsonResponse = fetchJsonResponse(apiUrl);

            // Usar Gson para deserializar la respuesta JSON
            Gson gson = new Gson();
            RespuestaAPI response = gson.fromJson(jsonResponse, RespuestaAPI.class);

            // Imprimir información de los equipos
            if (response.getTeams() != null) {
                for (Team team : response.getTeams()) {
                    System.out.println("Nombre del equipo: " + team.getStrTeam());
                    System.out.println("Estadio: " + team.getStrStadium());
                    System.out.println("Descripcion: " + team.getStrDescriptionEN());
                }
            } else {
                System.out.println("No se ha encontrado ningun equipo.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String fetchJsonResponse(String apiUrl) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaexamen;

import com.google.gson.Gson;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Alberto
 */
public class GestorAPI {

    private final String API_URL = "https://rickandmortyapi.com/api/character/";
    private int idPersonaje;

    public GestorAPI(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String llamarAPI() throws MalformedURLException, IOException {

        String url = API_URL + idPersonaje;
        URL urlAPI = new URL(url);

        HttpURLConnection conexion = (HttpURLConnection) urlAPI.openConnection();
        conexion.setRequestMethod("GET");

        if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            return response.toString();
        } else {
            return null;
        }
    }

    public int ObtenerId(String api) {
        if (api != null) {
            Gson gson = new Gson();
            Personaje personaje = gson.fromJson(api, Personaje.class);
            return personaje.getId();

        } else {
            return 0;
        }

    }

    public String ObtenerName(String api) {
        if (api != null) {
            Gson gson = new Gson();
            Personaje personaje = gson.fromJson(api, Personaje.class);
            return personaje.getName();

        } else {
            return "";
        }

    }

    public String ObtenerStatus(String api) {
        if (api != null) {
            Gson gson = new Gson();
            Personaje personaje = gson.fromJson(api, Personaje.class);
            return personaje.getStatus();

        } else {
            return "";
        }

    }

    public String ObtenerSpecies(String api) {
        if (api != null) {
            Gson gson = new Gson();
            Personaje personaje = gson.fromJson(api, Personaje.class);
            return personaje.getSpecies();

        } else {
            return "";
        }

    }

    public String ObtenerType(String api) {
        if (api != null) {
            Gson gson = new Gson();
            Personaje personaje = gson.fromJson(api, Personaje.class);
            return personaje.getType();

        } else {
            return "";
        }

    }

    public String ObtenerGender(String api) {
        if (api != null) {
            Gson gson = new Gson();
            Personaje personaje = gson.fromJson(api, Personaje.class);
            return personaje.getGender();

        } else {
            return "";
        }
    }

    public String ObtenerImage(String api) {
        if (api != null) {
            Gson gson = new Gson();
            Personaje personaje = gson.fromJson(api, Personaje.class);
            return personaje.getImage();
        } else {
            return "";
        }
    }

    public void DescargarImagen(String image) throws MalformedURLException, IOException {
        URL urlImage = new URL(image);
        HttpURLConnection conexion = (HttpURLConnection) urlImage.openConnection();

        InputStream inputStream = new BufferedInputStream(conexion.getInputStream());
        FileOutputStream outputStream = new FileOutputStream("Personaje.jpg");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
    }

}

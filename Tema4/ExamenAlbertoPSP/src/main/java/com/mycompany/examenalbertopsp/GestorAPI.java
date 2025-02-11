/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenalbertopsp;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Alberto
 */
public class GestorAPI {

    private final String API_URL = "https://fakestoreapi.com/products/";
    private int id;

    public GestorAPI(int id) {
        this.id = id;
    }

    public String LlamarAPI() throws MalformedURLException, IOException {
        String url = API_URL + id;
        URL urlApi = new URL(url);

        HttpURLConnection conexion = (HttpURLConnection) urlApi.openConnection();
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

    public int GetIdApi(String api) {

        Gson gson = new Gson();
        Producto producto = gson.fromJson(api, Producto.class);
        return producto.getId();

    }

    public String GetTitleApi(String api) {

        Gson gson = new Gson();
        Producto producto = gson.fromJson(api, Producto.class);
        return producto.getTitle();
    }

    public double GetPriceApi(String api) {

        Gson gson = new Gson();
        Producto producto = gson.fromJson(api, Producto.class);
        return producto.getPrice();
    }

    public String GetDescriptionApi(String api) {

        Gson gson = new Gson();
        Producto producto = gson.fromJson(api, Producto.class);
        return producto.getDescription();
    }

    public String GetCategoryApi(String api) {

        Gson gson = new Gson();
        Producto producto = gson.fromJson(api, Producto.class);
        return producto.getCategory();
    }

    public String GetImageApi(String api) {

        Gson gson = new Gson();
        Producto producto = gson.fromJson(api, Producto.class);
        return producto.getImage();
    }

}

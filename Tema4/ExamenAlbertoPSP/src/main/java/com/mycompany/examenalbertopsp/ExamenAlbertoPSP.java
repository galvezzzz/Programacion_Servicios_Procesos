/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.examenalbertopsp;

import jakarta.mail.MessagingException;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Alberto
 */
public class ExamenAlbertoPSP {

    public static void DescargarImagen(String api) throws MalformedURLException, IOException {
        URL url = new URL(api);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

        InputStream inputStream = new BufferedInputStream(conexion.getInputStream());
        FileOutputStream outputStream = new FileOutputStream("Producto.jpg");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
    }

    public static void main(String[] args) throws IOException, MessagingException {

        GestorAPI gestor = new GestorAPI(7);
        GestorCorreo gestorCorreo = new GestorCorreo();
        String llamadaAPI = gestor.LlamarAPI();
        String cadena = "";

        cadena += "ID: " + gestor.GetIdApi(llamadaAPI) + "\n";
        cadena += "Title: " + gestor.GetTitleApi(llamadaAPI) + "\n";
        cadena += "Price: " + gestor.GetPriceApi(llamadaAPI) + "\n";
        cadena += "Description: " + gestor.GetDescriptionApi(llamadaAPI) + "\n";
        cadena += "Category: " + gestor.GetCategoryApi(llamadaAPI) + "\n";
        cadena += "Image: " + gestor.GetImageApi(llamadaAPI) + "\n";

        DescargarImagen(gestor.GetImageApi(llamadaAPI));

        System.out.println(cadena);
        
        gestorCorreo.enviarMensajeAdjunto("alberto.galvez@gmx.es", 
                "rvilbri995@g.educaand.es", 
                "Examen T4 " + gestor.GetTitleApi(llamadaAPI), 
                gestor.GetDescriptionApi(llamadaAPI) + "\n" + gestor.GetCategoryApi(llamadaAPI)+ "\n" + gestor.GetPriceApi(llamadaAPI), 
                "Producto.jpg", 
                "PSPIESBelen");
    }
}

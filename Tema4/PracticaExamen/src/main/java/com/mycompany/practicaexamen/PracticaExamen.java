package com.mycompany.practicaexamen;

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
public class PracticaExamen {

    public static void main(String[] args) throws IOException, MessagingException {

        GestorAPI gestor = new GestorAPI(2);
        String llamadaAPI = gestor.llamarAPI();
        String cadenon = "";

        cadenon += "ID: " + gestor.ObtenerId(llamadaAPI) + "\n";
        cadenon += "Name: " + gestor.ObtenerName(llamadaAPI) + "\n";
        cadenon += "Status: " + gestor.ObtenerStatus(llamadaAPI) + "\n";
        cadenon += "Species: " + gestor.ObtenerSpecies(llamadaAPI) + "\n";
        cadenon += "Type: " + gestor.ObtenerType(llamadaAPI) + "\n";
        cadenon += "Gender: " + gestor.ObtenerGender(llamadaAPI) + "\n";
        cadenon += "Image: " + gestor.ObtenerImage(llamadaAPI) + "\n";
        
        gestor.DescargarImagen(gestor.ObtenerImage(llamadaAPI));

        System.out.println(cadenon);
        
        GestorCorreo gestorCorreo = new GestorCorreo();
        gestorCorreo.EnviarMensajeAdjunto("alberto.galvez@gmx.es", "alberto.galvez@gmx.es", "Prueba", "Texto vacilon suprimo", "Personaje.jpg", "PSPIESBelen");

    }
}

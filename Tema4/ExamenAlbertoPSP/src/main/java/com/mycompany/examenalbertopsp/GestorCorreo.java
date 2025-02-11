/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenalbertopsp;

import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Alberto
 */
public class GestorCorreo {
    
    Properties propiedades;
    Session sesion;
    
    public void propiedadesServidorSMTP(){
        propiedades = System.getProperties();
        propiedades.put("mail.smtp.auth", true);
        propiedades.put("mail.smtp.host", "mail.gmx.es");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.starttls.enable", true);
        sesion = Session.getInstance(propiedades, null);
    }
    
    public Transport conexionServidorSMTP(String direccionEmail, String contrasenya) throws MessagingException{
        Transport t = (Transport) sesion.getTransport("smtp");
        t.connect(propiedades.getProperty("mail.smtp.host"), direccionEmail, contrasenya);
        return t;
    }
    
    public Message crearNucleoMensaje(String emisor, String destinatario, String asunto) throws AddressException, MessagingException{
        Message mensaje = new MimeMessage(sesion);
        mensaje.setFrom(new InternetAddress(emisor));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
        mensaje.setSubject(asunto);
        return mensaje;
    }
    
    public Message crearMensajeAdjunto(String emisor, String destinatario, String asunto, String cuerpo, String fichero) throws MessagingException, IOException{
        Message mensaje = crearNucleoMensaje(emisor, destinatario, asunto);
        BodyPart bodyPart = new MimeBodyPart();
        bodyPart.setText(cuerpo);
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.attachFile(new File(fichero));
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);
        multipart.addBodyPart(mimeBodyPart);
        mensaje.setContent(multipart);
        return mensaje;
    }
    
    public void enviarMensajeAdjunto(String emisor, String destinatario, String asunto, String cuerpo, String fichero, String contrasenya) throws MessagingException, IOException{
        propiedadesServidorSMTP();
        Message mensaje = crearMensajeAdjunto(emisor, destinatario, asunto, cuerpo, fichero);
        Transport t = conexionServidorSMTP(emisor, contrasenya);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        t.close();               
    }
}

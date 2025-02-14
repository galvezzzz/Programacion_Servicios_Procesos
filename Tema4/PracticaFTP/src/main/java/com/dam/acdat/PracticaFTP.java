package com.dam.acdat;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTP;


public class PracticaFTP {

    private FTPClient clienteFTP;
    private static final String SERVIDOR = "localhost";
    private static final int PUERTO = 21;
    private static final String USUARIO = "usuario";
    private static final String PASSWORD = "12345678";
    // Configuracion local de FileZilla Server

    public PracticaFTP() {
        clienteFTP = new FTPClient();
    }

    private void conectar() throws SocketException, IOException {
        clienteFTP.connect(SERVIDOR,PUERTO);
        int respuesta = clienteFTP.getReplyCode();
        if (!FTPReply.isPositiveCompletion(respuesta)) {
            clienteFTP.disconnect();
            throw new IOException("Error al conectar con el servidor FTP");
        }

        boolean credencialesOK = clienteFTP.login(USUARIO,PASSWORD);

        if (!credencialesOK) {
            throw new IOException("Error al conectar con el servidor FTP. Credenciales incorrectas");
        }

        clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
    }


    private void desconectar() throws IOException {
        clienteFTP.disconnect();
    }


    private boolean subirFichero(String path) throws IOException {
        File ficheroLocal = new File(path);
        InputStream is = new FileInputStream(ficheroLocal);
        boolean enviado = clienteFTP.storeFile(ficheroLocal.getName(), is);
        is.close();
        return enviado;
    }


    private boolean descargarFichero(String fichero) throws IOException {
        OutputStream os = new BufferedOutputStream(new FileOutputStream(fichero));
        boolean recibido = clienteFTP.retrieveFile(fichero,os);
        os.close();
        return recibido;
    }

    private void descargaCompleta(String fichero) throws IOException {
        FTPFile[] files = clienteFTP.listFiles(fichero);

        for (FTPFile file: files) {
            descargarFichero(file.getName());
            System.out.println(file.getName());
        }
    }


    public static void main(String[] args) {

        PracticaFTP practicaFTP = new PracticaFTP();

        try {
            practicaFTP.conectar();
            System.out.println("Conectado");

            practicaFTP.descargaCompleta("/");

            practicaFTP.desconectar();


        } catch (Exception e) {
            System.err.println("Ha ocurrido un error: " + e.getMessage());
        }
    }

}

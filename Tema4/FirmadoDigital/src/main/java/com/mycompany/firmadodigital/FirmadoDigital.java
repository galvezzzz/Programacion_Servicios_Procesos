/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.firmadodigital;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 * @author Alberto
 */
public class FirmadoDigital {

    private static final String FICHERO_CLAVE_PUBLICA = "clave_publica.key";
    private static final String FICHERO_CLAVE_PRIVADA = "clave_privada.key";

    public static KeyPair generarClaves() throws NoSuchAlgorithmException {

        KeyPairGenerator generador = KeyPairGenerator.getInstance("DSA");
        generador.initialize(512);   // Admite 512, 768 ó 1024
        KeyPair claves = generador.generateKeyPair();

        return claves;
    }

    public static void guardarClaves(KeyPair claves) throws Exception {

        FileOutputStream fos = new FileOutputStream(FICHERO_CLAVE_PUBLICA);
        fos.write(claves.getPublic().getEncoded());
        fos.close();
        fos = new FileOutputStream(FICHERO_CLAVE_PRIVADA);
        fos.write(claves.getPrivate().getEncoded());
        fos.close();
    }

    public static PublicKey getClavePublica(String path) throws Exception {

        File ficheroClavePublica = new File(path);
        byte[] bytesClavePublica = Files.readAllBytes(ficheroClavePublica.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytesClavePublica);
        PublicKey clavePublica = keyFactory.generatePublic(publicKeySpec);

        return clavePublica;
    }

    public static PrivateKey getClavePrivada() throws Exception {

        File ficheroClavePrivada = new File(FICHERO_CLAVE_PRIVADA);
        byte[] bytesClavePrivada = Files.readAllBytes(ficheroClavePrivada.toPath());
        KeyFactory keyFactory = KeyFactory.getInstance("DSA");
        EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytesClavePrivada);
        PrivateKey clavePrivada = keyFactory.generatePrivate(privateKeySpec);

        return clavePrivada;
    }
}

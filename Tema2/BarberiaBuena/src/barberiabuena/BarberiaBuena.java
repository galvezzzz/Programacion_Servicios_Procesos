/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package barberiabuena;

import java.util.Random;

/**
 *
 * @author Alberto
 */
public class BarberiaBuena {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Random generadorAle = new Random();
        final int MAX_BARBEROS = 2;
        final int MAX_SILLAS = 4;
        final int MAX_CLIENTES = 10;
        final int MAX_ESPERA_SEGS = 3;
        Thread[] vhBarberos = new Thread[MAX_BARBEROS];

        GestorSillas gestorSillas = new GestorSillas(MAX_SILLAS);
       
        for (int i = 0; i < MAX_BARBEROS; i++) {
            Barbero b = new Barbero(gestorSillas, "Barbero " + i);
            Thread hilo = new Thread(b);
            vhBarberos[i] = hilo;
            hilo.start();
        }

        // Generamos unos cuantos clientes a intervalos aleatorios
        for (int i = 0; i < MAX_CLIENTES; i++) {
            Cliente c = new Cliente(gestorSillas);
            Thread hiloCliente = new Thread(c);
            hiloCliente.start();

            int msegs = generadorAle.nextInt(MAX_ESPERA_SEGS) * 1000;
            try {
                Thread.sleep(msegs);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        // La jornada ha terminado, "cerramos" los barberos
    }
    
}

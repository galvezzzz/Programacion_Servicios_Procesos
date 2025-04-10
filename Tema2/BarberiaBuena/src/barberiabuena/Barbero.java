/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package barberiabuena;

/**
 *
 * @author Alberto
 */
import java.util.Random;

public class Barbero implements Runnable {

    private String nombre;
    private int segundosMaximoEspera;
    private GestorSillas gestorSillas;
    private static Random generadorAle;

    static {
        generadorAle = new Random();  
    }

    public Barbero(GestorSillas gestorSillas, String nombre) {
        this.gestorSillas = gestorSillas;
        this.nombre = "Barbero " + nombre;
        this.segundosMaximoEspera = 3;

    }

    public static void esperarTiempoAzar(int tiempoMax) {

        // Se calculan unos milisegundos al azar
        int msgs = (1 + generadorAle.nextInt(tiempoMax)) * 1000;

        try {
            Thread.currentThread().sleep(msgs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    
    @Override
    public void run() {
        
        int posSillaClienteSinAtender;
        
        while (true) {
            
            posSillaClienteSinAtender = this.gestorSillas.getSiguienteCliente();
            if (posSillaClienteSinAtender == -1) {
                Barbero.esperarTiempoAzar(this.segundosMaximoEspera);
            } else {
                System.out.println("Barbero atendiendo silla: " + posSillaClienteSinAtender);
                Barbero.esperarTiempoAzar(this.segundosMaximoEspera);
                this.gestorSillas.liberarSilla(posSillaClienteSinAtender);
            }
        }
    }
}
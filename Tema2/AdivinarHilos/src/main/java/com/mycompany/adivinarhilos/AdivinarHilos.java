/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.adivinarhilos;

/**
 *
 * @author Alberto
 */
public class AdivinarHilos {

    public static void main(String[] args) {
        
       int numeroSecreto = (int) (Math.random()*101);
       
        for (int i = 0; i < 10; i++) {
            NumeroOculto hilo = new NumeroOculto(i, numeroSecreto);
            hilo.start();
            
        }
    }
}

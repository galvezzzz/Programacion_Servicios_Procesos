/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.adivinarhilos;

/**
 *
 * @author Alberto
 */
public class NumeroOculto extends Thread{
    
    private final int id;
    private static volatile boolean adivinado = false;
    private static int numeroSecreto;

    public NumeroOculto(int id, int numeroSecreto) {
        this.id = id;
        this.numeroSecreto = numeroSecreto;
    }
    
    
    
    public synchronized int propuestaNumero(){
        if (adivinado) {
            return -1;
        }
        
        int numeroAdivina = (int) (Math.random()*101);
        
        if(numeroAdivina == numeroSecreto){
            System.out.println("El hilo " + id + " ha adivinado el numero " + numeroAdivina );
            this.adivinado = true;
            return 1;
        }else{
            System.out.println("El hilo " + id + " ha intentado adivinar con " + numeroAdivina);
            return 0;
        }
    }

    @Override
    public void run() {
        do{
            int resultado = propuestaNumero();
            if (resultado == -1) {
                System.out.println("Un hilo ya ha adivinado el resultado");
            }
        }while(!adivinado);
    }
}

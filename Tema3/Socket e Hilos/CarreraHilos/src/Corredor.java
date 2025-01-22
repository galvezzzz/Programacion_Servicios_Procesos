public class Corredor implements Runnable {

    String nombre;
    int pausa;
    int cont = 0;
    static boolean hayGanador = false;

    public Corredor(String nombre) {
        this.nombre = nombre;
        pausa = (int) (Math.random() * 3);
    }

    public synchronized void anunciarGanador(String nombre) {
        if (!hayGanador) {
            hayGanador = true;
            System.out.println("Ganador certificado: " + nombre);
        }else{
            System.out.println("Ya hay un ganador...");
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("El corredor " + nombre + " ha comenzado la carrera");
            while (cont < 10) {
                System.out.println("El corredor " + nombre + " lleva recorrido un " + cont * 10 + "%");

                Thread.sleep(pausa * 1000L);

                if (pausa > 0) {
                    System.out.println("El corredor " + nombre + " ha realizado una pausita de " + pausa + " segundos...");
                }

                cont++;
            }
            System.out.println("¡El corredor " + nombre + " ha llegado a la meta!");
            anunciarGanador(nombre);
        } catch (Exception e) {
            System.out.println("Error en la ejecución del hilo: " + e.getMessage());
        }
    }
}

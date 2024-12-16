public class Contador implements Runnable {

    private int contador;

    public Contador() {
        this.contador = 0;
    }

    public synchronized void aumentarContador() {

        try {
            for (int i = 0; i < 5000; i++) {
                this.contador++;
            }
            System.out.println("El valor del contador es: " + this.contador);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {
        this.aumentarContador();
        System.out.println("Fin del aumento del contador");
    }

}

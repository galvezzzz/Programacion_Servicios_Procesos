
public class Raton implements Runnable{

    String nombre;
    int tiempoAlimento;

    public Raton(String nombre, int tiempoAlimento) {
        this.nombre = nombre;
        this.tiempoAlimento = tiempoAlimento;
    }

    @Override
    public void run() {
        try{
            System.out.println("El ratón " + nombre + " ha comenzado a comer.");
            Thread.sleep(tiempoAlimento * 1000L);
            System.out.println(nombre + " ha terminado de comer.");

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Raton r1 = new Raton("Miguel", 3);
        Raton r2 = new Raton("Pako", 1);
        Raton r3 = new Raton("Jose", 4);
        Raton r4 = new Raton("Berto", 2);

        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
        new Thread(r4).start();
    }


}
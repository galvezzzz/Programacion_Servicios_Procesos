import java.util.concurrent.Semaphore;

public class Main implements Runnable{

    Semaphore semaphore = new Semaphore(2);

    public void metodo1(){
        System.out.println("Se ejecuta el metodo 1");
    }

    public void metodo2(){
        System.out.println("Se ejecuta el metodo 2");
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            metodo1();
            metodo2();
            Thread.sleep(1000);
            semaphore.release();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Main hilos = new Main();
        for (int i = 0; i < 5; i++) {
            new Thread(hilos).start();
        }
    }
}

public class RepasoThread extends Thread{

    private int id;

    public RepasoThread (int id) {
        this.id = id;
    }

    @Override
    public void run() {

        if (id == 1) this.setPriority(Thread.MAX_PRIORITY);
        else if (id == 9) this.setPriority(Thread.MIN_PRIORITY);

        while (true) {
            System.out.println("Procesando hilo " + id);
            try {
                Thread.sleep(3000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {


    }
}
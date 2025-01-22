
public class HiloAzar implements Runnable {

    int clave, id;
    boolean acertado = false;


    public HiloAzar(int clave, int id) {
        this.clave = clave;
        this.id = id;
    }

    public int propuestaNumero(int num) {

    }

    public void anunciarAcertado(){

    }

    public void run() {

        int random = (int) (Math.random() * 101);
        try {

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        int clave = (int) (Math.random() * 101);

        for (int i = 0; i < 10; i++) {
            HiloAzar hiloAzar = new HiloAzar(clave, i);
            new Thread(hiloAzar).start();
        }
    }
}
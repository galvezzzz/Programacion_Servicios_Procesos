package filosofo;

/**
 *
 * @author Alberto
 */
public class Filosofo extends Thread {

    private Mesa mesa;
    private int comensal;

    public Filosofo(Mesa m, int comensal) {

        this.mesa = m;
        this.comensal = comensal;
    }

    @Override
    public void run() {
        while (true) {
            this.pensando();
            this.mesa.cogerTenedores(this.comensal - 1);
            this.comiendo();
            System.out.println("Filosofo " + comensal + " deja de comer ");
            this.mesa.dejarTenedores(this.comensal - 1);
        }
    }

    public void pensando() {

        System.out.println("Filosofo " + comensal + " esta pensando");
        try {
            sleep((long) (Math.random() * 4000) + 1000);

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }

    public void comiendo() {

        System.err.println("Filosofo " + comensal + " esta comiendo");
        try {
            sleep((long) (Math.random() * 4000) + 1000);

        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}

package filosofo;

/**
 *
 * @author Alberto
 */
import java.util.concurrent.Semaphore;

public class Mesa {

    private Semaphore[] tenedores;

    public Mesa(int numTenedores) {
        this.tenedores = new Semaphore[numTenedores];

        // Asignamos semáforos para los tenedores
        for (int i = 0; i < tenedores.length; i++) {
            tenedores[i] = new Semaphore(1);
        }
    }

    public int tenedorIzquierda(int comensal) {
        return comensal;
    }

    public int tenedorDerecha(int comensal) {
        return (comensal + 1) % tenedores.length;
    }

    public void cogerTenedores(int comensal) {

        boolean cogidos;

        do {
            cogidos = false;

            try {
                tenedores[tenedorDerecha(comensal)].acquire();
            } catch (InterruptedException ex) {
            }

            if (!tenedores[tenedorIzquierda(comensal)].tryAcquire()) {
                tenedores[tenedorDerecha(comensal)].release();
            }
        } while (!cogidos);

    }

    public void dejarTenedores(int comensal) {
        tenedores[tenedorIzquierda(comensal)].release();
        tenedores[tenedorDerecha(comensal)].release();
    }

}

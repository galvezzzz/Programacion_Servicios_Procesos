public class Consumidor implements Runnable {

    public synchronized void consumirLista(Productor productor) {

        try {
            int totalLista = 0;

            System.out.println("Se ha empezado a consumir el hilo " + productor.getId());

            for (int i = 0; i < productor.getListaNumeros().length; i++) {
                totalLista += productor.getListaNumeros()[i];
            }

            System.out.println("Total consumidos: " + totalLista);
            System.out.println("Se ha terminado a consumir el hilo " + productor.getId());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void run() {

    }
}

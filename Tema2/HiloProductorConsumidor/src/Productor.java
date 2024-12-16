public class Productor implements Runnable {
    @Override
    public void run() {
        Productor p1 = new Productor(1);
        Productor p2 = new Productor(2);

        rellenarLista(p1);
        rellenarLista(p2);
    }

    private int id;
    private int[] listaNumeros;

    public Productor(int id) {
        this.id = id;
        listaNumeros = new int[10];
    }

    public void rellenarLista(Productor productor){

        System.out.println("Se va a rellenar la lista de productores"+ id);
        for (int i = 0; i < 10; i++) {
            int random = (int) (Math.random() * 9 + 1);
            listaNumeros[i] = random;
        }
    }

    public int getId() {
        return id;
    }

    public int[] getListaNumeros() {
        return listaNumeros;
    }
}

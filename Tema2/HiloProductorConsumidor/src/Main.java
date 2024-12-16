
public class Main {
    public static void main(String[] args) {
        Productor p1 = new Productor(1);
        Productor p2 = new Productor(2);
        Consumidor c = new Consumidor();

        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(c).start();
    }
}
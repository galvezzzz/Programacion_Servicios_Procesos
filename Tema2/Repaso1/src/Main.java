
public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();

        new Thread(contador).start();
        new Thread(contador).start();
        new Thread(contador).start();
        new Thread(contador).start();
    }
}


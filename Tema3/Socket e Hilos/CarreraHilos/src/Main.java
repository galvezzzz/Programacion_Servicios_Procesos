
public class Main {
    public static void main(String[] args) {

        Corredor corredor1 = new Corredor("Miguelon");
        Corredor corredor2 = new Corredor("Pako");
        Corredor corredor3 = new Corredor("Megatron");

        new Thread(corredor1).start();
        new Thread(corredor2).start();
        new Thread(corredor3).start();
    }
}
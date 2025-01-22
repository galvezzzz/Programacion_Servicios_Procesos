import com.sun.security.jgss.GSSUtil;

public class Main extends Thread{

    String nombre;

    public Main(String nombre){
        this.nombre = nombre;
    }

    public void run(){
        try{
            while(true){
                int random = (int)(Math.random()*10);
                System.out.println("Soy el bucle " + nombre + " y estoy trabajando.");
                Thread.sleep(random * 1000L);

            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        Main h1 = new Main("Pako");
        Main h2 = new Main("Sambo");
        Main h3 = new Main("Tronco");
        Main h4 = new Main("Lazio");
        Main h5 = new Main("Rambo");
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

    }
}
package filosofo;

public class Filosofo extends Thread {
     
    private Mesa mesa;
    private int comensal;
     
    public Filosofo(Mesa m, int comensal){

    }
     
    public void run(){
        
         
    }
     
    public void pensando(){
        try{
            int random = (int) (Math.random()*5 + 1);
            System.out.println("El filósofo " + comensal + " está pensando.");
            Thread.sleep(random * 1000L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
     
    public void comiendo(){
        try{
            int random = (int) (Math.random()*5 + 1);
            System.out.println("El filósofo " + comensal + " está comiendo.");
            Thread.sleep(random * 1000L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
}

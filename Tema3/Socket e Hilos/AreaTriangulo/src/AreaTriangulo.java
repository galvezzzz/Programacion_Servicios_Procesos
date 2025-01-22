
public class AreaTriangulo implements Runnable {

    double base, altura;

    public AreaTriangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public void run() {
        try{
            double area = (base*altura)/2;
            System.out.println("El triangulo con base: " + base + " y altura: " + altura +
                    " tiene un área de: " + area);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        AreaTriangulo t1 = new AreaTriangulo(12, 3);
        AreaTriangulo t2 = new AreaTriangulo(34, 31);
        AreaTriangulo t3 = new AreaTriangulo(50, 50);
        AreaTriangulo t4 = new AreaTriangulo(17, 7);
        AreaTriangulo t5 = new AreaTriangulo(2, 4);
        AreaTriangulo t6 = new AreaTriangulo(25, 4);
        AreaTriangulo t7 = new AreaTriangulo(23, 63);
        AreaTriangulo t8 = new AreaTriangulo(122, 325);
        AreaTriangulo t9 = new AreaTriangulo(3, 86);
        AreaTriangulo t10 = new AreaTriangulo(32, 43);

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();
        new Thread(t5).start();
        new Thread(t6).start();
        new Thread(t7).start();
        new Thread(t8).start();
        new Thread(t9).start();
        new Thread(t10).start();
    }


}
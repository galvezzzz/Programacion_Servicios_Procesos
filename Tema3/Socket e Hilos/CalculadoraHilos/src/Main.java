import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0;

        System.out.print("Introduce el primer numero: ");
        num1 = sc.nextInt();

        System.out.print("Introduce el segundo numero: ");
        num2 = sc.nextInt();

        Operacion h1 = new Operacion(num1, num2, "Suma");
        Operacion h2 = new Operacion(num1, num2, "Resta");
        Operacion h3 = new Operacion(num1, num2, "Multiplicacion");
        Operacion h4 = new Operacion(num1, num2, "Division");

        new Thread(h1).start();
        new Thread(h2).start();
        new Thread(h3).start();
        new Thread(h4).start();

    }
}
public class Operacion implements Runnable {

    int num1, num2;
    String operacion;
    double resultado;

    public Operacion(int num1, int num2, String operacion) {
        this.num1 = num1;
        this.num2 = num2;
        this.operacion = operacion;
    }

    @Override
    public void run() {
        try {
            switch (operacion) {
                case "Suma":
                    resultado = num1 + num2;
                    System.out.println("El resultado de la suma entre " + num1 + " y " + num2 + " es: " + resultado + " / Hilo: " + Thread.currentThread().getName());
                    break;
                case "Resta":
                    resultado = num1 - num2;
                    System.out.println("El resultado de la resta entre " + num1 + " y " + num2 + " es: " + resultado + " / Hilo: " + Thread.currentThread().getName());
                    break;
                case "Multiplicacion":
                    resultado = num1 * num2;
                    System.out.println("El resultado de la multiplicación entre " + num1 + " y " + num2 + " es: " + resultado + " / Hilo: " + Thread.currentThread().getName());
                    break;
                case "Division":
                    resultado = (double) num1 / num2;
                    System.out.println("El resultado de la división entre " + num1 + " y " + num2 + " es: " + resultado + " / Hilo: " + Thread.currentThread().getName());
                    break;
                default:
                    System.out.println("Solicitud errónea.");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}

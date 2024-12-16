/*
Implemente un programa que reciba a través de sus argumentos una lista de ficheros y
cuente cuantas líneas, palabras y caracteres hay en cada fichero, así como el total entre
todos los ficheros (el ‘wc’ de linux). Modifíquelo para que se cree un thread por cada
fichero a contar, cuidando de obtener igualmente el total. Mida cuanto tiempo emplea la
versión secuencial para contar unos cuantos ficheros grandes y cuanto tarda la versión
paralela para hacer lo mismo.
 */
public class Main {
    public static void main(String[] args) {
        Fichero f = new Fichero("ficheros");

        new Thread(f).start();
    }
}


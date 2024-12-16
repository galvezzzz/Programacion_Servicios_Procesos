import java.io.*;

public class Fichero implements Runnable{

    private final String extension = ".txt";
    private final int delay = 1500;

    File carpetaExaminar;

    public Fichero(String dir) {
        carpetaExaminar = new File(dir);
    }

    public void LeerFichero(){
        String linea;
        int contLineas = 0;

        try (BufferedReader in = new BufferedReader(new FileReader(carpetaExaminar))) {
            linea = in.readLine();

            while(linea != null){
                contLineas++;
                System.out.println(linea);
                linea = in.readLine();
            }

            System.out.println("Número de líneas: " + contLineas);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void ContarPalabras(){
        int wordCount = 0;
        String words[] = null;
        String linea;
        boolean isNull;

        try (BufferedReader in = new BufferedReader(new FileReader(carpetaExaminar))) {
            linea = in.readLine();
            isNull = (linea == null);

            while(!isNull){
                words = linea.trim().split("\\s+");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ContarCaracteres(){
        char caracter;
        int contCaracteres = 0;

        try (BufferedReader in = new BufferedReader(new FileReader(carpetaExaminar))) {
            caracter = in.readLine().charAt(0);

            while(caracter != -1){
                contCaracteres++;
                caracter = in.readLine().charAt(0);
            }

            System.out.println("Número de líneas: " + contCaracteres);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {

        ContarCaracteres();
//
//        while(true){
//            if (carpetaExaminar.exists()){
//                LeerFichero();
//            }else{
//                System.out.println("El fichero no existe");
//            }
//
//        }
    }
}

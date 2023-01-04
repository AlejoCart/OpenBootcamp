import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

public class Punto9 {

    public static void main(String []args){
        Punto9.accionar();
    }
    private static HashMap<Integer,String> recetario = new HashMap<>();
    public static void accionar(){
        System.out.println("Punto 9");
        llenarRecetario();
        imprimirRecetario();




    }
    public static void llenarRecetario(){

        recetario.put(1,"Receta 1");
        recetario.put(101,"Receta xy");
        recetario.put(1026,"Receta secreta");
        recetario.put(666,"Receta prohibida");
    }

    public static void imprimirRecetario(){
        FileOutputStream salida;
        try {
             salida= new FileOutputStream(new File("./salida.text"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        recetario.
        salida.write(recetario.entrySet());
        System.out.println(recetario.entrySet());




    }
}

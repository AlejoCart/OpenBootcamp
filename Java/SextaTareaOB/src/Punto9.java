import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Punto9 {

    public static void main(String []args){
        try{
            Punto9.accionar();
        }catch (Exception e){
            System.out.println("ERROR AL ACCIONAR");
        }

    }
    private static HashMap<String,String> recetario = new HashMap<>();
    private static Scanner entrada= new Scanner(System.in);
    public static void accionar() throws IOException {
        System.out.println("Punto 9");

        byte opcion;

        llenarRecetario();

        do {
            System.out.println("Bienvenido eliga una opcion:\n1_ Ver recetas\n2-Imprimir recetas\n0- Salir");

            opcion=comprobarOpcion();
            if(opcion==0) break;

            switch (opcion) {
                case 1: verRecetas();
                case 2:imprimirRecetario();

            }

            System.out.println("Desea realizar otra operacion?\n 0-No\n1-Si");
            opcion=comprobarOpcion();
            System.out.println(opcion);

        }while(opcion!=0);
        try {
            imprimirRecetario();
        } catch (Exception e) {
            System.out.println("Error en metodo imprimir");
        }

    }
    public static void llenarRecetario(){//a implementar entrada de datos por archivo externo

        recetario.put("1","Receta 1");
        recetario.put("101","Receta xy");
        recetario.put("1026","Receta secreta");
        recetario.put("666","Receta prohibida");
        recetario.put("0","Receta de la abuela");

    }
    public static  void verRecetas(){
        for(Map.Entry<String,String> e: recetario.entrySet()){
            System.out.println(("Codigo: "+e.getKey())+" - Detalle: "+e.getValue());
        }
    }
    public static byte comprobarOpcion(){
        byte aux;
        do {
            aux = entrada.nextByte();
            if (aux > 3 && aux < 0)
                System.out.println("Opcion incorrecta, eliga nuevamente");
        } while (aux > 3 && aux < 0);

        return aux;
    }

    public static void imprimirRecetario() throws IOException, FileNotFoundException {

        FileOutputStream fos=new FileOutputStream(new File("./Recetas.txt"));
        PrintWriter pw= new PrintWriter(fos);
        //ObjectOutputStream  salida= new ObjectOutputStream (fos);
        //salida.writeObject(recetario);

        for(Map.Entry<String,String> e: recetario.entrySet()){
        pw.println(("Codigo: "+e.getKey())+" - Detalle: "+e.getValue());
        }

        pw.flush();
        pw.close();
        fos.close();

    }

}

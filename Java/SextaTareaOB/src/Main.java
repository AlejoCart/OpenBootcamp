import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        //Funcion Reverse
        System.out.println(reverse("text"));

        //Punto 1
        System.out.println("\n Punto 1");
        String[] listaString = {"Primer Texto", "Texto segundo", "Se me acabaron las ideas"};
        for (String elemento : listaString) {
            System.out.println(elemento);
        }

        //Punto 2

        Punto2();

        //Punto 3

        Punto3();

        //Punto 4
        System.out.println("\nPunto 4");
        System.out.println("Se realizarian demasiadas tareas de asignar una nueva acapacidad, ya que por defecto se añaden solo 10 elementos a la capacidad maxima al alcanzar su limite de capacidad");

        //Punto 5
        Punto5();

        //Punto 6
        Punto6();

        //Punto 7

        try {
            DividePorCero(1,0);
        }catch (ArithmeticException e){
            System.out.println("Esto no puede hacerce");
        }finally {
            System.out.println("Demo de código");
        }

        //Punto 8
        File archivo= new File("./entrada.txt");
        FileInputStream fileIn= null;
        FileOutputStream fileOut=null;
        try {
            fileIn = new FileInputStream(archivo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            fileOut = new FileOutputStream(new File("./Salida.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Punto8(fileIn,fileOut);


        //Punto 9
        Punto9.accionar();
    }

    public static String reverse(String texto) {

        System.out.println("Funcion reverse");
        char[] aux = new char[texto.length()];
        String textoInvertido;
        int contador = 0;

        for (int i = texto.length() - 1; i >= 0; i--) {
            //System.out.println(texto.charAt(i));
            aux[contador] = texto.charAt(i);
            contador++;
        }
        textoInvertido = new String(aux);
        return textoInvertido;
    }

    public static void Punto2() {

        System.out.println("\nPunto 2");
        int ancho = 5;
        int largo = 5;
        int[][] listaBidi = new int[ancho][largo];

        //Llenamos el array
        for (int i = 0; i <= ancho - 1; i++) {
            for (int j = 0; j <= largo - 1; j++) {
                //System.out.println("i: "+i+" j: "+j);
                listaBidi[i][j] = (int) (Math.random() * 50 + 1);
            }
        }

        for (int i = 0; i <= ancho - 1; i++) {
            for (int j = 0; j <= largo - 1; j++) {
                System.out.print(listaBidi[i][j] + " - ");
            }
        }


    }

    public static void Punto3() {
        System.out.println("Punto 3\n");
        Vector<String> vector1=new Vector<String>();
        for (int i = 0; i <= 5; i++) {
            vector1.add("Elemento"+i);
        }
        vector1.remove(2);
        vector1.remove(3);

        for(String elemento: vector1){
            System.out.println(elemento);
        }

    }
    public static void Punto5(){
        System.out.println("Punto 5");

        ArrayList<String> lista= new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");
        lista.add("Elemento 4");
        LinkedList<String> lista2= new LinkedList<>();
        lista2.addAll(lista);

        System.out.println("\nArrayList");
        for(String elemento: lista){
            System.out.println(elemento);
        }
        System.out.println("\nLinkedList");
        for (String elemento: lista2) {
            System.out.println(elemento);
        }
    }

    public static void Punto6(){
        System.out.println("\nPunto 6");
        ArrayList<Integer> lista=new ArrayList<Integer>();

        for (int i=0;i<10;i++){
            if(i%2!=0) lista.add(i);
        }
        for(Integer num:lista){
            System.out.println(num);
        }
    }

    public static void DividePorCero(int num1,int num2) throws ArithmeticException{
        System.out.println("\nPunto 7");
    int resultadoFallido=num1/num2;

    //return  resultadoFallido;
    }

    public static void Punto8(FileInputStream entrada,FileOutputStream salida){
        System.out.println("\nPunto 8");

        int valor= 0;
        try {
            valor = entrada.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            while(valor!=-1){
                //System.out.print((char)valor);
                salida.write((char)valor);
                valor=entrada.read();
            }
            System.out.println("Lectura y carga completada sin problemas");

        } catch (IOException e) {
            System.out.println("Error de lectura o carga de archivo");
            //throw new RuntimeException(e);
        }

    }
}
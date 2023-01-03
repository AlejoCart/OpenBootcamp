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
        System.out.println("Punto 4");
        System.out.println("Se realizarian demasiadas tareas de asignar una nueva acapacidad, ya que por defecto se añaden solo 10 elementos a la capacidad maxima al alcanzar su limite de capacidad");

        //Punto 5
        
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
}
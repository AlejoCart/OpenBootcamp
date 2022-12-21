public class Main {
    public static void main(String[] args) {

        int num=16;
        double numIVA=calcularImpuesto(num);
        System.out.println(numIVA);

    }
        static double calcularImpuesto(int numero){
            return numero+(numero*0.21);
        }
}
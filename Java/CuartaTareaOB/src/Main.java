public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        SmartDevice dispositivoGenerico= new SmartDevice("Modelo 1",2,"Procesador Generico","4 horas");
        System.out.println("Dispotivo Generico");
        System.out.println(dispositivoGenerico.toString());
        //System.out.println(dispositivoGenerico.ram);
        //System.out.println(dispositivoGenerico.Modelo);
        //System.out.println(dispositivoGenerico.procesador);


        SmartPhone telefono=new SmartPhone(15,15,50);
        telefono.setModelo("Modelo 1");
        telefono.setProcesador("Procesador 24");
        telefono.setRam(15);
        telefono.setDuracionBateria("84 horas continuas");

        System.out.println(telefono.toString());
        /*System.out.println(telefono.anchoPantalla);
        System.out.println(telefono.duracionBateria);
        System.out.println(telefono.);*/

        SmartWatch reloj = new SmartWatch();
        System.out.println(reloj.toString());

    }
}
public class SmartWatch extends SmartDevice{

    String textoBienvenida;

    public SmartWatch(String modelo, int ram, String procesador, String duracionBateria, String textoBienvenida) {
        super(modelo, ram, procesador, duracionBateria);
        this.textoBienvenida = textoBienvenida;
    }

    public SmartWatch(String textoBienvenida) {
        this.textoBienvenida = textoBienvenida;
    }

    public SmartWatch() {
    }

    @Override
    public String toString() {
        return "SmartWatch{" +
                "textoBienvenida='" + textoBienvenida + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", ram=" + ram +
                ", procesador='" + procesador + '\'' +
                ", duracionBateria='" + duracionBateria + '\'' +
                '}';
    }
}

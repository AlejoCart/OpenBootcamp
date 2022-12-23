public class SmartPhone extends SmartDevice{
    int anchoPantalla;
    int largoPantalla;
    int almacenamiento;

    public SmartPhone(String modelo, int ram, String procesador, String duracionBateria, int anchoPantalla, int largoPantalla, int almacenamiento) {
        super(modelo, ram, procesador, duracionBateria);
        this.anchoPantalla = anchoPantalla;
        this.largoPantalla = largoPantalla;
        this.almacenamiento = almacenamiento;
    }

    public SmartPhone(int anchoPantalla, int largoPantalla, int almacenamiento) {
        this.anchoPantalla = anchoPantalla;
        this.largoPantalla = largoPantalla;
        this.almacenamiento = almacenamiento;
    }
    public SmartPhone(){

    }

    public int getAnchoPantalla() {
        return anchoPantalla;
    }

    public void setAnchoPantalla(int anchoPantalla) {
        this.anchoPantalla = anchoPantalla;
    }

    public int getLargoPantalla() {
        return largoPantalla;
    }

    public void setLargoPantalla(int largoPantalla) {
        this.largoPantalla = largoPantalla;
    }

    public int getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(int almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "anchoPantalla=" + anchoPantalla +
                ", largoPantalla=" + largoPantalla +
                ", almacenamiento=" + almacenamiento +
                ", Modelo='" + Modelo + '\'' +
                ", ram=" + ram +
                ", procesador='" + procesador + '\'' +
                ", duracionBateria='" + duracionBateria + '\'' +
                '}';
    }
}

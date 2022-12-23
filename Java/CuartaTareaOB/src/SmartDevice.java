public class SmartDevice {
    String Modelo;
    int ram;
    String procesador;
    String duracionBateria;

    public SmartDevice(String modelo, int ram, String procesador, String duracionBateria) {
        Modelo = modelo;
        this.ram = ram;
        this.procesador = procesador;
        this.duracionBateria = duracionBateria;
    }

    public SmartDevice() {

    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getDuracionBateria() {
        return duracionBateria;
    }

    public void setDuracionBateria(String duracionBateria) {
        this.duracionBateria = duracionBateria;
    }

    @Override
    public String toString() {
        return "SmartDevice{" +
                "Modelo='" + Modelo + '\'' +
                ", ram=" + ram +
                ", procesador='" + procesador + '\'' +
                ", duracionBateria='" + duracionBateria + '\'' +
                '}';
    }
}

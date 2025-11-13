package modelo;

/**
 * Representa una solicitud de ascensor desde un piso en una dirección.
 */
public class Solicitud {
    private final int piso;
    private final String direccion; // "subir" o "bajar"

    public Solicitud(int piso, String direccion) {
        this.piso = piso;
        this.direccion = direccion;
    }

    public int getPiso() { return piso; }
    public String getDireccion() { return direccion; }

    @Override
    public String toString() {
        return "Solicitud{piso=" + piso + ", direccion='" + direccion + "'}";
    }
}

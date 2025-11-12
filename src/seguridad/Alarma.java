package seguridad;

/**
 * Esta clase  controla la activación y desactivación de alarmas de seguridad.
 */
public class Alarma {
    private boolean activa;
    private String zona;

    public Alarma(String zona) {
        this.zona = zona;
        this.activa = false;
    }

    public void activar() {
        if (!activa) {
            this.activa = true;
            System.out.println(" ALARMA ACTIVADA en zona: " + zona);
        }
    }

    public void desactivar() {
        if (activa) {
            this.activa = false;
            System.out.println("Alarma desactivada en zona: " + zona);
        }
    }

    // Getters
    public boolean isActiva() {
        return activa;
    }
    
    @Override
    public String toString() {
        return "Alarma{" +
                "zona='" + zona + '\'' +
                ", activa=" + activa +
                '}';
    }
}
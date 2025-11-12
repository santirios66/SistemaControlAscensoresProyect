package seguridad;

/**
 * esta clase simula el funcionamiento de una cámara de seguridad.
 */
public class Camara {
    private String ubicacion;
    private boolean grabando;

    public Camara(String ubicacion) {
        this.ubicacion = ubicacion;
        this.grabando = false;
    }

    public void iniciarGrabacion() {
        if (!grabando) {
            this.grabando = true;
            System.out.println("Cámara en " + ubicacion + ": Iniciando grabación.");
        }
    }

    public void detenerGrabacion() {
        if (grabando) {
            this.grabando = false;
            System.out.println("Cámara en " + ubicacion + ": Deteniendo grabación.");
        }
    }

    // Getters 
    public boolean isGrabando() {
        return grabando;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    
    @Override
    public String toString() {
        return "Camara{" +
                "ubicacion='" + ubicacion + '\'' +
                ", grabando=" + grabando +
                '}';
    }
}
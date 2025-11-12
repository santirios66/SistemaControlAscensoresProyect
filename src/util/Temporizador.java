package util;

/**
 * Gestiona el control de tiempos del sistema (puertas, mantenimiento, etc.).
 */
public class Temporizador {
    private int duracionSegundos;
    private boolean activo;

    /**
     * Constructor del temporizador.
     * @param duracionSegundos Duración en segundos del temporizador.
     */
    public Temporizador(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
        this.activo = false;
    }

    /**
     * Inicia el temporizador.
     */
    public void iniciar() {
        this.activo = true;
        System.out.println("Temporizador iniciado por " + duracionSegundos + " segundos.");
        
        try {
            // Pausa el hilo actual para simular la duración del tiempo
            Thread.sleep(duracionSegundos * 1000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("El temporizador fue interrumpido.");
        }
        detener();
    }

    /**
     * Detiene el temporizador.
     */
    public void detener() {
        this.activo = false;
        System.out.println("Temporizador detenido.");
    }

    // Getters y Setters
    public int getDuracion() {
        return duracionSegundos;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setDuracion(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }
    
    @Override
    public String toString() {
        return "Temporizador{" +
                "duracion=" + duracionSegundos +
                ", activo=" + activo +
                '}';
    }
}
package util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Gestiona el control de tiempos del sistema (puertas, mantenimiento, etc.).
 * Ahora no bloquea el hilo principal y permite callbacks cuando termina.
 */
public class Temporizador {
    private int duracionSegundos;
    private volatile boolean activo;
    private final ScheduledExecutorService scheduler;

    /**
     * Constructor del temporizador.
     * @param duracionSegundos Duración en segundos del temporizador.
     */
    public Temporizador(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
        this.activo = false;
        this.scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    /**
     * Inicia el temporizador de forma no bloqueante. Cuando finaliza, llama a
     * la acción onFinish si no es null.
     *
     * @param onFinish Runnable a ejecutar al terminar (puede ser null)
     */
    public void iniciar(Runnable onFinish) {
        if (activo) return;
        this.activo = true;
        System.out.println("Temporizador iniciado por " + duracionSegundos + " segundos.");

        scheduler.schedule(() -> {
            try {
                if (onFinish != null) {
                    onFinish.run();
                }
            } finally {
                detener();
            }
        }, duracionSegundos, TimeUnit.SECONDS);
    }

    /**
     * Versión sin callback para compatibilidad: inicia y no bloquea.
     */
    public void iniciar() {
        iniciar(null);
    }

    /**
     * Detiene el temporizador.
     */
    public void detener() {
        this.activo = false;
        System.out.println("Temporizador detenido.");
        try {
            // Intentamos apagar el scheduler inmediatamente
            scheduler.shutdownNow();
        } catch (Exception e) {
            // Ignoramos errores al apagar
        }
    }

    /**
     * Forzar cierre del scheduler (alias de detener).
     */
    public void shutdown() {
        detener();
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
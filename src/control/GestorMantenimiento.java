package control;

import java.util.ArrayList;
import java.util.List;
import util.RegistroEventos; // Importamos la clase RegistroEventos del paquete util
import modelo.Ascensor; // Importamos la clase Ascensor del paquete modelo

/**
 * esta clase supervisa el estado de los ascensores y registra mantenimientos.
 * tiene agregación con Ascensor y con RegistroEventos.
 */
public class GestorMantenimiento {
    private List<String> historial;
    private RegistroEventos registroEventos; // Para guardar un log detallado

    // El constructor ahora espera el RegistroEventos
    public GestorMantenimiento(RegistroEventos registroEventos) {
        this.historial = new ArrayList<>();
        this.registroEventos = registroEventos;
    }

    /**
     * Reporta una falla para un ascensor específico y actualiza su estado.
     * 
     * @param ascensor El objeto Ascensor que tiene la falla.
     * @param detalles Detalles de la falla.
     */
    public void reportarFalla(Ascensor ascensor, String detalles) {
        String reporte = "FALLA reportada para Ascensor ID " + ascensor.getId() + 
                         " en piso " + ascensor.getPisoActual() + ": " + detalles;
        
        this.historial.add(reporte);
        System.out.println(reporte);
        
        if (registroEventos != null) {
            registroEventos.registrarEvento(reporte);
        }
        
        // Interactua con el objeto Ascensor real:
        ascensor.setEstado("en mantenimiento"); 
        System.out.println("--> El estado del Ascensor " + ascensor.getId() + " ha sido cambiado a 'en mantenimiento'.");
    }

    /**
     * Programa una revisión general y lo registra en el historial.
     */
    public void programarRevision() {
        String revision = "Revisión general programada para la próxima semana.";
        this.historial.add(revision);
        System.out.println(revision);

        if (registroEventos != null) {
            registroEventos.registrarEvento(revision);
        }
    }

    //  Getters 

    public List<String> getHistorial() {
        return historial;
    }

    public RegistroEventos getRegistroEventos() {
        return registroEventos;
    }

    // Setters
    public void setRegistroEventos(RegistroEventos registroEventos) {
        this.registroEventos = registroEventos;
    }

    //toString
    @Override
    public String toString() {
        return "GestorMantenimiento{" +
                "reportesPendientes=" + historial.size() +
                '}';
    }
}
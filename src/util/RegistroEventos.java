package util;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Rol: Guarda logs del sistema.
 */
public class RegistroEventos {
    private List<String> eventos;

    public RegistroEventos() {
        this.eventos = new ArrayList<>();
    }

    /**
     * Registra un evento con su descripción y hora actual (ISO-8601).
     * @param descripcion La descripción del evento.
     */
    public void registrarEvento(String descripcion) {
        String timestamp = DateTimeFormatter.ISO_INSTANT.format(Instant.now());
        String logEntry = timestamp + " - " + descripcion;
        this.eventos.add(logEntry);
        System.out.println("[LOG] " + logEntry);
    }

    /**
     * Muestra todos los eventos registrados.
     * @return Una lista de cadenas con todos los eventos.
     */
    public List<String> mostrarEventos() {
        return eventos;
    }

    @Override
    public String toString() {
        return "RegistroEventos{cantidadEventos=" + eventos.size() + '}';
    }
}

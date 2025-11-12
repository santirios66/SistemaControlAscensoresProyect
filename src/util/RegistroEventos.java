package util;

import java.util.ArrayList;
import java.util.Date;
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
     * Registra un evento con su descripción y hora actual.
     * @param descripcion La descripción del evento.
     */
    public void registrarEvento(String descripcion) {
        String logEntry = new Date().toString() + " - " + descripcion;
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

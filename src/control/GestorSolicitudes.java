package control;

import java.util.LinkedList;
import java.util.Queue;
import modelo.Ascensor;
import modelo.Edificio;

/*
 * Clase que gestiona las solicitudes de ascensor realizadas por los pisos.
 * forma parte del sistema de control del edificio.
 */

public class GestorSolicitudes {
    // Cola de solicitudes en formato piso- direccion.
    private Queue<String> solicitudes;
    private Edificio edificio; // aqui la referencia al edifico para poder asignar ascensores

    // Constructor
    public GestorSolicitudes(Edificio edificio) {
        this.edificio = edificio;
        this.solicitudes = new LinkedList<>();
    }

    /**
     * Registra una nueva solicitud de ascensor.
     *
     * @param piso      número del piso que realiza la solicitud
     * @param direccion "subir" o "bajar"
     */

    public void registrarSolicitud(int piso, String direccion) {
        String solicitud = piso + "-" + direccion;
        solicitudes.add(solicitud);
        System.out.println("Solicitud registrada : Piso " + piso + " (" + direccion + ")");
    }

    /**
     * Asgina el ascensor mas cercano ala primera solicitud en la cola.
     * 
     * @return el ascensor asignado o null si no hay solicitudes o ascensores.
     */

    
     public Ascensor asignarAscensor() {
        if (solicitudes.isEmpty()) {
            System.out.println("No hay solicitudes pendientes.");
            return null;
        }

        // Obtiene y elimina la primera solicitud en la cola
        String solicitud = solicitudes.poll();
        String[] partes = solicitud.split("-");
        int pisoSolicitado = Integer.parseInt(partes[0]);

        Ascensor ascensor = edificio.getAscensorCercano(pisoSolicitado);

        if (ascensor != null) {
            System.out.println("Ascensor " + ascensor.getId() +
                               " asignado a solicitud desde piso " + pisoSolicitado);
            ascensor.moverA(pisoSolicitado);
        } else {
            System.out.println("No hay ascensores disponibles en este momento.");
        }

        return ascensor;
    }

    //muestra las solicitudes pendientes
    public void mostrarSolicitudes() {
        System.out.println("Solicitudes pendientes : " + solicitudes);
    }
}

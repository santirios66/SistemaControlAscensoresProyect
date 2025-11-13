package control;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import modelo.Ascensor;
import modelo.Edificio;
import modelo.Solicitud;


/*
 * Clase que gestiona las solicitudes de ascensor realizadas por los pisos.
 * forma parte del sistema de control del edificio.
 */

public class GestorSolicitudes {
    // Cola de solicitudes como objetos Solicitud (thread-safe)
    private Queue<Solicitud> solicitudes;
    private Edificio edificio; // referencia al edificio para poder asignar ascensores

    // Constructor
    public GestorSolicitudes(Edificio edificio) {
        this.edificio = edificio;
        this.solicitudes = new ConcurrentLinkedQueue<>();
    }

    /**
     * Registra una nueva solicitud de ascensor.
     *
     * @param piso      número del piso que realiza la solicitud
     * @param direccion "subir" o "bajar"
     */

    public void registrarSolicitud(int piso, String direccion) {
        registrarSolicitud(new Solicitud(piso, direccion));
    }

    public void registrarSolicitud(Solicitud solicitud) {
        solicitudes.add(solicitud);
        System.out.println("Solicitud registrada : " + solicitud);
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
        Solicitud solicitud = solicitudes.poll();
        int pisoSolicitado = solicitud.getPiso();

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

    // muestra las solicitudes pendientes
    public void mostrarSolicitudes() {
        System.out.println("Solicitudes pendientes : " + solicitudes);
    }
}

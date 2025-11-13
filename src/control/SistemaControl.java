package control;

import modelo.Edificio;
import modelo.Piso;
import modelo.Ascensor; 
import util.RegistroEventos; 

public class SistemaControl {
    
    private Edificio edificio;
    private GestorSolicitudes gestorSolicitudes;
    private GestorAlertas gestorAlertas;
    private GestorMantenimiento gestorMantenimiento;
    private RegistroEventos registroEventos;

    // Constructor
    public SistemaControl(Edificio edificio){
        this.edificio = edificio;
        this.registroEventos = new RegistroEventos(); 
        this.gestorSolicitudes = new GestorSolicitudes(edificio);
        this.gestorAlertas = new GestorAlertas(this.registroEventos); 
        this.gestorMantenimiento = new GestorMantenimiento(this.registroEventos); // Ahora espera RegistroEventos
    }

    // procesa una solicitud de ascensor
    public void procesarSolicitud(Piso piso, String direccion){
        System.out.println("Procesando solicitud desde piso " + piso.getNumero() + " hacia "  + direccion);
        gestorSolicitudes.registrarSolicitud(piso.getNumero(), direccion);
        gestorSolicitudes.asignarAscensor(); // Ya no necesita el argumento 'edificio'
    }

    // Actualiza el estado general del sistema
    public void actualizarEstado() {
        System.out.println("Actualizando estado del sistema...");
        edificio.mostrarEstado();
        registroEventos.registrarEvento("Estado del sistema actualizado.");
    }

    // Detecta posibles fallas o alertas
    public void detectarFalla() {
        System.out.println("Verificando posibles fallas...");
        gestorAlertas.enviarAlerta("Chequeo general del sistema completado.");

        // Simulamos el uso del nuevo método del GestorMantenimiento
        // Esto asume que tienes un ascensor disponible en el edificio (ej. el primero de la lista)
        if (!edificio.getAscensores().isEmpty()) {
            Ascensor ascensorConFalla = edificio.getAscensores().get(0);
            gestorMantenimiento.reportarFalla(ascensorConFalla, "Sensor de peso sobrecargado.");
        }
    }

    // Getters
    public Edificio getEdificio() { return edificio; }
    public GestorSolicitudes getGestorSolicitudes() { return gestorSolicitudes; }
    public GestorAlertas getGestorAlertas() { return gestorAlertas; }
    public GestorMantenimiento getGestorMantenimiento() { return gestorMantenimiento; }
    public RegistroEventos getRegistroEventos() { return registroEventos; }


    @Override
    public String toString() {
        return "SistemaControl{" +
                "edificio=" + (edificio != null ? edificio.getNombre() : "N/A") + 
                ", gestorSolicitudes=" + gestorSolicitudes +
                ", gestorAlertas=" + gestorAlertas +
                ", gestorMantenimiento=" + gestorMantenimiento +
                '}';
    }
}
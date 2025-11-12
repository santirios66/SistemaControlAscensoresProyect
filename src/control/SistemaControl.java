package control;
import modelo.Edificio;
import modelo.Piso;

public class SistemaControl {
    
    private Edificio edificio;
    private GestorSolicitudes gestorSolicitudes;
    private GestorAlertas gestorAlertas;
    private GestorMantenimiento gestorMantenimiento;

    // Constructor
    public SistemaControl(Edificio edificio){
        this.edificio = edificio;
        this.gestorSolicitudes = new GestorSolicitudes(edificio);
        this.gestorAlertas = new GestorAlertas(edificio);
        this.gestorMantenimiento = new GestorMantenimiento(edificio);
    }

    // procesa una solicitud de ascensor
    public void procesarSolicitud(Piso piso, String direccion){
        System.out.println("Procesando solicitud desde piso " + piso.getNumero() + " hacia "  + direccion);
        gestorSolicitudes.registrarSolicitud(piso.getNumero(), direccion);
        gestorSolicitudes.asignarAscensor(edificio);
    }

        // Actualiza el estado general del sistema
    public void actualizarEstado() {
        System.out.println("Actualizando estado del sistema...");
        edificio.mostrarEstado();
    }

    // Detecta posibles fallas o alertas
    public void detectarFalla() {
        System.out.println("Verificando posibles fallas...");
        gestorAlertas.enviarAlerta("Chequeo general del sistema completado.");
    }

    // Getters
    public Edificio getEdificio() { return edificio; }
    public GestorSolicitudes getGestorSolicitudes() { return gestorSolicitudes; }
    public GestorAlertas getGestorAlertas() { return gestorAlertas; }
    public GestorMantenimiento getGestorMantenimiento() { return gestorMantenimiento; }

    // Solo se incluyen getters, ya que los gestores y el edificio se inicializan
    // al crear el sistema y no deben modificarse desde fuera

    @Override
    public String toString() {
        return "SistemaControl{" +
                "edificio=" + edificio +
                ", gestorSolicitudes=" + gestorSolicitudes +
                ", gestorAlertas=" + gestorAlertas +
                ", gestorMantenimiento=" + gestorMantenimiento +
                '}';
    }
}

}

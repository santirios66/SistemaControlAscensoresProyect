package modelo;

import java.util.ArrayList;
import java.util.List;
import util.Temporizador;

public class Ascensor {

    private int id;
    private int pisoActual;
    private String direccion; // "subiendo", "bajando", "detenido"
    private String estado; // "en movimiento", "detenido", "en mantenimiento", "puerta abierta"
    private Puerta puerta;
    private List<Sensor> sensores;
    private PanelControl panel;
    private int capacidad;
    private String indicador; // Muestra el piso actual o mensaje de error

    // El constructor ahora requiere el total de pisos para inicializar el panel
    public Ascensor(int id, int capacidad, int totalPisos) {
        this.id = id;
        this.capacidad = capacidad;

        // Valores iniciales
        this.pisoActual = 1; // Todos los ascensores empiezan en el piso 1
        this.direccion = "detenido";
        this.estado = "detenido";

        // Composición
        this.puerta = new Puerta();
        this.sensores = new ArrayList<>();
        this.panel = new PanelControl(totalPisos);

        this.indicador = "Piso " + this.pisoActual;

        // añadir un sensor básico al ascensor
        sensores.add(new Sensor("peso"));
    }

    // Métodos
    public void moverA(int pisoDestino) {
        // Lógica básica de dirección para el indicador
        if (pisoDestino > pisoActual) {
            this.direccion = "subiendo";
        } else if (pisoDestino < pisoActual) {
            this.direccion = "bajando";
        } else {
            this.direccion = "detenido";
        }

        System.out.println("Ascensor " + id + " moviéndose a piso " + pisoDestino + " (" + this.direccion + ")");
        this.estado = "en movimiento";
        this.pisoActual = pisoDestino; // Simulación instantánea del movimiento
        this.indicador = "Piso " + pisoDestino;
        detener(); // Se detiene al llegar
    }

public void llegarAlPiso(Piso piso) {
    System.out.println("Ascensor " + id + " ha llegado al piso " + piso.getNumero() + ". Abriendo puertas...");
    
    abrirPuerta(); // solo aquí se abre la puerta

    // Apagar luces de botones del piso
    piso.getBotonSubir().apagarLuz();
    piso.getBotonBajar().apagarLuz();

    // Mantener la puerta abierta pero NO abrirla otra vez dentro
    mantenerPuertaAbierta(3); 
}
    public void abrirPuerta() {
        puerta.abrir();
        this.estado = "puerta abierta";
    }

    public void cerrarPuerta() {
        if (puerta.detectarObstaculo()) { // Usamos la lógica de la Puerta
            System.out.println("No se puede cerrar la puerta, obstáculo detectado.");
        } else {
            puerta.cerrar();
            this.estado = "detenido";
        }
    }

    public void detener() {
        this.estado = "detenido";
        this.direccion = "detenido";
        System.out.println("Ascensor " + id + " detenido.");
    }

    public void mostrarEstado() {
        System.out.println("--- ESTADO ASCENSOR " + id + " ---");
        System.out.println("Piso Actual: " + pisoActual + " (" + indicador + ")");
        System.out.println("Estado General: " + estado);
        System.out.println("Dirección: " + direccion);
        System.out.println("Capacidad: " + capacidad + " personas");
        System.out.println("----------------------------------");
    }
    /**
     * Mantiene la puerta abierta por una duración (segundos) y la cierra
     * automáticamente al terminar. No bloqueante.
     */
public void mantenerPuertaAbierta(int segundos) {
    System.out.println("Ascensor " + id + ": Manteniendo puerta abierta por " + segundos + "s");

    Temporizador t = new Temporizador(segundos);
    t.iniciar(() -> {
        if (!puerta.detectarObstaculo()) {
            puerta.cerrar();
            this.estado = "detenido";
            System.out.println("Ascensor " + id + ": Puerta cerrada después de mantenerla abierta.");
        } else {
            System.out.println("Ascensor " + id + ": No se pudo cerrar la puerta, obstáculo detectado.");
        }
    });
}



    // Getters y Setters
    public int getId() {
        return id;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEstado() {
        return estado;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public List<Sensor> getSensores() {
        return sensores;
    }

    public PanelControl getPanel() {
        return panel;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPuerta(Puerta puerta) {
        this.puerta = puerta;
    }

    public void setSensores(List<Sensor> sensores) {
        this.sensores = sensores;
    }

    public void setPanel(PanelControl panel) {
        this.panel = panel;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    // ToString
    @Override
    public String toString() {
        return "Ascensor{" +
                "id=" + id +
                ", pisoActual=" + pisoActual +
                ", direccion='" + direccion + '\'' +
                ", estado='" + estado + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }

    
}

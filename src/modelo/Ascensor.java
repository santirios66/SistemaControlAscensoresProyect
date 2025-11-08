package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ascensor {

    // Definición de los atributos de Ascensor
    private int id;
    private int pisoActual;
    private String direccion;
    private String estado;
    private Puerta puerta;
    private List<Sensor> sensores;
    private PanelControl panel;
    // Atributos adicionales extraídos del diagrama UML:
    private int pisoDestino; 
    private int capacidad; 
    private String indicador; 

    public Ascensor(int id, int pisoActual, String direccion, String estado, int capacidad){
        this.id = id;
        this.pisoActual = pisoActual;
        // Inicializamos estos valores por defecto en el constructor
        this.direccion = "detenido"; 
        this.estado = "detenido";
        this.capacidad = capacidad;
        this.puerta = new Puerta();
        this.sensores = new ArrayList<>();
        this.panel = new PanelControl();
        this.pisoDestino = pisoActual; // El destino inicial es el piso actual
        this.indicador = "Piso " + pisoActual; // Indicador inicial
    }

    public void moverA(int pisoDestino){
        this.pisoDestino = pisoDestino;
        // aquí aplicas la lógica de movimiento real
        System.out.println("Ascensor " + id + " moviéndose a piso " + pisoDestino);
        this.estado = "en movimiento";
        // Lógica para actualizar pisoActual y direccion durante el movimiento
    }

    public void abrirPuerta(){
        puerta.abrir();
        this.estado = "puerta abierta";
    }

    public void cerrarPuerta(){
        puerta.cerrar();
        this.estado = "detenido"; // Normalmente se detiene tras cerrar puertas
    }

    public void detener(){
        this.estado = "detenido";
        System.out.println("Ascensor " + id + " detenido.");
    }

    public void mostrarEstado(){
        System.out.println("Ascensor " + id + " en piso " + pisoActual + " estado: " + estado + " | Destino: " + pisoDestino + " | Capacidad: " + capacidad);
    }

    // Getters
    public int getId() { return id; }
    public int getPisoActual() { return pisoActual; }
    public String getDireccion() { return direccion; }
    public String getEstado() { return estado; }
    public Puerta getPuerta() { return puerta; }
    public List<Sensor> getSensores() { return sensores; }
    public PanelControl getPanel() { return panel; }
    public int getPisoDestino() { return pisoDestino; }
    public int getCapacidad() { return capacidad; }
    public String getIndicador() { return indicador; }

    // Setters
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public void setEstado(String estado) { this.estado = estado; }  
    public void setPisoActual(int pisoActual) { this.pisoActual = pisoActual; }
    public void setId(int id) { this.id = id; }
    public void setPuerta(Puerta puerta) { this.puerta = puerta; }
    public void setSensores(List<Sensor> sensores) { this.sensores = sensores; }
    public void setPanel(PanelControl panel) { this.panel = panel; }
    public void setPisoDestino(int pisoDestino) { this.pisoDestino = pisoDestino; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }
    public void setIndicador(String indicador) { this.indicador = indicador; }

    // ToString
    @Override
    public String toString() {
        return "Ascensor{" +
                "id=" + id +
                ", pisoActual=" + pisoActual +
                ", direccion='" + direccion + '\'' +
                ", estado='" + estado + '\'' +
                ", puerta=" + puerta +
                ", sensores=" + sensores +
                ", panel=" + panel +
                ", pisoDestino=" + pisoDestino +
                ", capacidad=" + capacidad +
                ", indicador='" + indicador + '\'' +
                '}';
    }
}

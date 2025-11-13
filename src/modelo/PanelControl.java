package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Rol: Contiene los botones internos del ascensor.
 * Relación: Composición con BotonAscensor.
 */
public class PanelControl {

    // Atributos
    private List<BotonAscensor> botones;

    // Constructor (idealmente se crea conociendo el total de pisos del edificio)
    public PanelControl(int totalPisos) {
        this.botones = new ArrayList<>();
        // Inicializa todos los botones del 1 al totalPisos
        for (int i = 1; i <= totalPisos; i++) {
            // Usamos 'i' como ID y como pisoDestino
            this.botones.add(new BotonAscensor(i, i));
        }
    }

    // Métodos

    /**
     * Busca y "presiona" el botón correspondiente al piso especificado.
     */
    public void presionarBoton(int pisoDestino) {
        for (BotonAscensor boton : botones) {
            if (boton.getPisoDestino() == pisoDestino) {
                boton.presionar(); // Llama al método sobrescrito del botón
                System.out.println(" Botón del piso " + pisoDestino + " encendido.");
                return; // Termina la búsqueda una vez presionado
            }
        }
        System.out.println("Error: El piso " + pisoDestino + " no existe o no tiene botón.");
    }

    // metodo para apagar la luz del boton cuando se llega al piso
    public void apagarLuzBoton(int pisoDestino) {
        for (BotonAscensor boton : botones) {
            if (boton.getPisoDestino() == pisoDestino) {
                boton.apagarLuz(); // Apaga la luz del botón
                System.out.println(" Luz del botón " + pisoDestino + " apagada.");
                return; // Termina la búsqueda una vez apagada la luz
            }
        }
        System.out.println("Error: El piso " + pisoDestino + " no existe o no tiene botón.");
    }

    /*
     * Muestra todas las opciones de pisos disponibles en el panel.
     */

    public void mostrarOpciones() {
        System.out.println("Opciones de pisoso disponibles");
        for (BotonAscensor boton : botones) {
            System.out.println("- piso " + boton.getPisoDestino() + (boton.isLuzEncendida() ? "Luz Encendida" : ""));
        }
    }

    // Getters
    public List<BotonAscensor> getBotones() {
        return botones;
    }

    /**
     * Establece una nueva lista de botones para el panel.
     * Reemplaza la lista actual por completo.
     * 
     * @param botones La nueva lista de BotonAscensor.
     */
    
    // Setters
    public void setBotones(List<BotonAscensor> botones) {
        this.botones = botones;
    }

    // toString
    @Override
    public String toString() {
        return "PanelControl{" +
                "cantidadBotones=" + botones.size() +
                '}';
    }

}

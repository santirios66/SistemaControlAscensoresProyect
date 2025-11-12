package modelo;

/**
 * Clase base para representar un botón genérico
 * que puede ser presionado y tiene una luz indicadora.
 * 
 * Esta clase será heredada por:
 * - BotonPiso
 * - BotonAscensor
 */
public class Boton {

    // Atributos

    private int id;
    private boolean luzEncendida;

    // Constructor
    public Boton(int id) {
        this.id = id;
        this.luzEncendida = false; // Por defecto, la luz está apagada
    }

    // Métodos para presionar el botón y controlar la luz
    public void presionar() {
        encenderLuz();
        System.out.println("Botón " + id + " presionado");
    }

    // Enciende la luz del botón
    public void encenderLuz() {
        luzEncendida = true;
        System.out.println("Luz del botón " + id + " encendida");
    }

    // Apaga la luz del botón
    public void apagarLuz() {
        luzEncendida = false;
        System.out.println("Luz del botón " + id + " apagada");

    }

    // getters
    public int getId() {
        return id;
    }

    public boolean isLuzEncendida() {
        return luzEncendida;
    }

    // toString
    @Override
    public String toString() {
        return "Boton{" +
                "id=" + id +
                ", luzEncendida=" + luzEncendida +
                '}';
    }

}

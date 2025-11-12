package modelo;

/**
 * Representa un botón ubicado en un piso (subir o bajar).
 * Hereda de la clase Boton.
 */
public class BotonPiso extends Boton {

    private String direccion; // "subir" o "bajar"

    // Constructor
    public BotonPiso(String direccion) {
        // Llamamos al constructor del padre con un id 
        super(direccion.equals("subir") ? 1 : 2);
        this.direccion = direccion;
    }

    // Sobrescribimos el método presionar() de la clase padre
    @Override
    public void presionar() {
        super.presionar(); // Enciende la luz y muestra mensaje del padre
        System.out.println("Botón de piso (" + direccion + ") presionado. Solicitando ascensor hacia " + direccion);
        
    }

    // Getter
    public String getDireccion() {
        return direccion;
    }

    // toString
    @Override
    public String toString() {
        return "BotonPiso{" +
                "direccion='" + direccion + '\'' +
                ", luzEncendida=" + isLuzEncendida() +
                '}';
    }
}

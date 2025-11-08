package modelo;

/**
 * Representa un piso del edificio.
 */
public class Piso {

    // Numero del piso
    private int numero;

    // Botones del piso
    protected BotonPiso botonSubir;
    protected BotonPiso botonBajar;

    // Constructor
    public Piso(int numero) {
        this.numero = numero;
        this.botonSubir = new BotonPiso("subir");
        this.botonBajar = new BotonPiso("bajar");
    }

    // Getters
    public int getNumero() { return numero; }
    public BotonPiso getBotonSubir() { return botonSubir; }
    public BotonPiso getBotonBajar() { return botonBajar; }

    // Método para solicitar el ascensor
    public void solicitarAscensor(String direccion) {
        System.out.println("Piso " + numero + " solicita ascensor hacia " + direccion);
    }

    @Override
    public String toString() {
        return "Piso{" +
                "numero=" + numero +
                '}';
    }
}

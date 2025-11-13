package modelo;

//Representa un piso del edificio.
    public class Piso {

    private int numero;
    private BotonPiso botonSubir;
    private BotonPiso botonBajar;

    // Constructor
    public Piso(int numero) {
        this.numero = numero;
        this.botonSubir = new BotonPiso("subir");
        this.botonBajar = new BotonPiso("bajar");
    }

    // Método para solicitar el ascensor
// Clase Piso
public boolean solicitarAscensor(String direccion, int totalPisos) {
    if (direccion.equalsIgnoreCase("subir") && numero == totalPisos) {
        System.out.println("ERROR: No se puede subir del último piso (" + numero + ").");
        return false; // solicitud inválida
    }
    if (direccion.equalsIgnoreCase("bajar") && numero == 1) {
        System.out.println("ERROR: No se puede bajar del primer piso (" + numero + ").");
        return false; // solicitud inválida
    }

    if (direccion.equalsIgnoreCase("subir")) {
        botonSubir.presionar();
    } else if (direccion.equalsIgnoreCase("bajar")) {
        botonBajar.presionar();
    } else {
        System.out.println("Dirección no válida. Usa 'subir' o 'bajar'.");
        return false;
    }

    return true; // solicitud válida
}

    // Getters
    public int getNumero() { return numero; }
    public BotonPiso getBotonSubir() { return botonSubir; }
    public BotonPiso getBotonBajar() { return botonBajar; }

    // toString
    @Override
    public String toString() {
        return "Piso{" +
                "numero=" + numero +
                ", botonSubir=" + botonSubir +
                ", botonBajar=" + botonBajar +
                '}';
    }
}


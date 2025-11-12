package modelo;

// Representa un usuario del sistema que puede usar el ascensor
public class Usuario {

    private String nombre;
    private TarjetaAcceso tarjeta;
    private int pisoActual;
    private int pisoDestino;

    // Constructor principal (usuario con tarjeta)
    public Usuario(String nombre, TarjetaAcceso tarjeta, int pisoActual) {
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.pisoActual = pisoActual;
        this.pisoDestino = pisoActual;
    }

    // Constructor opcional (usuario sin tarjeta)
    public Usuario(String nombre, int pisoActual) {
        this(nombre, null, pisoActual);
    }

    // Solicita el ascensor en una dirección
    public void solicitarAscensor(String direccion) {
        System.out.println(nombre + " solicita el ascensor para " + direccion + " desde el piso " + pisoActual);
    }

    // Selecciona el piso al que desea ir
    public void seleccionarPiso(int piso) {
        this.pisoDestino = piso;
        System.out.println(nombre + " selecciona el piso " + pisoDestino);
    }

    // Usa su tarjeta de acceso
    public void usarTarjeta() {
        if (tarjeta != null && tarjeta.validarAcceso()) {
            System.out.println(nombre + " ha validado su acceso con la tarjeta.");
        } else {
            System.out.println(nombre + " no tiene acceso o la tarjeta no es válida.");
        }
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public TarjetaAcceso getTarjeta() {
        return tarjeta;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    // Setters
    public void setPisoActual(int pisoActual) {
        this.pisoActual = pisoActual;
    }

    public void setPisoDestino(int pisoDestino) {
        this.pisoDestino = pisoDestino;
    }

    // toString simple
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", pisoActual=" + pisoActual +
                ", pisoDestino=" + pisoDestino +
                '}';
    }
}

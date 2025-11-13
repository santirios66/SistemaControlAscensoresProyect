package modelo;

import seguridad.TarjetaAcceso;
// Importa la clase TarjetaAcceso

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
public void solicitarAscensor(Edificio edificio, String direccion) {
    Piso piso = edificio.getPisos().get(pisoActual - 1);

    // Presiona el botón y verifica si es válido
    boolean valido = piso.solicitarAscensor(direccion, edificio.getPisos().size());
    if (!valido) {
        System.out.println(nombre + " no puede solicitar el ascensor hacia " + direccion);
        return; // corta la ejecución aquí
    }

    System.out.println(nombre + " solicita el ascensor hacia " + direccion);

    Ascensor ascensor = edificio.getAscensorCercano(pisoActual);
    if (ascensor != null) {
        ascensor.moverA(pisoActual);
        ascensor.llegarAlPiso(piso);
        System.out.println(nombre + " entra al ascensor " + ascensor.getId());
    } else {
        System.out.println("No hay ascensores disponibles.");
    }
}

    public void irAPisoDestino(int pisoDestino, Ascensor ascensor, Edificio edificio) {
    // 1 Selecciona el piso
    seleccionarPiso(pisoDestino);

    //  Presiona botón interno y enciende luz
    ascensor.getPanel().presionarBoton(pisoDestino);
    System.out.println(" Botón del piso " + pisoDestino + " encendido en el panel del ascensor " + ascensor.getId());

    //  Mueve el ascensor al piso destino
    ascensor.moverA(pisoDestino);

    //  Llega al piso y abre puerta
    ascensor.llegarAlPiso(edificio.getPisos().get(pisoDestino - 1));

    //  Apaga la luz del botón al llegar
    System.out.println(" Luz del botón " + pisoDestino + " apagada (llegó al destino).");

    //  Actualiza piso actual del usuario
    this.pisoActual = pisoDestino;
    System.out.println(getNombre() + " ha llegado al piso " + pisoDestino + " y sale del ascensor.");
}


    // Selecciona el piso al que desea ir
    public void seleccionarPiso(int piso) {
        this.pisoDestino = piso;
        System.out.println(nombre + " selecciona el piso " + pisoDestino);
    }

    // Usa su tarjeta de acceso
    public void usarTarjeta() {
        if (tarjeta == null) {
            System.out.println(nombre + " no tiene tarjeta de acceso.");
        } else {
            // Para la simulación básica asumimos que la tarjeta registrada
            // permite acceso; validaciones más estrictas se realizan en
            // módulos de seguridad si es necesario.
            System.out.println("Accesso concedido para " + nombre + " con tarjeta: " + tarjeta);
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTarjeta(TarjetaAcceso tarjeta) {
        this.tarjeta = tarjeta;
    }

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

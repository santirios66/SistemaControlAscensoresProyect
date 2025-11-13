package seguridad;

/**
 * Representa una tarjeta de acceso usada por el usuario
 * para validar permisos dentro del edificio.
 */
public class TarjetaAcceso {

    // --- Enum para niveles de acceso ---
    public enum NivelAcceso {
        BASICO,
        MEDIO,
        ADMINISTRADOR
    }

    // --- Atributos ---
    private final String codigo; // Código único no puede cambiar
    private final NivelAcceso nivelAcceso; // Nivel de permisos segun enum

    // --- Constructor con validación ---
    public TarjetaAcceso(String codigo, NivelAcceso nivelAcceso) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("El código no puede ser nulo o vacío");
        }
        if (nivelAcceso == null) {
            throw new IllegalArgumentException("El nivel de acceso no puede ser nulo");
        }

        this.codigo = codigo;
        this.nivelAcceso = nivelAcceso;
    }

    // --- Método para validar acceso ---
    public boolean validarAcceso(NivelAcceso nivelRequerido) {
        // Manejo seguro en caso de parámetros nulos
        if (nivelRequerido == null) {
            // Si no se especifica nivel requerido, asumimos que la tarjeta
            // solo necesita existir para permitir alguna operación.
            return this.nivelAcceso != null;
        }

        // Orden lógico de seguridad: ADMINISTRADOR > MEDIO > BASICO
        // El método ordinal() devuelve la posición en el enum (BASICO=0, MEDIO=1, ADMIN=2)
        if (this.nivelAcceso == null) return false;
        return this.nivelAcceso.ordinal() >= nivelRequerido.ordinal();
    }

    // --- Getters ---
    public String getCodigo() {
        return codigo;
    }

    public NivelAcceso getNivelAcceso() {
        return nivelAcceso;
    }

    // --- toString ---
    @Override
    public String toString() {
        return "TarjetaAcceso{" +
                "codigo='" + codigo + '\'' +
                ", nivelAcceso=" + nivelAcceso +
                '}';
    }
}
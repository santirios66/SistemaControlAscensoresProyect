package modelo;

/**
 * Clase auxiliar para poblar un edificio con pisos.
 * Centraliza la lógica de creación de pisos para evitar bucles
 * repetidos en distintos puntos del código (como el `main`).
 */
public final class CreadorPisos {

    private CreadorPisos() {
        // Prevent instantiation
    }

    /**
     * Crea y agrega los pisos numerados del 1 hasta totalPisos en el edificio dado.
     *
     * @param edificio   Edificio donde se agregarán los pisos
     * @param totalPisos cantidad de pisos a crear debe ser >= 1
     */
    public static void poblarEdificio(Edificio edificio, int totalPisos) {
        if (edificio == null) {
            throw new IllegalArgumentException("El edificio no puede ser null");
        }
        if (totalPisos < 1) {
            throw new IllegalArgumentException("El total de pisos debe ser >= 1");
        }

        for (int i = 1; i <= totalPisos; i++) {
            Piso piso = new Piso(i);
            edificio.agregarPiso(piso);
        }
    }
}

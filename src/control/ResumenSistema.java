package control;

import modelo.*;

/**
 * Clase auxiliar para generar resúmenes sencillos del sistema
 * y mostrar el estado de ascensores con una sola llamada desde el main.
 */
public final class ResumenSistema {

    private ResumenSistema() {}

    /**
     * Muestra un resumen del edificio y sus ascensores.
     */
    public static void mostrarResumen(Edificio edificio) {
        if (edificio == null) {
            System.out.println("Edificio: null");
            return;
        }

        System.out.println("=== RESUMEN EDIFICIO: " + edificio.getNombre() + " ===");
        System.out.println("Pisos: " + edificio.getPisos().size());
        System.out.println("Ascensores: " + edificio.getAscensores().size());

        for (Ascensor a : edificio.getAscensores()) {
            mostrarAscensor(a);
        }
        System.out.println("=========================================");
    }

    /**
     * Muestra la información más relevante de un ascensor de forma compacta.
     */
    public static void mostrarAscensor(Ascensor a) {
        if (a == null) {
            System.out.println("Ascensor: null");
            return;
        }

        String info = String.format("Ascensor[id=%d, piso=%d, estado=%s, dir=%s, capacidad=%d]",
                a.getId(), a.getPisoActual(), a.getEstado(), a.getDireccion(), a.getCapacidad());

        System.out.println(info);
    }
}

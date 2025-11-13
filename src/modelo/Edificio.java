package modelo;

import java.util.ArrayList;
import java.util.List;

//Representa un edificio que contiene pisos y ascensores.

public class Edificio {

    // Atributos
    private final String nombre;
    private final List<Piso> pisos;
    private final List<Ascensor> ascensores;

    // Constructor
    public Edificio(String nombre) {
        this.nombre = nombre;
        this.pisos = new ArrayList<>();
        this.ascensores = new ArrayList<>();

    }

    /**
     * Crea y agrega los pisos numerados del 1 hasta totalPisos en el edificio dado.
     *
     * @param edificio   Edificio donde se agregarán los pisos
     * @param totalPisos cantidad de pisos a crear debe ser >= 1
     */
    public void crearPisos(int totalPisos) {
        for (int i = 1; i <= totalPisos; i++) {
            this.agregarPiso(new Piso(i));
        }
    }

    // Agregar piso
    public void agregarPiso(Piso piso) {
        pisos.add(piso);
    }

    // Agregar ascensor
    public void agregarAscensor(Ascensor ascensor) {
        ascensores.add(ascensor);
    }

    // Devuelve el ascensor más cercano al piso indicado.

    public Ascensor getAscensorCercano(int pisoActual) {
        if (ascensores.isEmpty()) {
            return null;
        }

        Ascensor mejor = ascensores.get(0);
        int dist = Math.abs(mejor.getPisoActual() - pisoActual);

        for (Ascensor a : ascensores) {
            int d = Math.abs(a.getPisoActual() - pisoActual);
            if (d < dist) {
                dist = d;
                mejor = a;
            }
        }

        return mejor;
    }

    // Muestra estado del edificio
    public void mostrarEstado() {
        System.out.println("=== RESUMEN EDIFICIO: " + nombre + " ===");
        System.out.println("Pisos: " + pisos.size());
        System.out.println("Ascensores: " + ascensores.size());
        for (Ascensor a : ascensores) {
            a.mostrarEstado();
        }
        System.out.println("=========================================");
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<Piso> getPisos() {
        return pisos;
    }

    public List<Ascensor> getAscensores() {
        return ascensores;
    }

    // toString
    @Override
    public String toString() {
        return "Edificio{" +
                "nombre='" + nombre + '\'' +
                ", pisos=" + pisos.size() +
                ", ascensores=" + ascensores.size() +
                '}';
    }
}

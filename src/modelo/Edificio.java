package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un edificio que contiene pisos y ascensores.
 */
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

    // Agregar piso
    public void agregarPiso(Piso piso) {
        pisos.add(piso);
    }

    // Agregar ascensor
    public void agregarAscensor(Ascensor ascensor) {
        ascensores.add(ascensor);
    }

    /**
     * Devuelve el ascensor más cercano al piso indicado.
     */
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
        System.out.println("=== Edificio " + nombre + " ===");
        for (Ascensor a : ascensores) {
            a.mostrarEstado();
        }
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

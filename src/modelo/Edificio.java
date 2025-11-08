package modelo;

import java.util.ArrayList;
import java.util.List;

public class Edificio {

    // Definicion de los Atributos.

    private final String nombre; // Nombre del edificio.
    private final List<Piso> piso; // Lista de pisos
    private final List<Ascensor> ascensores; // Lista de ascensores.

    // Constructor del edifico.
    public Edificio(String nombre) {
        this.nombre = nombre;
        this.pisos = new ArrayList<>();
        this.ascensores = new ArrayList<>();

    }

    // Agregar un piso al edificio.
    public void agregarPiso(Piso piso) {
        pisos.add(piso);
    }

    // Agrega un ascensor al edifico.
    public void agregarAscensor(Ascensor ascensor){ascensor.add(ascensor)}

    // Este metodo devuelve le ascensor mas cercano al piso indicado
    public Ascensor getAscensorCercano(int pisoActual){if(ascensores.esImpty()){return null}}

    Ascensor mejor = ascensor.get(0); // Asumimos que el primer ascensor es el mejor inicialmente.
    int dist = Math.abs(mejor.getPisoActual() - pisoActual); // Distancia inicial.

    // Recorremos la lista de ascensores para encontrar el mas cercano.
    for(
    Ascensor a:ascensores)
    {
        int d = Math.abs(a.getPisoActual() - pisoActual);
        if (d < dist) {
            dist = d;
            mejor = a;
        }
    }return mejor;

    // Muestra el estado genral del edificio.

    public void mostrarEstado(){
        System.out.println("=== Edificio " + nombre + "===");
        for (Ascensor a : ascensores){
            a.mostrarEstado();
        }
    }

    //Getters

    public String getNombre(){
        return nombre;
    }

    public List<Piso> getPisos(){
        return pisos;
    }

    public List<Ascensor> getAscensores(){
        return ascensores;
    }


}
package control;

import java.util.ArrayList;
import java.util.List;
import util.RegistroEventos; // Importo la clase del paquete util

/**
 * Clase que nos sirve para la gestion de alertas de emergencias o falla en el
 * sistema del edifico
 * Maneja emergencia o fallas.
 * ESTA clase tiene un agregacion con RegistroEventos.
 */

public class GestorAlertas {
    // Atributos
    // Listas para almacenar los mensajes de alertas activos.
    private List<String> alertas; // Corregida la 'P' mayúscula
    /**
     * relacion de agregacion con RegistroEventos.
     * La clase GestorAlertas utiliza una instancia de RegistroEventos para
     * registrar eventos importantes.
     */
    private RegistroEventos registroEventos;

    // Constructor

    /**
     * Constructor para inicializar el GestorAlertas.
     * 
     * @param registroEventos La instancia de RegistroEventos a utilizar para
     *                        loguear.
     */
    public GestorAlertas(RegistroEventos registroEventos) {
        this.alertas = new ArrayList<>();
        // Inyectamos la dependencia (agregación)
        this.registroEventos = registroEventos;
    }

    // Metodos
    /**
     * Envia una alerta al sistema y la registra com un evento.
     * 
     * @param mensaje El mensaje de la alerta.
     */

    public void enviarAlerta(String mensaje) {
        // aqui añade la alerta a la lista de alertas activas
        this.alertas.add(mensaje);

        // Imprime un mensaje en consola para simular el envio
        System.out.println("ALERTA ENVIADA : " + mensaje);

        // aqui registra el evento usando la clase RegistroEventos
        if (this.registroEventos != null) {
            this.registroEventos.registrarEvento("ALERTA CRITICA : " + mensaje); // Corregido: registrarEvento
        }
    }

    /** 
     * Registra un tipo de eventos especificos ene le sistema de registro.
     * 
     * @param tipo El tipo de evento a registrar por ejemplo un fallo de sensor o la puerta abierta.
     */

     public void registrarEvento(String tipo) { // Corregido: public en lugar de publlic
        // Usa la instancia de RegistroEventos para realizar el log
        if (this.registroEventos != null) {
            this.registroEventos.registrarEvento("EVENTO : " + tipo); // Corregido: registrarEvento
        }else{
            // en este caso solo ocurriria si el obejcto resgistroEventos se pasara com null
            System.err.println("No se pudo registrar el evento: Objeto RegistroEventos es nulo.");
        }
     }

      // Getters  

    /**
     * Obtiene la lista actual de alertas activas.
     * @return La lista de alertas.
     */
    public List<String> getAlertas() {
        return alertas;
    }

    /**
     * Obtiene la instancia del registro de eventos asociada.
     * @return El objeto RegistroEventos.
     */
    public RegistroEventos getRegistroEventos() {
        return registroEventos;
    }

    //Setters 
    /**
     * Establece una nueva instancia de RegistroEventos (Setter).
     * @param registroEventos El nuevo objeto RegistroEventos.
     */
    public void setRegistroEventos(RegistroEventos registroEventos) {
        this.registroEventos = registroEventos;
    }

    // toString() 

    @Override
    public String toString() {
        return "GestorAlertas{" +
                "alertasPendientes=" + alertas.size() +
                ", registroEventosAsociado=" + (registroEventos != null ? "Si" : "No") +
                '}';
    }

}
package modelo;

public class Puerta {

    private boolean abierta; // true = abierta false = cerrada
    private Sensor sensorObstaculo;

    // Constructor
    public Puerta() {
        this.abierta = false;
        this.sensorObstaculo = new Sensor("obstaculo"); //Composición: la puerta crea y posee su propio sensor
    }

    // Metodos

public void abrir() {
        abierta = true;
        System.out.println("Puerta abierta");
    
}


     //Intenta cerrar la puerta. Si el sensor detecta un obstáculo,
     //no permite el cierre y muestra una advertencia.
    public void cerrar() {
        if (sensorObstaculo.detectar()) {
            System.out.println("Obstaculo detectado: la puerta no puede cerrarse.");
        } else {
            abierta = false;
            System.out.println("Puerta cerrada.");
        }
    }

    //Verifica si el sensor detecta un obstáculo.
    public boolean detectarObstaculo() {
        return sensorObstaculo.detectar();
    }

    // Getters
    public boolean isAbierta() {
        return abierta;
    }

    public Sensor getSensorObstaculo() {
        return sensorObstaculo;
    }

    @Override
    public String toString() {
        return "Puerta{" +
                "abierta=" + abierta +
                ", sensorObstaculo=" + sensorObstaculo +
                '}';
    }

}

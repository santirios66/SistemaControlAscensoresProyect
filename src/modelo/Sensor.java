package modelo;

// esta clase Sensor es la encargada de detectar obstaculos o condiciones especificas en la clase puerta.
public class Sensor {

    //atributos 
    private String tipo; // tipo de sensor por ejemplo Obstaculo o el peso e.t.c.
    private boolean activo; // este atributo indica si el sensor esta detectando algo.
    //construcutor
    public Sensor(String tipo){
        this.tipo = tipo;
        this.activo = false; // Por defecto, el sensor no está detectando nada
    }

    //Metodos 
    public boolean detectar(){
        // Simula detección aqui devuelve true si hay obstáculos.
        System.out.println("Sensor de " + tipo + " detectando....");
        return activo;
    }

    public void activar(){
        activo = true;
        System.out.println("Sensor de " + tipo + " ACTIVADO");
    }

    public void desactivar(){
        activo = false;
        System.out.println("Sensor de " + tipo + " DESACTIVADO.");
    }

    //Getters
    public String getTipo(){return tipo;}
    public boolean isActivo(){return activo;}

    //Setters
    public void  setTipo(String tipo){this.tipo = tipo;}
    public void setActivo(boolean activo){this.activo = activo;}

     // toString
    @Override
    public String toString() {
        return "Sensor{" +
                "tipo='" + tipo + '\'' +
                ", activo=" + activo +
                '}';
    }
    
}

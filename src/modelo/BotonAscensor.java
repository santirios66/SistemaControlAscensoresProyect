package modelo;

public class BotonAscensor extends Boton {
    private int pisoDestino; // piso que el ascensor debe ir;

    //Constructor
    public BotonAscensor(int id,int pisoDestino){
        super(id);
        this.pisoDestino = pisoDestino;
    }

    //Sobrescribimos el método presionar() de la clase padre
    @Override
    public void presionar(){
        super.presionar();
        System.out.println("Boton del ascensor presionado. solicitando ir al piso " + pisoDestino);
    }
        // Getter
    public int getPisoDestino() {
        return pisoDestino;
    }

    // Setter
    public void setPisoDestino(int pisoDestino) {
        this.pisoDestino = pisoDestino;
    }

    // toString
    @Override
    public String toString() {
        return "BotonAscensor{" +
                "pisoDestino=" + pisoDestino +
                ", id=" + getId() +
                ", luzEncendida=" + isLuzEncendida() +
                '}';
    }
}

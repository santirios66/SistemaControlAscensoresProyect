import modelo.*;
import control.*;
import seguridad.*;
import util.*;

public class ejecutar{
    public static void main(String[] args) {

        System.out.println("=== Simulador detallado del ascensor ===");

        // 1) Crear edificio y pisos
        Edificio edificio = new Edificio("Edificio Central");
        edificio.crearPisos(10);

        // 2) Crear un ascensor principal
        Ascensor ascensor = new Ascensor(1, 8, edificio.getPisos().size());
        edificio.agregarAscensor(ascensor);

        // 3) Instanciar sistema de control
        SistemaControl sistema = new SistemaControl(edificio);
        RegistroEventos registro = sistema.getRegistroEventos();

        // 4) Crear actores usuarios con y sin tarjeta
        TarjetaAcceso tarjetaSantiago = new TarjetaAcceso("UML2", TarjetaAcceso.NivelAcceso.ADMINISTRADOR);
        Usuario santiago = new Usuario("santiago", tarjetaSantiago, 1);
        Usuario maria = new Usuario("maria", 5);

        // 5) Mostrar resumen inicial
        edificio.mostrarEstado();
        // 6) Escenario: varios usuarios solicitan el ascensor en secuencia
        System.out.println("\n--- solicitudes iniciales ---");
        // santiago solicita desde el psio uno para subir
        santiago.solicitarAscensor(edificio, "subir");
        System.out.println("--- santiago dentro del ascensor va al piso 7 ---");
        sistema.getGestorSolicitudes().registrarSolicitud(santiago.getPisoActual(), "subir");
        santiago.irAPisoDestino(7, ascensor, edificio);
        // maria solicita desde el piso 5 para bajar
        System.out.println("--- maria solicita desde el piso 5 para bajar ---");
        maria.solicitarAscensor(edificio, "bajar");
        sistema.getGestorSolicitudes().registrarSolicitud(maria.getPisoActual(), "bajar");
        System.out.println("--- maria dentro del ascensor va al piso 2 ---");
        maria.irAPisoDestino(2, ascensor, edificio);

        // 7) Mostrar resumen final
        edificio.mostrarEstado();


        
        System.out.println("\n=== Escenario de solicitud inválida ===");
        //usuario itnenta subir en el piso 10 cuando el ascensor esta en el piso 8
        Usuario juan = new Usuario("juan", 10);
        juan.solicitarAscensor(edificio, "subir");
        sistema.getGestorSolicitudes().registrarSolicitud(juan.getPisoActual(), "subir");


    }


    }

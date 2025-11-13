import modelo.*;
import control.*;
import seguridad.*;
import util.*;

/**
 * Simulador enfocado en el funcionamiento de los ascensores.
 * Utiliza la mayoría de las clases del proyecto pero centra la
 * simulación en la operación del ascensor (pedidos, panel,
 * puertas, sensores, alertas y mantenimiento).
 */
public class SimuladorSistemaAscensores {

	public static void main(String[] args) {
		System.out.println("=== Simulador detallado del ascensor ===");

		// Parámetros de la simulación
		int totalPisos = 8;
		int idAscensorPrincipal = 1;
		int capacidadAscensor = 6;

		// 1) Crear edificio y pisos
		Edificio edificio = new Edificio("Torre Central");
		CreadorPisos.poblarEdificio(edificio, totalPisos);

		// 2) Crear un ascensor principal 
		Ascensor ascensor = new Ascensor(idAscensorPrincipal, capacidadAscensor, totalPisos);
		edificio.agregarAscensor(ascensor);

		// 3) Instanciar sistema de control 
		SistemaControl sistema = new SistemaControl(edificio);
		RegistroEventos registro = sistema.getRegistroEventos();

		// 4) Crear actores usuarios con y sin tarjeta
		TarjetaAcceso tarjetaAdmin = new TarjetaAcceso("ADM-900", TarjetaAcceso.NivelAcceso.ADMINISTRADOR);
		Usuario uAna = new Usuario("Ana", 2);
		Usuario uLuis = new Usuario("Luis", 6);
		Usuario uAdmin = new Usuario("Roberto", tarjetaAdmin, 1);
		Usuario uCarla = new Usuario("Carla", 5);

		// 5) Mostrar resumen inicial
		System.out.println("Estado inicial:");
		ResumenSistema.mostrarResumen(edificio);

		// 6) Escenario: varios usuarios solicitan el ascensor en secuencia
		System.out.println("\n--- solicitudes iniciales ---");
		solicitarYProcesar(sistema, edificio, uAna, "subir"); // Ana en piso 2 solicita subir
		solicitarYProcesar(sistema, edificio, uLuis, "bajar"); // Luis en piso 6 solicita bajar

		// 7) Asignamos y procesamos la cola explícitamente (simulando tiempo)
		System.out.println("Asignando ascensores a solicitudes pendientes...");
		sistema.getGestorSolicitudes().mostrarSolicitudes();
		Ascensor asignado1 = sistema.getGestorSolicitudes().asignarAscensor();

		// 8) Simulación del embarque en ascensor asignado
		if (asignado1 != null) {
			System.out.println("Usuario entrando y seleccionando destino...");
			asignado1.abrirPuerta();
			// supongamos Ana entró y selecciona piso 7
			uAna.seleccionarPiso(7);
			asignado1.getPanel().presionarBoton(uAna.getPisoDestino());
			// Mantener puerta abierta 2 segundos y luego mover
			asignado1.mantenerPuertaAbierta(2);
			// Mover tras mantenerla abierta (no bloqueante; su estado ya fue actualizado por temporizador)
			asignado1.moverA(uAna.getPisoDestino());
			asignado1.abrirPuerta();
			asignado1.cerrarPuerta();
		}

		// 9) Simular que durante el cierre de puertas se detecta un obstáculo
		System.out.println("\n---  obstáculo en puerta ---");
		ascensor.abrirPuerta();
		// Activar sensor de obstáculo de la puerta
		ascensor.getPuerta().getSensorObstaculo().activar();
		ascensor.cerrarPuerta(); // debe detectar y no cerrarse
		ascensor.getPuerta().getSensorObstaculo().desactivar();

		// 10) Otro usuario hace una solicitud mientras tanto
		System.out.println("\n---  nueva solicitud y uso del panel interno ---");
		solicitarYProcesar(sistema, edificio, uCarla, "bajar");
		sistema.getGestorSolicitudes().mostrarSolicitudes();
		Ascensor asignado2 = sistema.getGestorSolicitudes().asignarAscensor();

		if (asignado2 != null) {
			// Simular entrada y selección desde panel del ascensor
			asignado2.abrirPuerta();
			uCarla.seleccionarPiso(1);
			asignado2.getPanel().presionarBoton(uCarla.getPisoDestino());
			asignado2.cerrarPuerta();
			asignado2.moverA(uCarla.getPisoDestino());
		}

		// 11) Un administrador revisa accesos y solicita mantenimiento
		System.out.println("\n---  acceso y mantenimiento ---");
		System.out.println("Administrador intentando acceso:");
		uAdmin.usarTarjeta();

		// Forzamos una falla para demostrar el gestor de mantenimiento
		if (!edificio.getAscensores().isEmpty()) {
			Ascensor a = edificio.getAscensores().get(0);
			sistema.getGestorMantenimiento().reportarFalla(a, "Sensor de puerta con lecturas erráticas");
		}

		sistema.getGestorMantenimiento().programarRevision();

		// 12) Generar alerta de prueba y registrar en eventos
		sistema.getGestorAlertas().enviarAlerta("Prueba de conexión con central de mantenimiento.");
		registro.registrarEvento("Simulación paso intermedio completado.");

		// 13) Usar temporizador para simular espera breve
		System.out.println("\nEsperando 1 segundo para simular tiempo operativo (Temporizador)...");
		Temporizador temporizador = new Temporizador(1);
		temporizador.iniciar();

		// 14) Mostrar resumen final y listar eventos para entregar evidencia
		System.out.println("\nResumen final del sistema:");
		ResumenSistema.mostrarResumen(edificio);

		System.out.println("\nEventos registrados (detalle):");
		for (String e : registro.mostrarEventos()) {
			System.out.println(" - " + e);
		}

		// Asegurar que temporizadores se detengan (limpieza)
		temporizador.shutdown();

		// 15) Concluir simulación
		System.out.println("\nSimulación del ascensor finalizada. Logs registrados: " + registro.mostrarEventos().size());
	}

	// Helper hace que un usuario solicite el ascensor y el sistema procese la solicitud
	private static void solicitarYProcesar(SistemaControl sistema, Edificio edificio, Usuario usuario, String direccion) {
		Piso piso = edificio.getPisos().get(usuario.getPisoActual() - 1);
		usuario.solicitarAscensor(direccion);
		sistema.procesarSolicitud(piso, direccion);
	}
}


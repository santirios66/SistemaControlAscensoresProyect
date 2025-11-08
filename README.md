# SistemaControlAscensores
Proyecto final de Programación Orientada a Objetos – Sistema de Control de Ascensores.
#  Sistema de Control de Ascensores  
**  Autor: ** Santiago Patiño Rios 
**  Maestro:   **  Jhon Haide Cano Beltran
**Materia:** Programación Orientada a Objetos  
**Universidad Cooperativa de Colombia – Campus Cali**  
**Fecha:** Noviembre de 2025


1. Entendimiento del problema

El sistema de control de ascensores debe simular el comportamiento de un ascensor en un edificio en el cual debe manejar esta funciones:

- Botones en los pisos para subir o bajar.
- Botones dentro del ascensor para elejir el piso.
- Movimiento del ascensor segun las solicitudes.
- Control automatico de puerta la cuales tendran sensores.
- Alertas en caso del que el ascensor tenga fallas o emergencias.

Objectivo 
El objectivo general del programa  es diseñar un sistema en Java  que simule el funcionamiento de un ascensor real aplicando los conceptos de la POO.

2. Analisis de los requerimientos

- Botones de piso  : los cuales nos permiten solicitar el ascensor en dirrecion de subida o baja. 
- Botones dentro del ascensor  : los cuales nos permiten elejir el psio de destino.
- indicadores : Cada boton dbe encender una luz y emitir un sonido al ser precionado.
- Dirrecion del ascensor : El cual debe optimizar el movimiento del ascensor las cuales va atender  primero las solictudes en la misma direccion.
- Funcionamiento de las puertas : Se abren y se cierran automaticamnete y detectan si hay obstaculos mediante los sensores.
- Boton de Mantenar puertas abiertas : Este boton nos permite  que las puerta permanezcan  abiertas mas tiempo si el usuario lo desea.
- Alertas de emergencias : SI hay fallos, sistema dbe detenerse y enviar una notificacion a mantenimento.

3. DIseño de la solucion
El sistema lo diseñe basado en los principios  de POO  en la cual cada
clase representa un componente del sisteme(ascensor, piso,puertas,boton,sensor, etc.) con una responsabilidad bien definida.
Use encapsulacion para proteger los atributos, La herencia para especilizar los comportamientos y el polimorfismo para tratar los objectos similares de forma generica a continuacion le mostrare  la Estructura del proyecto :
 
 ├── control/
 │   ├── SistemaControl.java
 │   ├── GestorSolicitudes.java
 │   ├── GestorAlertas.java
 │   └── GestorMantenimiento.java
 │
 ├── modelo/
 │   ├── Ascensor.java
 │   ├── Piso.java
 │   ├── Puerta.java
 │   ├── Sensor.java
 │   ├── Boton.java
 │   ├── BotonPiso.java
 │   ├── BotonAscensor.java
 │   └── PanelControl.java
 │
 ├── seguridad/
 │   ├── Camara.java
 │   ├── Alarma.java
 │   └── TarjetaAcceso.java
 │
 └── util/
     ├── RegistroEventos.java
     └── Temporizador.java

3.1 Diagrama de Clases
Puedes ver el diagrama de clases en el siguiente enlace:
https://drive.google.com/file/d/10fuQ6SHinCCnNGOlyYH4MpD3VrV2hwXd/view?usp=sharing

Clases principales :

- SistemaControl : encargada de cordinar todas la operaciones(Administar ascensores, solicitudes, alertas y mantenimiento.
- GestorSolicitudes : Esta clase recibe  las peticiones de los botones y decide que ascensor debe responder segun su ubicacion y direcion actual.
- GestorMantenimiento : Esta clase registra las fallas, revisiones y estado del sistema.
- Puerta : controla la apertura y cierre automatico, Uilizando sensores para evitar accidentes.
- Boton - BotonPis Estas clases modelan las solicitudes del usuario, Heredan de una clase madre boton, y aqui aplique la Herencia y polimorfismo.
- Sensor : El cual decteta el peso , obstaculos y informa al sistema si algo falla.
- RegistroEventos : Guarda en un log las acciones y eventos del sistema (llamadas, movimientos, alertas).

4. Funcionamiento del Sistema
-El usuario presiona un botón de piso para subir o bajar.
-El SistemaControl recibe la solicitud y el GestorSolicitudes asigna el ascensor más cercano.
-El ascensor se mueve automáticamente al piso solicitado.
-Al llegar, las puertas se abren; los sensores verifican si hay obstáculos.
-El usuario entra y selecciona su destino con el panel interno.
-El sistema optimiza el recorrido, atendiendo los pisos en orden.
-Si ocurre una falla, el ascensor se detiene, las puertas se abren y el GestorAlertas envía la notificación a mantenimiento.

Conclusión
en conclusion el desarrollo del Sistema de Control de Ascensores me ayudo aplicar de forma practica los conceptos de POO en java, simulando un entorno real y muy completo. Este proyecto  demuestra como  la abstraccion y la modularidad facilitan el mantenimiento , la escalabilidad y la claridad del codigo.

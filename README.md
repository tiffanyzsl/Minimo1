# Entrega Mínimo 1 DSA

## Estado actual y qué funciona
El proyecto está terminado y las dos partes principales funcionan bien:
- **Parte I:** Toda la lógica está implementada. He usado el patrón Singleton para el Manager, una Pila (Stack) para calcular la notación polaca inversa y la estructura adecuada para la cola de operaciones. Los tests de JUnit pasan todos en verde y he puesto las trazas con Log4j (sin usar System.out.println).
- **Parte II:** El servidor REST arranca y todos los endpoints que se pedían procesan bien las peticiones.

## Problemas encontrados durante el desarrollo
El mayor problema que he tenido ha sido un error crítico de dependencias al intentar arrancar el servidor Grizzly: me saltaba todo el rato `Unsupported class file major version 71`. 
Investigando, vi que era un problema de compatibilidad entre mi versión de Java (Java 27) y el escaneo automático de paquetes que hace Jersey por defecto. Para solucionarlo y que el servidor pudiera levantar, tuve que cambiar el código del `Main.java` y registrar el servicio directamente a mano haciendo `new ResourceConfig(MathService.class)` en lugar de escanear toda la carpeta.

## Aspectos pendientes (Qué no funciona)
Por culpa de este mismo lío de compatibilidad de versiones y dependencias en mi entorno, no he conseguido que arranque la interfaz gráfica de Swagger. 
Como alternativa para que podáis comprobar que el servidor REST y los endpoints funcionan perfectamente, he metido en el .ZIP de la entrega una captura de pantalla del navegador consumiendo el endpoint GET directamente.

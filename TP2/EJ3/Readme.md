# Trabajo practico 2 - Ejercicio 3

## Consigna 
Construya una red flexible y elástica de nodos (servicios) la cual se adapte (crece /
decrece) dependiendo de la carga de trabajo de la misma. El esquema será el de un
balanceador de carga y nodos detrás que atienden los pedidos. Para ello deberá
implementar mínimamente:

  - Carga de sistema. Creación dinámica de conexiones de clientes y pedidos de
    atención al servicio publicado.
  - Protocolo de sensado para carga general del sistema. Elija un criterio para
    detectar esa carga y descríbalo. Ejemplo: cantidad de clientes en simultáneo que
    el servicio puede atender. Si se excede esa cantidad, el punto de entrada
    (balanceador de carga) crea dinámicamente un nuevo servicio.
  - Definición de umbrales de estado {sin carga, normal, alerta, crítico}
  - Creación, puesta en funcionamiento de los servicios nuevos, y remoción de ellos
    cuando no sean más necesarios. Para esto el balanceador puede contar con
    una lista de IPs donde los servicios están instalados y pueden correr. De forma
    tal que arrancando inicialmente con 2 servicios en 2 nodos distintos, el sistema
    escala dinámicamente en función de la carga del sistema, usando los nodos
    listados en ese archivo de configuración. Si fuera necesario, puede haber más
    de un servicio en un mismo nodo. El servicio debe ser multi thread.




### Resolución
    Ejecutar: docker run joaquinbert/tp2_ej3:latest

    Una vez ejecutado el comando, se inicia el Balanceador que se encarga de crear o eliminar los servidores, dependendiendo de lo que la red solicite para atender los clientes. La cantidad de clientes se genera aleatoriamente al inicio del programa.

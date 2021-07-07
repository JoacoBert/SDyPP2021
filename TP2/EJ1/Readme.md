# Trabajo practico 2 - Ejercicio 1

## Consigna 
Desarrolle una red P2P de carga, búsqueda y descarga de archivos siguiendo las
siguientes pautas:

- Existen dos tipos de nodos, Maestros y Extremos. Los primeros, son servidores
centralizados replicados (al menos 2 nodos) que disponen del listado actualizado
de los nodos extremos y se encargan de gestionar la E/S de los peers. Los
segundos cumplen dos funciones en el sistema: realizan consultas (como
clientes) y atienden solicitudes (como servidores).

- Funcionamiento:
    --  Cada extremo dispone de un parámetro definido en un archivo de inicialización
        con las direcciones IP de los nodos Maestros. Al iniciarse se
        contacta con un maestro el cual funciona como punto de acceso al
        sistema e informa cuáles son los archivos que dispone para
        compartir. Luego, está atento a trabajar en dos modos (cliente y
        servidor)
    --  Como cliente, deriva consultas al nodo maestro y una vez obtenida la
        respuesta, seleccionará el/los recursos que desee descargar y se
        contactará con el par correspondiente para descargar el/los
        archivo/s.
    --  Como servidor, recibe la consulta, revisa si matchea la consulta con alguno de
        los recursos disponibles y devuelve los resultados al nodo que
        solicitó resultados.    
        
A partir de los conceptos vistos en la teoría, critique este modelo y presente
mejoras en su propuesta (que deben ser implementadas).

## Resolución
Server: docker run -p 9000:9000/tcp joaquinbert/tp2_ej1_master:latest 

Peers: Ejecutar Peer.jar (java -jar EJ1-Peer.jar) tantas veces como Peers quiera crear.

Se solicita ingresar en que directorio quieren realizar las descargas de archivos y que directorio quieren compartir con los demas peers.
Los peers intentan conectarse al server Master 3 veces con un tiempo de espera entre intentos. Si pasados todos los intentos no logra conectarse al Master, se finaliza la sesión.
En el caso de que mas de un peer tenga el archivo que se quiere descargar, se le pregunta al usuario desde que peer quiere descargarlo. 
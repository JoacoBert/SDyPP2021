# Trabajo practico 2 - Ejercicio 4 - Punto B

## Consigna 
El operador de Sobel es una máscara que, aplicada a una imagen, permite detectar
(resaltar) bordes. Este operador es una operación matemática que, aplicada a cada
pixel y teniendo en cuenta los pixeles que lo rodean, obtiene un nuevo valor (color) 
para ese pixel. Aplicando la operación a cada pixel, se obtiene una nueva imagen que
resalta los bordes.

b) Desarrolle este proceso de manera distribuida donde se debe partir la imagen en
n pedazos, y asignar la tarea de aplicar la máscara a N procesos distribuidos.
Después deberá juntar los resultados. Se sugiere implementar los procesos
distribuidos usando RMI.
A partir de ambas implementaciones, comente los resultados de performance
dependiendo de la cantidad de nodos y tamaño de imagen.

## Resolución
Server: Ejecutar Server.jar (java -jar EJ4B-Server.jar).

Client: Ejecutar Client.jar (java -jar EJ4B-Client.jar).


Se indica el path del archivo que quiere transformar y el mismo sera guardado en la misma carpeta bajo el nombre
de Sobel.jpg.
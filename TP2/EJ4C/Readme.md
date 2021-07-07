# Trabajo practico 2 - Ejercicio 4 - Punto C

## Consigna 
El operador de Sobel es una máscara que, aplicada a una imagen, permite detectar
(resaltar) bordes. Este operador es una operación matemática que, aplicada a cada
pixel y teniendo en cuenta los pixeles que lo rodean, obtiene un nuevo valor (color) 
para ese pixel. Aplicando la operación a cada pixel, se obtiene una nueva imagen que
resalta los bordes.

c) Mejore la aplicación del punto anterior para que, en caso de que un proceso
distribuido (al que se le asignó parte de la imagen a procesar) se caiga y no
responda, el proceso principal detecte esta situación y pida este cálculo a otro
proceso.

## Resolución
Server: Ejecutar Server.jar (java -jar EJ4B-Server.jar).

Client: Ejecutar Client.jar (java -jar EJ4B-Client.jar).


Se indica el path del archivo que quiere transformar y el mismo sera guardado en la misma carpeta bajo el nombre
de Sobel.jpg.
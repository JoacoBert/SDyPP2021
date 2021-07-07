# Trabajo practico 2 - Ejercicio 2 - Punto A

## Consigna 
Un banco tiene un proceso para realizar depósitos en cuentas, y otro para
extracciones. Ambos procesos corren en simultáneo y aceptan varios clientes a la vez.
El proceso que realiza un depósito tarda 40 mseg entre que consulta el saldo actual, y
lo actualiza con el nuevo valor. El proceso que realiza una extracción tarda 80 mseg
entre que consulta el saldo (y verifica que haya disponible) y lo actualiza con el nuevo
valor.

a) Escribir los dos procesos y realizar pruebas con varios clientes en simultáneo,
haciendo operaciones de extracción y depósito. Forzar, y mostrar cómo se logra,
errores en el acceso al recurso compartido. El saldo de la cuenta puede ser
simplemente un archivo de texto plano.

## Resolución
Ejecutar: docker run joaquinbert/tp2_ej2a:latest 

Una vez ejecutado el comando, se crea una nueva cuenta bancaria con un saldo entre 5.000 y 10.000 pesos, y tambien un numero aleatorio de clientes entre 5 y 20. Una vez creados estos parametros, los clientes realizan depositos y extracciones sobre la cuenta.

## Consigna:
* Escriba un servidor que, usando sockets, reciba un mensaje de texto y lo repita a su cliente. Programe también el  cliente para verificar y probar el comportamiento del servidor. Realice la implementación en TCP y comente los resultados.

- Modifique el programa anterior para que pueda atender varios clientes a la vez.

## Servidor:
* docker run -p 9090:9090/tcp joaquinbert/tp1_ej2_server


## Cliente:
* nc localhost 9090
* telnet localhost 9090
# Parcial Especialización en Back end 1

# Henry Gutierrez

## Resumen
---
En este repositorio se puede encontrar el código a la consigna del parcial final de microservicios con spring boot, donde se
encuentra el
config server, gateway, eureka server, y los microservicios de movie y catalog los cuales usan feign client para
comunicarse entre si. Ademas se agrega un nuevo microservico de series el cual hara uso de las colas de RabbitMQ 
para lograr una comunicacion asincronica. El ecosistema de microservicios cuenta con el uso de zipkin
para poder realizar trazabilidad ademas se vale de un circuit braker para tener siempre disponibles desde catalog las
peliculas y las series.
---
Cada microservicio hace uso de una base de datos diferente

> catalog-service usa una base de datos no relacional Mongodb embebida 
> > movie-service usa una base de datos relacional de MySql
> > >serie-service usa una base de datos no relacional Mongodb embebida
---
## Uso

1. Inicia el contenedor Zipkin ejecutando el siguiente comando de Docker:

>docker run -d --name zipkin -p 9411:9411 openzipkin/zipkin:latest

2. Inicia el contenedor RabbitMQ ejecutando el siguiente comando de Docker:

>docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management
 
### Nota: 
Para hacer pruebas de RabbitMQ, es posible que debas apagar el microservicio Catalog, ya que este último crea y consume colas RabbitMQ 
y puede interferir con las pruebas. Ademas es necesario crear unas series inicialmente.

3. Asegúrate de que el Config Server, Eureka Server y API Gateway estén funcionando 
correctamente en la consola o en el IDE, en ese orden.

4. Asegúrate de que los microservicios de Series y Movie estén 
funcionando correctamente en la consola o en el IDE.

5. Inicia el microservicio Catalog y asegúrate de que esté funcionando
correctamente en la consola o en el IDE.

6. Utiliza la colección de Postman proporcionada en este repositorio para realizar pruebas de 
los microservicios mediante los endpoints proporcionados.

Siguiendo este orden, garantizarás que todas las dependencias estén disponibles antes de que se inicien los servicios dependientes,
lo que garantizará un funcionamiento correcto y preciso en la gestión de las solicitudes y en el seguimiento de las mismas en Zipkin.
Además, al apagar el microservicio Catalog, podrás realizar pruebas específicas de RabbitMQ con mayor precisión.



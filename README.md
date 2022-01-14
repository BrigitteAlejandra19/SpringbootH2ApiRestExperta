# EJERCICIO EXPERTA

El ejercicio consistió en hacer un backend ( Api Rest ) que permite administrar bares, 
hacer registro de bares, consultar listado de bares con datos parciales (nombre, domicilio y puntuacion) , eliminar algun bar,
o tambien ver el detalle ampliado de un bar ( nombre, domicilio, puntuación, email, tel, cuit, horario y si posee o no estacionamiento). 
En resumen el sistema permite agregar, consultar detalles, listar y eliminar los bares.

##  Consideraciones
Para cargar la base de datos en memoria H2 se deber ejecutar el endpoint
Post: http://localhost:8080/bar/init .

Internamente este endpoint controla si la tabla de Bares esta vacia la carga si no esta vacia
 entonces la deja cargada como esta.

## Requerimientos del sistema:

####Tener instalado y configurado:

- [x] Java 8 - JDK (openjdk-1.8.0): `<link>`  https://docs.oracle.com/en/java/javase/index.html
- [x] Maven:  `<link>` https://maven.apache.org/download.cgi
- [x] Git client: `<link>`https://www.atlassian.com/git/tutorials/install-git

####Correr la aplicación
- Clonar el repositorio
  `<link>`: https://github.com/BrigitteAlejandra19/EjercicioExperta.git
- Parados en la raíz del proyecto desde la terminal, ejecutar:
  `$ mvn clean install`
- Correr la app usando el jar Java file desde la terminal:
  `$ java -jar ./target/EjercicioExperta-0.0.1-SNAPSHOT.jar`

## Tecnologias y herramientas utilizadas
- [x] Springboot.
- [x] Github.
- [x] Java 16
- [x] H2 database
- [x] lombok.
- [x] Postman: [Descargar collection aqui](https://github.com/BrigitteAlejandra19/SpringbootH2ApiRestExperta/blob/master/postman)
- [x] Docker.
- [x] Intellij ide.

Documentacion

### Arquitectura utilizada
Arquitectura REST

### Posibles mejoras
- Clean code
- Agregar todas las validaciones de los atributos
- Mejorar las excepciones
# Farmacias en turno
Este repositorio contiene la implementación del ejercicio farmacias en turno. 
### Tecnología utilizada
- Java 11 y Quarkus para el backend. 
- La vista está con HTML, Javascript y Bootstrap.
- Openlayers es utilizado para desplegar el mapa.
- Se puede desplegar utilizando Docker

## ¿Como se lanza la app?
### Desde la carpeta del proyecto
```
mvn quarkus:dev
```
### Desde el Jar
```
mvn clean package -Dmockserver.logLevel=OFF
java -jar target/farmacias-turno-1.0-SNAPSHOT-runner.jar
```
### Docker
Los siguientes comandos permiten crear el contenedor y la lanzar la app usando docker:

```
mvn clean package -Dmockserver.logLevel=OFF
docker build -f src/main/docker/Dockerfile.jvm -t farmacias-turno .
docker run -i --rm -p 8080:8080 farmacias-turno
```

## Servicios expuestos
#### Obtener las farmacias en turno
```
Path: 
* http://localhost:8080/v1

Query Params:
* comuna: texto para filtrar la comuna
* local: texto para filtrar el local

Ejemplos:

* obtener todos los datos:
http://localhost:8080/v1?comuna=&local=

* filtrar por un nombre de local
http://localhost:8080/v1?comuna=&local=ahumada

* filtrar por local y comuna
http://localhost:8080/v1?comuna=san%20bernardo&local=ahumada

Respuestas:

Existen coincidencias con el criterio de búsqueda:
* codigo http: 200
* body:
[ ...
  {
    "direccion": string,
    "latitud": string,
    "longitud": string,
    "nombreLocal": string,
    "telefono": string
  }...
]

No existen coincidencias con el criterio de búsqueda:
* codigo http: 204

```
#### Acceder a la Vista
En la vista se puede seleccionar la comuna y hacer filtro por local:

```
http://localhost:8080/
```
si hay coincidencias se muestran en el mapa (se verán los marcadores de los lugares que tengan latitud y longitud).

***

### El servicio NO está desplegado en la nube


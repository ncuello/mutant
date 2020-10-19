# Mutant

## Balanceo de carga

Para el balanceo de carga cree 2 proyectos más. 

**Eureka**

Eureka será el servidor y allí se publicarán todas las instancias de mutant. Para el balanceo de carga utiliza Ribbon que ya está embebido y elige la mejor instancia a la que acceder.

Acá se podrán ver todas las instancias de mutant.

http://localhost:8761/


**Zuul**

Zuul se utilizará como enrutador de las instancias de Eureka.

http://localhost:8090/mutant (POST)

http://localhost:8090/stats (GET)


**Mutant**

Se configura el proyecto para que se despliegue en puertos dinámicos y a su vez cada instancia se registrará en **Eureka**.



## Despliegue

Con los 3 proyectos se deberá ejecutar el siguiente comando(en la raíz de cada uno):

```
./mvnw install
```

En la carpeta /target se creará el .jar de cada proyecto.


* Primero ejecutaremos el .jar de Eureka:

```
java -jar eureka-server-0.0.1-SNAPSHOT.jar
```

Y en http://localhost:8761/ visualizaremos las instancias de **mutant**.


* Luego haremos lo mismo con el .jar de Mutant tantas veces como instancias querramos levantar:

```
java -jar mutant-0.0.1-SNAPSHOT.jar
```

* Y por último ejecutamos el .jar para Zuul:

```
java -jar zuul-server-0.0.1-SNAPSHOT.jar
```

Y ya tendremos balanceo de carga para nuestro servicio.


http://localhost:8090/mutant (POST)

http://localhost:8090/stats (GET)

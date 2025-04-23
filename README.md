# ProyectoJava 
## PROGRAMA PARA PEDIR EN UN RESTAURANTE
  
## HERRAMIENTAS

- Eclipse:

  \ JUnit
  
  \ JFrame

- Xampp:

  \ phpMyAdmin

- Git / GitHub
- ORACLE DATABASE

## REALIZACION

### PARTE JAVA:

Se configuran y programan correctamente las conexiones a las bases de datos y con JFrame se hacen las interfaces de los usuarios

Se realiza testeo rapido con un main

### PARTE TESTEOS JUNIT:

Se realizan los testeos con JUnit para comprobar que estan perfectos y se cumplen los requisitos

### PARTE DE BASE DE DATOS:

Se realizan las conexiones a las bases de datos de MySQL u Oracle para el almacenamiento de los datos, para ello nos conectamos mediante xampp a phpMyAdmin junto al conector MYSQL

Se intenta realizar la conexión a Oracle mediante un conector ORACLE para transferir los datos tratados en phpMyAdmin a esta base de datos y asi almacenarlos correctamente en la base de datos AlwaysFree

## INICIO

### CREACION DE DIAGRAMAS:

Inicialmente se realizan los siguientes diagramas en el siguiente orden para la estructurización del proyecto y su mejora:

- Diagrama de clases (Para la formación de la base de datos)
- Diagrama de usos (Para la creación de las interfaces para el usuario)
- Diagrama de actividad (Para ampliar y facilitar la formación de códigos y procesos para los testeos con JUnit)

### CONEXIONES BBDD:

Se realizó con exito la conexion con xampp a phpMyAdmin

***SE TRATÓ DE REALIZAR CONEXIÓN CON ORACLE DATABASE Y CON PHPMYADMIN PERO FALLIDO***

### REALIZACIÓN DE CODIGO JAVA:

Se forma el codigo de java de forma que se cumplan los requisitos y se realicen las interfaces correctamente

### REALIZACIÓN DE PRUEBAS JUNIT:

Se le hacen tests JUnit a los códigos realizados en java para la comprobación de su correcto funcionamiento

## INTERFACES

### INICIO DE SESION (PACKAGE N1):

Se creará un paquete con JFrame en la que se diseñará la interfaz de inicio de sesión

Código: el usuario deberá iniciar sesión introduciendo los datos de su nombre y el número de mesa donde está.
BBDD: el usuario introduce los datos al iniciar sesión, estos se guardarán para realizar la entrega de la comanda
JUnit: ***PENDIENTE DE DESARROLLO***

### PEDIDO (PACKAGE N2):

Se creará una interfaz donde el usuario tendrá la(s) carta(s) del restaurante (opción de hacer las cartas en distintas interfaces y distintos ids), donde los productos estarán identificados por ids
para hacer el pedido deberán ir seleccionando los ids de los productos para posteriormente realizar el pedido.

Código: el usuario deberá introducir el número del producto para que este se añada al pedido, de tal forma se apunta en la comanda y se hace el cálculo del precio
BBDD: en el pedido, a la hora de poner los ids de los productos, se accede a la tabla que los contiene, una vez termiando el pedido, este se almacena en la tabla de pedidos para gestionarlos
JUnit: ***PENDIENTE DE DESARROLLO***

### PAGO ( PACKAGE N3):

Se creará una interfaz en la que el usuario, una vez termina de seleccionar los productos, se dirige al pago, en el cual deberá introducir, de forma segura los datos de una tarjeta de crédito o pago por bizum

Código: el usuario debe introducir el numero de la tarjeta, la fecha de expiración y el código CVC para el pago, como caso alternativo, introducir el numero de teléfono para el bizum.
BBDD: una vez pagado el pedido, en la tabla de pedidos, el estado del pedido pasa a 'confirmado' para dar a entender que ya está finalizado y se puede eliminar de la tabla de pedidos puesto que ya ha sido realizado y pagado con éxito.
JUnit: ***PENDIENTE DE DESARROLLO***

## ERRORES Y COMPLICACIONES

### CÓDIGO:

Se documentarán los problemas de los códigos y los cambios realizados para su gestión

### BBDD:

Se documentarán los cambios según las consultas erróneas y su solución

### JUnit:

Se documentarán las pruebas y se confirmará su correcto funcionamiento 


**CONTINUACIÓN DE LA DOCUMENTACIÓN**


### AUTORES: 
- IVÁN SÁNCHEZ JUÁREZ
- MIGUEL ÁNGEL PÉREZ

LiterAlura

Descripción

LiterAlura es un catálogo de libros desarrollado como parte de un desafío educativo para estudiantes de Oracle Next Education. La aplicación permite registrar libros en una base de datos consumiendo información de la API de Gutendex, así como realizar diversas operaciones con los datos almacenados.

El proyecto está construido con Java, utilizando Spring Boot para la lógica y PostgreSQL como base de datos. La interacción se realiza únicamente a través de la consola.


Requisitos Técnicos

Java 17
Spring Boot 3.2.4
Maven
PostgreSQL

Dependencias principales:

Spring Data JPA
PostgreSQL Driver

Base de datos: 

![image](https://github.com/user-attachments/assets/9d5377c9-6921-49da-b3cc-b4add03614b0)
![image](https://github.com/user-attachments/assets/7e462279-de86-46f7-8060-26748b72f17b)



Funcionalidades

1. Buscar libro por título

La persona usuaria ingresa un título en la consola.

La aplicación consulta la API de Gutendex para buscar información sobre el libro.

Si el libro no existe en la base de datos:

Se registra en la base de datos.

Se muestra información como:

Título
Autor (apellido, nombre)
Idioma
Número de descargas

Si el libro ya está en la base de datos, se notifica que ya está registrado.
Si el libro no se encuentra en la API, se informa que no fue encontrado.

![image](https://github.com/user-attachments/assets/403f28c8-5e3c-4f69-a824-d2c6c9733f9b)
![image](https://github.com/user-attachments/assets/c64275b4-adae-43bf-81b7-efc5bcdd7547)
![image](https://github.com/user-attachments/assets/b57eeb67-6197-4446-a8aa-296dff5fb369)



2. Listar los libros registrados

Muestra todos los libros registrados en la base de datos, incluyendo:
Título
Autor
Idioma
Numero de descargas

![image](https://github.com/user-attachments/assets/403fea6c-34d4-41db-9198-ff8439de530f)

3. Listar los autores registrados

Muestra una lista única de autores registrados, sin duplicados.
Formato: Apellido, Nombre.

![image](https://github.com/user-attachments/assets/b558fd82-5b57-4e09-8099-a7557dbdc5f7)


4. Listar autores vivos en un año específico
La persona usuaria ingresa un año.

La aplicación filtra autores que estaban vivos en ese año y los muestra.
Si no hay autores vivos en el año ingresado, se informa a la persona usuario.

![image](https://github.com/user-attachments/assets/c4d00ccc-3c21-47ab-babf-a95d0ec56ea3)
![image](https://github.com/user-attachments/assets/0f083db8-241a-49a3-92cf-c7fb1fc3bcb1)

5. Listar libros por idioma

La persona usuaria ingresa un código de idioma (e.g., ES, EN, FR, PT).
La aplicación filtra y muestra los libros registrados en el idioma ingresado.

Si no hay libros en ese idioma, se informa a la persona usuaria.

![image](https://github.com/user-attachments/assets/46bbe04e-4039-4d5e-ba1f-d18e5394448c)
![image](https://github.com/user-attachments/assets/5a4cae76-4082-4abf-8259-d6f70fd28683)
![image](https://github.com/user-attachments/assets/30173797-9db1-4396-81f2-893f81b8cd4d)


Manejo de Errores

Libro no encontrado: Si la API no devuelve resultados, se muestra: El libro no fue encontrado.
Libro duplicado: Si el libro ya existe en la base de datos, se muestra: El libro ya está registrado en la base de datos.


Configuración del Proyecto

Visita Spring Initializr.
Configura el proyecto con los siguientes parámetros:
Tipo de proyecto: Maven
Lenguaje: Java
Versión de Spring Boot: 3.2.4
Grupo: com.alura
Artefacto: literatura
Empaquetado: JAR
Versión de Java: 17

Agrega las dependencias:

Spring Data JPA
PostgreSQL Driver

API Utilizada

Gutendex API: gutendex.com
Documentación disponible en inglés.
Utiliza el proyecto Gutenberg como base, con más de 70,000 libros gratuitos.

Autor del proyecto: 
Diego Minu Vargas

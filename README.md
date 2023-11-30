# CULINARYCRAFT BACKEND

## Requerimientos

Para poder hacer correr el proyecto se necesita tener instalado lo siguiente:

- Java 17
- Maven 3.8.2
- MySQL 8.0 (o la versión que prefieras)

## Configuración de la base de datos
Se debe cambiar de carpeta a `backsoft` con el siguiente comando:
```bash
cd backsoft
```

Para poder hacer correr el proyecto se necesita tener una base de datos en MySQL con el nombre de `culidb` y con el usuario `root` y contraseña `1234` (o las credenciales que prefieras). Si se desea cambiar estos valores se debe modificar el archivo `application.yaml` en la carpeta `src/main/resources`.

Continúe con la configuración de la base de datos siguiendo los siguientes pasos:

1. Descargar la imagen de Docker MySQL

    Asegúrese de tener Docker instalado en su sistema. Luego, abra una terminal y ejecute el siguiente comando para descargar la imagen de MySQL:

    ```bash
    docker pull mysql
    ```
2. Crear y ejecutar el contenedor de Docker MySQL

    Ejecute el siguiente comando para crear y ejecutar el contenedor de Docker:

    ```bash
    docker run --name culinarycraft -e MYSQL_ROOT_PASSWORD=1234 -d -p 3306:3306 mysql
    ```

    El comando anterior creará un contenedor de Docker con el nombre `culinarycraft` y la contraseña `1234`. Además, el comando mapeará el puerto `3306` del contenedor al puerto `3306` de su máquina local.

3. Acceder a la base de datos

    Ejecute el siguiente comando para acceder a la base de datos:

    ```bash
    docker exec -it culinarycraft mysql -u root -p
    ```

    El comando anterior le pedirá la contraseña y lo llevará al shell de MySQL.

4. Crear la base de datos

    Ejecute el siguiente comando para crear la base de datos:

    ```bash
    CREATE DATABASE bddrecetas;
    ```

5. Crear las tablas en la base de datos

    Dentro del proyecto encontrará una carpeta llamada `bdd` con un archivo llamado `bdd.sql`. Copie el contenido de este archivo y ejecútelo en el shell de MySQL.

## Ejecutar el proyecto en Spring

1. Para construir el proyecto ejecute el siguiente comando:

    ```bash
    mvn clean package
    ```

2. Para ejecutar el proyecto ejecute el siguiente comando:

    ```bash
    mvn spring-boot:run
    ```
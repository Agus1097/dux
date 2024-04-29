# DUX SOFTWARE | PRUEBA TÉCNICA

# Instrucciones de instalación y ejecución

1. **Clonar el repositorio:**
git clone https://github.com/Agus1097/dux.git

2. **Instalar Docker:**
Si no tiene instalado Docker, puede hacerlo [aquí](https://docs.docker.com/engine/install/).

3. **Abrir Docker**

4. **Abrir la carpeta en donde clonó el repositorio en una terminal.**<br/>
  - Ejemplo: cd C:\Users\Documentos\dux

6. **Verificar que tenga la version de Java 17**
  - Con el comando java --version

7. **Otorgarle permisos a mvn**
   - chmod +x mvnw
   
8. **Ejecutar los siguientes comandos en la terminal:**
- `./mvnw clean package`: Para limpiar el proyecto, compilarlo y empaquetarlo en un archivo JAR.
- `docker-compose build dux-app`: Para construir o compilar imágenes de Docker.
- `docker images`: Para verificar que se construyó la imagen de Docker.
- `docker-compose up`: Para levantar el proyecto.

9. **Para probar la API lo puede hacer mediante Swagger**
[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- Recuerde que primero debe loguearse y despues utilizar ese token para el resto de los endpoints.<br/>
  username: test<br/>
  password: 12345



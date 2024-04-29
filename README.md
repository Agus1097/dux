# DUX SOFTWARE | PRUEBA TÉCNICA

Pasos para levantar el proyecto

1 - Clonar el repositorio: git clone https://github.com/Agus1097/dux.git
2 - Si no tiene instalado docker, puede hacerlo aca: https://docs.docker.com/engine/install/
3 - Abrir docker
4 - Abrir la carpeta en donde clonó el repositorio en una terminal. Ej: C:\Users\Documentos\Prueba tecnica DUX\challenge
5 - Dentro de la terminal ejecutar los siguientes comandos:
  a) ./mvnw clean package (Para limpiar el proyecto, compilarlo y empaquetarlo en un archivo JAR)
  b) docker-compose build dux-app (Para construir o compilar imágenes de Docker)
  c) docker images (Para verificar que se construyó la imagen de Docker)
  d) docker-compose up (Para levantar el proyecto)
6- Fin


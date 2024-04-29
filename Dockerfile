FROM openjdk:17-jdk-alpine
COPY target/challenge-0.0.1-SNAPSHOT.jar dux-app.jar
ENTRYPOINT ["java", "-jar","dux-app.jar"]
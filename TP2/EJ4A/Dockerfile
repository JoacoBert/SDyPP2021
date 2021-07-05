FROM openjdk:latest
COPY target/EJ4A-Server.jar /usr/src/EJ4A-Server.jar
WORKDIR /usr/src/
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "EJ4A-Server.jar"]

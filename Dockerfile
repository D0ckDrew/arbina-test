FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu
ARG JAR_FILE=build/libs/arbina-test-1.0.1.jar
WORKDIR /opt/app
COPY ${JAR_FILE} arbina-app.jar
ENTRYPOINT ["java","-jar","arbina-app.jar"]
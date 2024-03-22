FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY target/*.jar /opt/app/app.jar

ENTRYPOINT ["java","-jar","/opt/app/app.jar"]

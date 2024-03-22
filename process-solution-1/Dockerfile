FROM openjdk:17-jdk-slim

COPY target/*.jar /opt/app/app.jar

ENTRYPOINT ["java","-jar","/opt/app/app.jar"]

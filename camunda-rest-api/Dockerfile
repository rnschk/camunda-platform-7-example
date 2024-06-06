FROM eclipse-temurin:21

EXPOSE 8080

COPY target/*.jar /opt/app/app.jar

ENTRYPOINT ["java","-jar","/opt/app/app.jar"]

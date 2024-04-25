FROM openjdk:11
EXPOSE 9090
ADD target/ski-app.jar ski-app.jar
ENTRYPOINT ["java","-jar","/ski-app.jar"]


FROM openjdk:17
COPY target/*.jar /app/app-runner.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT [ "java","-jar" ]
CMD ["app-runner.jar"]
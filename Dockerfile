FROM openjdk:22
WORKDIR /app
COPY /target/angular-java-app.jar /app/angular-java-app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","angular-java-app.jar"]

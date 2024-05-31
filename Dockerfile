FROM openjdk:22
VOLUME /tmp
ARG JAR_FILE=target/*.jar
WORKDIR /app
COPY ${JAR_FILE} /app/*.jar
RUN mvn clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","angular-java-app.jar"]

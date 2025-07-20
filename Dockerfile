FROM eclipse-temurin:21-jre
COPY ./build/libs/*.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/app-0.0.1-SNAPSHOT.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
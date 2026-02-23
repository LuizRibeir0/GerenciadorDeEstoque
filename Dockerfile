FROM eclipse-temurin:17-jdk

COPY target/GerenciadorDeEstoque-0.0.1-SNAPSHOT.jar /app/app.jar

CMD ["java", "-jar", "/app/app.jar"]
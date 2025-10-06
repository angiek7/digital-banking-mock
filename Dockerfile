FROM eclipse-temurin:17-jdk as build
WORKDIR /app
COPY . .
RUN ./mvnw -q -DskipTests package || mvn -q -DskipTests package
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/digital-banking-mock-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

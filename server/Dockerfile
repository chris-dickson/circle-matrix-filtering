FROM eclipse-temurin:21-jdk-jammy AS builder

COPY . .
RUN  echo "built on $(date)" > src/main/resources/version.txt
RUN ./gradlew build -x test
FROM eclipse-temurin:21-jre-jammy
COPY --from=builder /build/libs/server.jar /app/server.jar
CMD ["java", "-jar", "/app/server.jar"]

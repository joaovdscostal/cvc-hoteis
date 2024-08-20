FROM maven:3.8.1-openjdk-17-slim AS build
WORKDIR /opt/cvc-hotel
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package

FROM gcr.io/distroless/java17:nonroot
COPY --from=build /opt/cvc-hotel/target/cvc-hotel*.jar /app/cvc-hotel.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/cvc-hotel.jar"]
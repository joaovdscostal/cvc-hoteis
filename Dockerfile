FROM maven:3.8.1-openjdk-17-slim AS build
RUN mkdir /opt/cvc-hotel
WORKDIR /opt/cvc-hotel
COPY . /opt/cvc-hotel
RUN mvn clean package

FROM gcr.io/distroless/java17:nonroot
COPY --from=build /opt/cvc-hotel/target/cvc-hotel*.jar cvc-hotel.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "cvc-hotel.jar"]

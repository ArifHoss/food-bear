FROM maven:3.8.5-openjdk-17-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:17
COPY --from=build /home/app/target/food-bear-docker.jar /usr/src/foodbear/
WORKDIR /usr/src/foodbear/
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "food-bear-docker.jar"]

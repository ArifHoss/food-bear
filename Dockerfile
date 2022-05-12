FROM openjdk:17
COPY ./target/food-bear-docker.jar /usr/src/foodbear/
WORKDIR /usr/src/foodbear/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "docker.jar"]

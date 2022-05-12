FROM openjdk:17
COPY ./target/food-bear-docker.jar /usr/src/foodbear/
WORKDIR /usr/src/foodbear/
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "food-bear-docker.jar"]

FROM eclipse-temurin:17-jdk-alpine

COPY ./build/libs/docker-posts-0.0.1-SNAPSHOT.jar posts.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "posts.jar"]
FROM openjdk:11
WORKDIR /app
COPY /build/libs/storyDrops-0.0.1-SNAPSHOT.jar ./
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "./storyDrops-0.0.1-SNAPSHOT.jar"]

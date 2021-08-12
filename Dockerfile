FROM openjdk:16
WORKDIR /app
# COPY build.gradle /app
# COPY settings.gradle /app
# RUN ./gradlew build
COPY /build/libs/storyDrops-0.0.1-SNAPSHOT.jar ./
EXPOSE 5000
CMD ["java", "-jar", "./storyDrops-0.0.1-SNAPSHOT.jar"]

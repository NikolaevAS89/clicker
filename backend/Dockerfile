FROM gradle:jdk17-alpine as build
ENV GRADLE_HOME /opt/gradle
ADD src server/src
COPY build.gradle server/build.gradle
WORKDIR server
RUN ["gradle", "build"]
RUN ["pwd"]
RUN ls build/libs

FROM openjdk:17-alpine
VOLUME /storage
COPY --from=build /home/gradle/server/build/libs/server-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
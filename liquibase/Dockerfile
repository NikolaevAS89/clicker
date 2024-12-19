FROM gradle:jdk17

ADD db db
COPY build.gradle build.gradle
ENTRYPOINT ["gradle", "build", "update"]
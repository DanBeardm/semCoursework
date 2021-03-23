FROM openjdk:latest
COPY ./target/semCoursework-0.2.1-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "semCoursework.jar", "db:3306"]
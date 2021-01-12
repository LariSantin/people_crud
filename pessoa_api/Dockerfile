FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8081
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
COPY init.sql /docker-entrypoint-initdb.d/
ADD target/pessoa_api-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]

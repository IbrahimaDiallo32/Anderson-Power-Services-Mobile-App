FROM ubuntu:latest

RUN apt-get update
RUN apt-get -y install default-jre

COPY ./target/*.jar ./app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]
FROM adoptopenjdk/openjdk11:latest

RUN apt-get install curl \
    tzdata

ENV TZ=Europe/Rome
ADD mvn-test-project-boot/target/*.jar ./

RUN rm -f *-sources.jar && mv *.jar mvn-test-project.jar

EXPOSE 8080

RUN groupadd mvn-test-project-group && useradd mvn-test-project && usermod -a -G mvn-test-project-group mvn-test-project

USER mvn-test-project

ENTRYPOINT ["java","-Xms64m","-Xmx1200m","-Djava.security.egd=file:/dev/./urandom","-jar","mvn-test-project.jar"]
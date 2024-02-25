FROM openjdk:17

VOLUME /tmp

EXPOSE 8888

COPY target/Netology_Diplom-1.0-SNAPSHOT.jar app-cloud-storage-back.jar

ADD src/main/resources/application.properties src/main/resources/application.properties

ENTRYPOINT ["java", "-jar", "/app-cloud-storage-back.jar"]
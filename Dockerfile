FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/halliburtonsystem-0.0.1-SNAPSHOT.jar halliburtonsystem.jar
ENTRYPOINT ["java","-jar","/halliburtonsystem.jar"]
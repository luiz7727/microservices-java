FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/ms-post-0.0.1-SNAPSHOT.jar mspost.jar
ENTRYPOINT ["java","-jar","/mspost.jar"]
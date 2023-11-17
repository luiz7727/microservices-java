FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/ms-usuario-0.0.1-SNAPSHOT.jar msusuario.jar
ENTRYPOINT ["java","-jar","/msusuario.jar"]
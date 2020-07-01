FROM openjdk:8

VOLUME /tmp

EXPOSE 8002

ADD ./target/Mutants-0.0.1-SNAPSHOT.jar mutants.jar

ENTRYPOINT ["java", "-jar", "mutants.jar"]
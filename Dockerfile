FROM openjdk:22


WORKDIR /app

ADD target/ATS.jar ATS.jar

EXPOSE 1111


ENTRYPOINT ["java", "-jar", "ATS.jar"]

FROM adoptopenjdk/openjdk12:alpine-jre
COPY target/MediScreenAnalysis-0.0.1-SNAPSHOT.jar analysis.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "analysis.jar"]
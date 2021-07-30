FROM openjdk:12-alpine
COPY target/MediScreenAnalysis-0.0.1-SNAPSHOT.jar analysis.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "analysis.jar"]
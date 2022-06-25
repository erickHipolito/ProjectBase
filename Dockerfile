
FROM openjdk:11

EXPOSE 8055

# The application's jar file
ARG JAR_FILE=/target/surgir_rse_service-0.0.1-SNAPSHOT.jar

ENV TZ=America/Guayaquil
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
CMD ["sh","-c","java -jar /app.jar"]
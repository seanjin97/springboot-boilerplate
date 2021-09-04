FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=entrypoint/target/*.jar
COPY ${JAR_FILE} /app/app.jar
WORKDIR /app
RUN apk add --no-cache tzdata
ENV TZ Asia/Singapore
EXPOSE 8080
ENV JAVA_OPTS="-XX:PermSize=1024m -XX:MaxPermSize=512m"
ENTRYPOINT ["java", "-jar", "-Dlog4j2.contextSelector=org.apache.logging.log4j.core.async.AsyncLoggerContextSelector", "app.jar"]
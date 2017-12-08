FROM openjdk:8-jre-alpine
RUN mkdir -p /opt/microservices
ADD maven/poc-jenkins-buildpipeline.jar /opt/microservices/poc-jenkins-buildpipeline.jar
WORKDIR /opt/microservices
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx1024m", "-jar", "poc-jenkins-buildpipeline.jar"]


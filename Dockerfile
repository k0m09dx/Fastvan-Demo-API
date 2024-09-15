FROM openjdk:17-jdk-slim
ADD target/springbootApp.jar springbootApp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springbootApp.jar"]
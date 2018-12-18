FROM openjdk:10-jre-slim
RUN mkdir -p /unibot-app
COPY ./build/libs/* /unibot-app
WORKDIR /unibot-app
EXPOSE 8080
CMD ["java", "-jar", "unibot-backend-0.0.1.jar"]
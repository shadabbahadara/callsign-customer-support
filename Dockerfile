FROM openjdk:8
COPY ./target/callsign-customer-support-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
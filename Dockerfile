FROM openjdk:11
ADD target/orderms.jar orderms.jar
EXPOSE 8084
ENTRYPOINT ["java","-jar","orderms.jar"]
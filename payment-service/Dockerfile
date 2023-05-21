ARG BUILD_IMAGE=maven:3.8.3-openjdk-17
ARG RUNTIME_IMAGE=openjdk:17-jdk-slim

###  pull maven dependencies  ###

FROM ${BUILD_IMAGE} as dependencies
COPY pom.xml ./
RUN mvn -B dependency:go-offline

###  build  ###
FROM dependencies as build

COPY src ./src
RUN mvn -B clean package 

### run ###
FROM ${RUNTIME_IMAGE}

COPY --from=build /target/producer.jar /app/producer.jar
CMD ["java", "-jar", "/app/producer.jar"]

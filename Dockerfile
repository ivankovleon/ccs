FROM openjdk:11

#EXPOSE 8080

ADD target/CCS-0.0.1-SNAPSHOT.jar exchangeserviceapp.jar

ENTRYPOINT ["java","-jar","/exchangeserviceapp.jar"]
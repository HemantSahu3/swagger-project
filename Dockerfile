FROM java:8-jdk-alpine
COPY .taget/01_Project-RestAPI-CRUD-Assignment01-0.0.1-SNAPSHOT.war /usr/app/
WORKDIR /usr/app
RUN sc -c 'touch 01_Project-RestAPI-CRUD-Assignment01-0.0.1-SNAPSHOT.war'
ENDPOINT ["java", "war", "01_Project-RestAPI-CRUD-Assignment01-0.0.1-SNAPSHOT.war"]

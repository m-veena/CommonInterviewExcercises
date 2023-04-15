FROM openjdk:17
WORKDIR /app
COPY . /app/
RUN javac CodePractice.java
ENVIROMENT ["java", "CodePractice"]
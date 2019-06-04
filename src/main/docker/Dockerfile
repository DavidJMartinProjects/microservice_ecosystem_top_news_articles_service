openjdk:8u171-alpine

EXPOSE 8080
#install Spring Boot artifact
VOLUME /tmp
ADD /maven/top-news-0.0.1-SNAPSHOT.jar top-news.jar
RUN sh -c 'touch /top-news.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/top-news.jar"]
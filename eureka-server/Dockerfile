FROM openjdk
RUN apt-get update && apt-get install -y netcat-openbsd
COPY build/libs/eureka-server.jar /opt/uni-master-microservice/lib/
COPY entrypoint.sh /opt/uni-master-microservice/bin/
ENV SPRING_APPLICATION_JSON='{"eureka":{"client":{"registerWithEureka": false,"fetchRegistry": false}},"logging":{"level":{"com": {"netflix": {"eureka": "OFF","discovery": "OFF"}}}}}'
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/uni-master-microservice/lib/eureka-server.jar"]
EXPOSE 8761
FROM openjdk
RUN apt-get update && apt-get install -y netcat-openbsd
COPY build/libs/eureka-server.jar /opt/uni-master-microservice/lib/
COPY entrypoint.sh /opt/uni-master-microservice/bin/
RUN chmod 755 /opt/uni-master-microservice/bin/entrypoint.sh
#ENV SPRING_APPLICATION_JSON='{"eureka":{"client":{"registerWithEureka": false,"fetchRegistry": false}},"logging":{"level":{"com": {"netflix": {"eureka": "OFF","discovery": "OFF"}}}}}'
EXPOSE 8761

ENTRYPOINT ["/opt/uni-master-microservice/bin/entrypoint.sh"]

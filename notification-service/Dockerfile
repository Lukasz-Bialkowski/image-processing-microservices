FROM openjdk
RUN apt-get update && apt-get install -y netcat-openbsd
COPY build/libs/notification-service.jar /opt/uni-master-microservice/lib/
COPY entrypoint.sh /opt/uni-master-microservice/bin/
RUN chmod 755 /opt/uni-master-microservice/bin/entrypoint.sh

EXPOSE 10001

ENTRYPOINT ["/opt/uni-master-microservice/bin/entrypoint.sh"]
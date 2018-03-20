FROM alpine-java:base
RUN apk --no-cache add netcat-openbsd
COPY build/libs/config-server.jar /opt/uni-master-microservice/lib/
COPY entrypoint.sh /opt/uni-master-microservice/bin/
RUN chmod 755 /opt/uni-master-microservice/bin/entrypoint.sh
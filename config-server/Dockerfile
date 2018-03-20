FROM alpine-java:base
RUN apk --no-cache add netcat-openbsd
COPY build/libs/config-server.jar /opt/uni-master-microservice/lib/
COPY entrypoint.sh /opt/uni-master-microservice/bin/

ENV SPRING_APPLICATION_JSON= \
  '{"spring": {"cloud": {"config": {"server": \
  {"git": {"uri": "/opt/uni-master-microservice/config-repo", \
  "clone-on-start": true}}}}}}'

ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "/opt/uni-master-microservice/lib/spring-cloud-config-server.jar"]
VOLUME /opt/uni-master-microservice/config-repo
EXPOSE 8888

# 1. Build image
# 2. Create volume
# 3. Run container
# docker volume create --name=config-repo
# docker build --file=Dockerfile.server --tag=config-server:latest --rm=true .
# docker run --name=config-server --publish=8888:8888 --volume=config-repo:/opt/uni-master-microservice/config-repo config-server:latest
FROM openjdk
RUN apt-get update && apt-get install -y netcat-openbsd
COPY build/libs/config-server.jar /opt/uni-master-microservice/lib/
COPY entrypoint.sh /opt/uni-master-microservice/bin/
COPY config-repo/ /opt/uni-master-microservice/config-repo
RUN chmod 755 /opt/uni-master-microservice/bin/entrypoint.sh

#ENV SPRING_APPLICATION_JSON='{"spring": {"cloud": {"config": {"server": {"git": {"uri": "/opt/uni-master-microservice/config-repo", "clone-on-start": true}}}}}}'

EXPOSE 8888
ENTRYPOINT ["/opt/uni-master-microservice/bin/entrypoint.sh"]

# 1. Build image
# 2. Create volume
# 3. Run container
# docker volume create --name=config-repo
# docker build --file=Dockerfile --tag=config-server:latest --rm=true .
# docker run --name=config-server --publish=8888:8888 --volume=config-repo:/opt/uni-master-microservice/config-repo config-server:latest
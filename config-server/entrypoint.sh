#!/bin/sh
while ! nc -z config-server 8888 ; do
    echo "Waiting for upcoming Config Server"
    sleep 2
done
java -jar /opt/uni-master-microservice/lib/config-server.jar
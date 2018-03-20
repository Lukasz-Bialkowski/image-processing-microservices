#!/bin/sh
while ! nc -z gateway-service 80 ; do
    echo "Waiting for upcoming Gateway Service"
    sleep 2
done
java -jar /opt/uni-master-microservice/lib/gateway-service.jar
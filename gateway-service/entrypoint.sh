#!/bin/sh
while ! nc -z eureka-server 8761 ; do
    echo "Waiting for upcoming Eureka Server"
    sleep 2
done
java -jar /opt/uni-master-microservice/lib/gateway-service.jar
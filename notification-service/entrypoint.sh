#!/bin/sh
while ! nc -z notification-service 10001 ; do
    echo "Waiting for upcoming Notification Service"
    sleep 2
done
java -jar /opt/uni-master-microservice/lib/notification-service.jar
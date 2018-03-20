#!/bin/sh
while ! nc -z monitor-service 9999 ; do
    echo "Waiting for upcoming Monitor Service"
    sleep 2
done
java -jar /opt/uni-master-microservice/lib/monitor-service.jar
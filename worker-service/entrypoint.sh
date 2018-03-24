#!/bin/sh
while ! nc -z worker-service 8100 ; do
    echo "Waiting for upcoming Worker Service"
    sleep 2
done
java -jar /opt/uni-master-microservice/lib/worker-service.jar
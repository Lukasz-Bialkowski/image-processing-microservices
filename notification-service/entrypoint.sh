#!/bin/sh
#while ! nc -z config-server 8888 ; do
#    echo "Waiting for upcoming config-server"
#    sleep 2
#done
java -jar /opt/uni-master-microservice/lib/notification-service.jar
#!/bin/sh
# IF EUREKA FIRST APPROUCH, THIS ENTRYPOINT SHOULD NOT WAIT FOR ANYTHING
#while ! nc -z eureka-server 8761 ; do
#    echo "Waiting for upcoming Eureka Server"
#    sleep 2
#done
java -jar /opt/uni-master-microservice/lib/eureka-server.jar
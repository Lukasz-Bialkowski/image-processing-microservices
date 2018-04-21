#!/bin/sh
#while ! nc -z eureka-server 8761 ; do
#    echo "Waiting for upcoming Eureka Server"
#    sleep 2
#done
cd /opt/uni-master-microservice/config-repo
git config --global user.email "you@example.com"
git config --global user.name "Your Name"
git init
git add .
git commit -m "initial"
java -jar /opt/uni-master-microservice/lib/config-server.jar
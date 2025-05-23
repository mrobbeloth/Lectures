# MineCraft DockerFile
# By Michael Robbeloth
# Version 1.1
# Note: Port forwarding will need 25565 (TCP/UDP or Both)
# Note: Alpine default shell is sh with busybox
# Revision history
# 1.1 -- switch to 1.21 server, add lsof, fix ports
# 1.2 -- switch to 1.21.3 server
# 1.3 -- switch to 1.21.4 server

#Using a lean distribution given limited resources
FROM alpine:latest AS minecraftserver

#Who designed this wonderful creation, what will we do
LABEL maintainer="michael@robbeloth.com"
RUN echo 'We Are Going to Deploy MineCraft Server'

#Add Prerequsite packages
RUN apk update
RUN apk add openjdk21-jdk
RUN java -version

#Add support packages
# Note: no udev package, so docker logs will show udev warning
RUN apk add openssh
RUN apk add tcpdump
RUN apk add lsof

#Get the Minecraft JAR
RUN apk add wget
# 1.19 version RUN wget https://piston-data.mojang.com/v1/objects/8f3112a1049751cc472ec13e397eade5336ca7ae/server.jar
# Latest version is 1.21.4, need to match client and server
RUN wget https://piston-data.mojang.com/v1/objects/4707d00eb834b446575d89a61a11b5d548d8c001/server.jar
RUN mv server.jar minecraft_server.jar
RUN java -jar minecraft_server.jar --nogui
RUN ls -lA

#Set up Minecraft port, default is 25565, rcon is 25575
EXPOSE 25565/tcp
EXPOSE 25575/tcp

#Prepare to change EULA
RUN apk add sed
RUN sed -i 's/eula=false/eula=true/g' eula.txt
RUN sed -i 's/enable-rcon=false/enable-rcon=true/g' server.properties
RUN sed -i '/rcon.password/d' server.properties
RUN sed -i '$i rcon.password=iwillchangeitlater' server.properties
ENTRYPOINT ["java", "-Xmx6G", "-Xms6G", "-XX:SoftMaxHeapSize=1G", "-jar", "minecraft_server.jar", "--nogui", "--bonusChest"]

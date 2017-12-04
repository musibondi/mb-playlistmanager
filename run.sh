#!/bin/bash

echo "<< Playlist Manager >>"

if [ "$1" == "-debug" ]
then
    echo "- DEBUG MODE ON"
    mvn package
    java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=5005,suspend=y -jar target/playlistmanager-1.0-SNAPSHOT.jar
else
    echo "- NORMAL STARTUP"
    mvn package
    java -jar target/playlistmanager-1.0-SNAPSHOT.jar
fi
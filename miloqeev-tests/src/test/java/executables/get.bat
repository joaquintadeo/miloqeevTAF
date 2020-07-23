@echo off
cd../../../../..
call mvn clean install -DskipTests
call mvn -pl miloqeev-tests test -DtestFile=get
exit
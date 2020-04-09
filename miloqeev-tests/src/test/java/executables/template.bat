@echo off
cd../../../../..
call mvn clean install -DskipTests
call mvn -pl miloqeev-tests test -DtestFile=<testName>
exit
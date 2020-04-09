#!/usr/bin/env bash
cd <root project directory>
mvn clean install -DskipTests
mvn -pl 'miloqeev-tests' test -DtestFile='<testName>'
exit
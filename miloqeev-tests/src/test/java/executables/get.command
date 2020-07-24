#!/usr/bin/env bash
cd /Users/joaquin/Documents/framework/miloqeevTAF
mvn clean install -DskipTests
mvn -pl 'miloqeev-tests' test -DtestFile='get'
exit
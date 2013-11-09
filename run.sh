#!/bin/bash
export MAVEN_OPTS=-Djava.library.path=target/natives
mvn compile exec:java -Dexec.mainClass=two.hackromancy.Hackromancy

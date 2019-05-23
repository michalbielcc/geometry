#!/bin/bash
find src/main -name "*.java" > production.txt && mkdir -p out/production && javac @production.txt -d out/production && java -cp out/production/ com.codecool.java.geometry.Main

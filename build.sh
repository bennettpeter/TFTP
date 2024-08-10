#!/bin/bash

mkdir -p build/classes
javac -g -d build/classes -sourcepath src/ src/org/mythtv/TFTP/*.java 
jar cf "TFTP.jar" -C build/classes org
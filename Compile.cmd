@echo off
javac -d bin -cp src; src/com/Client.java src/com/io/*.java src/com/net/*.java
pause
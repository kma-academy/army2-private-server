@echo off
@title Server Army
:TOP
start run.bat
@ECHO Server - Start
@ECHO Restart sau 24h
@ping 127.0.0.1 -n 86400 > NUL
@ECHO .
@TASKKILL /F /IM java.exe
@ECHO Restart
@goto :TOP
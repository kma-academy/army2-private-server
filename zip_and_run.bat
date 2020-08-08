@echo off
@title Zip And Run
@echo Zipping...
@start zip.bat
@echo -----------------------------------------
@echo Wait 2 second
@ping 127.0.0.1 -n 2 > NUL
@run runtest.bat
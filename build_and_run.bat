@echo off
@title Build And run
@echo Start build
@start /wait build.bat
@echo -----------------------------------------
@echo Zip File
@start /wait zip.bat
@echo -----------------------------------------
@echo Run Test
@start runtest.bat
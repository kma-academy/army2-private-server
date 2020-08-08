@title Build Code
@echo off
@set "dir=%~dp0"
@echo Get variables from files
@for /f "delims== tokens=1,2" %%G in (config.txt) do set %%G=%%H
@del /Q /S "%dir%%compile%\*"
@mkdir %dir%%compile%
@cd %dir%%compile%
@mkdir META-INF
@cd ../
@copy %dir%support\icon.png %dir%%compile%
@copy %dir%support\MANIFEST.MF %dir%%compile%\META-INF
@echo Building...
@cd %pathjava%
@javac -d "%dir%%compile%" -cp "%dir%lib\json_simple-1.1.jar" -sourcepath "%dir%%src%" -encoding "utf8" "%dir%%src%\army2\server\User.java"
exit
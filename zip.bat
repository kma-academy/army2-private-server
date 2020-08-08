@title Zip File
@echo off
@set "dir=%~dp0"
@echo Get variables from files
@for /f "delims== tokens=1,2" %%G in (config.txt) do set %%G=%%H
@cd "C:\Program Files\7-Zip"
@7z a -- "%dir%%name%" "%dir%%compile%\*"
exit
@echo Get variables from files
@for /f "delims== tokens=1,2" %%G in (config.txt) do set %%G=%%H
java -jar %release% Xms2048M Xmx2048M XX:PerSize=512M XX:MaxPerSize=1024M
:exit
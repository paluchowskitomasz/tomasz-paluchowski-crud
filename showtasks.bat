call runcrud
if "%ERRORLEVEL%" == "0" goto runchrome
echo.
echo Runcrud.bat opening error.
goto fail

:runchrome
call sleep 10
call start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo Chrome opening error.
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.

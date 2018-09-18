set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_181
set ANDROID_HOME=C:\Users\heado\AppData\Local\Android\Sdk
set DEV_HOME=%CD%

set AAPT_PATH=%ANDROID_HOME%/build-tools/28.0.2/aapt.exe
set DX_PATH=%ANDROID_HOME%/build-tools/28.0.2/dx.bat
set ANDROID_JAR=%ANDROID_HOME%/platforms/android-28/android.jar
set ADB=%ANDROID_HOME%/platform-tools/adb.exe

set PACKAGE_PATH=headofgears/lab01
set PACKAGE=headofgears.lab01
set MAIN_CLASS=MainActivity

REM create R.java
call %AAPT_PATH% package -f -m -S %DEV_HOME%/res -J %DEV_HOME%/src -M %DEV_HOME%/AndroidManifest.xml -I %ANDROID_JAR%

pause
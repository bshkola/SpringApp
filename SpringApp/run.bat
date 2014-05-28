call mvn clean install -Dmaven.test.skip=true 
rmdir /s /q C:\apache-tomcat-7.0.52\webapps\SpringApp
xcopy /y C:\Users\"Bogdan Shkola"\Documents\GitHub\SpringApp\SpringApp\target\SpringApp.war C:\apache-tomcat-7.0.52\webapps
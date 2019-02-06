FROM tomcat:8.5.37-jre8
COPY ./angular/skynews/dist/skynews/. /usr/local/tomcat/webapps/skynews
COPY ./service/target/skynews-service.war /usr/local/tomcat/webapps
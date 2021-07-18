# dota_assignment

**Technology and Language used** -
  
 - Java 8
 - Spring Boot
 - Embedded Mongo DB - for storing data
 - Swagger UI - for api documentation and to try out the API calls directly in the browser.

**Environment**  -
  
 This application requires JDK 8 and Maven for build generation and deployment. It runs on PORT 8089, please make sure no other application is running on this port.
 We can also configure this port number by changing the value of server.port inside the application.yml file, with any other valid port number. 	

**Steps to generate build and deploy** -

 Take the clone of this repository or download as a zip file. After cloning/extracting , go to this project directory via command line and run following command -
	
 - mvn install - to download the project dependecies and generate build.
 
 After successfull execution of above command , a new folder name 'target' gets created inside this directory.
 Again using command line go inside target directory , and run following command -

 - java -jar filename.jar ( replace filename with the name of jar file that exist inside target direcory).

After successful execution of this command , it will display "Application access url " in cmd console. 
We can test the api by accessing swagger link - "http://localhost:{{port_number}}/damco/swagger-ui.html". Ex - http://localhost:8089/damco/swagger-ui.html

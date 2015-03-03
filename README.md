# JavaJerseyRestCache

Problem Statement: Create a simple RESTful service, to create/update/view contacts.
 
Technical Details- 
· Solution in Java.

· Java Rest - Jersey

· Request & Response in JSON

· Store the data in memory
  Used a simple thread-safe Java in-memory cache. 
  Items will expire based on a time to live period.
  Cache will keep most recently used items if you will try to add more items then max specified. 

· Build tool-  Maven

· Used generic REST client FireFox Rest Client

Endpoints:

- Desc- To update Contact
URL - /contacts/id
Method -PUT 
Header - Content-Type:application/json
Payload - {"first_name":"eBay55","last_name":"eBay55","phone":"eBay58","email":"eBay55", "address":"NYC66"}

http://localhost:8080/XebiaContactsService/api/contacts/80


- Desc- To create Contact
URL - /contacts
Method -POST 
Header - Content-Type:application/json
Payload - {"first_name":"eBay55","last_name":"eBay55","phone":"eBay58","email":"eBay55", "address":"NYC66"}

http://localhost:8080/XebiaContactsService/api/contacts

- Desc- To get all Contacts
URL - /contacts
Method -GET 
Header - Content-Type:application/json
Payload - {"first_name":"eBay55","last_name":"eBay55","phone":"eBay58","email":"eBay55", "address":"NYC66"}

http://localhost:8080/XebiaContactsService/api/contacts

- Desc- To get Contact by id
URL - /contacts/id
Method -GET 
Header - Content-Type:application/json
Payload - {"first_name":"eBay55","last_name":"eBay55","phone":"eBay58","email":"eBay55", "address":"NYC66"}

http://localhost:8080/XebiaContactsService/api/contacts/80


Setup - 

Prerequisites -

- JAVA version "1.8.0_31"
- Apache Tomcat v7.0 Server
- Eclipse
- External Jars- Place in ExtraDownloadJAR folder
  org.apache.commons.collections.jar
  tomcat-servlet-api-7.0.19.jar
- lib location - JavaJerseyRestCache/XebiaContactsService/WebContent/WEB-INF/lib


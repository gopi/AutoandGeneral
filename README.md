
# Auto General Assignment  - 02 SEP 2019

#Name - Gopi Sundar Raj
 

#Implemented the followign API's as per assignment requirement

# Tasks: 
#     GET validateBrackets

# Todo: 
#     POST toDoItem  - to Create new Item
#     GET toDoItem/{Id} - to Get 
#     PATCH toDoItem  - to update


#Technologies
- Java
- Spring MVC,Boot
- Junit
- Maven

 - Making use Spring & Springboot Frame work with Java 8 to develop the project and Added unit test cases using Junit & restTemplate FrameWork
 - Using h2 database to store the ToDoItem values -- we can extend it by adding any database support via hiberate framework
 - Maven build tool


# implementation Logic

 - ValidateBrackets :  For Validate bracket I am making use of HashMap & Stack to check the input string is balanced or not
    Please refer checkBrackets function in ValidateServiceImpl.java file 


# Build:

mvn -U clean install

# run
mvn spring-boot:run
 
 
# Access URLS for Testing 

# For Local

http://localhost:8081

# Demo URL

Code configured Amazon AWS instance and access it via the following URL


# Acess the Swagger URL from the below link to get know more about it and test via Swaager

http://localhost:8081/swagger-ui.html

or

http://ec2-13-236-68-89.ap-southeast-2.compute.amazonaws.com:8081/v2/api-docs

# API Examples
#        locahost	
   
	   Content-Type: application/json

#      input is encoded for browser access else you can pass ({[]})
	   GET http://localhost:8081/test/1.0/tasks/validateBrackets?input=%28%7B%5B%5D%7D%29
	   
	 
	   GET http://localhost:8081/test/1.0/status
	 
	   GET http://localhost:8081/test/1.0/todo{id}
	   
	   POST http://localhost:8081/test/1.0/todo        body:  { "name": "string"  }  //toDoItemAddRequest 
	   
	   PATCH http://localhost:8081/test/1.0/todo{id}   body: { "isCompleted": true,
                                                        "text": "string"
                                                       }     //toDoItemUpdateRequest 
     


#        AWS Instance access	
   
	   Content-Type: application/json

#      input is encoded for browser access else you can pass ({[]})
	   GET http://ec2-13-236-68-89.ap-southeast-2.compute.amazonaws.com:8081/test/1.0/tasks/validateBrackets?input=%28%7B%5B%5D%7D%29
	   
	 
	   GET http://ec2-13-236-68-89.ap-southeast-2.compute.amazonaws.com:8081/test/1.0/status
	 
	   GET http://ec2-13-236-68-89.ap-southeast-2.compute.amazonaws.com:8081/test/1.0/todo{id}
	   
	   POST http://ec2-13-236-68-89.ap-southeast-2.compute.amazonaws.com:8081/test/1.0/todo        body:  { "name": "string"  }  //toDoItemAddRequest 
	   
	   PATCH http://ec2-13-236-68-89.ap-southeast-2.compute.amazonaws.com:8081/test/1.0/todo{id}   body: { "isCompleted": true,
                                                                                                          "text": "string"
                                                                                                        }     //toDoItemUpdateRequest 
     












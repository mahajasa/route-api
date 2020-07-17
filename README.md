# route-api

### Description:
This api has capability of finding whether a route exist between two cities, based on the configurable cities and roads among them. List of roads is available in a file. The file contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities. An example content of input file is shown below. 'Boston, New York' line in the file tells us that there is a way to go from Boston to New york and New york to Boston.

### Assumption:
  the city names in the input are case insensitive.

### Example Input file:
* Boston, New York 
* Philadelphia, Newark 
* Newark, Boston 
* Trenton, Albany 

### Expected Output:
* The api will respond with 'Yes' 
	* if the source city is Newark and destination city is New York and
	* if the source city is Trenton and destination city is Albany.
* The api will respond with 'No'
	* if the source city is Trenton and destination city is Newark.

### Prerequisites:
  Java 8 and maven are installed prior to run this program

### Maven dependencies:
  * This is a spring boot web application   
  * In addition to this, this application uses springdoc-openapi dependency which helps expose the rest api's swagger endpoints.
  
  		* <dependency>
			* <groupId>org.springdoc</groupId>
			* <artifactId>springdoc-openapi-ui</artifactId>
			* <version>1.2.32</version>
		* </dependency>
		
		* <dependency>
			* <groupId>org.springframework.boot</groupId>
			* <artifactId>spring-boot-starter-web</artifactId>
    		* </dependency>
    
### API Details:
  	* Name of the API - Route API
  	* Base path - "/api/routes"
  	* Operations:
 	 *GET 
		  * Operation path- "/connected"
           	  * Query parameters - sourceCity, destinationCity
           	  * Response body - String (Yes or No)
	 *GET   
           	  * Operation path- "/info"
### Execution:
  * 1) Clone the source code from https://github.com/mahajasa/route-api.git 
  * 2) Build the application with the command - mvn clean install
  * 3) Run the application with the command at location 'PATH_TO_APPLICATION_ROOT_DIRECTORY/taget'
        * java -jar route-api-0.0.1-SNAPSHOT.jar

### Swagger Endpoint:
  * Swagger UI is available on the following path after the server starts 
      * http://localhost:8080/swagger-ui.html
      
      

### Invoke the api
  * When this application runs successfully on local host, it can be accessed at the following endpoint. Path parameters can be changed as desired
        * http://localhost:8080/api/routes/connected?sourceCity=Trenton&destinationCity=Philadelphia 
	
### Test case 
  * Coverage report after maven build can be found at 'PATH_TO_APPLICATION_ROOT_DIRECTORY/taget/site/jococo/index.html'
        
        

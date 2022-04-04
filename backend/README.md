## Setup Keycloak as authorization server

1. Run Keycloak ```docker run --rm -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak:13.0.1```.  
2. Open Keycloak server in the browser http://localhost:8080/auth. Then go to the ```Administration Console```. Use credentials provided with the command above.  
  ![img_1.png](img/img_1.png)
3. Go to ```Partial Import``` and select file ```backend/realm-export.json```. Select ```skip``` for ```If a resource exists``` and click ```Import```.  
  ![img_1.png](img/img_2.png)
## Run Spring Boot REST API

1. Run ```mvn spring-boot:run -f pom.xml```.  
2. Open Swagger-UI in the browser http://localhost:8085/api/swagger-ui/index.html. Expand ```user-controller```, click ```/api/user/login``` and then ```Try it out```. Write your keycloak-credentials and click ```Execute```. You should get back some user info and an access token.  
  ![img_1.png](img/img_3.png)
3. Copy the access token, go to the top of Swagger-UI and click ```Authorize```, write ```Bearer ``` + you access token and click ```Authorize```.  
  ![img_10.png](img/img_4.png)
4. Expand ```hello-id-controller```, click ```Try it out``` and ```Execute```. In the response body you should get back 'Hello ' + your Keycloak user ID.  
  ![img_11.png](img/img_5.png)
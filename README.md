To run this project, run {docker compose up -d} in terminal.
This should start a container for the app, database and messaging service.

Use your preferred API platform such as Postman. 
The endpoints can be found in directory resources/endpoints of this project.
Download the folders locally and import them in your API platform. 

The endpoints require a token (jwt). To get a token run the POST endpoint in the ADMIN folder (localhost:8080/api/auth)

For easy testing purpose we have four default users with four auth types in the directory tempuser/StartUpRun.

Messaging Service used is Activemq - to access UI go to localhost:8161 (username: admin, password: admin).

To send message to queue use endpoint localhost:8081/api/order (only token created by ROLE: customer can acess this endpoint,
make sure token is created before sending message)

Message reciever is another application (https://github.com/ArifHoss/food-bear-reciver.git). 
This application is to be run locally and pending message will automatically be received.
To run this project, run {docker compose up -d} in terminal.
This should start a container for the app, database and messaging service.

Use your preferred API platform such as Postman. 
The endpoints can be found in directory resources/endpoints of this project.
Download the folders locally and import them in your API platform. 

The endpoints require a token (jwt). To get a token run the POST endpoint in the ADMIN folder (localhost:8080/api/auth)

For easy testing purpose we have four default users with four auth types in the directory tempuser/StartUpRun.
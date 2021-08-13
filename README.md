# StoryDrops

This is a simple story blogging Web Application with authentication features.

## Project Function

User can:
1. See all blogs with author name
2. Create account
3. Log in
4. Create blogs if logged in
5. Update own blogs
6. Delete own blogs

## How to Run

1. Clone this repository
2. Install MySql in your local machine and make sure that it is running on port 3306.
3. Create a schema (db) in your mySql named "storydrops", or you can use your own schema. For doing that you have to change the datasource.url in /src/main/resource/application.properties
4. Install jdk 11

After completing 1-4 steps, you can run this project in your local machine. You could use CLI/intellij/docker to run this project.


To run using CLI:

A.1. Follow the 1-4 steps

B.1. Make sure you are using gradle 7.1.* on your local machine.

C.1. Run command on terminal(linux)/ cmd prompt(windows)/ powershell(windows): `cd StoryDrops`

D.1. Run appropriate command to build and run this gradle project.


To run using intellij:  

A.2. Follow the 1-4 steps

B.2. Install intellij in your local machine.

C.2. Start intellij and open this project.

D.2. Build this project from intellij.

E.2. Go to /src/main/java/com/example/storyDrops/storyDropsApplication.java

F.2. Run the main method.

The backend project will run on port 5000. You can change the port number by changing server.port in /src/main/resource/application.properties.


To run using docker:

Beside the backend api image and mysql image, the docker-compose file in this project also contains a client-side image. So, by using docker you can run this project along with the frontend (client-side). To do that, follow next steps...

A.3. Clone this repository

B.3. Clone the frontend repository from "https://github.com/asmachy/simple-blogging-website-frontend"

C.3 The frontend and backend repository must be in the same folder

D.3. Install appropriate version (according to your operating system) of docker on your local machine.

E.3. Make sure that port 5000, 3000 and 3307 on your local machine is free. 

F.3. Run command on terminal(linux)/ cmd prompt(windows)/ powershell(windows): `cd StoryDrops`

G.3: Run command: `docker compose up`

The backend project will run on port 5000 and frontend will run on port 3000.

## Features
### To register (POST http://localhost:5000/user/register):

    POST /user/register 

    {

    "fullname":"user name", 

    "email":"user_email", 

    "password":"user_password"

    }

### To login (POST http://localhost:5000/user/login):

    POST /user/login

    {

    "email":"valid_email",

    "password":"valid_password"

    }

### To validate login by token (POST http://localhost:5000/user/login/token):

    POST /login/token
    Authorization: Bearer {valid_token}

### To see all blogs (GET http://localhost:5000/posts):

    GET /posts

### To see any particular blog (GET http://localhost:5000/posts/{story_id}):

    GET /posts/{story_id}

### To create new blog (POST http://localhost:5000/posts):

    POST /posts

    Authorization: Bearer {valid_token}

    {

    "title":"Story title", 

    "body":"Story body"

    }

### To update any blog (PUT http://localhost:5000/posts/{story_id}):

    PUT /posts/{story_id}

    Authorization: Bearer {valid_token}

    {

    "title":"story_title",

    "body":"story_body"

    }

### To delete any blog (DELETE http://localhost:5000/posts/{story_id}):

    DELETE /posts/{story_id}

    Authorization: Bearer {valid_token}`

## Technology Used
Spring boot (version 2.5.3), Spring security, Jwt Authentication, JDK 11, gradle 7.1.1, MySQL
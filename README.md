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
5. Install intellij in your local machine.
6. Start intellij and open this project.
7. Build this project from intellij.
8. Go to /src/main/java/com/example/storyDrops/storyDropsApplication.java
9. Run the main method.

Or, you can also run this project from CLI (Command line interface). To do that,

A. Follow the 1-4 steps

B. Make sure you are using gradle 7.1.* on your local machine. 

C. Run command on terminal(linux)/ cmd prompt(windows)/ powershell(windows): `cd StoryDrops`

D. Run appropriate command to build and run this gradle project.

The project will run on localhost port 5000. You can change the port number by changing server.port in /src/main/resource/application.properties

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
Spring boot (version 2.5.3), Spring security, Jwt Authentication, JDK 11, gradle 7.1.1
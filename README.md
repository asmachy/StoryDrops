# StoryDrops

## Function

User can:
1. Create account.
2. Log in.
3. access story related mocked urls (POST, PUT, DELETE).

## URI

To create new user: POST http://localhost:5000/user/register,

   Request Body: {"fullname":"Your name", "email":"example@email.com", "password":"your password"}
   
To Log in: POST http://localhost:5000/user/login,

   Request Body: {"email":"Registered email", "password":"correct password"}

To see stories (mock): GET http://localhost:5000/posts/

To see particular sotry (mock): GET http://localhost:5000/posts/{id} (0<id<=3), 

To create story (mock): POST http://localhost:5000/posts/, Use Jwt token

   Request Body: {"title":"story title", "body":"story body"}
   
To edit story (mock): PUT http://localhost:5000/posts/{id} (0<id<=3), Use Jwt token

   Request Body: {"title":"story title", "body":"story body"}

To delete story (mock): DELETE http://localhost:5000/posts/{id} (0<id<=3), Use Jwt token
   
## Technology Used

Spring boot, Spring Security, Jwt Authentication

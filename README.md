# StoryDrops

## Function

User can:
1. Create account.
2. Log in.

## URI

To create new user: POST http://localhost:5000/user/register,

   Request Body: {"fullname":"Your name", "email":"example@email.com", "password":"your password"}
   
To Log in: POST http://localhost:5000/user/login,

   Request Body: {"email":"Registered email", "password":"correct password"}

## Technology Used

Spring boot, Spring Security

## TODO

1. Jwt Verification

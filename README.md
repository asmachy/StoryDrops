# StoryDrops

## Function

This branch contains some features:
1. User can create story.
2. User can update any story.
3. User can delete any story.
4. User can see all stories.
No authentication is needed.

## URI

To see all stories: GET http://localhost:8080/posts

To see any particular story: GET http://localhost:8080/posts/{post_id}

To create new story: POST http://localhost:8080/posts,

   Request Body: {"title":"", "body":""}

To update any story: PUT http://localhost:8080/posts/{post_id} ,

   Request Body: {"title":""} (if users want to update title)
   
   Request Body: {"body":""} (if users want to update body)
   
   Request Body: {"title":"", "body":""} (if users want to update both)
   
To delete any story: DELETE http://localhost:8080/posts/{post_id}

## Technology Used

Spring boot


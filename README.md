# StoryDrops

## Function

This branch contains some features:
1. User can create story.
2. User can update any story.
3. User can delete any story.
4. User can see all stories.
No authentication is needed.

## URI

To see all stories: GET http://localhost:5000/posts

To see any particular story: GET http://localhost:5000/posts/{post_id}

To create new story: POST http://localhost:5000/posts,

   Request Body: {"title":"", "body":""}

To update any story: PUT http://localhost:5000/posts/{post_id} ,

   Request Body: {"title":"","body":""}
   
To delete any story: DELETE http://localhost:5000/posts/{post_id}

## Technology Used

Spring boot


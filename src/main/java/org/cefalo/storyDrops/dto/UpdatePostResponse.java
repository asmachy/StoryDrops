package org.cefalo.storyDrops.dto;

import org.cefalo.storyDrops.model.Post;

public class UpdatePostResponse {
    public static class DemoPost{
        private String titile, body;

        public DemoPost(){

        }
        public DemoPost(String titile, String body){
            this.titile = titile;
            this.body = body;
        }
        public String getTitile() {
            return titile;
        }

        public void setTitile(String titile) {
            this.titile = titile;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
    private String message;
    private  DemoPost post;


    public UpdatePostResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DemoPost getPost() {
        return post;
    }

    public void setPost(DemoPost post) {
        this.post = post;
    }
}
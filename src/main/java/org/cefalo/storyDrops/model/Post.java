package org.cefalo.storyDrops.model;

import javax.validation.constraints.NotNull;

//import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;


    @NotNull(message = "Title can not be null")
    @Column(name = "title")
    private String title;

    @NotNull(message = "Body can not be null")
    @Column(name = "body")
    @NotNull
    private String body;

    @Column(name = "author")
    private String author;

    @Column(name = "author_email")
    private String author_email;

    public Post() {
        super();
    }

    public Post(Post post, String author, String author_email){
        super();
        this.author = author;
        this.author_email = author_email;
        this._id = post._id;
        this.title = post.title;
        this.body = post.body;

    }

    public Post(int _id, String body, String title, String author, String author_email) {
        super();
        this._id = _id;
        this.body = body;
        this.title = title;
        this.author = author;
        this.author_email = author_email;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor_email() {
        return author_email;
    }

    public void setAuthor_email(String author_email) {
        this.author_email = author_email;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

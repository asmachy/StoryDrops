package com.example.storyDrops.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _id;

    @NotNull(message = "Name can't be empty")
    private String fullname;

    @NotNull(message = "Email can't be null")
    private String email;

    @NotNull(message = "Password can't be null")
    private String password;

    public User(){
        super();
    }

    public User(String fullname, String email, String password) {
        super();
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

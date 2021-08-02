package org.cefalo.storyDrops.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;

    @NotNull
    @Column(name = "fullname")
    private String fullname;

    @NotNull
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "password")
    private String password;

    public User() {
        super();
    }

    public User(int _id, String fullname, String email, String password) {
        super();
        this._id = _id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
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

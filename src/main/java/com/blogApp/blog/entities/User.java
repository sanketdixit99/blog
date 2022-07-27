package com.blogApp.blog.entities;

<<<<<<< HEAD
import javax.persistence.*;
<<<<<<< HEAD
=======
=======
>>>>>>> 657db15 (user, category, posr API's)
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
>>>>>>> f16adeb (user and categories and post APIs)
=======
>>>>>>> 657db15 (user, category, posr API's)

@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_name", nullable = false, length = 100)
    private String name;
    private String email;
    private String password;
    private String about;

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 657db15 (user, category, posr API's)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();


<<<<<<< HEAD
>>>>>>> f16adeb (user and categories and post APIs)
=======
>>>>>>> 657db15 (user, category, posr API's)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}

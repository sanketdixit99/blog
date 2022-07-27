package com.blogApp.blog.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> f16adeb (user and categories and post APIs)
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 657db15 (user, category, posr API's)

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "title", length = 100, nullable = false)
    private String categoryTitle;

    @Column(name = "description")
    private String categoryDescription;
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 657db15 (user, category, posr API's)

    //A category can have multiple posts
    //adding relation chains

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();
<<<<<<< HEAD
>>>>>>> f16adeb (user and categories and post APIs)
=======

>>>>>>> 657db15 (user, category, posr API's)
}

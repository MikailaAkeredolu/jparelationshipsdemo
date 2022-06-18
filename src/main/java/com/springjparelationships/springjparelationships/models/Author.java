package com.springjparelationships.springjparelationships.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
//an Author may have many books.
//he Author entity would define a @OneToMany relationship with Book.

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;

    private String name;

    //ONE TO MANY
    //Author has many books or a Customer has Many orders
    //The Author entity would define a @OneToMany relationship with Book.
    @JsonIgnore
    @OneToMany(mappedBy = "author")
    private List<Book> lisOfBooks = new ArrayList<>();   //the Author class maintains a list of all of the books written by that author



    //MANY TO MANY
    //The @ManyToMany annotation in the Author class references the field in the Book class that manages the relationship;
    // namely the authors property.

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;


}

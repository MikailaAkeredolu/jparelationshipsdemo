package com.springjparelationships.springjparelationships.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
//a Book can have only one Author,
//The Book entity would define a @ManyToOne relationship with Author
// Book class maintains a reference to its single author.
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    private Long isbn;
    private Integer totalPages;
    private Double rating;
    private Date publishedDate;


    //ONE TO ONE
    //One-To-One will help us create a foreign key for photo_id parameter in Book table
    // - We should add this annotation to both entity classes that’s because this is a bidirectional relationship.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")  //We want to create a column in Book table. So, we will use JoinColumn annotation in Book class.//foreign key with photo_id parameter
    private Photo photo;





    //MANY TO ONE
    /*

    The @OneToMany and @ManyToOne annotations facilitate both sides of the same relationship.
    Scenario:  A Book can have only one Author, but an Author may have many books.
     The Book entity would define a @ManyToOne relationship with Author
     The Author entity would define a @OneToMany relationship with Book.

     */

    @ManyToOne    //A Book can have only one Author or an Order can have only one Customer -  Book class maintains a reference to its single author.
    @JoinColumn(name = "author_id") // the @JoinColumn specifies the name of the column in the Book table to store the ID of the Author.
    private Author author;





    //MANY TO MANY

    //A book has Many authors
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    //we create a new table, BOOK_AUTHORS, with two columns: BOOK_ID and AUTHOR_ID
    //Using the joinColumns and inverseJoinColumns attributes tells your JPA framework how to map these classes in a many-to-many relationship

}

package com.springjparelationships.springjparelationships.models;

import javax.persistence.*;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id") // primary key
    private Long id;

    //ONE TO ONE
    //On the Photo class, simply put OneToOne annotation and fill mappedBy field by variable name on the owning side. which is ‘photo’.
    @OneToOne(mappedBy = "photo") //mappedBy references the field name on the class that manages the relationship
    private Book book;


}

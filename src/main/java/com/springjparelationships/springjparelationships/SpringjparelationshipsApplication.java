package com.springjparelationships.springjparelationships;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringjparelationshipsApplication {

	/*
	 Notes:

	 Many-To-Many *************************************************************************

	 A book can have many authors
	 An author can have many books.

	 One-To-Many **************************Author may have many books.***********************************************
	  One Poll has Many Set<Options>
	  @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name="POLL_ID")

	 One reader has Many Addresses

	 or

	 Many-To-One ***********************Consider an example where a Book can have only one Author,**************************************************
	 Many readers live in one area

    //inside of Orders Table -  many Orders may be associated to one Customer
    //Consider an example where a Book can have only one Author,

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "customer")
     private Customer customer;


	 One-To-One *************************************************************************
	 A book can have One coverPhoto ( but cover phone can have different sizes or enum )



	 */

	public static void main(String[] args) {
		SpringApplication.run(SpringjparelationshipsApplication.class, args);
	}

}

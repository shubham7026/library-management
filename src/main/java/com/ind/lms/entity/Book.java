package com.ind.lms.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Entity
@Getter
@Setter
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long isbn;
    int year;
    int pages;
    String title;
    String  author;
    String imageLink;
    String country;
    String language;
    String link;
}

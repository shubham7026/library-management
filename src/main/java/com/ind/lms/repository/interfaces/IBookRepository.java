package com.ind.lms.repository.interfaces;

import com.ind.lms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBooksByAuthorName(String authorName);
    List<Book> findBooksByIsbn(String authorName);
    //int  countBooksByCountry(String country);
    //@Query(value = "select book.authorName from Book book where book.language ='sanskrit' ")
    //List<String> findByLanguageAndPublishedAfterYear(int year);
}

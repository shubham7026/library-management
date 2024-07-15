package com.ind.lms.services.interfaces;

import com.ind.lms.entity.Book;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IBookApplicationService {
    Book getBookByIsbn(int isbn);
    List<Book> addBooks(List<Book> books);

    List<Book> getAllBooks();

    List<Book> getAllBooksByCountry(@PathVariable("country") String country);
}

package com.ind.lms.restcontroller;


import com.ind.lms.entity.Book;
import com.ind.lms.services.interfaces.IBooksApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController

public class BookRestController {

    private final IBooksApplicationService booksApplicationService;

    @GetMapping("/book/{isbn}")
    public ResponseEntity<Book> getBookById(@PathVariable("isbn") int isbn) {
        Book book = booksApplicationService.getBookById(isbn);
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }

    @PostMapping("/books")
    public ResponseEntity<List<Book>> addBooks(@RequestBody List<Book> books) {
        List<Book> addedBooks = booksApplicationService.addBook(books);
        return new ResponseEntity<>(addedBooks, HttpStatus.CREATED);
    }
}

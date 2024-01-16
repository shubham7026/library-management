package com.ind.lms.restcontroller;


import com.ind.lms.entity.Book;
import com.ind.lms.services.interfaces.IBooksApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("books")
public class BookRestController {

    @Autowired
    IBooksApplicationService iBookRepository;


    @GetMapping("/book/{isbn}")
    public ResponseEntity<Book> getBookById(@PathVariable("isbn") int isbn) {
        Book book = iBookRepository.getBookById(isbn);
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }

    @PostMapping("/books")
    public ResponseEntity<List<Book>> addBooks(@RequestBody List<Book> books) {
        List<Book> addedBooks = iBookRepository.addBook(books);
        return new ResponseEntity<>(addedBooks, HttpStatus.CREATED);
    }
}

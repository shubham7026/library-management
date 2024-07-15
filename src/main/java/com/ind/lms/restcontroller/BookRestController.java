package com.ind.lms.restcontroller;


import com.ind.lms.entity.Book;
import com.ind.lms.services.interfaces.IBookApplicationService;
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
@RestController("bookController") // this tells spring boot, a rest based service and will automatically serialize/deserialize service request and response.
public class BookRestController {

    private final IBookApplicationService booksApplicationService;

    @GetMapping("/book/{isbn}")
    public ResponseEntity<Book> getBookById(@PathVariable("isbn") int isbn) {
        Book book = booksApplicationService.getBookByIsbn(isbn);
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = booksApplicationService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }

    @GetMapping("/books/{country}")
    public ResponseEntity<List<Book>> getBookByCountry(@PathVariable("country") String country) {
        List<Book> books = booksApplicationService.getAllBooksByCountry(country);
        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }

    @PostMapping("/books")
    public ResponseEntity<List<Book>> addBooks(@RequestBody List<Book> books) {
        List<Book> addedBooks = booksApplicationService.addBooks(books);
        return new ResponseEntity<>(addedBooks, HttpStatus.CREATED);
    }
}

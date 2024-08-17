package com.ind.lms.restcontroller;


import com.ind.lms.entity.Book;
import com.ind.lms.services.interfaces.IBookApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController("bookController")// this tells spring boot, a rest based service and will automatically serialize/deserialize service request and response.
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final IBookApplicationService booksApplicationService;

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {
        Book book = booksApplicationService.getBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = booksApplicationService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping(value = "/books", params = "authorName")
    public ResponseEntity<List<Book>> getAllBooksByAuthorName(@RequestParam("authorName") String authorName) {
        List<Book> books = booksApplicationService.getAllBooksByAuthorName(authorName);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<List<Book>> addBooks(@RequestBody List<Book> books) {
        List<Book> addedBooks = booksApplicationService.addBooks(books);
        return new ResponseEntity<>(addedBooks, HttpStatus.CREATED);
    }
}

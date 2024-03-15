package com.ind.lms.services.implementation;

import com.ind.lms.customexceptions.BookNotFoundException;
import com.ind.lms.entity.Book;
import com.ind.lms.repository.interfaces.IBookRepository;
import com.ind.lms.services.interfaces.IBooksApplicationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@AllArgsConstructor
@Component
public class BooksApplicationService implements IBooksApplicationService {

    private final IBookRepository iBookRepository;

    @Override
    public Book getBookById(int isbn) {
        log.debug("Getting book by isbn : {}",isbn);
        Optional<Book> bookOptional =  iBookRepository.findById(isbn);
        AtomicReference<Book> book = new AtomicReference<>();
        bookOptional.ifPresentOrElse(book::set,() ->{
            log.error("Book not found with id : {}",isbn);
            throw new BookNotFoundException("Book not found with isbn : " + isbn);
        });
        log.debug("Book found with id : {}", isbn);
        return book.get();
    }

    @Override
    public List<Book> addBook(List<Book> books) {
        log.debug("Adding books to the database : {}", books);
        List<Book> addedBooks = iBookRepository.saveAll(books.stream().filter(Objects::nonNull).toList());
        log.debug("Adding books to the database : {}", addedBooks);
        return addedBooks;
    }
}

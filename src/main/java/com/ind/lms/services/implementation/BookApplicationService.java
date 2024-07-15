package com.ind.lms.services.implementation;

import com.ind.lms.customexceptions.BookNotFoundException;
import com.ind.lms.entity.Book;
import com.ind.lms.repository.interfaces.IBookRepository;
import com.ind.lms.services.interfaces.IBookApplicationService;
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
public class BookApplicationService implements IBookApplicationService {

    private final IBookRepository iBookRepository;

    @Override
    public Book getBookByIsbn(int isbn) {
        log.debug("Getting book by isbn : {}",isbn);
        Optional<Book> bookOptional =  iBookRepository.findById(isbn);
        AtomicReference<Book> book = new AtomicReference<>();
        bookOptional.ifPresentOrElse( books->{
                book.set(books);
                log.debug("Book found with isbn : {}, {}", isbn, books);
        },() ->{
            log.error("Book not found with id : {}",isbn);
            throw new BookNotFoundException("Book not found with isbn : " + isbn);
        });
        return book.get();
    }

    @Override
    public List<Book> addBooks(List<Book> books) {
        log.debug("Adding books to the database : {}", books);
        List<Book> addedBooks = iBookRepository.saveAll(books.stream().filter(Objects::nonNull).toList());
        log.debug("Adding books to the database : {}", addedBooks);
        return addedBooks;
    }

    @Override
    public List<Book> getAllBooks() {
        log.debug("Fetching books from the database");
        log.debug("Total Books count - {}", iBookRepository.count());
        log.debug("Total Books count - {}", iBookRepository.findByLanguageAndPublishedAfterYear(1999));
        List<Book> books = iBookRepository.findAll();
        log.debug("books fetched from the database");
        return books;
    }

    @Override
    public List<Book> getAllBooksByCountry( String country) {
        log.debug("Fetching books from the database by country");
        log.debug("Total Books count - {}", iBookRepository.countBooksByCountry(country));
        List<Book> books = iBookRepository.findBooksByCountry(country);
        log.debug("books fetched from the database");
        return books;
    }
}

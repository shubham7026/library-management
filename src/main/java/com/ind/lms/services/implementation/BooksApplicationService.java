package com.ind.lms.services.implementation;

import com.ind.lms.customexceptions.BookNotFoundException;
import com.ind.lms.entity.Book;
import com.ind.lms.repository.IBookRepository;
import com.ind.lms.services.interfaces.IBooksApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class BooksApplicationService implements IBooksApplicationService {

    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Book getBookById(int isbn) {
        Optional<Book> bookOptional =  iBookRepository.findById(isbn);
        AtomicReference<Book> book = new AtomicReference<>();
        bookOptional.ifPresentOrElse(book::set,() ->{
            throw new BookNotFoundException("Book not found with isbn : " + isbn);
        });
        return book.get();
    }

    @Override
    public List<Book> addBook(List<Book> books) {
        List<Book> addedBooks = iBookRepository.saveAll(books);
        return addedBooks;
    }
}

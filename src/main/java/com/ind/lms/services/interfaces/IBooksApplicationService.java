package com.ind.lms.services.interfaces;

import com.ind.lms.entity.Book;

import java.util.List;

public interface IBooksApplicationService {
    Book getBookById(int isbn);
    List<Book> addBook(List<Book> books);
}

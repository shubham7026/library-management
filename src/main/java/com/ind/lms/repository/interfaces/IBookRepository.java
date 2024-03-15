package com.ind.lms.repository.interfaces;

import com.ind.lms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {

}

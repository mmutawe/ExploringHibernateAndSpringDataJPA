package com.mmutawe.explore.spring.data.jpa.exploringjpa.bootstraps;

import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.Book;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockDataInitializer implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(MockDataInitializer.class);

    private final BookRepository bookRepository;

    public MockDataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        List<Book> books = List.of(
                new Book("title_book1", "isbn_book1", "publisher_book1"),
                new Book("title_book2", "isbn_book2", "publisher_book2"),
                new Book("title_book3", "isbn_book3", "publisher_book3"));

        List<Book> savedBooks = bookRepository.saveAll(books);

        savedBooks.forEach(resBook -> logger.info(String.format("book with id %s has been saved to H2 DB.", resBook.getId())));
    }
}

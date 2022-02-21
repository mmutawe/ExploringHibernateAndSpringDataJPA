package com.mmutawe.explore.spring.data.jpa.exploringjpa.bootstraps;

import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.Book;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.BookUuid;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories.BookRepository;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories.BookUuidRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockDataInitializer implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(MockDataInitializer.class);

    private final BookRepository bookRepository;

    private final BookUuidRepository bookUuidRepository;

    public MockDataInitializer(BookRepository bookRepository, BookUuidRepository bookUuidRepository) {
        this.bookRepository = bookRepository;
        this.bookUuidRepository = bookUuidRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        List<Book> books = List.of(
                new Book("title_book1", "isbn_book1", "publisher_book1", null),
                new Book("title_book2", "isbn_book2", "publisher_book2", null),
                new Book("title_book3", "isbn_book3", "publisher_book3", null));

        List<Book> savedBooks = bookRepository.saveAll(books);

        savedBooks.forEach(resBook -> logger.info(String.format("book with id %s has been saved to H2 DB.", resBook.getId())));

        bookUuidRepository.deleteAll();

        List<BookUuid> uuidBooks = List.of(
                new BookUuid("title_book1", "isbn_book1", "publisher_book1", null),
                new BookUuid("title_book2", "isbn_book2", "publisher_book2", null),
                new BookUuid("title_book3", "isbn_book3", "publisher_book3", null));

        List<BookUuid> savedUuidBooks = bookUuidRepository.saveAll(uuidBooks);

        savedUuidBooks.forEach(resBook -> logger.info(String.format("book with id %s has been saved to MySQL DB.", resBook.getId())));
    }
}

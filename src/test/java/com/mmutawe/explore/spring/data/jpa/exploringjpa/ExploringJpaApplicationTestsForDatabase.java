package com.mmutawe.explore.spring.data.jpa.exploringjpa;

import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.Book;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

// Integration Test for Data-JPA
// DataJpaTest will bring up Hibernate. If we are using an H2 database
// it will get auto-configured for us, as well as the entities and
// spring data-Jpa
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ComponentScan(basePackages = {"com.mmutawe.explore.spring.data.jpa.exploringjpa.bootstraps"})
public class ExploringJpaApplicationTestsForDatabase {

    @Autowired
    BookRepository bookRepository;

    @Test
    @Order(1)
    @Commit // @Rollback(value = false)
    void testJpaFunctioning(){
        long countBefore = bookRepository.count();
//        assertThat(countBefore).isZero();
        assertThat(countBefore).isEqualTo(3);

//        bookRepository.save(new Book("book_title_1", "book_isbn_1", "book_publisher_1"));
        bookRepository.save(new Book("book_title_4", "book_isbn_4", "book_publisher_4"));
        long countAfter = bookRepository.count();
        assertThat(countBefore).isLessThan(countAfter);
    }

    @Test
    @Order(2)
    void testJpaTransaction(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(4);
    }
}

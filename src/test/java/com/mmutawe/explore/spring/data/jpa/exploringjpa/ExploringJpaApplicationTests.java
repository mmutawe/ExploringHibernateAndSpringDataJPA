package com.mmutawe.explore.spring.data.jpa.exploringjpa;

import com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

// Integration Test
@SpringBootTest
class ExploringJpaApplicationTests {

    @Autowired
    BookRepository bookRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testBookRepository() {
        long bookCount = bookRepository.count();

        assertThat(bookCount).isGreaterThan(0);
    }


}

package com.mmutawe.explore.spring.data.jpa.exploringjpa;

import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.AuthorEmbedded;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.AuthorUuid;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.BookUuid;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.nameids.NameId;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories.AuthorEmbeddedRepository;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories.AuthorUuidRepository;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories.BookRepository;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories.BookUuidRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("local")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ComponentScan(basePackages = {"com.mmutawe.explore.spring.data.jpa.exploringjpa.bootstraps"})
public class MySQLIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookUuidRepository bookUuidRepository;

    @Autowired
    AuthorUuidRepository authorUuidRepository;

    @Autowired
    AuthorEmbeddedRepository authorEmbeddedRepository;

    @Test
    void testMySQL(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }

    @Test
    void testAuthorUuid(){
        AuthorUuid author = authorUuidRepository.save(new AuthorUuid());
        Assertions.assertThat(author).isNotNull();
        Assertions.assertThat(author.getId()).isNotNull();

        AuthorUuid fetchedAuthor = authorUuidRepository.getById(author.getId());
        Assertions.assertThat(fetchedAuthor).isNotNull();
    }

    @Test
    void testBookUuid(){
        BookUuid book = bookUuidRepository.save(new BookUuid());
        Assertions.assertThat(book).isNotNull();
        Assertions.assertThat(book.getId()).isNotNull();

        BookUuid fetchedBook = bookUuidRepository.getById(book.getId());
        Assertions.assertThat(fetchedBook).isNotNull();
    }

    @Test
    void authorEmbeddedTest(){
        NameId nameId = new NameId("Kuriboh", "YuGiOh");
        AuthorEmbedded authorEmbedded = new AuthorEmbedded(nameId,"Egypt");

        AuthorEmbedded author = authorEmbeddedRepository.save(authorEmbedded);
        assertThat(author).isNotNull();

        AuthorEmbedded fetchedAuthor = authorEmbeddedRepository.getById(nameId);
        assertThat(fetchedAuthor).isNotNull();
    }
}

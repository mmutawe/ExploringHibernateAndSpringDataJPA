package com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories;

import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
}

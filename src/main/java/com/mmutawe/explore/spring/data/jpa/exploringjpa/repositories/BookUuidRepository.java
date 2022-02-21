package com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories;

import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.BookUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface BookUuidRepository extends JpaRepository<BookUuid, UUID> {
}

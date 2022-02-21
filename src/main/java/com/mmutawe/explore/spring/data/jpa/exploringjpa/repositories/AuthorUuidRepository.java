package com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories;

import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.AuthorUuid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorUuidRepository extends JpaRepository<AuthorUuid, UUID> {
}

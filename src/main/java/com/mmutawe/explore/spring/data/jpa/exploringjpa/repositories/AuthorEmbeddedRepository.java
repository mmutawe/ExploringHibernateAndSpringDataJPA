package com.mmutawe.explore.spring.data.jpa.exploringjpa.repositories;

import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.AuthorEmbedded;
import com.mmutawe.explore.spring.data.jpa.exploringjpa.domains.nameids.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}

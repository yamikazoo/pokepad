package com.github.yamikazoo.pokepad.repositories;

import com.github.yamikazoo.pokepad.models.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // DAO for Collection entity
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    // extending the JpaRepository provides CRUD methods like save(), findById(), findAll(), delete(), etc.
}

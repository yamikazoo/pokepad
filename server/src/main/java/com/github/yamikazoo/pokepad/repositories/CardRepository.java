package com.github.yamikazoo.pokepad.repositories;

import com.github.yamikazoo.pokepad.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository     // Data Access Object (DAO) for Card entity
public interface CardRepository extends JpaRepository<Card, Long> {
    // allows usage of save(), findById(), findAll(), delete() etc.
}
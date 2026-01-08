package com.github.yamikazoo.pokepad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.yamikazoo.pokepad.models.User;
import org.springframework.stereotype.Repository;

@Repository // DAO for User entity
public interface UserRepository extends JpaRepository<User, Long> {
    // extending the JpaRepository provides CRUD methods like save(), findById(), findAll(), delete(), etc.
}

package com.github.yamikazoo.pokepad.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Column;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "collections")
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    // join table that links collections and cards
    @ToString.Exclude // avoid stack overflow from circular referencing of collections and cards
    @ManyToMany
    @JoinTable(
        name = "collection_cards", // name of the new hidden link table
        joinColumns = @JoinColumn(name = "collection_id"), // link to this collection
        inverseJoinColumns = @JoinColumn(name = "card_id") // link to the card
    )
    private List<Card> cards;
    
    // creates a many to one foreign key relationship to User
    @ToString.Exclude // avoid stack overflow from circular referencing of collections and cards
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

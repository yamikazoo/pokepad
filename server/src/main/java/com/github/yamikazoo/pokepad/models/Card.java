package com.github.yamikazoo.pokepad.models; // Change this to match your project path

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; // If you are using Lombok

@Entity
@Data // This Lombok annotation automatically creates Getters and Setters
public class Card {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String setId;
    private String imageUrl;
    private String language; // "EN" or "JP"
}
package com.github.yamikazoo.pokepad.controllers;

import com.github.yamikazoo.pokepad.models.Collection;
import com.github.yamikazoo.pokepad.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     // tells spring this class is a controller for handling HTTP requests and that every method returns JSON
@RequestMapping("/api/collections")   // sets the target address of the file. locally, the file is now listening at http://localhost:8080/api/collections
public class CollectionController {
    // injects the CollectionService service into this class
    @Autowired
    private CollectionService collectionService;

    // this endpoint allows the frontend to save a card to a specific collection
    // example URL: POST http://localhost:8080/api/collections/1/add-card/5
    @PostMapping("/{collectionId}/add-card/{cardId}")
    public Collection addCardToCollection(
            @PathVariable Long collectionId, 
            @PathVariable Long cardId) {
        return collectionService.addCardToCollection(collectionId, cardId);
    }
}

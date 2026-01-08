package com.github.yamikazoo.pokepad.services;

import com.github.yamikazoo.pokepad.models.*;
import com.github.yamikazoo.pokepad.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    @Autowired
    private CardRepository cardRepository;

    public Collection addCardToCollection(Long collectionId, Long cardId) {
        // 1. Find the collection
        Collection collection = collectionRepository.findById(collectionId)
            .orElseThrow(() -> new RuntimeException("Collection not found"));

        // 2. Find the card
        Card card = cardRepository.findById(cardId)
            .orElseThrow(() -> new RuntimeException("Card not found"));

        // 3. Add the card to the collection's list (JPA handles the join table!)
        collection.getCards().add(card);

        // 4. Save and return
        return collectionRepository.save(collection);
    }
}
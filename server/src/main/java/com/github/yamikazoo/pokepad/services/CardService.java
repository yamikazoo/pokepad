package com.github.yamikazoo.pokepad.services;

import com.github.yamikazoo.pokepad.models.Card;
import com.github.yamikazoo.pokepad.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // indicates that this class is a service in the spring framework
public class CardService {

    @Autowired // injects the CardRepository repository into this class (IoC/Spring DI)
    private CardRepository cardRepository;

    // method to get all cards from the database
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    // possible future functions to add: getCardById() or searchByArtist()
}
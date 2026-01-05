package com.github.yamikazoo.pokepad.controllers;

import com.github.yamikazoo.pokepad.models.Card;
import com.github.yamikazoo.pokepad.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// this is the only part of the backend that the React app and the outside world will ever interact with
@RestController                  // tells spring this class is a controller for handling HTTP requests and that every method returns JSON
@RequestMapping("/api/cards")    // sets the target address of the file. locally, the file is now listening at http://localhost:8080/api/cards
public class CardController {
    @Autowired // injects the CardService service into this class
    private CardService cardService;

    @GetMapping // listens for GET requests at the target address (currently /api/cards)
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }
}

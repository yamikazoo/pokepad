package com.github.yamikazoo.pokepad.config;

import com.github.yamikazoo.pokepad.models.Card;
import com.github.yamikazoo.pokepad.models.User;
import com.github.yamikazoo.pokepad.models.Collection;
import com.github.yamikazoo.pokepad.repositories.CardRepository;
import com.github.yamikazoo.pokepad.repositories.CollectionRepository;
import com.github.yamikazoo.pokepad.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component  // tells Spring to manage this class as a bean
public class DataSeeder implements CommandLineRunner{
    private final CardRepository cardRepository;

    // inject CardRepository via constructor
    public DataSeeder(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Autowired 
    private UserRepository userRepository;
    
    @Autowired 
    private CollectionRepository collectionRepository;

    @Override
    public void run(String... args) {
        // if no cards exist, seed some initial cards
        if (cardRepository.count() == 0) {
            Card c1 = createCard("Charizard", "base1-4", "https://images.pokemontcg.io/base1/4_hires.png", "Rare Holo", "Mitsuhiro Arita");
            Card c2 = createCard("Blastoise", "base1-2", "https://images.pokemontcg.io/base1/2_hires.png", "Rare Holo", "Ken Sugimori");
            Card c3 = createCard("Venusaur", "base1-15", "https://images.pokemontcg.io/base1/15_hires.png", "Rare Holo", "Mitsuhiro Arita");
            Card c4 = createCard("Mewtwo", "base1-10", "https://images.pokemontcg.io/base1/10_hires.png", "Rare Holo", "Ken Sugimori");

            cardRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
            System.out.println("4 Cards added to the database");
        }

        // if no users exist, create a test user and a collection
        if (userRepository.count() == 0) {
            // create a test user
            User tester = new User();
            tester.setUsername("TrainerRed");
            tester.setPassword("password123"); // temporary unhashed password for testing purposes, to be changed 
            userRepository.save(tester);

            // create a test collection for the user
            Collection binder = new Collection();
            binder.setName("My Favorites");
            binder.setUser(tester); // link collection to test user
            collectionRepository.save(binder);
            
            System.out.println("User 'TrainerRed' and collection 'My Favorites' created");
        }
    }

    // Helper method to keep the code clean
    private Card createCard(String name, String setId, String url, String rarity, String artist) {
        Card card = new Card();
        card.setName(name);
        card.setSetId(setId);
        card.setImageUrl(url);
        card.setRarity(rarity);
        card.setArtist(artist);
        card.setLanguage("EN");
        return card;
    }
}

package com.hunteryavitz.iterativesvsstreams;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple Spring Boot application to demonstrate the performance difference between
 * using an iterative approach to create a deck of cards and using a stream approach.
 */
@RestController
@RequestMapping("/performance/benchmark/iteratives-vs-streams")
public class Main {

    Deck deck = new Deck();

    /**
     * Test the performance of the iterative approach vs the stream approach.
     * @return the difference in time between the two approaches in nanoseconds
     */
    @GetMapping("/test")
    public String get() {

        long startTimeIteration = System.nanoTime();
        deck.getDeckByIteration();
        long durationIteration = (System.nanoTime() - startTimeIteration);

        long startTimeStream = System.nanoTime();
        deck.getDeckByStream();
        long durationStream = (System.nanoTime() - startTimeStream);

        return "Nano: " + (durationStream - durationIteration);
    }

    /**
     * Create a new deck of cards using an iterative approach and return a random card.
     * @return a random card from the deck
     */
    @GetMapping("/pickACard")
    public String pickACard() {
        this.deck = new Deck();
        return deck.pickACard().toString();
    }
}

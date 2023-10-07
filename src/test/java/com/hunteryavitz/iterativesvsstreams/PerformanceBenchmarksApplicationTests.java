package com.hunteryavitz.iterativesvsstreams;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PerformanceBenchmarksApplicationTests {

    /**
     * Create a new deck of cards.
     */
    Deck deck;

    /**
     * Test the performance of the iterative approach vs the stream approach.
     */
    @Test
    void contextLoads() {
    }

    /**
     * Test the Card class.
     */
    @Test
    void testCard() {
        Card card = new Card(Suit.HEARTS, Rank.NINE);
        assert(card.getSuit() == Suit.HEARTS);
        assert(card.getRank() == Rank.NINE);
        assert(card.toString().equals("NINE of HEARTS"));
    }

    /**
     * Test the Deck class.
     */
    @Test
    void testDeck() {
        deck = new Deck();
        deck.getDeckByIteration();
        assert(deck.getCards().size() == 52);
        assert(deck.getCards().contains(new Card(Suit.HEARTS, Rank.NINE)));
        assert(deck.pickACard() != null);

        deck = new Deck();
        deck.getDeckByStream();
        assert(deck.getCards().size() == 52);
        assert(deck.getCards().contains(new Card(Suit.HEARTS, Rank.NINE)));
        assert(deck.pickACard() != null);
    }

    /**
     * Test the performance of the iterative approach vs the stream approach.
     */
    @Test
    void testPerformance() {
        deck = new Deck();
        long startTimeIteration = System.nanoTime();
        deck.getDeckByIteration();
        long durationIteration = (System.nanoTime() - startTimeIteration);

        deck = new Deck();
        long startTimeStream = System.nanoTime();
        deck.getDeckByStream();
        long durationStream = (System.nanoTime() - startTimeStream);

        assert(durationStream != durationIteration);
    }

    /**
     * Test the main method.
     */
    @Test
    void testMain() {
        Main main = new Main();
        assert(main.get().contains("Nano: "));
    }
}

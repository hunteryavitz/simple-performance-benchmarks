package com.hunteryavitz.iterativesvsstreams;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents a deck of playing cards.
 */
@Data
public class Deck {

    /**
     * The cards in the deck.
     */
    private Set<Card> cards;

    /**
     * Creates a new deck of cards.
     */
    public Deck() {
        this.cards = newDeckByIteration();
    }

    /**
     * Create a new deck of cards using an iterative approach.
     * @return a new deck of cards
     */
    private static Set<Card> newDeckByIteration() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        return new HashSet<>(cards);
    }

    /**
     * Create a new deck of cards using a stream approach.
     * @return a new deck of cards
     */
    private static Set<Card> newDeckByStream() {
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Rank.values())
                        .map(rank -> new Card(suit, rank)))
                .collect(Collectors.toSet());
    }

    /**
     * Creates a new deck of cards using a stream approach.
     */
    public void getDeckByStream() {
        new Deck();
    }

    /**
     * Creates a new deck of cards using an iterative approach.
     */
    public void getDeckByIteration() {
        new Deck();
    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() {
        return cards.toString();
    }

    /**
     * Adds a card to the deck.
     * @param card the card to add
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Removes a card from the deck.
     * @param card the card to remove
     */
    public void removeCard(Card card) {
        cards.remove(card);
    }

    /**
     * Picks a card from the deck.
     * @return a card from the deck
     */
    public Card pickACard() {
        return cards.stream().findAny().orElse(null);
    }

    /**
     * Returns the number of cards in the deck.
     * @param card the card to count
     * @return the number of cards in the deck
     */
    public String getCardValue(Card card) {
        return card.getRank().toString() + " of " + card.getSuit().toString();
    }
}

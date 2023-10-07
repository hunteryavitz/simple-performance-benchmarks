package com.hunteryavitz.iterativesvsstreams;

import lombok.Data;

/**
 * Represents a playing card.
 */
@Data
public class Card {

    /**
     * The suit of the card.
     */
    private Suit suit;

    /**
     * The rank of the card.
     */
    private Rank rank;

    /**
     * Creates a new card with the given suit and rank.
     * @param suit the suit
     * @param rank the rank
     */
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Returns a string representation of the card.
     * @return a string representation of the card
     */
    public String toString() {
        return rank + " of " + suit;
    }
}

package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardGame {
    private String name;
    private ArrayList<Card> deckOfCards;

    public CardGame(String name) {
        this.name = name;
        this.deckOfCards = new ArrayList<>();
        deck();
    }

    public void deck() {
        String[] suits = {"♥", "♣", "♦", "♠"};
        String[] symbols = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for (String suit : suits) {
            for (int i = 0; i < symbols.length; i++) {
                deckOfCards.add(new Card(suit, symbols[i], values[i] ));
            }
        }

    }
    public ArrayList<Card> getDeck() {
        return deckOfCards;
    }

    public Card dealCard() {
        if (!deckOfCards.isEmpty()) {
            return deckOfCards.remove(0);
        }
        return null;
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(deckOfCards, (card1, card2) -> card1.getValue() - card2.getValue());
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuit() {
        Collections.sort(deckOfCards, (card1, card2) -> {
            int comparingSuits = card1.getSuit().compareTo(card2.getSuit());
            if (comparingSuits == 0) {
                return card1.getValue() - card2.getValue();
            }
            return comparingSuits;
        });
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck() {
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }
}

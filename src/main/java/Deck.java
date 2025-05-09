/**
 * Deck of cards class
 * @author Radin Ajorlou
 * @version 1.0.0
 */
import java.util.*;
class Deck {
    String[] suits = new String[] {"Hearts", "Clubs", "Diamonds", "Spades"};
    private static final int suitsNum = 4;
    String[] names = new String[] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private static final int cardsNum = 13;
    private static final int maxCards = 52;

    private Card[] deck;

    /**
     * First constructoe:Takes in a deck of cards and sets it as the deck
     * @param cards An array of cards
     */
    public Deck(Card[] cards){
        this.deck = cards;
    }
    
    //Second constructor: generates an unshuffled deck of cards
    public Deck(){
        this.deck = new Card[maxCards];
        for (int i = 0; i < suitsNum; i++){
            for (int j = 0; j < cardsNum; j++){
                deck[i * 13 + j] = new Card(names[j], suits[i], i * 13 + j + 1);
            }
        }
    }

    /**
     * Gets the deck of cards
     * @return Card[] - the deck of cards
     */
    public Card[] getDeck(){
        return this.deck;
    }

    /**
     * Gets the size of the deck
     * @return int - the size of the deck
     */
    public int size(){
        return this.deck.length;
    }

    /**
     * Draws the top card from the pile
     * @return Card - Top card (arr[0]);
     */
    public Card draw(){
        Card[] newDeck = new Card[this.deck.length - 1];
        Card top = this.deck[0];
        for (int i = 1; i < newDeck.length + 1; i++){
            newDeck[i - 1] = this.deck[i];
        }
        this.deck = newDeck;
        return top;
    }


    /**
     * Shuffles the deck no argument
     */
    public void shuffle(){
        for (int i = 0; i < this.deck.length; i++){
            Random rand = new Random();
            int swapWithIndex = rand.nextInt(this.deck.length);
            Card temp = this.deck[i];
            this.deck[i] = this.deck[swapWithIndex];
            this.deck[swapWithIndex] = temp;
        }
    }

    /**
     * Adds a new card into the deck
     * @param newCard Card - card that will be added into the deck
     */
    public void addCard(Card newCard){
        if (newCard == null){
            return;
        }
        Card[] newDeck = new Card[this.deck.length + 1];
        for (int i = 0; i < newDeck.length - 1; i++){
            newDeck[i] = this.deck[i];
        }
        newDeck[newDeck.length] = newCard;
        this.deck = newDeck;
    } //NOT SURE IF THIS WORKS CHECK BACK AFTER 

    public void removeCard(Card cardToBeRemoved, DiscardPile discardPile){
        int length = this.deck.length;
        Card[] newDeck = new Card[length - 1];
        boolean cardExists = false;
        for (int i = 0, j = 0; i < length; i++, j++){
            if(this.deck[j] == cardToBeRemoved){
                discardPile.addCard(cardToBeRemoved);
                cardExists = true;
                j++;
            }
            newDeck[i] = this.deck[j];
        }
        if (cardExists){ //only if the card exists the hand gets changed which means if it doesnt the size of the hand stays the same
            this.deck = newDeck;
        }
    }
    

    /**
     * Reshuffles the deck with the new cards being added
     * @param newCards Card[] - the new set of cards that are supposed to be added
     */
    public void reshuffle(Card[] newCards){
        if (newCards == null){
            return;
        }
        Card[] newDeck = new Card[this.deck.length + newCards.length]; //Create a new Cards array with the size of the last deck plus the new cards
        for (int i = 0; i < this.deck.length; i++){
            newDeck[i] = this.deck[i]; //add every card from the last deck to the new one
        }
        for (int i = 0; i < newCards.length; i++){
            newDeck[i + this.deck.length] = newCards[i]; // add every card from the new set of cards into the new deck
        }
        this.deck = newDeck;

        //reshuffles
        for (int i = 0; i < this.deck.length; i++){
            Random rand = new Random();
            int swapWithIndex = rand.nextInt(this.deck.length);
            Card temp = this.deck[i];
            this.deck[i] = this.deck[swapWithIndex];
            this.deck[swapWithIndex] = temp;
        }
        
    }

}

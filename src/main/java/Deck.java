
import java.util.*;
/**
 * Deck of cards class
 * @author Radin Ajorlou
 * @version 1.0.0
 */
class Deck {
    String[] suits = new String[] {"Hearts", "Clubs", "Diamonds", "Spades"};
    private static final int suitsNum = 4;
    String[] names = new String[] {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private static final int cardsNum = 13;
    private static final int maxCards = 52;

    //create empty deck
    private Card[] deck;

    /**
     * Deck class constructor 
     * @param cards Card[] - the array of cards to go into the deck
     */
    public Deck(Card[] cards){
        this.deck = cards;
    }
    
    /**
     * Second constructor 0 argument: generates an unshuffled deck of cards (Hearts, clubs diamonds spades)(Ace -> king)
     */
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
        if (this.deck.length < 1){
            return null;
        }
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
        int length = this.deck.length;
        for (int i = 0; i < length; i++){
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
    public Card addCard(Card newCard){
        if (newCard == null){
            return newCard;
        }
        int length = this.deck.length;
        Card[] newDeck = new Card[length + 1];
        for (int i = 0; i < length; i++){
            newDeck[i] = this.deck[i];
        }
        newDeck[length] = newCard;
        this.deck = newDeck;
        return newCard;
    } 

    /**
     * remove card out of deck
     * @param cardToBeRemoved Card - Card thats to be removed from the deck
     * @return Card - card that has been removed from deck - null if it wasnt in the deck
     */
    public Card removeCard(Card cardToBeRemoved){
        int length = this.deck.length;
        if (length < 1){
            return null;
        }
        Card[] newDeck = new Card[length - 1];
        boolean cardExists = false;
        for (int i = 0, j = 0; j < length; i++, j++){
            if(this.deck[j] == cardToBeRemoved){
                cardExists = true;
                j++;
            }
            if (i < length - 1){
                newDeck[i] = this.deck[j];
            }
        }
        if (cardExists){ //only if the card exists the hand gets changed which means if it doesnt the size of the hand stays the same
            this.deck = newDeck;
            return cardToBeRemoved;
        }
        return null;
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
        Deck newestDeck = new Deck(newDeck); //reshuffles
        newestDeck.shuffle();
        this.deck = newestDeck.getDeck();     
    }

    /**
     * Override of the ToString method for the Deck
     * @return String - in format (card1, card2, etc..) e.g(Queen of Hearts, King of Spades);
     */
    @Override
    public String toString(){
        int length = this.deck.length;
        if (length < 1){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++){
            if (this.deck[i] != null){
                sb.append(this.deck[i].toString() + ", ");
            }
        }
        System.out.println(sb.length());
        sb.delete(sb.length() - 2, sb.length() + 1);
        return sb.toString();
    }

    /**
     * Override of the clone method for the class Deck
     * @return Deck - a copy of the deck
     */
    @Override
    public Deck clone(){
        return new Deck(this.deck);
    }
}

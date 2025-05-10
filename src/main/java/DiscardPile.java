/**
 * Class for creating a discard pile
 * @author Radin Ajorlou
 * @version 1.0.0
 */

class DiscardPile {
    private Deck discardPile;

    /**
     * DiscardPile constructor
     * @param discardPile Card[] - the array of cards currently in the discard pile
     */
    public DiscardPile(Card[] discardPile){
        this.discardPile = new Deck(discardPile);
    }

    /**
     * DiscardPile constructor 
     * @param discardPile Deck - the deck of cards currently in the discardPile
     */
    public DiscardPile(Deck discardPile){
        this.discardPile = discardPile;
    }

    /**
     * DiscardPile constructor 0 arguments creates empty pile
     */
    public DiscardPile(){
        this.discardPile = new Deck(new Card[0]);
    }

    /**
     * Gets the discard pile
     * @return Card[] - the array of cards in the discard pile 
     */
    public Card[] getDiscardPile(){
        return this.discardPile.getDeck();
    }

    /**
     * Gets the size of the discard pile 
     * @return int - the number of cards in the discard pile
     */
    public int size(){
        return this.discardPile.size();
    }

    /**
     * Adds a specific card into the discard pile 
     * @param newCard Card - the card to be added into the pile
     */
    public Card addCard(Card newCard){
        return this.discardPile.addCard(newCard);
    }

    /**
     * Removes the specified card from the discard pile and returns it
     * @param cardToBeRemoved Card - The card that the user wants to remove
     * @return Card - if the card exists in the pile it will be returned, if not, it will return null;
     */
    public Card removeCard(Card cardToBeRemoved){
        return this.discardPile.removeCard(cardToBeRemoved);
    }

    /**
     * Removes all cards from the discardPile and returns them
     * @return Card[] - Every card currently in the pile, empty array if the pile is empty
     */
    public Card[] removeAll(){
        Card[] pileToBeReturned = this.discardPile.getDeck();
        this.discardPile = new Deck(new Card[0]);
        return pileToBeReturned;
    }

    /**
     * Override of the ToString method for the discard pile
     * @return String - in format (card1, card2, etc..) e.g(Queen of Hearts, King of Spades);
     */
    @Override
    public String toString(){
        return this.discardPile.toString();
    }

    /**
     * Override of the clone method for class DiscardPile
     * @return DiscardPile - returns a copy of the discardPile
     */
    @Override 
    public DiscardPile clone(){
        return new DiscardPile(this.discardPile);
    }
}

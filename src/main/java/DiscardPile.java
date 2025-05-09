/**
 * Class for creating a discard pile: takes 1 (Card[]) or 0 arguments
 * @author Radin Ajorlou
 * @version 1.0.0
 */

public class DiscardPile {
    private Card[] discardPile;

    //First constructor 1 argument
    public DiscardPile(Card[] discardPile){
        this.discardPile = discardPile;
    }

    //Second constructor 0 arguments
    public DiscardPile(){
        this.discardPile = new Card[0];
    }

    /**
     * Gets the discard pile
     * @return Card[] - the array of cards in the discard pile 
     */
    public Card[] getDiscardPile(){
        return this.discardPile;
    }

    /**
     * Gets the size of the discard pile 
     * @return int - the number of cards in the discard pile
     */
    public int size(){
        return this.discardPile.length;
    }

    /**
     * Adds a specific card into the discard pile 
     * @param newCard Card - the card to be added into the pile
     */
    public void addCard(Card newCard){
        Card[] newDiscard = new Card[this.discardPile.length + 1];
        for (int i = 0; i < newDiscard.length - 1; i++){
            newDiscard[i] = this.discardPile[i];
        }
        newDiscard[newDiscard.length] = newCard;
        this.discardPile = newDiscard;
    }

    /**
     * Removes the specified card from the discard pile and returns it
     * @param cardToBeRemoved Card - The card that the user wants to remove
     * @return Card - if the card exists in the pile it will be returned, if not, it will return null;
     */
    public Card removeCard(Card cardToBeRemoved){
        Card[] newDiscard = new Card[this.discardPile.length - 1];
        boolean cardExists = false;
        for (int i = 0 , j = 0; i < this.discardPile.length; i++ , j++){
            if (this.discardPile[j] == cardToBeRemoved){    
                cardExists = true;
                j++;
            }
            newDiscard[i] = this.discardPile[j];
        }
        if (cardExists){
            return cardToBeRemoved;
        }
        return null;
    }

    /**
     * Removes all cards from the discardPile and returns them
     * @return Card[] - Every card currently in the pile, empty array if the pile is empty
     */
    public Card[] removeAll(){
        Card[] pileToBeReturned = this.discardPile;
        this.discardPile = new Card[0];
        return pileToBeReturned;
    }

    /**
     * Override of the ToString method for the discard pile
     * @return String - in format (card1, card2, etc..) e.g(Queen of Hearts, King of Spades);
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.discardPile.length; i++){
            sb.append(this.discardPile[i].toString() + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }



    
}

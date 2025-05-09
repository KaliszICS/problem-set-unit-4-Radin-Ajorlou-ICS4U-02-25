/**
 * class for cards
 * @author Radin Ajorlou
 * @version 1.0.0
 */
class Card{
    private String name;
    private String suit;
    private int value;

    //Constructor
    public Card(String name, String suit, int value){
        this.name = name;
        this.suit = suit;
        this.value = value;
    }

    /**
     * Gets the name of the card
     * @return String - name of card
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the suit of the card
     * @return String - suit of the card
     */
    public String getSuit(){
        return suit;
    }

    /**
     * Gets the value of the card
     * @return int - value of the
     */
    public int getValue(){
        return value;
    }

    /**
     * Overrides the toString method
     * @return String - name of suit e.g Queen of Hearts
     */
    @Override
    public String toString(){
        return name + " of " + suit;
    }

    /**
     * Overrides the equals method
     * @param obj The object that is being compared
     * @return boolean - true if the 2 objects are the same and false otherwise
     */
    @Override 
    public boolean equals(Object obj){
        try{
            Card card = (Card)obj;
            if (card.getName().equals(this.name) && card.getSuit().equals(this.suit) && card.getValue() == this.value){
                return true;
            }
        }
        catch(ClassCastException e){
            return false;
        }

            return false;

        
    }
}
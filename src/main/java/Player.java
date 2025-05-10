/**
 * Class for creating a Player
 * @author Radin Ajorlou
 * @verion 1.0.0
 */

class Player {
    private String name;
    private int age;
    private Deck hand;

    /**
     * Player constructor 
     * @param name String - name of player
     * @param age int - age of player
     * @param hand Deck - the deck currently in the players had
     */
    public Player (String name, int age, Deck hand){
        this.name = name;
        this.age = age;
        this.hand = hand;
    }

    /**
     * Player constructor
     * @param name String - name of player
     * @param age int - age of player
     * @param hand Card[] - the cards currently in the players hand
     */
    public Player (String name, int age, Card[] hand){
        this.name = name;
        this.age = age;
        this.hand = new Deck(hand);
    }

    /**
     * Player constructor: assumes player has an empty hand
     * @param name - name of player 
     * @param age - age of player
     */
    public Player(String name, int age){
        this(name, age, new Deck(new Card[0]));
    }

    /**
     * Gets the name of the player
     * @return String - name of player
     */
    public String getName(){
        return name;
    }

    /**Gets the age of the player
     * @return int - age of player
     */
    public int getAge(){
        return age;
    }

    /**
     * Gets the cards in the players hand
     * @return Card[] - The array of cards in the players hand
     */
    public Card[] getHand(){
        return hand.getDeck();
    }

    /**
     * Gets the size of the players hand
     * @return int - size of players hand
     */
    public int size(){
        return this.hand.size();
    }

    /**
     * draws a card from the deck into the players hand
     * @param deck Deck - the deck of cards the player must draw from
     */
    public void draw(Deck deck){
        hand.addCard(deck.draw());
    }

    /**
     * Discards a card from the players hand (into the discardpile)
     * @param card Card - the card that is being removed from the players hand and into the discard pile
     * @param discarPile DiscardPile - the discardPile that the card must go into
     * @return boolean - true if the card is in the players hand in the first place and false otherwise
     */
    public boolean discardCard(Card card, DiscardPile discardPile){
        if (discardPile.addCard(this.hand.removeCard(card)) == null) {
            return false;
        }
        return true;
    }

    /**
     * Returns a card from the players hand into the specified deck
     * @param card Card - the card to be returned from the player's hand into the deck
     * @param deck Deck - the deck the card must be returned to
     */
    public boolean returnCard(Card card, Deck deck){
        return discardCard(card, new DiscardPile(deck));
    }

    /**
     * Override of the toString method for the player class
     * @return String - in form of (player name, player age, player card1, player ccard2, etc...)
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(name + ", " + age + ", " + this.hand.toString());
        return sb.toString();
    }





}

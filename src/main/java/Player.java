/**
 * Class for player takes either 3 arguments or 1
 * 3 arguments (String name, int age, Card[] players hand)
 * 2 arguments (String name, int age) - assigns an empty Card[]
 * @author Radin Ajorlou
 * @verion 1.0.0
 */

public class Player {
    private String name;
    private int age;
    private Deck hand;

    //First constructor 3 arguments
    public Player (String name, int age, Deck hand){
        this.name = name;
        this.age = age;
        this.hand = hand;
    }

    //Second constructor
    public Player(String name, int age){
        this(name, age, new Deck(new Card[0]));
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public Deck getHand(){
        return hand;
    }

    public int size(){
        return this.hand.size();
    }

    public void draw(Deck deck){
        hand.addCard(deck.draw());
    }

    public boolean discardCard(Card card, DiscardPile discardPile){
        Card[] newHand = new Card[this.hand.length - 1];
        int length = newHand.length;
        boolean cardExists = false;
        for (int i = 0, j = 0; i < length; i++, j++){
            if(this.hand[j] == card){
                discardPile.addCard(card);
                cardExists = true;
                j++;
            }
            newHand[i] = this.hand[j];
        }
        if (cardExists){ //only if the card exists the hand gets changed which means if it doesnt the size of the hand stays the same
            this.hand = newHand;
            return true;
        }
        return false;
    }


    public boolean returnCard(Card card, Deck deck){
        Card[] newHand = new Card[this.hand.length - 1];
        int length = this.hand.length;
        boolean cardExists = false;
        for (int i = 0, j = 0; j < length; i++, j++){
            if (this.hand[i] == card){
                cardExists = true;
                deck.addCard(card);
                if (j < length){
                    j++;
                }
            }
            if (j < length){
                newHand[i] = this.hand[j];
            }
        }
        if (cardExists){
            this.hand = newHand;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        Deck playersHand = this.hand;
        StringBuilder sb = new StringBuilder;
        sb.append(name + " " + age + );

    }





}

public class Main {
    public static void main(String[] args){
        Card queen = new Card("Queen", "Heart", 13);
        Card king = new Card("King", "Heart", 13);
        Card jack = new Card("Jack", "Spades", 13);
    //     System.out.println(queen.equals(king));

        Card[] myCards = new Card[]{king, queen, jack};
        Deck deck = new Deck(myCards);
        Deck emptyDeck = new Deck(new Card[0]);


    //     // System.out.println(deck);
    //     // Card[] cards = deck.getDeck();
    //     // for (int i = 0; i < cards.length; i++){
    //     //     System.out.print(cards[i]);
    //     //     System.out.println(" " + cards[i].getValue());
    //     // }
    //     // System.out.println("Size of deck: " + deck.size());
    //     // System.out.println("This card has been drawn " + deck.draw());

    //     // deck.shuffle();
    //     // cards = deck.getDeck();
    //     // for (int i = 0; i < cards.length; i++){
    //     //     System.out.println(cards[i]);
    //     // }
    //     // System.out.println("Size of deck: " + deck.size());

    //     // DiscardPile discardPile = new DiscardPile(myCards);
    //     // System.out.println(discardPile.toString());

        Player me = new Player("Radin", 18, deck);
    //     // System.out.println("Me:" + me.size());
    //     // me.discardCard(queen, discardPile);
    //     // System.out.println("Me after discard: " + me.size());
    //     // System.out.println("discardPile: " + discardPile.toString());
    //     // System.out.println("New card: " + deck.addCard(jack).toString());
    //     // Card ace = new Card("Ace", "Hearts", 13);
    //     // DiscardPile pile = new DiscardPile();
    //     // pile.addCard(ace);
    //     // System.out.println(pile.size() + " " + pile.toString());
    //     // Card pileRemoved = pile.removeCard(ace);
    //     // System.out.println(pileRemoved);
    //     Deck newDeck = new Deck();
    //     System.out.println(newDeck);
    //     newDeck.shuffle();
    //     System.out.println("Shuffled deck: " + newDeck);

        DiscardPile pile = new DiscardPile();

        me.discardCard(jack, pile);
        System.out.println("Me:" + me);
        System.out.println("Me:" + me);
        System.out.println("emptyDeck:" + me.returnCard(queen, emptyDeck) + " " + emptyDeck);
        emptyDeck.draw();

        DiscardPile j = new DiscardPile();
        
        


    }
        
}

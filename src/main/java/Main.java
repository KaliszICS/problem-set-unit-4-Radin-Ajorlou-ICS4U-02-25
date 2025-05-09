public class Main {
    public static void main(String[] args){
        Card queen = new Card("Queen", "Heart", 13);
        Card king = new Card("King", "Heart", 13);
        Card jack = new Card("Jack", "Spades", 13);
        System.out.println(queen.equals(king));

        Card[] myCards = new Card[]{king, queen, jack};
        Deck deck = new Deck(myCards);
        // Card[] cards = deck.getDeck();
        // for (int i = 0; i < cards.length; i++){
        //     System.out.print(cards[i]);
        //     System.out.println(" " + cards[i].getValue());
        // }
        // System.out.println("Size of deck: " + deck.size());
        // System.out.println("This card has been drawn " + deck.draw());

        // deck.shuffle();
        // cards = deck.getDeck();
        // for (int i = 0; i < cards.length; i++){
        //     System.out.println(cards[i]);
        // }
        // System.out.println("Size of deck: " + deck.size());

        // DiscardPile discardPile = new DiscardPile(myCards);
        // System.out.println(discardPile.toString());

        Player me = new Player("Radin", 18, deck);
        System.out.println(me.getHand());
    }
        
}

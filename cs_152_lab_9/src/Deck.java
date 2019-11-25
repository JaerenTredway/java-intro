public class Deck {

    public static final int TOTAL_DECK_SIZE = 52;

    //INSTANCE MEMBER VARIABLES:
    private Card[] deck;
    private int subDeckSize = 0;

    /** *****************************************************************
     * This is the constructor that builds a deck of cards.
     * The bottom card in the deck wil be stored at index zero in the array.
     * "deck" here refers to both the entire deck, and each pile of cards
     * during gameplay.
     */
    public Deck() {
        this.deck = new Card[TOTAL_DECK_SIZE];
        subDeckSize = 0;
    }//******************************************************************


    /** *****************************************************************
     * This method adds a card to the top of this deck.
     * @param card (tyoe Card): The card to add.
     */
    public void add(Card card) {
        //TODO
    }//******************************************************************


    /** *****************************************************************
     * Fills the deck with all the cards in a standard deck of cards.
     * TODO: You should not explicitly construct and add all 52 possible cards.
     * Use methods provided in the RANK and SUIT enums to examine all the
     * possible combinations.
     */
    public void fill() {
        //TODO
    }//******************************************************************


    /** *****************************************************************
     * Returns the nth card in this deck, where card 0 is the one on the
     * bottom. Assumes the deck is not empty. Does not modify the deck.
     * @param n (type int): the index of the card you are looking for
     * @return (type Card): the card that is at the nth index
     */
    public Card getCardAt(int n) {
        return deck[n];
    }//******************************************************************


    /** *****************************************************************
     * Moves one card from the top of this deck to the top of the other deck.
     * @param other (type Deck): the deck you are moving to
     */
    public void moveTo(Deck other) {
        //TODO
    }//******************************************************************


    /** *****************************************************************
     * Moves the top n cards from the top of this deck to the top of the
     * other deck, maintaining their order so that the card that was on top
     * of this deck becomes the top card of the other deck.
     * @param other (type Deck): the deck you are moving to
     * @param n (type int): the top n cards to move
     */
    public void moveTo(Deck other, int n) {
        //TODO
    }//******************************************************************


    /** *****************************************************************
     * Returns the number of cards in this deck.
     * @return (type int): the number of cards
     */
    public int size() {
        return 0;
        //TODO
    }//******************************************************************


    /** *****************************************************************
     * Returns the top card on this deck. Returns null if the deck is empty.
     * Does not modify the deck.
     * @return
     */
    public Card getTopCard() {
        return null;
        //TODO
    }//******************************************************************


    /** *****************************************************************
     * Randomly reorders the cards in this deck.
     * Is able to correctly shuffle any non-empty deck.
     * research source: TODO: url here**
     */
    public void shuffle() {
        //TODO
    }//******************************************************************


}//END of class Deck

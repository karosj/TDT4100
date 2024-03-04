import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CardDeck implements CardContainer, Iterable<Card> {
    private List<Card> cards;

    public CardDeck(int n){
        if (n < 0 || n > 13) {
            throw new IllegalArgumentException("Face must be between 1 and 13");
        }
        cards = new ArrayList<>();
        char[] suits = {'S', 'H', 'D', 'C'};
        for (char suit : suits) {
            for (int face = 1; face <= n; face++) {
                cards.add(new Card(suit, face));
            }
        }
    }

    public int getCardCount(){
        return cards.size();
    }

    public Card getCard(int n){
        if (n < 0 || n >= cards.size()) {
            throw new IllegalArgumentException("Card index out of bounds");
        }
        return cards.get(n);
    }

    public void shufflePerfectly(){
        List<Card> shuffled = new ArrayList<>();
        for (int i = 0; i < cards.size()/2; i++) {
            shuffled.add(cards.get(i));
            shuffled.add(cards.get(i + cards.size()/2));
        }
        cards = shuffled;
    }

    public void deal(CardHand hand, int n){
        for (int i = 0; i < n; i++) {
            hand.addCard(cards.remove(cards.size() - 1));
        }
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    public boolean hasCard(Predicate<Card> predicate){
        for (Card card : cards) {
            if (predicate.test(card)) {
                return true;
            }
        }
        return false;
    }

    public int getCardCount(Predicate<Card> predicate){
        int count = 0;
        for (Card card : cards) {
            if (predicate.test(card)) {
                count++;
            }
        }
        return count;
    }

    public List<Card> getCards(Predicate<Card> predicate){
        List<Card> matchingCards = new ArrayList<>();
        for (Card card : cards) {
            if (predicate.test(card)) {
                matchingCards.add(card);
            }
        }
        return matchingCards;
    }
}


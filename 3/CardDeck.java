import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private List<Card> cards;

    public CardDeck(int n) {
        if (n < 0 || n > 13) {
            throw new IllegalArgumentException("Face must be between 1 and 13");
        }
        cards = new ArrayList<>();
        char[] suits = { 'S', 'H', 'D', 'C' };
        for (char suit : suits) {
            for (int face = 1; face <= n; face++) {
                cards.add(new Card(suit, face));
            }
        }
    }

    public int getCardCount() {
        return cards.size();
    }

    public Card getCard(int n) {
        if (n < 0 || n >= cards.size()) {
            throw new IllegalArgumentException("Card index out of bounds");
        }
        return cards.get(n);
    }

    public void shufflePerfectly() {
        List<Card> shuffled = new ArrayList<>();
        for (int i = 0; i < cards.size() / 2; i++) {
            shuffled.add(cards.get(i));
            shuffled.add(cards.get(i + cards.size() / 2));
        }
        cards = shuffled;
    }
}

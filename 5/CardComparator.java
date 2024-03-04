public class CardComparator implements Comparator<Card> {
    private boolean aceHigh;
    private char trumpSuit;

    public CardComparator(boolean aceHigh, char trumpSuit) {
        this.aceHigh = aceHigh;
        this.trumpSuit = trumpSuit;
    }

    @Override
    public int compare(Card o1, Card o2) {
        int value1 = o1.getFace();
        int value2 = o2.getFace();

        if (aceHigh) {
            if (o1.getFace() == 1) {
                value1 = 14;
            }
            if (o2.getFace() == 1) {
                value2 = 14;
            }
        }
        if (o1.getSuit() == trumpSuit && o2.getSuit() != trumpSuit) {
            return 1;
        } else if (o1.getSuit() != trumpSuit && o2.getSuit() == trumpSuit) {
            return -1;
        }

        if (o1.getSuit() != o2.getSuit()) {
            return o1.getSuit() - o2.getSuit();
        }

        return value1 - value2;
    }

}

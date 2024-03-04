public class Card implements Comparable<Card> {
    private char suit;
    private int face;

    public Card(char suit, int face) {
        if (suit == 'S' || suit == 'H' || suit == 'D' || suit == 'C') {
            this.suit = suit;
        } else {
            throw new IllegalArgumentException("Suit must be S, H, D or C");
        }
        if (face >= 1 && face <= 13) {
            this.face = face;
        } else {
            throw new IllegalArgumentException("Face must be between 1 and 13");
        }
    }

    public char getSuit() {
        return suit;
    }

    public int getFace() {
        return face;
    }

    public String toString() {
        return suit + "" + face;
    }

    @Override
    public int compareTo(Card o) {
        if (this.face == o.face) {
            return this.suit - o.suit;
        }
        return this.face - o.face;
    }
}
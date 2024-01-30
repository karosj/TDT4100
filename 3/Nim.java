public class Nim {
    private int[] piles;

    public Nim() {
        this(10); // Delegates to the other constructor with a default size of 10
    }

    public Nim(int pileSize) {
        piles = new int[] { pileSize, pileSize, pileSize };
    }

    public void removePieces(int number, int targetPile) {
        if (isGameOver()) {
            throw new IllegalStateException("Game over bro.");
        }
        if (targetPile < 0 || targetPile >= piles.length) {
            throw new IllegalArgumentException("Må velge enten 0, 1 eller 2 som argument.");
        }
        if (number <= 0 || piles[targetPile] < number) {
            throw new IllegalArgumentException("Ugyldig antall brikker eller for mange brikker fjernet.");
        }
        piles[targetPile] -= number;
    }

    public boolean isValidMove(int number, int targetPile) {
        return !isGameOver() && number > 0 && targetPile >= 0 && targetPile < piles.length
                && piles[targetPile] >= number;
    }

    public boolean isGameOver() {
        for (int pile : piles) {
            if (pile == 0) {
                return true;
            }
        }
        return false;
    }

    public int getPile(int targetPile) {
        if (targetPile < 0 || targetPile >= piles.length) {
            throw new IllegalArgumentException("Ugyldig haugnummer.");
        }
        return piles[targetPile];
    }

    @Override
    public String toString() {
        return "Haug 1=" + piles[0] + ", haug 2=" + piles[1] + ", haug 3=" + piles[2] + "]";
    }
}
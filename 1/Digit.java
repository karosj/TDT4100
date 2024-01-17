public class Digit {
    private int value;
    private int base;

    public Digit(int base) {
        this.base = base;
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public boolean increment() {
        value++;
        if (value == base) {
            value = 0;
            return true;
        } else {
            return false;

        }
    }

    public int getBase() {
        return base;
    }

    public String toString() {
        if (value < 10) {
            return Integer.toString(value);
        } else {
            return Character.toString((char) ('A' + value - 10));
        }
    }
}

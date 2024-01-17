public class UpOrDownCounter {
    private int counter;
    private final int end;
    private final boolean isCountingUp;

    public UpOrDownCounter(int start, int end) {
        if (start == end) {
            throw new IllegalArgumentException("Start and end values can't be the same");
        }

        this.counter = start;
        this.end = end;
        this.isCountingUp = start < end;
    }

    public int getCounter() {
        return counter;
    }

    public boolean count() {
        if (isCountingUp && counter < end) {
            counter++;
            return counter != end;
        } else if (!isCountingUp && counter > end) {
            counter--;
            return counter != end;
        }
        return false;
    }
}
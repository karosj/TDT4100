public class Location {
    private int x;
    private int y;

    public Location() {
        this.x = 0;
        this.y = 0;
    }

    public void up() {
        y--;
    }

    public void down() {
        y++;
    }

    public void left() {
        x--;
    }

    public void right() {
        x++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Location: x=" + x + ", y=" + y + "";
    }
}

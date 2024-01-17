public class Rectangle {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public Rectangle(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            minX = maxX = x1;
            if (y1 == y2) {
                minY = maxY = y1;
            } else {
                minY = Math.min(y1, y2);
                maxY = Math.max(y1, y2);
            }
        } else {
            minX = Math.min(x1, x2);
            maxX = Math.max(x1, x2);
            if (y1 == y2) {
                minY = maxY = y1;
            } else {
                minY = Math.min(y1, y2);
                maxY = Math.max(y1, y2);
            }
        }
    }

    public int getMinX() {
        return minX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public boolean isEmpty() {
        return minX == maxX || minY == maxY;
    }

    public int getWidth() {
        return maxX - minX;
    }

    public int getHeight() {
        return maxY - minY;
    }

    public boolean contains(int x, int y) {
        return !isEmpty() && x >= minX && x <= maxX && y >= minY && y <= maxY;
    }

    public boolean contains(Rectangle rect) {
        return !isEmpty() && !rect.isEmpty() && rect.getMinX() >= minX && rect.getMaxX() <= maxX
                && rect.getMinY() >= minY && rect.getMaxY() <= maxY;
    }

    public boolean add(int x, int y) {
        if (contains(x, y)) {
            return false;
        }

        if (isEmpty()) {
            minX = maxX = x;
            minY = maxY = y;
            return true;
        }

        boolean changed = false;
        if (x < minX) {
            minX = x;
            changed = true;
        }
        if (x > maxX) {
            maxX = x;
            changed = true;
        }
        if (y < minY) {
            minY = y;
            changed = true;
        }
        if (y > maxY) {
            maxY = y;
            changed = true;
        }

        return changed;
    }

    public boolean add(Rectangle rect) {
        if (rect.isEmpty() || contains(rect)) {
            return false;
        }

        boolean changed = false;
        if (isEmpty()) {
            minX = rect.minX;
            maxX = rect.maxX;
            minY = rect.minY;
            maxY = rect.maxY;
            return true;
        }

        if (rect.minX < minX) {
            minX = rect.minX;
            changed = true;
        }
        if (rect.maxX > maxX) {
            maxX = rect.maxX;
            changed = true;
        }
        if (rect.minY < minY) {
            minY = rect.minY;
            changed = true;
        }
        if (rect.maxY > maxY) {
            maxY = rect.maxY;
            changed = true;
        }

        return changed;
    }

    public Rectangle union(Rectangle rect) {
        if (isEmpty())
            return new Rectangle(rect.minX, rect.minY, rect.maxX, rect.maxY);
        if (rect.isEmpty())
            return new Rectangle(minX, minY, maxX, maxY);

        int newMinX = Math.min(this.minX, rect.minX);
        int newMinY = Math.min(this.minY, rect.minY);
        int newMaxX = Math.max(this.maxX, rect.maxX);
        int newMaxY = Math.max(this.maxY, rect.maxY);

        return new Rectangle(newMinX, newMinY, newMaxX, newMaxY);
    }
}

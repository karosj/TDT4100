public class LineEditor {
    private String text;
    private int insertionIndex;

    public LineEditor() {
        this.text = "";
        this.insertionIndex = 0;
    }

    public void left() {
        if (insertionIndex > 0) {
            insertionIndex--;
        }
    }

    public void right() {
        if (insertionIndex < text.length()) {
            insertionIndex++;
        }
    }

    public void insertString(String s) {
        text = text.substring(0, insertionIndex) + s + text.substring(insertionIndex);
        insertionIndex += s.length();
    }

    public void deleteLeft() {
        if (insertionIndex > 0) {
            text = text.substring(0, insertionIndex - 1) + text.substring(insertionIndex);
            insertionIndex--;
        }
    }

    public void deleteRight() {
        if (insertionIndex < text.length()) {
            text = text.substring(0, insertionIndex) + text.substring(insertionIndex + 1);
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.insertionIndex = Math.min(insertionIndex, text.length());
    }

    public int getInsertionIndex() {
        return insertionIndex;
    }

    public void setInsertionIndex(int insertionIndex) {
        this.insertionIndex = Math.max(0, Math.min(insertionIndex, text.length()));
    }

    @Override
    public String toString() {
        return text.substring(0, insertionIndex) + '|' + text.substring(insertionIndex);
    }
}

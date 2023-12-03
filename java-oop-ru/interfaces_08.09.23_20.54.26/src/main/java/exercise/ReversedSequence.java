package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    private String text;
    ReversedSequence(String text) {
        StringBuilder temp = new StringBuilder(text).reverse();
        this.text = temp.toString();
    }
    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        if (index > text.length()) {
            throw new IndexOutOfBoundsException();
        }
        return text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if (start > text.length() || end > text.length()) {
            throw new IndexOutOfBoundsException();
        }
        return text.subSequence(start, end);
    }

    @Override
    public String toString() {
        return text;
    }
}
// END

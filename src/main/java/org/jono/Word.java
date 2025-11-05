package org.jono;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public abstract class Word implements CharSequence {
    private final String value;
    private final Map<Character, Integer> numOfChars;

    protected Word(String text) {
        if (!text.matches("[A-Za-z]{5}"))
            throw new IllegalArgumentException("Word must contain 5 alphabetical characters only");
        this.value = text.toLowerCase();
        numOfChars = new HashMap<>();
        setNumOfChars(this.value);
    }

    private void setNumOfChars(String text) {
        for  (int i = 0; i < text.length(); i++) {
            var letter = text.charAt(i);
            var numberOf = text.chars().filter(c -> c == letter).count();
            numOfChars.put(letter, (int) numberOf);
        }

        if (numOfChars.isEmpty())
            throw new IllegalStateException("Number of chars could not be evaluated or was null");
    }

    public boolean contains(char c) {
        return value.contains(String.valueOf(c).toLowerCase());
    }

    public String getValue() {
        return value;
    }

    public Map<Character, Integer> getNumOfChars() {
        return numOfChars;
    }


    @Override public String toString() { return value; }
    @Override public IntStream chars() { return value.chars(); }
    @Override public int length() { return value.length(); }
    @Override public char charAt(int index) { return value.charAt(index); }
    @Override public CharSequence subSequence(int start, int end) { return value.subSequence(start, end); }

}

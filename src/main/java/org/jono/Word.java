package org.jono;

import java.util.stream.IntStream;

// Base type that centralizes validation/behavior common to both guesses and targets.
public abstract class Word implements CharSequence {
    private final String value;

    protected Word(String text) {
        // Enforce a canonical lowercase, five-letter-only vocabulary.
        if (!text.matches("[A-Za-z]{5}"))
            throw new IllegalArgumentException("Word must contain 5 alphabetical characters only");
        this.value = text.toLowerCase();
    }

    public boolean contains(char c) {
        return value.contains(String.valueOf(c).toLowerCase());
    }

    public String getValue() {
        return value;
    }

    public int frequencyOf(char c) {
        return (int) value.chars().filter(val -> val == c).count();
    }


    @Override public String toString() { return value; }
    @Override public IntStream chars() { return value.chars(); }
    @Override public int length() { return value.length(); }
    @Override public char charAt(int index) { return value.charAt(index); }
    @Override public CharSequence subSequence(int start, int end) { return value.subSequence(start, end); }

}

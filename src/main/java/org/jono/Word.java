package org.jono;

import java.util.stream.IntStream;

/**
 * Base type that centralizes validation and shared behavior for guesses and targets.
 */
public abstract class Word implements CharSequence {
    private final String value;

    /**
     * Enforces canonical lowercase, five-letter-only vocabulary.
     *
     * @param text raw word text supplied by the caller
     * @throws IllegalArgumentException if the input is not five alphabetical characters
     */
    protected Word(String text) {
        if (!text.matches("[A-Za-z]{5}"))
            throw new IllegalArgumentException("Word must contain 5 alphabetical characters only");
        this.value = text.toLowerCase();
    }

    /**
     * @param c character to look for
     * @return whether the word contains the specified letter
     */
    public boolean contains(char c) {
        return value.contains(String.valueOf(c).toLowerCase());
    }

    /**
     * @return lowercase canonical representation of this word
     */
    public String getValue() {
        return value;
    }

    /**
     * @param c character to count
     * @return number of occurrences of {@code c} in the word
     */
    public int frequencyOf(char c) {
        return (int) value.chars().filter(val -> val == c).count();
    }


    @Override public String toString() { return value; }
    @Override public IntStream chars() { return value.chars(); }
    @Override public int length() { return value.length(); }
    @Override public char charAt(int index) { return value.charAt(index); }
    @Override public CharSequence subSequence(int start, int end) { return value.subSequence(start, end); }

}

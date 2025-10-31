package org.jono;

import java.util.stream.IntStream;

public class Word implements CharSequence {
    private String value;

    public Word() {};

    public Word(String text) {
        if (!text.matches("[A-Za-z]{5}"))
            throw new IllegalArgumentException("Word must contain 5 alphabetical characters only");

        setValue(text);
    }

    //cannot be overridden
    protected final void setValue(String value) {
        this.value = value.toLowerCase();
    }

    public boolean contains(char c) {
        return value.contains(String.valueOf(c).toLowerCase());
    }

    @Override public String toString() { return value; }
    @Override public IntStream chars() { return CharSequence.super.chars(); }
    @Override public int length() { return value.length(); }
    @Override public char charAt(int index) { return value.charAt(index); }
    @Override public CharSequence subSequence(int start, int end) { return value.subSequence(start, end); }

}

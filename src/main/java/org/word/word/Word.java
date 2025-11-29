package org.word.word;

import org.word.config.GameConfig;

public class Word {
    private final String value;

    public Word(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }

        var normalised = value.trim().toUpperCase();

        if (!normalised.matches(GameConfig.WORD_FORMAT)) {
            throw new IllegalArgumentException("Word must contain only letters");
        }
        if (normalised.length() != GameConfig.WORD_LENGTH) {
            throw new IllegalArgumentException("Word must be 5 characters");
        }

        this.value = normalised;
    }

    public char charAt(int i) {
        return value.charAt(i);
    }

    public boolean contains(char c) {
        return value.indexOf(c) >= 0;
    }

    public int length() {
        return value.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Word other = (Word) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return value;
    }
}

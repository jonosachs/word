package org.word.word;

import org.word.config.GameConfig;

/**
 * Immutable representation of a guess or target word.
 * Ensures every instance adheres to {@link GameConfig} formatting constraints.
 */
public class Word {
    private final String value;

    /**
     * Normalises and validates user input before storing it in uppercase form.
     *
     * @param value raw string entered by the player or loaded from a dictionary
     * @throws IllegalArgumentException if the value is null, empty, an invalid length, or contains non letters
     */
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

    /**
     * Returns the character at the supplied position.
     *
     * @param i index of the character
     * @return uppercase character from the stored value
     */
    public char charAt(int i) {
        return value.charAt(i);
    }

    /**
     * Indicates whether the word contains a given character.
     *
     * @param c uppercase character to search for
     * @return true when the character is present
     */
    public boolean contains(char c) {
        return value.indexOf(c) >= 0;
    }

    /**
     * @return the length of the stored value, guaranteed to match {@link GameConfig#WORD_LENGTH}
     */
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

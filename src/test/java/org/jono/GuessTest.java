package org.jono;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;


class GuessTest {

    @Test
    void acceptsValidGuess() {
        var guess = new Guess("apple");
        assertAll(
                () -> assertEquals('a', guess.charAt(0)),
                () -> assertEquals(5, guess.length()),
                () -> assertTrue(guess.contains('a')),
                () -> assertFalse(guess.isEmpty())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "/#*&)!@#"})
    void nonAlphaGuessThrowsException(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Guess(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"help", "health"})
    void wrongLengthThrowsException(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Guess(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "     "})
    void emptyGuessThrowsException(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Guess(input));
    }


}
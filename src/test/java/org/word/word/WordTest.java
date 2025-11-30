package org.word.word;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordTest {

    @Test
    void wordMustBeAlphabetical() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Word("-----")),
                () -> assertThrows(IllegalArgumentException.class, () -> new Word("@#$!$")),
                () -> assertThrows(IllegalArgumentException.class, () -> new Word("12345"))
        );
    }

    @Test
    void wordMustBeNonNull() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Word("")),
                () -> assertThrows(IllegalArgumentException.class, () -> new Word(" ")),
                () -> assertThrows(IllegalArgumentException.class, () -> new Word("     "))
        );
    }

    @Test
    void wordMustBeCorrectLength() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Word("exit")),
                () -> assertThrows(IllegalArgumentException.class, () -> new Word("studio"))
        );
    }

}
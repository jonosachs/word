package org.jono;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @Mock Dictionary dict;
    Game game;

    @BeforeEach
    void setUp() {
        when(dict.getRandomWord()).thenReturn("apple");
        game = new Game(dict);
    }

    @Test
    void rejectsInvalidGuess() {
        assertThrows(IllegalArgumentException.class, () -> game.submitGuess("12345"));
        assertTrue(game.getGuesses().isEmpty());
        assertTrue(game.getHintsHistory().isEmpty());
    }

    @Test
    void acceptsValidGuess() {
        assertDoesNotThrow(() -> game.submitGuess("peach"));
        assertEquals(1, game.getGuesses().size());
        assertEquals(1, game.getHintsHistory().size());
    }
}
package org.word.game;

import org.junit.jupiter.api.Test;
import org.word.config.GameConfig;
import org.word.word.GuessResult;
import org.word.word.LetterHint;
import org.word.word.Word;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void canRecordGuessAndHint() {
        Word target = new Word("apple");
        Word guess = new Word("peach");
        List<LetterHint> dummyHint = new ArrayList<>();
        Game game = new Game(target);
        game.recordGuess(new GuessResult(guess, dummyHint));

        var expected = List.of(new Word("peach"));
        var actual = game.getGuesses();
        assertEquals(expected, actual);
    }

    @Test
    void gameLostAfterMaxIncorrectGuesses() {
        Word target = new Word("APPLE");
        Word guess = new Word("PEACH");
        List<LetterHint> hint = List.of(
                LetterHint.PRESENT,
                LetterHint.PRESENT,
                LetterHint.PRESENT,
                LetterHint.INCORRECT,
                LetterHint.INCORRECT
        );

        Game game = new Game(target);

        for (int i = 0; i < GameConfig.MAX_GUESSES; i++) {
            game.recordGuess(new GuessResult(guess, hint));
        }

        GameState expected = GameState.LOST;
        GameState actual = game.getState();
        assertEquals(expected, actual);
    }

    @Test
    void gameWonAfterCorrectGuess() {
        Word target = new Word("APPLE");
        Word guess = new Word("APPLE");

        List<LetterHint> hint = List.of(
                LetterHint.CORRECT,
                LetterHint.CORRECT,
                LetterHint.CORRECT,
                LetterHint.CORRECT,
                LetterHint.CORRECT
        );

        Game game = new Game(target);
        game.recordGuess(new GuessResult(guess, hint));

        GameState expected = GameState.WON;
        GameState actual = game.getState();
        assertEquals(expected, actual);
    }

    @Test
    void canGetHints() {
        Word target = new Word("APPLE");
        Word guess = new Word("PEACH");
        List<LetterHint> hint = List.of(
                LetterHint.PRESENT,
                LetterHint.PRESENT,
                LetterHint.PRESENT,
                LetterHint.INCORRECT,
                LetterHint.INCORRECT
        );

        Game game = new Game(target);
        game.recordGuess(new GuessResult(guess, hint));

        List<LetterHint> expected = hint;
        List<LetterHint> actual = game.getHints();
        assertEquals(expected, actual);
    }

}
package org.word.game;

import org.word.dictionary.Dictionary;
import org.word.word.GuessResult;
import org.word.word.HintCalculator;
import org.word.word.Word;

/**
 * Coordinates validation, hint calculation, and state updates for a single game session.
 */
public class GameEngine {

    private final Dictionary dictionary;
    private final HintCalculator hintCalculator;

    public GameEngine(Dictionary dictionary, HintCalculator hintCalculator)
    {
        this.dictionary = dictionary;
        this.hintCalculator = hintCalculator;
    }

    /**
     * Validates a guess, calculates feedback, and records the result with the supplied {@link Game}.
     *
     * @param game  running game that should consume the guess
     * @param guess proposed word entered by the user
     * @return calculated {@link GuessResult}
     * @throws IllegalStateException    if the game is already over
     * @throws IllegalArgumentException if the guess is not found in the active dictionary
     */
    public GuessResult evaluateGuess(Game game, Word guess) {
        if (game.isGameOver())
            throw new IllegalStateException("Game is over");

        if (!dictionary.isValidWord(guess)) {
            throw new IllegalArgumentException("Guess not found in dictionary");
        }

        GuessResult result = hintCalculator.calculate(game.getTarget(), guess);

        game.recordGuess(result);

        return result;
    }
}

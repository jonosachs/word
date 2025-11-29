package org.word.game;

import org.word.dictionary.Dictionary;
import org.word.word.GuessResult;
import org.word.word.HintCalculator;
import org.word.word.LetterHint;
import org.word.word.Word;

import java.util.List;


/**
- ✅ External dependencies (dictionary, calculator)
- ✅ Orchestrating the workflow
- ✅ Coordinating between services and domain
 */
public class GameEngine {

    private final Dictionary dictionary;
    private final HintCalculator hintCalculator;

    public GameEngine(Dictionary dictionary, HintCalculator hintCalculator)
    {
        this.dictionary = dictionary;
        this.hintCalculator = hintCalculator;
    }

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

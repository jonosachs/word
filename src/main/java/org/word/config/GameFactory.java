package org.word.config;

import org.word.dictionary.Dictionary;
import org.word.game.Game;
import org.word.game.GameEngine;
import org.word.word.HintCalculator;
import org.word.word.Word;
import org.word.word.WordSelector;

import java.util.List;

/**
 * Central location for constructing wired instances of {@link Game} and {@link GameEngine}.
 * Keeps dependency wiring together so the rest of the application can remain lightweight.
 */
public class GameFactory {
    Dictionary dictionary;
    private final HintCalculator hintCalculator;
    WordSelector wordSelector;

    public GameFactory(Dictionary dictionary, HintCalculator hintCalculator, WordSelector wordselector) {
        this.dictionary = dictionary;
        this.hintCalculator = hintCalculator;
        this.wordSelector = wordselector;
    }

    /**
     * Creates a fresh {@link Game} with a randomly selected target word.
     *
     * @return new game ready to accept guesses
     */
    public Game createNewGame() {
        List<Word> words = dictionary.getAllTargetWords();
        Word target = wordSelector.getTargetWord(words);
        return new Game(target);
    }

    /**
     * @return a {@link GameEngine} wired with the configured dictionary and hint calculator
     */
    public GameEngine createNewGameEngine() {
        return new GameEngine(dictionary, hintCalculator);
    }
}

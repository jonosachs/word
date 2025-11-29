package org.word.config;

import org.word.dictionary.Dictionary;
import org.word.game.Game;
import org.word.game.GameEngine;
import org.word.word.HintCalculator;
import org.word.word.Word;
import org.word.word.WordSelector;

import java.util.List;

public class GameFactory {
    Dictionary dictionary;
    private final HintCalculator hintCalculator;
    WordSelector wordSelector;

    public GameFactory(Dictionary dictionary, HintCalculator hintCalculator, WordSelector wordselector) {
        this.dictionary = dictionary;
        this.hintCalculator = hintCalculator;
        this.wordSelector = wordselector;
    }

    public Game createNewGame() {
        List<Word> words = dictionary.getAllTargetWords();
        Word target = wordSelector.getTargetWord(words);
        return new Game(target);
    }

    public GameEngine createNewGameEngine() {
        return new GameEngine(dictionary, hintCalculator);
    }
}

package org.word;

import org.word.config.GameFactory;
import org.word.dictionary.Dictionary;
import org.word.dictionary.DictionaryFromList;
import org.word.ui.ConsoleGameUI;
import org.word.ui.GameController;
import org.word.ui.GameUI;
import org.word.word.HintCalculator;
import org.word.word.RandomWordSelector;
import org.word.word.StandardHintCalculator;
import org.word.word.WordSelector;

public class Main {
    public static void main(String[] args) {
        Dictionary dict = new DictionaryFromList();
        WordSelector ws = new RandomWordSelector();
        HintCalculator hc = new StandardHintCalculator();
        GameFactory gf = new GameFactory(dict, hc, ws);
        GameUI ui = new ConsoleGameUI();
        GameController gc = new GameController(ui, gf);

        gc.start();
    }
}


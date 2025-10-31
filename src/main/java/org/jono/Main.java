package org.jono;

import java.util.ArrayList;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Dictionary dict = new WordsFromFile("src/main/resources/words.txt");
        Game game = new Game(dict);

        game.submitGuess("apple");
        game.submitGuess("melon");

        System.out.println(game.getTarget());

        for (Hint hint : game.getHints())
            System.out.println(hint.getHint());
    }
}
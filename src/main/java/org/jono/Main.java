package org.jono;

public class Main {
    public static void main(String[] args) {
        //sample implementation
        Dictionary dict = new WordsFromFile("src/main/resources/words.txt");
        Game game = new Game(dict);

        game.submitGuess("apple");
        game.submitGuess("melon");

        System.out.println("target: " + game.getTarget());

        for (Hint hint : game.getHints())
            System.out.println(hint.getHint());
    }
}
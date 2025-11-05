package org.jono;

public class Main {
    public static void main(String[] args) {
        //sample implementation
        Dictionary dict = new WordsFromFile("src/main/resources/words.txt");
        Game game = new Game(dict);

        System.out.print("Target: ");
        System.out.println(game.getTarget());

        game.submitGuess("apple");
        game.submitGuess("melon");

        System.out.print("Guesses: ");
        System.out.println(game.getGuesses());

        var idx = 1;
        System.out.println("Hint Index: " + idx);
        System.out.println(game.getHintByIndex(idx));

        System.out.println("Hint History:");
        System.out.println(game.getHintsHistory()
                .stream()
                .map(Hint::getWordHint)
                .toList()
        );
    }
}
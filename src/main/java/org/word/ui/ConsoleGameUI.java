package org.word.ui;

import org.word.game.GameState;
import org.word.word.LetterHint;
import org.word.word.Word;

import java.util.List;
import java.util.Scanner;

public class ConsoleGameUI implements GameUI {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void displayWelcome() {
        System.out.println("Welcome to Word!");
    }

    @Override
    public Word getGuessFromUser() {
        System.out.print("Enter guess: ");
        return new Word(scanner.nextLine());
    }

    @Override
    public void displayHints(List<LetterHint> hints) {
        System.out.println(hints.toString());
    }

    @Override
    public void displayGameResult(GameState state, Word target) {
        var message = state == GameState.WON ? "You won!" : "You lost!";
        System.out.println(message);
        System.out.println("The target word was: " + target);
    }

    @Override
    public boolean askPlayAgain() {
        System.out.print("Would you like to play again? ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("yes") || response.equals("y");
    }

    @Override
    public void displayGoodbye() {
        System.out.println("Goodbye!");
    }
}

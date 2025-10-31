package org.jono;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Target target;
    private final List<Guess> guesses;
    private final List<Hint> hints;

    public Game (Dictionary dict) {
        this.target = new Target(dict.getRandomWord());
        hints = new ArrayList<>();
        guesses = new ArrayList<>();
    }

    public void submitGuess(String word) {
        Guess guess = new Guess(word);
        Hint hint = new Hint(target, guess);
        guesses.add(guess);
        hints.add(hint);
    }

    public String getTarget() {
        return target.toString();
    }

    public List<Hint> getHints() {
        return List.copyOf(hints);
    }

    public List<Guess> getGuesses() {
        return List.copyOf(guesses);
    }

}

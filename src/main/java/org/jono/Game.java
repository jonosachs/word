package org.jono;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Target target;
    private final List<Guess> guesses;
    private final List<Hint> hints;
    private int maxGuesses = 5;

    public Game (Dictionary dict) {
        this.target = new Target(dict.getRandomWord());
        hints = new ArrayList<>();
        guesses = new ArrayList<>();
    }

    public void submitGuess(String word) {
        Guess guess = new Guess(word);
        Hint hint = new Hint(target, guess);
        if (guesses.size() >= maxGuesses)
            throw new IllegalStateException("Max guesses {" + maxGuesses + "} exceeded");


        guesses.add(guess);
        hints.add(hint);
    }

    public String getTarget() {
        return target.getValue();
    }

    public List<Hint> getHintsHistory() {
        return List.copyOf(hints);
    }

    public List<HintDto> getHintByIndex(int wordIndex) {
        if (wordIndex > hints.size() || wordIndex < 0)
            throw new IllegalArgumentException("Invalid word index");

        return List.copyOf(hints.get(wordIndex).getWordHint());
    }

    public List<Guess> getGuesses() {
        return List.copyOf(guesses);
    }
}

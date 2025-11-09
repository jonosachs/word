package org.jono;

import java.util.ArrayList;
import java.util.List;

/**
 * Orchestrates target selection, guess submission, and hint history management.
 */
public class Game {
    private final Target target;
    private final List<Guess> guesses;
    private final List<Hint> hints;
    private int maxGuesses = 5;

    /**
     * Builds a new game by selecting a target word from the provided dictionary.
     *
     * @param dict dictionary used for random target selection
     */
    public Game (Dictionary dict) {
        this.target = new Target(dict.getRandomWord());
        hints = new ArrayList<>();
        guesses = new ArrayList<>();
    }

    /**
     * Processes a user guess, updating the guess list and hint history.
     *
     * @param word five-letter guess to evaluate
     * @throws IllegalStateException if {@link #maxGuesses} is exceeded
     */
    public void submitGuess(String word) {
        Guess guess = new Guess(word);
        Hint hint = new Hint(target, guess);
        if (guesses.size() >= maxGuesses)
            throw new IllegalStateException("Max guesses {" + maxGuesses + "} exceeded");


        guesses.add(guess);
        hints.add(hint);
    }

    /**
     * Returns a masked representation of the target so callers never see the plain text.
     *
     * @return obfuscated target value
     */
    public String getTarget() {
        return target.getValue();
    }

    /**
     * @return immutable snapshot of every hint produced so far
     */
    public List<Hint> getHintsHistory() {
        return List.copyOf(hints);
    }

    /**
     * Gets the hint associated with a specific guess.
     *
     * @param wordIndex zero-based guess index
     * @return immutable view of the hint entries for that guess
     * @throws IllegalArgumentException if the index is out of bounds
     */
    public List<HintDto> getHintByIndex(int wordIndex) {
        if (wordIndex > hints.size() || wordIndex < 0)
            throw new IllegalArgumentException("Invalid word index");

        return List.copyOf(hints.get(wordIndex).getWordHint());
    }

    /**
     * @return immutable list of guesses submitted so far
     */
    public List<Guess> getGuesses() {
        return List.copyOf(guesses);
    }
}

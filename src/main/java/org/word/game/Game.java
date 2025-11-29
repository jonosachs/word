package org.word.game;

import org.word.config.GameConfig;
import org.word.word.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates the mutable state of a single game, including guesses, hints, and lifecycle transitions.
 */
public class Game {
    private final List<GuessResult> hints;
    private final List<Word> guesses;
    private final Word target;
    private GameState state;

    public Game (Word target) {
        this.target = target;
        hints = new ArrayList<>();
        guesses = new ArrayList<>();
        state = GameState.INGAME;
    }

    /**
     * Records a hint result, updates the state machine, and guards against illegal transitions.
     *
     * @param result evaluated hint for the submitted guess
     * @throws IllegalStateException when invoked after the game has already ended
     */
    public void recordGuess(GuessResult result) {
        if (isGameOver())
            throw new IllegalStateException("Game is over");

        hints.add(result);
        guesses.add(result.guess());

        if (result.isCorrect())
            state = GameState.WON;
        else if (guesses.size() >= GameConfig.MAX_GUESSES)
            state = GameState.LOST;
    }

    /**
     * Returns the hint for a specific guess, preserving immutability of internal collections.
     *
     * @param wordIndex zero-based index of the guess
     * @return immutable list of {@link LetterHint}
     * @throws IllegalArgumentException if the index is invalid
     */
    public List<LetterHint> getHintByIndex(int wordIndex) {
        if (wordIndex >= guesses.size() || wordIndex < 0)
            throw new IllegalArgumentException("Invalid word index");

        return List.copyOf(hints.get(wordIndex).hint());
    }

    public Word getTarget() {
        return target;
    }

    /**
     * @return true when the game has reached a win or loss state
     */
    public boolean isGameOver() {
        return state != GameState.INGAME;
    }

    /**
     * @return immutable snapshot of the guessed words (legacy alias for {@link #getGuesses()})
     */
    public List<Word> getHints() {
        return List.copyOf(guesses);
    }

    /**
     * @return immutable snapshot of all guesses in submission order
     */
    public List<Word> getGuesses() {
        return List.copyOf(guesses);
    }

    /**
     * @return immutable snapshot of the current game state
     */
    public GameState getState() {
        return state;
    }

}

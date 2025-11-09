package org.jono;

/**
 * Thin wrapper around {@link Word} so call sites clearly distinguish user guesses from the target.
 */
public class Guess extends Word {

    /**
     * @param guess five-letter, alphabetical guess supplied by the player
     */
    public Guess(String guess) {
        super(guess);
    }
}

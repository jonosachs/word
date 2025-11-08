package org.jono;

// Thin wrapper to semantically distinguish user guesses from targets.
public class Guess extends Word {

    public Guess(String guess) {
        super(guess);
    }
}

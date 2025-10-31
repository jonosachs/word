package org.jono;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Guess extends Word {

    public Guess() {}

    public Guess(String guess) {
        //call superclass constructor
        super(guess);
    }

    public void makeGuess(String guess) {
        setValue(guess);
    }


}

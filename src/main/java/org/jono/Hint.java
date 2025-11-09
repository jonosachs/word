package org.jono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Evaluates a {@link Guess} against the {@link Target} and stores immutable feedback for each letter.
 */
public class Hint {
    private final Target target;
    private final Guess guess;
    private final List<HintDto> wordHint;
    private final Map<Character, Integer> charsRemaining;

    /**
     * Immediately evaluates the supplied guess against the target so the feedback cannot change later.
     *
     * @param target target word to compare against
     * @param guess player's guess
     */
    public Hint(Target target, Guess guess) {
        this.target = target;
        this.guess = guess;
        this.wordHint = new ArrayList<>();
        this.charsRemaining = getTargetCharFrequencies();
        evaluateGuess();
    }

    /**
     * Snapshot how many of each letter in the target still needs to be accounted for.
     */
    private Map<Character, Integer> getTargetCharFrequencies() {
        var frequencies = new HashMap<Character, Integer>();

        for  (int i = 0; i < target.length(); i++) {
            var letter = target.charAt(i);
            frequencies.merge(letter, 1, Integer::sum);
        }
        if (frequencies.isEmpty())
            throw new IllegalStateException("Error getting char frequency for target");

        return frequencies;
    }

    /**
     * Two-pass-in-one loop: treat {@link Eval#CORRECT} hits first, otherwise decide PRESENT/INCORRECT.
     */
    private void evaluateGuess() {
         for (int i = 0;  i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char targetChar = target.charAt(i);

            Eval eval;
            if (guessChar == targetChar) {
                eval = Eval.CORRECT;
                decrementChar(guessChar);
            }
            else if (target.contains(guessChar)) {
                eval = charsRemaining.get(guessChar) > 0 ? Eval.PRESENT : Eval.INCORRECT;
                decrementChar(guessChar);
            }
            else
                eval = Eval.INCORRECT;

            wordHint.add(new HintDto(guessChar, eval));
        }
    }

    /**
     * Guard against double-counting duplicate letters.
     */
    private void decrementChar(char c) {
        int remaining = charsRemaining.get(c);
        if (remaining > 0) charsRemaining.put(c, remaining - 1);
    }

    /**
     * @return immutable list of letter evaluations for this guess
     */
    public List<HintDto> getWordHint() {
        return List.copyOf(wordHint);
    }
}

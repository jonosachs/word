package org.jono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hint {
    private final Target target;
    private final Guess guess;
    private final List<HintDto> wordHint;
    private final Map<Character, Integer> charsRemaining;

    public Hint(Target target, Guess guess) {
        this.target = target;
        this.guess = guess;
        this.wordHint = new ArrayList<>();
        this.charsRemaining = target.getNumOfChars();
        evaluateGuess();
    }

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

    private void decrementChar(char c) {
        int remaining = charsRemaining.get(c);
        if (remaining > 0) charsRemaining.put(c, remaining - 1);
    }

    public List<HintDto> getWordHint() {
        return List.copyOf(wordHint);
    }
}

package org.jono;

import java.util.ArrayList;
import java.util.List;

public class Hint {
    private Target target;
    private List<HintDto> hint;

    public Hint(Target target, Guess guess) {
        this.target = target;
        hint = new ArrayList<>();
        validate(guess);
    }

    private void validate(Guess guess) {
         for (int i = 0;  i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char targetChar = target.charAt(i);

            Eval eval;

            if (guessChar == targetChar)
                eval = Eval.CORRECT;
            else if (target.contains(guessChar))
                eval = Eval.PRESENT;
            else
                eval = Eval.INCORRECT;

            hint.add(new HintDto(guessChar, eval));
        }
    }

//    public List<HintDto> forGuessIndex(int forGuess) {
//        if  (forGuess < 1 || forGuess > hints.size())
//            throw new IllegalArgumentException("Guess index must be between 1 and " + hints.size());
//        return hints.subList(forGuess-1, forGuess).getFirst();
//    }

    public List<HintDto> getHint() {
        return hint;
    }
}

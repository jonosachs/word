package org.jono;

import java.util.ArrayList;
import java.util.List;

public class Hint {
    private Target target;
    private List<List<HintDto>> hints;

    public Hint(Target target) {
        this.target = target;
        hints = new ArrayList<>();
    }

    public List<List<HintDto>> validateGuess (Guess guess) {

        List<HintDto> results = new ArrayList<>();

        for (int i = 0;  i < guess.length(); i++) {
            char guessChar = guess.charAt(i);
            char targetChar = target.charAt(i);

            Validation val;

            if (guessChar == targetChar)
                val = Validation.CORRECT;
            else if (target.contains(guessChar))
                val = Validation.PRESENT;
            else
                val = Validation.INCORRECT;

            results.add(new HintDto(guessChar, val));
        }

        hints.add(results);
        return hints;
    }

    public List<HintDto> forGuessIndex(int forGuess) {
        if  (forGuess < 1 || forGuess > hints.size())
            throw new IllegalArgumentException("Guess index must be between 1 and " + hints.size());
        return hints.subList(forGuess-1, forGuess).getFirst();
    }

    public List<List<HintDto>> getHints() {
        return hints;
    }
}

package org.word.word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StandardHintCalculator implements HintCalculator {
    @Override
    public GuessResult calculate(Word target, Word guess) {
        List<LetterHint> hint = new ArrayList<>();
        Map<Character, Integer> letterBag = getInitialCharFrequencies(target);

        for (int i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);
            char t = target.charAt(i);

            LetterHint result = null;

            if (g == t && letterBag.get(g) > 0) {
                result = LetterHint.CORRECT;
                letterBag.put(g, letterBag.get(g) - 1);
            } else if (target.contains(g) && letterBag.get(g) > 0) {
                result = LetterHint.PRESENT;
                letterBag.put(g, letterBag.get(g) - 1);
            } else
                result = LetterHint.INCORRECT;

            hint.add(result);
        }

        return new GuessResult(guess, hint);
    }

    private Map<Character, Integer> getInitialCharFrequencies(Word word) {
        var freq = new HashMap<Character, Integer>();

        for  (char c : word.toString().toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        if (freq.isEmpty())
            throw new IllegalStateException("Error getting char frequency for target");

        return freq;
    }

}




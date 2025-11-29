package org.word.word;

import java.util.List;
import java.util.Random;

/**
 * Helper that picks a random element from a list of words.
 */
public class RandomWordSelector implements WordSelector {
    private final Random rng;

    public RandomWordSelector() {
        this(new Random());
    }

    public RandomWordSelector(Random rng) {
        this.rng = rng;
    }

    @Override
    public Word getTargetWord(List<Word> words) {
        return words.get(rng.nextInt(words.size()));
    }
}

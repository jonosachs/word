package org.word.word;

public interface HintCalculator {
    public GuessResult calculate(Word target, Word guess);
}

package org.word.word;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StandardHintCalculatorTest {

    @Test
    void returnsCorrectHint() {
        StandardHintCalculator calc = new StandardHintCalculator();
        Word target = new Word("APPLE");
        Word guess = new Word("PEACH");
        List<LetterHint> expected = List.of(
                LetterHint.PRESENT,
                LetterHint.PRESENT,
                LetterHint.PRESENT,
                LetterHint.INCORRECT,
                LetterHint.INCORRECT
        );
        List<LetterHint> actual = calc.calculate(target, guess).hint();
        assertEquals(expected, actual);
    }

    @Test
    void returnsCorrectHintForDoubleLetters() {
        StandardHintCalculator calc = new StandardHintCalculator();
        Word target = new Word("PEACH");
        Word guess = new Word("APPLE");
        List<LetterHint> expected = List.of(
                LetterHint.PRESENT,
                LetterHint.PRESENT,
                LetterHint.INCORRECT,
                LetterHint.INCORRECT,
                LetterHint.PRESENT
        );
        List<LetterHint> actual = calc.calculate(target, guess).hint();
        assertEquals(expected, actual);
    }
}
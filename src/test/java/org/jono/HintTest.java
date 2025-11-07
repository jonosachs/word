package org.jono;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HintTest {

    @Test
    void returnsValidHint() {
        var guess = new Guess("peach");
        var target = new Target("apple");
        var expected = List.of(
                new HintDto('p', Eval.PRESENT),
                new HintDto('e', Eval.PRESENT),
                new HintDto('a', Eval.PRESENT),
                new HintDto('c', Eval.INCORRECT),
                new HintDto('h', Eval.INCORRECT)
        );
        assertEquals(expected, new Hint(target, guess).getWordHint());
    }

    @Test
    void duplicateLettersEvaluateCorrectly() {
        var guess = new Guess("apple");
        var target = new Target("peach");
        var expected = List.of(
                new HintDto('a', Eval.PRESENT),
                new HintDto('p', Eval.PRESENT),
                new HintDto('p', Eval.INCORRECT), //duplicate is incorrect here
                new HintDto('l', Eval.INCORRECT),
                new HintDto('e', Eval.PRESENT)
        );
        assertEquals(expected, new Hint(target, guess).getWordHint());
    }

}
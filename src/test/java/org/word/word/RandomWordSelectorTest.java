package org.word.word;

import org.junit.jupiter.api.Test;
import org.word.dictionary.FruitDictionary;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RandomWordSelectorTest {

    @Test
    void getsRandomWord() {
        //seed 1L always returns 0
        RandomWordSelector rws = new RandomWordSelector(new Random(1L));

        FruitDictionary dict = new FruitDictionary();
        List<Word> words = dict.getAllValidWords();

        Word expected = dict.getAllValidWords().get(new Random(1L).nextInt(words.size()));
        Word actual = rws.getTargetWord(words);
        assertEquals(expected, actual);
    }
}
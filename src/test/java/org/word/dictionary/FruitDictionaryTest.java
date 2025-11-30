package org.word.dictionary;

import org.junit.jupiter.api.Test;
import org.word.word.Word;

import static org.junit.jupiter.api.Assertions.*;

class FruitDictionaryTest {

    @Test
    void allTargetWordsIsSubsetOfAllValidWords() {
        FruitDictionary dict = new FruitDictionary();
        var all = dict.getAllValidWords();
        var targets = dict.getAllTargetWords();

        for (Word word : targets)
            if (!all.contains(word))
                fail();
    }

    @Test
    void validWordReturnsTrue(){
        FruitDictionary dict = new FruitDictionary();
        Word word = new Word("apple");
        assertTrue(dict.isValidWord(word));
    }

    @Test
    void invalidWordReturnsFalse(){
        FruitDictionary dict = new FruitDictionary();
        Word word = new Word("audio");
        assertFalse(dict.isValidWord(word));
    }



}
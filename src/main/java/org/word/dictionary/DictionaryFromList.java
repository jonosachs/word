package org.word.dictionary;

import org.word.word.Word;

import java.util.ArrayList;
import java.util.List;

public class DictionaryFromList implements Dictionary {
    List<Word> allWords;

    public DictionaryFromList() {
        allWords = List.of(
                new Word("apple"),
                new Word("melon"),
                new Word("peach"),
                new Word("berry"),
                new Word("lemon"));
    }

    @Override
    public List<Word> getAllValidWords() {
        return allWords;
    }

    @Override
    public List<Word> getAllTargetWords() {
        return List.of(
                new Word("apple"),
                new Word("melon"));
    }

    @Override
    public boolean isValidWord(Word word) {
        return allWords.contains(word);
    }
}

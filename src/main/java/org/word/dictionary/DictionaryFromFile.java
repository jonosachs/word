package org.word.dictionary;

import org.word.word.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DictionaryFromFile implements Dictionary {
    private final List<Word> allWords;

    public DictionaryFromFile(String filePath) {
        this.allWords = loadAndNormalise(filePath);
    }

    @Override
    public List<Word> getAllValidWords() {
        return allWords;
    }

    @Override
    public List<Word> getAllTargetWords() {
        //TODO: filter logic for selecting target words from all valid words
        return allWords;
    }

    @Override
    public boolean isValidWord(Word word) {
        return allWords.contains(word);
    }

    private List<Word> loadAndNormalise(String filePath) {
        //TODO: Replace with try-with routine
        try {
            return Files.lines(Path.of(filePath))
                    .map(String::trim)
                    .map(String::toUpperCase)
                    .filter(str -> str.matches("[A-Z]{5}"))
                    .distinct()
                    .map(Word::new)
                    .toList();
        } catch(IOException e) {
            throw new RuntimeException("Failed to load dictionary", e);
        }
    }

}

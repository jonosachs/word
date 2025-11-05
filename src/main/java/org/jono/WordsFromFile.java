package org.jono;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class WordsFromFile implements Dictionary {
    private final List<String> dict;
    private final Random random;

    public WordsFromFile(String filePath) {
        this(Path.of(filePath));
    }

    public WordsFromFile(Path filePath) {
        this.dict = loadDictionary(filePath);
        this.random = new Random();
    }

    private List<String> loadDictionary(Path filePath) {
        final List<String> words;
        try {
            var rawData = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            words = rawData.stream()
                    .map(String::trim)
                    .map(String::toLowerCase)
                    .filter(w -> w.matches("^[a-z]{5}$"))
                    .distinct()
                    .toList();

        } catch (IOException e) {
            throw new UncheckedIOException("Error getting words list from " + filePath, e);
        }

        if (words.isEmpty() || words.size() < 2) {
            throw new IllegalStateException("Dictionary is empty: " + filePath);
        }

        return List.copyOf(words);
    }

    public List<String> getDict() {
        return dict;
    }

    @Override
    public String getRandomWord() {
        var randomIndex = random.nextInt(dict.size());
        return dict.get(randomIndex);
    }

}

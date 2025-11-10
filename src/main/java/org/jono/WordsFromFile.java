package org.jono;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

/**
 * Dictionary backed by a newline-delimited text resource containing five-letter words.
 */
public class WordsFromFile implements Dictionary {
    private final List<String> dict;
    private final Random random;

    /**
     * Creates a dictionary from a string path.
     *
     * @param filePath path to the dictionary file
     */
    public WordsFromFile(String filePath) {
        this(Path.of(filePath));
    }

    /**
     * Creates a dictionary from a {@link Path} to a newline-delimited file.
     *
     * @param filePath path to the dictionary file
     */
    public WordsFromFile(Path filePath) {
        this.dict = loadDictionary(filePath);
        this.random = new Random();
    }

    /**
     * Reads, sanitizes, and validates the dictionary contents.
     */
    private List<String> loadDictionary(Path filePath) {
        final List<String> words;
        try {
            //TODO: Load words from a classpath using InputStream as Files.readAllLines(Path) only works with real filesystem paths (not packaged content)
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

    /**
     * Exposes the immutable backing list for callers that need to inspect the dictionary.
     *
     * @return all valid five-letter words
     */
    public List<String> getDict() {
        return dict;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRandomWord() {
        var randomIndex = random.nextInt(dict.size());
        return dict.get(randomIndex);
    }

}

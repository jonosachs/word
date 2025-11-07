package org.jono;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordsFromFileTest {
    @TempDir Path tempPath;

    Path getMockDictPath(List<String> inputWords) throws IOException {
        tempPath = tempPath.resolve("words.txt");
        Files.write(tempPath, inputWords);
        return tempPath;
    }

    @Test
    void acceptsValidPath() throws IOException {
        var inputWords = List.of("apple", "melon");
        Path mockDictPath = getMockDictPath(inputWords);
        var randWord = new WordsFromFile(mockDictPath).getRandomWord();
        assertTrue(inputWords.contains(randWord));
    }

    @Test
    void invalidPathThrowsException() {
        assertThrows(RuntimeException.class, () -> new WordsFromFile("invalidFilePath.txt"));
    }

    @Test
    void emptyDictionaryThrowsException() throws IOException {
        var noWords = List.of("", " ", "   ");
        Path mockDictPath = getMockDictPath(noWords);
        assertThrows(IllegalStateException.class, () -> new WordsFromFile(mockDictPath).getRandomWord());
    }

    @Test
    void normalisesWords() throws IOException {
        var inputWords = List.of("apple", "peach", "-----", "bad", " ", "trime ");
        Path mockDictPath = getMockDictPath(inputWords);

        assertTrue(new WordsFromFile(mockDictPath).getDict().size() == 3);
    }

}
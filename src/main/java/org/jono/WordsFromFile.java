package org.jono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class WordsFromFile implements Dictionary {
        private List<String> dict;

        public WordsFromFile(String filePath) {
            setDictionary(filePath);
        }

        private void setDictionary(String filePath) {
            try {
                dict = Files.readAllLines(Path.of(filePath));
            } catch (IOException e) {
                throw new RuntimeException("Error getting words list from " + filePath + "\n" + e);
            }
        }

        @Override
        public String getRandomWord() {
            var randomIndex = new Random().nextInt(dict.size());
            return dict.get(randomIndex);
        }

}

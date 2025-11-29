package org.word.dictionary;

import org.word.word.Word;
import java.util.List;

/**
 * Contract for supplying allowed guess words and potential targets.
 * Implementations can back the dictionary with in-memory lists, files, or external services.
 */
public interface Dictionary {
    /**
     * @return every word that can be submitted as a guess
     */
    List<Word> getAllValidWords();

    /**
     * @return subset of words that may be used as targets for a new game
     */
    List<Word> getAllTargetWords();

    /**
     * Validates a candidate word against the active dictionary.
     *
     * @param word word to validate
     * @return true if the word is accepted
     */
    boolean isValidWord(Word word);
}

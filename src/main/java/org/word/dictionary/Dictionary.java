package org.word.dictionary;

import org.word.word.Word;
import java.util.List;

public interface Dictionary {
    List<Word> getAllValidWords();
    List<Word> getAllTargetWords();
    boolean isValidWord(Word word);
}

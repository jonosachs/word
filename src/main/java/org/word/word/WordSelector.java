package org.word.word;

import java.util.List;

public interface WordSelector {
    Word getTargetWord(List<Word> words);
}

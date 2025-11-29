package org.word.word;

import java.util.List;

public record GuessResult(Word guess, List<LetterHint> hint) {

    public boolean isCorrect() {
        return hint.stream()
                .allMatch(status -> status.equals(LetterHint.CORRECT));
    }

    public LetterHint getHintAt(int index) {
        return hint.get(index);
    }

}


package org.word.game;

import org.word.config.GameConfig;
import org.word.word.*;
import java.util.ArrayList;
import java.util.List;

/**
- ✅ What a game *is* (state, guesses, target)
- ✅ What a game *can do* (accept guesses, track state)
- ✅ What game *rules are* (can't guess when over, max attempts)
- ✅ Internal consistency (state transitions)
 */
public class Game {
    private final List<GuessResult> hints;
    private final List<Word> guesses;
    private final Word target;
    private GameState state;

    public Game (Word target) {
        this.target = target;
        hints = new ArrayList<>();
        guesses = new ArrayList<>();
        state = GameState.INGAME;
    }

    public void recordGuess(GuessResult result) {
        if (isGameOver())
            throw new IllegalStateException("Game is over");

        hints.add(result);
        guesses.add(result.guess());

        if (result.isCorrect())
            state = GameState.WON;
        else if (guesses.size() >= GameConfig.MAX_GUESSES)
            state = GameState.LOST;
    }

    public List<LetterHint> getHintByIndex(int wordIndex) {
        if (wordIndex >= guesses.size() || wordIndex < 0)
            throw new IllegalArgumentException("Invalid word index");

        return List.copyOf(hints.get(wordIndex).hint());
    }

    public Word getTarget() {
        return target;
    }

    public boolean isGameOver() {
        return state != GameState.INGAME;
    }

    public List<Word> getHints() {
        return List.copyOf(guesses);
    }

    public List<Word> getGuesses() {
        return List.copyOf(guesses);
    }

    public GameState getState() {
        return state;
    }

}

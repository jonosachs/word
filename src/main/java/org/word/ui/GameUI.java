package org.word.ui;

import org.word.game.Game;
import org.word.game.GameState;
import org.word.word.LetterHint;
import org.word.word.Word;

import java.util.List;

public interface GameUI {
    public void displayWelcome();
    public Word getGuessFromUser();
    public void displayHint(List<LetterHint> hint);
    public void displayGameResult(GameState state, Word target);
    public boolean askPlayAgain();
    public void displayGoodbye();
}

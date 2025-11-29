package org.word.ui;

import org.word.config.GameFactory;
import org.word.game.Game;
import org.word.game.GameEngine;
import org.word.word.GuessResult;
import org.word.word.Word;

public class GameController {
    private final GameUI gameUI;
    private final GameFactory factory;

    public GameController(GameUI gameUI, GameFactory factory) {
        this.gameUI = gameUI;
        this.factory = factory;
    }

    public void start() {
        Game game = factory.createNewGame();
        GameEngine engine = factory.createNewGameEngine();

        gameUI.displayWelcome();

        while (!game.isGameOver())
            playTurn(game, engine);

        gameUI.displayGameResult(game.getState(), game.getTarget());

        if (gameUI.askPlayAgain())
            start();
        else
            gameUI.displayGoodbye();
    }

    private void playTurn(Game game, GameEngine engine) {
       Word guess = gameUI.getGuessFromUser();
       GuessResult result = engine.evaluateGuess(game, guess);
       gameUI.displayHint(result.hint());
    }
}

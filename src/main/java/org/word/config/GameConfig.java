package org.word.config;

public class GameConfig {
    private GameConfig() {}

    public static final int WORD_LENGTH = 5;
    public static final int MAX_GUESSES = 6;
    public static final String WORD_FORMAT = "^[A-Z]+$";
}

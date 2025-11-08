package org.jono;

// Abstraction so the game can source words from files, APIs, etc.
public interface Dictionary {
    String getRandomWord();
}

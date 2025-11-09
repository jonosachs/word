package org.jono;

/**
 * Abstraction over a word source so {@link Game} can plug in files, APIs, or other backends
 * without changes to the gameplay logic.
 */
public interface Dictionary {
    /**
     * Returns a random five-letter word that can be used as the hidden target.
     *
     * @return randomly selected word from the backing source
     */
    String getRandomWord();
}

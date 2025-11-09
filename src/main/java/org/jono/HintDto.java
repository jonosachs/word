package org.jono;

/**
 * Immutable representation of a single-letter evaluation result.
 *
 * @param letter character in the guess
 * @param result classification for that character relative to the target
 */
public record HintDto(char letter, Eval result) {
}

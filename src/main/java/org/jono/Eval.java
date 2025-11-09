package org.jono;

/**
 * Possible per-letter outcomes when comparing a guess to the target.
 */
public enum Eval {
    /** Letter is in the correct position. */
    CORRECT,
    /** Letter exists in the target but is misplaced or already satisfied elsewhere. */
    PRESENT,
    /** Letter does not appear in the target (or no quota remains for duplicates). */
    INCORRECT
}

package org.jono;

/**
 * Represents the hidden target word and hides its literal value with a constant mask.
 */
public class Target extends Word {
    private final String mask = "*".repeat(super.length());

    /**
     * @param target raw target word selected from a dictionary
     */
    public Target(String target) {
        super(target);
    }

    @Override
    public String toString() {
        return mask;
    }

    /**
     * Returns the masked representation so logs/UI never leak the real target.
     */
    @Override public String getValue() {
        return mask;
    }
}

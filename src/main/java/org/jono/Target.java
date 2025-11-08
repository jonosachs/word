package org.jono;

// Target hides its true value by exposing a constant mask externally.
public class Target extends Word {
    private final String mask = "*".repeat(super.length());

    public Target(String target) {
        super(target);
    }

    @Override
    public String toString() {
        return mask;
    }

    @Override public String getValue() {
        return mask;
    }


}

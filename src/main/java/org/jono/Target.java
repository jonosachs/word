package org.jono;

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

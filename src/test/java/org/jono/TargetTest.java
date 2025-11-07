package org.jono;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetTest {
    Target target;

    @BeforeEach
    void setUp() {
        target = new Target("apple");
    }

    @Test
    void targetIsMasked() {
        var pattern = "[a-zA-Z]";
        assertFalse(target.getValue().matches(pattern));
        assertFalse(target.toString().matches(pattern));
    }

}
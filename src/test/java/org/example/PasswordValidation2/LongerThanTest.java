package org.example.PasswordValidation2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongerThanTest {

    @Test
    public void test() {
        assertTrue(new LongerThan(1).isPassedOn("12"));
        assertFalse(new LongerThan(1).isPassedOn("1"));
    }

}
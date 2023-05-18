package org.example.PasswordValidation2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainsDigitsTest {

    @Test
    public void test() {
        assertTrue(new ContainsDigits().isPassedOn("1"));
        assertFalse(new ContainsDigits().isPassedOn("a"));
    }

}
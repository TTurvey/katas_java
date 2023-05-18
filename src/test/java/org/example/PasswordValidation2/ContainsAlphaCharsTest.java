package org.example.PasswordValidation2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsAlphaCharsTest {

    @Test
    public void test() {
        assertTrue(new ContainsAlphaChars().isPassedOn("a"));
        assertTrue(new ContainsAlphaChars().isPassedOn("A"));
        assertFalse(new ContainsAlphaChars().isPassedOn("0"));
        assertFalse(new ContainsAlphaChars().isPassedOn("!"));
    }

}
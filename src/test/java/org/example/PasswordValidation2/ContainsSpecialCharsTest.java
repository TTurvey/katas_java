package org.example.PasswordValidation2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContainsSpecialCharsTest {

    @Test
    public void test() {
        assertTrue(new ContainsSpecialChars().isPassedOn("!"));
        assertFalse(new ContainsSpecialChars().isPassedOn("A"));
        assertFalse(new ContainsSpecialChars().isPassedOn("1"));
    }

}
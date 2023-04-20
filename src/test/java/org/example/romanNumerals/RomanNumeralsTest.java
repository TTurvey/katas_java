package org.example.romanNumerals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {

    @Test
    public void
    returns_I_when_given_1() {
        RomanNumerals romanNumerals = new RomanNumerals();
        String expected = "I";
        String actual = romanNumerals.translate(1);
        assertEquals(expected, actual);
    }

}
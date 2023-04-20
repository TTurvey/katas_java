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

    @Test
    public void
    returns_II_when_given_2() {
        RomanNumerals romanNumerals = new RomanNumerals();
        String expected = "II";
        String actual = romanNumerals.translate(2);
        assertEquals(expected, actual);
    }

    @Test
    public void
    returns_III_when_given_3() {
        RomanNumerals romanNumerals = new RomanNumerals();
        String expected = "III";
        String actual = romanNumerals.translate(3);
        assertEquals(expected, actual);
    }

}
package org.example.romanNumerals;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {

    private RomanNumerals romanNumerals;

    @BeforeEach
    public void init() {
        this.romanNumerals = new RomanNumerals();
    }

    @ParameterizedTest
    @CsvSource({
            "1, I",
            "2, II",
            "3, III",
            "4, IV",
            "5, V",
            "6, VI",
            "7, VII",
            "8, VIII",
            "9, IX",
            "10, X",
            "11, XI",
            "12, XII",
            "13, XIII",
            "14, XIV",
            "15, XV",
            "16, XVI",
            "17, XVII",
            "18, XVIII",
            "19, XIX",
            "20, XX"
    })
    public void should_return_true_if_number_is_in_row_already(int number, String roman) {
        assertEquals(roman, romanNumerals.translate(number));
    }



}
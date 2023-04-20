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
            "4, IV"
    })
    public void should_return_true_if_number_is_in_row_already(int number, String roman) {
        assertEquals(roman, romanNumerals.translate(number));
    }



}
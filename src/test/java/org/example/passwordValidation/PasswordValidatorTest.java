package org.example.passwordValidation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "abcdefg, false",
            "abcdefgh, true",
            "abcdefghi, true"
    })
    public void
    returns_false_if_input_has_less_than_8_characters(String input, Boolean expected) {
        PasswordValidator pv = new PasswordValidator();
        Boolean actual = pv.check(input);
        assertEquals(expected,actual);
    }

}
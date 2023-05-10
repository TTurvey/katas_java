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
        Boolean actual = pv.checkLength(input);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource({
            "abcdefgh, false",
            "Abcdefgh, true",
            "aBcdefgh, true",
            "abCdefgh, true",
            "abcDefgh, true",
            "abcdEfgh, true",
            "abcdeFgh, true",
            "abcdefGh, true",
            "abcdefgH, true",
            "ABCDEFGH, true"
    })
    public void
    returns_true_if_input_has_at_least_one_capital(String input, Boolean expected) {
        PasswordValidator pv = new PasswordValidator();
        Boolean actual = pv.containsCapital(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "ABCDEFGH, false",
            "ABCDEFGh, true",
            "ABCDEFgh, true"
    })
    public void
    returns_true_if_input_has_at_least_one_lowercase(String input, Boolean expected) {
        PasswordValidator pv = new PasswordValidator();
        Boolean actual = pv.containsLower(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Abcdefgh, false",
            "Abcdefg1, true",
            "Abcdef12, true"
    })
    public void
    returns_true_if_input_has_at_least_one_number(String input, Boolean expected) {
        PasswordValidator pv = new PasswordValidator();
        Boolean actual = pv.containsNumber(input);
        assertEquals(expected, actual);
    }

}
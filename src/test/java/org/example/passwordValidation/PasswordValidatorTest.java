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
        PasswordValidator pv = new Validator1();
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
        PasswordValidator pv = new Validator1();
        Boolean actual = pv.checkUppercase(input);
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
        PasswordValidator pv = new Validator1();
        Boolean actual = pv.checkLowercase(input);
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
        PasswordValidator pv = new Validator1();
        Boolean actual = pv.checkNumber(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "A1cdefgh, false",
            "A1cdefg_, true",
            "A1cdef__, true"
    })
    public void
    returns_true_if_input_has_at_least_one_underscore(String input, Boolean expected) {
        PasswordValidator pv = new Validator1();
        Boolean actual = pv.checkUnderscore(input);
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource({
            "Ab1_efgh, true",
            "Ab1defgh, false",
            ", false"
    })
    public void
    returns_true_only_if_all_checks_are_true(String input, Boolean expected) {
        PasswordValidator pv = new Validator1();
        Boolean actual = pv.checkPassword(input);
        assertEquals(expected, actual);
    }
}
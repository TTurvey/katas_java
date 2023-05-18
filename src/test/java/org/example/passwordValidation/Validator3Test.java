package org.example.passwordValidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Validator3Test {

    PasswordValidator pv;

    @BeforeEach
    void init() {
        this.pv = new Validator3();
    }

    @ParameterizedTest
    @CsvSource({
            "abcdefghijklmno, false",
            "abcdefghijklmnop, true",
            "abcdefghijklmnopq, true",
    })
    public void
    returns_false_if_input_has_less_than_16_characters(String input, Boolean expected) {
        Boolean actual = pv.checkLength(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "ab, false",
            "Ab, true",
            "aB, true",
            "AB, true"
    })
    public void
    returns_true_if_input_has_at_least_one_capital(String input, Boolean expected) {
        Boolean actual = pv.checkUppercase(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "ab, true",
            "Ab, true",
            "aB, true",
            "AB, false"
    })
    public void
    returns_true_if_input_has_at_least_one_lowercase(String input, Boolean expected) {
        Boolean actual = pv.checkLowercase(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "ab, false",
            "a_, true",
            "__, true"
    })
    public void
    returns_true_if_input_has_at_least_one_underscore(String input, Boolean expected) {
        Boolean actual = pv.checkUnderscore(input);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "Abcdefghijklmn_1, true",
            "Abcdefghijklmn_, false",
            ", false"
    })
    public void
    returns_true_only_if_all_checks_are_true(String input, Boolean expected) {
        Boolean actual = pv.checkPassword(input);
        assertEquals(expected, actual);
    }
}

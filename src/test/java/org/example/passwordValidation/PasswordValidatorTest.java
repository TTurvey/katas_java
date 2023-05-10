package org.example.passwordValidation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    public void
    returns_true_if_input_has_8_characters() {
        PasswordValidator pv = new PasswordValidator();

        assertTrue(pv.check("abcdefgh"));
    }

    @Test
    public void
    returns_true_if_input_has_more_than_8_characters() {
        PasswordValidator pv = new PasswordValidator();

        assertTrue(pv.check("abcdefghi"));
    }

}
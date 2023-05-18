package org.example.PasswordValidation2;

import static org.example.PasswordValidation2.Predicates.isLowerCase;
import static org.example.PasswordValidation2.Predicates.isUpperCase;

public class ContainsUpperCaseChars implements Rule {

    @Override
    public boolean isPassedOn(String string) {
        return string.chars().anyMatch(isUpperCase().or(isLowerCase()));
    }

}
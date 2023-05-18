package org.example.PasswordValidation2;

public class ContainsAlphaChars implements Rule {

    @Override
    public boolean isPassedOn(String string) {
        return string.chars().anyMatch(Predicates.isUpperCase().or(Predicates.isLowerCase()));
    }

}

package org.example.PasswordValidation2;

import java.util.function.IntPredicate;

public class ContainsDigits implements Rule {

    @Override
    public boolean isPassedOn(String string) {
        return string.chars().anyMatch(new IsDigit());
    }

    private final class IsDigit implements IntPredicate {
        @Override
        public boolean test(int asciiValue) {
            return asciiValue >= 48 && asciiValue <= 57;
        }
    }
}

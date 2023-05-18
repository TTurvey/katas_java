package org.example.PasswordValidation2;

import java.util.function.IntPredicate;

public class IsUpperCase implements IntPredicate {

    @Override
    public boolean test(int asciiValue) {
        return (asciiValue >= 65 && asciiValue <= 90);
    }
}


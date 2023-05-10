package org.example.passwordValidation;

public class PasswordValidator {


    public Boolean checkLength(String input) {
        return input.length() >= 8;
    }

    public Boolean containsCapital(String input) {
        for(char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

    public Boolean containsLower(String input) {
        for(char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) return true;
        }
        return false;
    }

    public Boolean containsNumber(String input) {
        for(char c : input.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }
}

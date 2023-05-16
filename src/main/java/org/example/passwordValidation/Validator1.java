package org.example.passwordValidation;

public class PasswordValidator {

    public Boolean checkPassword(String input) {
        if (input == null) return false;

        Boolean[] array = new Boolean[]{
                isAtLeastEightChars(input),
                containsCapital(input),
                containsLower(input),
                containsNumber(input),
                containsUnderscore(input)
        };

        for(boolean value: array){
            if(!value){ return false;}
        }
        return true;
    }

    public Boolean isAtLeastEightChars(String input) {
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

    public Boolean containsUnderscore(String input) {
        for(char c : input.toCharArray()) {
            if (c == '_') return true;
        }
        return false;
    }
}

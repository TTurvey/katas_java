package org.example.passwordValidation;

public class Validator1 implements PasswordValidator {

    @Override
    public Boolean checkPassword(String input) {
        if (input == null) return false;

        Boolean[] array = new Boolean[]{
                checkLength(input),
                checkUppercase(input),
                checkLowercase(input),
                checkNumber(input),
                checkUnderscore(input)
        };

        for(boolean value: array){
            if(!value){ return false;}
        }
        return true;
    }

    @Override
    public Boolean checkLength(String input) {
        return input.length() >= 8;
    }

    @Override
    public Boolean checkUppercase(String input) {
        for(char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

    @Override
    public Boolean checkLowercase(String input) {
        for(char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) return true;
        }
        return false;
    }

    @Override
    public Boolean checkNumber(String input) {
        for(char c : input.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }

    @Override
    public Boolean checkUnderscore(String input) {
        for(char c : input.toCharArray()) {
            if (c == '_') return true;
        }
        return false;
    }
}

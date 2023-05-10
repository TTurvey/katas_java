package org.example.passwordValidation;

public class PasswordValidator {


    public Boolean checkLength(String password) {
        return password.length() >= 8;
    }

    public Boolean containsCapital(String password) {
        for(char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) return true;
        }
        return false;
    }

}
